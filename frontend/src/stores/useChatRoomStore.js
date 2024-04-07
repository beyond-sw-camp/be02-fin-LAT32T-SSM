import { defineStore } from "pinia";
import axios from "axios";
import { toast } from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

const backend = process.env.VUE_APP_API_ENDPOINT;
const storedToken = localStorage.getItem("accessToken");
const timeout = 10000;

export const useChatRoomStore = defineStore("chatRoom", {
    state: () => ({
        roomName: "",
        roomList: [],
        chatRoomId: "",
    }),
    actions: {
        async createChatRoom(chatRoomName, memberList, router) {
            const roomInfo = {
                chatRoomName: chatRoomName,
                memberId: memberList
            };
            try {
                let response = await axios.post(`${backend}/chat/room/create`, roomInfo, {
                    headers: {
                        Authorization: storedToken,
                    }
                });
                toast(response.data.message, {
                    timeout: timeout
                });
                this.getRoomList(router);

            } catch (error) {
                if (error.response.data.code === 'COMMON-002') {
                    this.sendErrorMessage(router, error);
                } else {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                }
            }
        },
        async getRoomList(router) {
            try {
                let response = await axios.get(`${backend}/chat/rooms`, {
                    headers: {
                        Authorization: storedToken
                    },
                });
                if (response.data.result !== null) {
                    this.roomList = response.data.result;
                }
            } catch (error) {
                if (error.response.data.code === 'COMMON-002') {
                    this.sendErrorMessage(router, error);
                } else {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                }
            }
        },
        sendErrorMessage(router, error) {
            router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}})
        }
    }
})