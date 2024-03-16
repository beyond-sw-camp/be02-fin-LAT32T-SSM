import {defineStore} from "pinia";

export const useMessageStore = defineStore("recvList", {
    state: () => ({ recvList: [] }),
    actions: {
         addMessage(message) {
             const date = new Date(message.createdAt);
             const minutes = date.getMinutes().toString().padStart(2, '0');
             const amOrPm = date.getHours() >= 12 ? '오후 ' : '오전 ';
             const formatHour = date.getHours() % 12 === 0 ? 12 : date.getHours() % 12;
             message.createdAt = amOrPm + formatHour + ':' + minutes;
             console.log(message);
             this.recvList.push(message);
         }
    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})