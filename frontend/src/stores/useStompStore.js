import {defineStore} from "pinia";
import Stomp from "webstomp-client";
import { useMessageStore } from "@/stores/useMessageStore";
import { useRouter } from "vue-router";
// import { toast } from 'vue3-toastify';
// import 'vue3-toastify/dist/index.css';

// const backend = process.env.VUE_APP_API_ENDPOINT;
// const timeout = 10000;
const backend = process.env.VUE_APP_WS_ENDPOINT

export const useStompStore = defineStore("stomp", {
    state: () => ({
        chatStomp: {}
    }),
    actions: {
        roomConnect(chatRoomId, token) {
            // console.log(`소켓 연결을 시도 중 서버 주소: ${server}`)
            const router = useRouter();
            window.localStorage.setItem("chatRoomId", chatRoomId);
            console.log(token);
            console.log(backend);
            const stomp = Stomp.client(`${backend}/chat`);
            stomp.connect({}, frame => {
                stomp.connected = true;
                console.log('소켓 연결 성공', frame);
                stomp.subscribe("/sub/room/" + chatRoomId, res => {
                    console.log("연결 후 채팅방 아이디", chatRoomId);
                    console.log(res);
                    console.log("구독으로 받은 메시지입니다.", res.body);
                    useMessageStore().addMessage(JSON.parse(res.body));
                })
            }, error => {
                console.log(error);
                console.log('=======에러발생=======');
                stomp.connected = false;
                console.log(error.code);
                console.log('소켓 연결 실패', error);
                if (error.code === 1001) {
                    console.log('=======재접속========');
                    if (this.retry < 3) {
                        setTimeout(() => {
                            console.log('접속을 재시도 합니다.');
                            this.retry += 1;
                            this.roomConnect(chatRoomId, token);
                        }, 1000 * this.retry);
                    } else {
                        router.push({name: 'error', params: {errorStatus: error.code, message: '서버가 예기치 못한 오류로 인해 종료되어 현재 채팅방에 접속할 수 없습니다.'}});
                    }
                } else if (error.code === 1002) {
                    console.log(error.code);
                } else if (error.code === 1006) {
                    console.log(error.code);
                }
            })
            this.chatStomp = stomp;
        },
    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})