import { defineStore } from "pinia";
import axios from "axios";
import {toRaw} from "vue";

const backend = 'http://192.168.0.41/api'

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
                    Authorization: localStorage.getItem("accessToken")
                },
            });
            console.log(response.data.result);
            response.data.result.forEach((chatRoom) => {
                this.roomList.push(chatRoom);
            })
            return toRaw(this.roomList);
        },
        async createChatRoom(memberList) {
           
            console.log(memberList)
            const roomInfo = {
                chatRoomName: this.roomName,
                memberId: memberList
            };

            let response = await axios.post(`${backend}/chat/room/create`, roomInfo);
            console.log(response.data);

            this.visible = false;
        },
    }
})