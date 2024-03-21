import { defineStore } from "pinia";
import axios from "axios";
const backend = 'http://192.168.0.41/api'
export const useMessageStore = defineStore("message", {
    state: () => ({
        recvList: [],
    }),
    actions: {
         addMessage(message) {
             const date = new Date(message.createdAt);
             const minutes = date.getMinutes().toString().padStart(2, '0');
             const amOrPm = date.getHours() >= 12 ? '오후 ' : '오전 ';
             const formatHour = date.getHours() % 12 === 0 ? 12 : date.getHours() % 12;
             message.createdAt = amOrPm + formatHour + ':' + minutes;
             console.log(message);
             this.recvList.push(message);
         },
        async getChatList(chatRoomId, token, page, size) {
            let response = await axios.get(`${backend}/chat/room/chatlist?chatRoomId=${chatRoomId}&page=${page}&size=${size}`, {
                headers: {
                    Authorization: token
                },
            });
            console.log(response.data);
            response.data.forEach((message) => {
                this.addMessage(message);
            })
        },

    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})