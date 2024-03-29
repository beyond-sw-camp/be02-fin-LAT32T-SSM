import { defineStore } from "pinia";
import axios from "axios";
import { useRouter } from "vue-router";

const backend = process.env.VUE_APP_API_ENDPOINT;
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
                console.log(error.response.status);
                console.log(error.response.data.message);
                router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}});
            }
        },
    }
})