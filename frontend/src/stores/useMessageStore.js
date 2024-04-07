import { defineStore } from "pinia";
import axios from "axios";
import { useRouter } from "vue-router";

// const backend = 'http://192.168.0.41/api'
const backend = 'http://localhost:8080';
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
            const router = useRouter();
             if (chatRoomId !== undefined) {
                 try {
                     let response = await axios.get(`${backend}/chat/room/chatlist?chatRoomId=${chatRoomId}&page=${page}&size=${size}`, {
                         headers: {
                             Authorization: token
                         },
                     });
                     response.data.result.forEach((message) => {
                         this.addMessage(message);
                     })
                 } catch (error) {
                     if (error.response.data.code === 'COMMON_001') {
                         this.sendErrorMessage(router, error);
                     } else if (error.response.data.code === 'COMMON_002') {
                         this.sendErrorMessage(router, error);
                     } else if (error.response.data.code === 'COMMON_003') {
                         this.sendErrorMessage(router, error);
                     } else if (error.response.data.code === 'CHATTING_015') {
                         alert(error.response.data.message);
                     } else if (error.response.data.code === 'CHATTING_016') {
                         alert(error.response.data.message);
                     } else if (error.response.data.code === 'CHATTING_017') {
                         alert(error.response.data.message);
                     } else if (error.response.data.code === 'CHATTING_018') {
                         alert(error.response.data.message);
                     } else if (error.response.data.code === 'CHATTING_019') {
                         alert(error.response.data.message);
                     }
                 }
             }
        },
        sendErrorMessage(router, error) {
            router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}});
        },
    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})