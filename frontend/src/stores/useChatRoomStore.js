import { defineStore } from "pinia";
import axios from "axios";
import {toRaw} from "vue";
import { useRouter } from "vue-router";

// const backend = 'http://192.168.0.41/api'
const backend = 'http://localhost:8080';

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
                        Authorization: localStorage.getItem("accessToken")
                    },
                });
                if (response.data.result !== null) {
                    response.data.result.forEach((chatRoom) => {
                        this.roomList.push(chatRoom);
                    })
                    return toRaw(this.roomList);
                }
            } catch (error) {
                console.log(error.response.status);
                console.log(error.response.data.message);
                router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}});
            }
        },
    }
})