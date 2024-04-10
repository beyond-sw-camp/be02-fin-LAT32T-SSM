import { defineStore } from "pinia";
import axios from "axios";
import { toast } from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

const backend = process.env.VUE_APP_API_ENDPOINT;
const timeout = 10000;

export const useMessageStore = defineStore("message", {
    state: () => ({
        recvList: [],
    }),
    actions: {
        async addMessage(message) {
             const date = new Date(message.createdAt);
             const minutes = date.getMinutes().toString().padStart(2, '0');
             const amOrPm = date.getHours() >= 12 ? '오후 ' : '오전 ';
             const formatHour = date.getHours() % 12 === 0 ? 12 : date.getHours() % 12;
             message.createdAt = amOrPm + formatHour + ':' + minutes;
             try {
                const result = await this.getChatProfile(message.memberId);
                message.profileImage = result;
            } catch (error) {
                // 에러 처리 로직을 여기에 추가하세요. 예를 들어, 기본 이미지 설정 등
                console.error("프로필 이미지를 가져오는 데 실패했습니다", error);
            }
             this.recvList.push(message);
         },
        async getChatList(chatRoomId, token, page, size) {
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
                 if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003') {
                     toast.error(error.response.data.message, {
                         timeout: timeout,
                         onClose: () => window.location.href = '/'
                     })
                 } else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
                     toast.error(error.response.data.message, {
                         timeout: timeout,
                         onClose: () => window.location.href = '/'
                     })
                 } else if (error.response.data.code === 'MEMBER-001') {
                     toast.error(error.response.data.message, {
                         timeout: timeout,
                         onClose: () => window.location.href = '/'
                     })
                 } else if (error.response.data.code === 'CHATTING_010') {
                     toast.error(error.response.data.message, {
                         timeout: timeout,
                         onClose: () => window.location.href = '/'
                     })
                 } else {
                     window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                 }
             }
        },
        async getChatProfile(memberId) {
            try {
              const response = await axios.post(backend + '/member/profile', {
                memberId: memberId
              })
              return response.data[0].imageAddr;
            } catch (error) {
                if (error.response.data.code === 'MEMBER-001') {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                } else {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                }
            }
          },
    },
})