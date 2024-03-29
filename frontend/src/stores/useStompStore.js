import {defineStore} from "pinia";
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";
import { useMessageStore } from "@/stores/useMessageStore";

const backend = 'http://192.168.0.41/api'
// const backend = 'http://localhost:8080';

export const useStompStore = defineStore("stomp", {
    actions: {
        basicConnect(stompClient) {
            console.log("================store============")
            console.log(stompClient);
            if (stompClient.ws.readyState === 0) {
                console.log("============기본 연결================");
                stompClient.connect(
                    {},
                    frame => {
                        this.connected = true;
                        console.log('소켓 연결 성공', frame);
                        stompClient.subscribe("/sub/room", res => {
                            console.log("구독으로 받은 메시지입니다.", res.body);
                            useMessageStore().addMessage(JSON.parse(res.body));
                        });
                    },
                    error => {
                        console.log('소켓 연결 실패', error);
                        console.log(stompClient);
                        this.connected = false;
                    }
                )
            }
        },
        roomConnect(chatRoomId, token) {
            console.log(token);
            const server = `${backend}/chat`
            let socket = new SockJS(server);
            this.stompClient = Stomp.over(socket);
            console.log(`소켓 연결을 시도 중 서버 주소: ${server}`)
            window.localStorage.setItem("chatRoomId", chatRoomId);
            // this.getChatList(chatRoomId, token, 1, 4);
            this.stompClient.connect(
                {},
                frame => {
                    this.connected = true;
                    console.log('소켓 연결 성공', frame);
                    socket.close(4000, '소켓 연결 종료');
                    this.stompClient.subscribe("/sub/room/" + chatRoomId, res => {
                        console.log("연결 후 채팅방 아이디", chatRoomId);
                        console.log(res);
                        console.log("구독으로 받은 메시지입니다.", res.body);
                        useMessageStore().addMessage(JSON.parse(res.body));
                    });
                },
                error => {
                    console.log('소켓 연결 실패', error);
                    this.connected = false;
                },
            );
            socket.onclose = function () {
                console.log("소켓 연결이 끊어졌을 경우");
            }

            socket.onerror = function (error) {
                console.log("소켓 연결 중 에러가 발생한 경우:", error);
            }
        },
    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})