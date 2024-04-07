import { defineStore } from "pinia";
import axios from "axios";
import { useRouter } from "vue-router";
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
        async createChatRoom(chatRoomName, memberList) {
            const router = useRouter();
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
                this.getRoomList();

            } catch (error) {
                console.log(error);
                toast.error(error.response.data.message, {
                    timeout: timeout,
                })
                this.sendErrorMessage(router, error);
            }
        },
        async getRoomList() {
            try {
                let response = await axios.get(`${backend}/chat/rooms`, {
                    headers: {
                        Authorization: storedToken
                    },
                });
                console.log(response);
                if (response.data.result !== null) {
                    this.roomList = response.data.result;
                }
            } catch (error) {
                console.log(error);
            }
        },
        sendErrorMessage(router, error) {
            router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}})
        }
    }
})