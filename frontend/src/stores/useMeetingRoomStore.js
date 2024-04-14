import { defineStore } from 'pinia';
import axios from 'axios';
import {toast} from "vue3-toastify";

const backend = process.env.VUE_APP_API_ENDPOINT;
export const useMeetingRoomStore = defineStore('meetingRoom', {
    state: () => ({
        rooms: [],
        selectedRoom: null,
    }),
    actions: {
        async fetchRoomReservations(roomIdx, router) {
            try {
                const response = await axios.get(`${backend}/meetingroom/select/` + roomIdx);
                if (response.data.code === 'MEETINGROOM_003') {
                    if (response.data.result !== null) {
                        this.selectedRoom = {
                            ...response.data.result,
                            reservations: response.data.result.reservations,
                        };
                    }
                }
            } catch (error) {
                if (error.message === 'Network Error') {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                } else if(error.response.data.code === 'COMMON_001' || error.response.data.code === 'COMMON_002' || error.response.data.code === 'COMMON_003'){
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    });
                } else if (error.response.data.code === 'ACCOUNT_001' || error.response.data.code === 'ACCOUNT_002' || error.response.data.code === 'ACCOUNT_003' || error.response.data.code === 'ACCOUNT_004') {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                } else if (error.response.data.code === 'MEETINGROOM_006') {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                } else {
                    router.push({name: 'error', params: {errorStatus: error.response.status, message: error.response.data.message}})
                }
            }
        },
    },
});


