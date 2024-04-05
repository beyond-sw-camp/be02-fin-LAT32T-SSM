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
            const roomInfo = {
                chatRoomName: chatRoomName,
                memberId: memberList
            };
            const token = localStorage.getItem('accessToken');

            try {
                let response = await axios.post(`${backend}/chat/room/create`, roomInfo, {
                    headers: {
                        Authorization: token,
                    }
                });
                console.log(response);
                toast(response.data.message, {
                    timeout: timeout
                });

            } catch (error) {
                console.log(error);
                toast.error(error.response.message, {
                    timeout: timeout,
                    // 여기에 추가 옵션을 넣을 수 있습니다.
                })
            }
        },
        async getRoomList() {
            const router = useRouter();
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
                console.log(error);
                router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}});
            }
        },
    }
})