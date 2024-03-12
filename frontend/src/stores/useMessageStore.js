import { defineStore } from "pinia";
import { toRaw } from "vue";

export const useMessageStore = defineStore("recvList", {
    state: () => ({ recvList: [] }),
    actions: {

    }
})