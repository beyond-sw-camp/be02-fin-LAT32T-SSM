import { defineStore } from "pinia";

export const useMessageStore = defineStore("recvList", {
    state: () => ({ recvList: [] }),
    actions: {
         addMessage(message) {
            this.recvList.push(message);
         }
    },
    getters: {
        getAllMessage(state) {
            return state.recvList;
        }
    }
})