import {defineStore} from "pinia";
import SockJS from "sockjs-client";
import Stomp from "webstomp-client";
import { useMessageStore } from "@/stores/useMessageStore";
import { useRouter } from "vue-router";

const backend = process.env.VUE_APP_API_ENDPOINT;

export const useStompStore = defineStore("stomp", {
    actions: {
        basicConnect(stompClient) {
            const router = useRouter();
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
                        stompClient.ws.readyState = 0;
                        this.connected = false;
                        console.log('소켓 연결 실패', error);
                        if (error.code === 1001) {
                            console.log('=======재접속========');
                            let retry = 0;
                            if (retry < 3) {
                                setTimeout(() => {
                                    console.log('접속을 재시도 합니다.');
                                    retry += 1;
                                    this.basicConnect(stompClient);
                                }, 1000 * retry);
                            } else {
                                router.push({name: 'error', params: {errorStatus: error.code, message: '서버가 예기치 못한 오류로 인해 종료되어 현재 채팅방에 접속할 수 없습니다.'}});
                            }
                        } else if (error.code === 1002) {
                            console.log('=======재접속========');
                            let retry = 0;
                            if (retry < 3) {
                                setTimeout(() => {
                                    console.log('접속을 재시도 합니다.');
                                    retry += 1;
                                    this.basicConnect(stompClient);
                                }, 1000 * retry);
                            } else {
                                router.push({name: 'error', params: {errorStatus: error.code, message: '서버가 예기치 못한 오류로 인해 종료되어 현재 채팅방에 접속할 수 없습니다.'}});
                            }
                        } else if (error.code === 1006) {
                            console.log('=======재접속========');
                            let retry = 0;
                            if (retry < 3) {
                                setTimeout(() => {
                                    console.log('접속을 재시도 합니다.');
                                    retry += 1;
                                    this.basicConnect(stompClient);
                                }, 1000 * retry);
                            } else {
                                router.push({name: 'error', params: {errorStatus: error.code, message: '서버가 예기치 못한 오류로 인해 종료되어 현재 채팅방에 접속할 수 없습니다.'}});
                            }
                        }
                    }
                )
            }
        },
        roomConnect(chatRoomId, token) {
            const router = useRouter();
            const server = `${backend}/chat`
            let socket = new SockJS(server);
            this.stompClient = Stomp.over(socket);
            console.log(`소켓 연결을 시도 중 서버 주소: ${server}`)
            window.localStorage.setItem("chatRoomId", chatRoomId);
            this.stompClient.connect(
                {},
                frame => {
                    this.connected = true;
                    console.log('소켓 연결 성공', frame);
                    this.stompClient.subscribe("/sub/room/" + chatRoomId, res => {
                        console.log("연결 후 채팅방 아이디", chatRoomId);
                        console.log(res);
                        console.log("구독으로 받은 메시지입니다.", res.body);
                        useMessageStore().addMessage(JSON.parse(res.body));
                    });
                },
                error => {
                    console.log('=======에러발생=======');
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
                }
            )
            socket.onclose = function (event) {
                console.log(event.wasClean);
                console.log(event);
                if (event.code === 4000) {
                    alert("채팅방 연결이 끊어졌습니다. 다시 연결을 시도해주세요");
                    window.location.href = '/';
                }

                if (event.code === 1001) {
                    console.log('=======재접속========');
                    let retry = 0;
                    if (retry < 3) {
                        setTimeout(() => {
                            console.log('접속을 재시도 합니다.');
                            retry += 1;
                            const server = `${backend}/chat`
                            let socket = new SockJS(server);
                            this.stompClient = Stomp.over(socket);
                        }, 1000 * retry);
                    } else {
                        router.push({name: 'error', params: {errorStatus: event.code, message: '서버가 예기치 못한 오류로 인해 종료되어 현재 채팅방에 접속할 수 없습니다.'}});
                    }
                }
            }

            socket.onerror = function (error) {
                console.log(error);
                console.log('소켓 연결에서 에러가 발생하였습니다.');
            }

        },
    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})