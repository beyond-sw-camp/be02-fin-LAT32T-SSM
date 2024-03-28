import { defineStore } from "pinia";
import axios from "axios";
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
            let response = await axios.get(`${backend}/chat/rooms`, {
                headers: {
                    Authorization: storedToken
                },
            });
            if (response.data.result !== null) {
                this.roomList = response.data.result;
                console.log(response.data.message);
            }     
        },
    }
})