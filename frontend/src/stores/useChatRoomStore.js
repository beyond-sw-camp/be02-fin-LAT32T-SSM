import { defineStore } from "pinia";
import axios from "axios";
import { useRouter } from "vue-router";
// const backend = 'http://192.168.0.41/api'
const backend = 'http://localhost:8080';
const storedToken = localStorage.getItem("accessToken");

export const useChatRoomStore = defineStore("chatRoom", {
    state: () => ({
        roomName: "",
        roomList: [],
        chatRoomId: "",
    }),
    actions: {
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
                    console.log(response.data.message);
                }
            } catch (error) {
                if (error.response.data.code === "COMMON-001") {
                    this.sendErrorMessage(router, error);
                } else if (error.response.data.code === 'COMMON-002') {
                    this.sendErrorMessage(router, error);
                } else if (error.response.data.code === 'COMMON_003') {
                    this.sendErrorMessage(router, error);
                } else if (error.response.data.code === 'CHATTING_009') {
                    this.sendErrorMessage(router, error);
                } else if (error.response.data.code === 'CHATTING_010') {
                    this.sendErrorMessage(router, error);
                } else if (error.response.data.code === 'CHATTING_011') {
                    alert(error.response.data.message);
                } else if (error.response.data.code === 'CHATTING_012') {
                    alert(error.response.data.message);
                } else if (error.response.data.code === 'CHATTING_013') {
                    alert(error.response.data.message);
                } else if (error.response.data.code === 'CHATTING_014') {
                    this.sendErrorMessage(router, error);
                }
            }
        },
        sendErrorMessage(router, error) {
            router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}});
        },
    }
})