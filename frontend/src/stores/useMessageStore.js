import {defineStore} from "pinia";
import axios from "axios";
import {toast} from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

const backend = process.env.VUE_APP_API_ENDPOINT;
const timeout = 10000;

export const useMessageStore = defineStore("message", {
    state: () => ({
        recvList: [],
    }),
    actions: {
        async addMessageFromSub(message) {
            const date = new Date();
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
        async addMessage(message) {
             const date = new Date(message.createdAt);
             const minutes = date.getMinutes().toString().padStart(2, '0');
             const amOrPm = date.getHours() >= 12 ? '오후 ' : '오전 ';
             const formatHour = date.getHours() % 12 === 0 ? 12 : date.getHours() % 12;
             message.createdAt = amOrPm + formatHour + ':' + minutes;
             this.recvList.push(message);
         },
        async getChatList(chatRoomId, token, page, size) {
            try {
                let response = await axios.get(`${backend}/chat/room/chatlist?chatRoomId=${chatRoomId}&page=${page}&size=${size}`, {
                    headers: {
                        Authorization: token
                    },
                });
                if (response.data.code === 'CHATTING_008') {
                    const messagesWithProfiles = await Promise.all(response.data.result.map(async (message) => {
                        try {
                            message.profileImage = await this.getChatProfile(message.memberId);
                        } catch (error) {
                            console.error("프로필 이미지를 가져오는 데 실패했습니다", error);
                            message.profileImage = './default-profile.png';
                        }
                        return message;
                    }));
                    messagesWithProfiles.forEach((message) => {
                        this.addMessage(message);
                    });
                }
            } catch (error) {
                if (error.message === 'Network Error') {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                } else if (error.response.data.code === 'COMMON_001' || error.response.data.code === 'COMMON_002' || error.response.data.code === 'COMMON_003') {
                     toast.error(error.response.data.message, {
                         timeout: timeout,
                         onClose: () => window.location.href = '/'
                     })
                 } else if (error.response.data.code === 'ACCOUNT_001' || error.response.data.code === 'ACCOUNT_002' || error.response.data.code === 'ACCOUNT_003' || error.response.data.code === 'ACCOUNT_004') {
                     toast.error(error.response.data.message, {
                         timeout: timeout,
                         onClose: () => window.location.href = '/'
                     })
                 } else if (error.response.data.code === 'MEMBER_008') {
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
              });
              if (response.data.code === 'CHATTING_008') {
                  if (response.data.length !== 0) {
                      return response.data.result[0].imageAddr;
                  } else {
                      return '';
                  }
              }
            } catch (error) {
                if (error.message === 'Network Error') {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                } else if (error.response.data.code === 'COMMON_001' || error.response.data.code === 'COMMON_002' || error.response.data.code === 'COMMON_003') {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                        onClose: () => window.location.href = '/'
                    })
                } else if (error.response.data.code === 'ACCOUNT_001' || error.response.data.code === 'ACCOUNT_002' || error.response.data.code === 'ACCOUNT_003' || error.response.data.code === 'ACCOUNT_004') {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                        onClose: () => window.location.href = '/'
                    })
                } else if (error.response.data.code === 'MEMBER_008') {
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
    },
})