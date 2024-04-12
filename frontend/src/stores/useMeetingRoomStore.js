import { defineStore } from 'pinia';
import axios from 'axios';
import {toast} from "vue3-toastify";

export const useMeetingRoomStore = defineStore('meetingRoom', {
    state: () => ({
        rooms: [],
        selectedRoom: null,
    }),
    actions: {
        async fetchRoomReservations(roomIdx, router) {
            try {
                const response = await axios.get(`${process.env.VUE_APP_API_ENDPOINT}/meetingroom/select/` + roomIdx);
                if (response.data.isSuccess && response.data.result) {
                    // 선택된 회의실 정보 업데이트
                    this.selectedRoom = {
                        ...response.data.result,
                        reservations: response.data.result.reservations,
                    };
                }
            } catch (error) {
                if(error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003'){
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    });
                } else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
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


