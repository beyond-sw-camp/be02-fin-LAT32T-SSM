import {defineStore} from "pinia";
import Stomp from "webstomp-client";
import { useMessageStore } from "@/stores/useMessageStore";
import { toast } from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

const storedToken = localStorage.getItem("accessToken");
const timeout = 10000;
const backend = process.env.VUE_APP_WS_ENDPOINT;
let retry = 0;


export const useStompStore = defineStore("stomp", {
    state: () => ({
        chatStomp: null,
        subscription: null
    }),
    actions: {
        async roomConnect(chatRoomId, router) {
            if(this.subscription !== null){
                this.subscription.unsubscribe();
            }
            window.localStorage.setItem("chatRoomId", chatRoomId);
            const stomp = Stomp.client(`${backend}/chat`);
            stomp.connect({}, frame => {
                console.log(frame.command);
                stomp.connected = true;
                toast('채팅방에 접속하였습니다.', {
                    timeout: timeout,
                })
                this.chatStomp = stomp;
                this.subscription = stomp.subscribe("/sub/room/" + chatRoomId, res => {
                    useMessageStore().addMessageFromSub(JSON.parse(res.body));
                })
            }, error => {
                stomp.connected = false;
                if (error.code === 1001 || error.code === 1002 || error.code === 1006) {
                    this.retrySocketConnect(error, chatRoomId, router);
                }
            })
            useMessageStore().recvList = []
            await useMessageStore().getChatList(chatRoomId, storedToken, 1, 10)
        },
        retrySocketConnect(error, chatRoomId, router) {
            toast.error('채팅방과 연결이 끊어졌습니다.', {
                timeout: timeout,
            })
            window.localStorage.removeItem('chatRoomId');
            if (retry < 3) {
                setTimeout(() => {
                    console.log('접속을 재시도 합니다.');
                    retry += 1;
                    this.roomConnect(chatRoomId, router);
                }, 1000 * retry);
            } else {
                router.push({name: 'error', params: {errorStatus: error.code, message: '서버가 예기치 못한 오류로 인해 종료되어 현재 채팅방에 접속할 수 없습니다.'}});
            }
        }
    },
})