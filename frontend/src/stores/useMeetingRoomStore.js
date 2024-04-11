import { defineStore } from 'pinia';
import axios from 'axios';

export const useMeetingRoomStore = defineStore('meetingRoom', {
    state: () => ({
        rooms: [], // 회의실 목록을 저장할 배열
        selectedRoom: null, // 선택된 회의실 정보
    }),
    actions: {
        // 회의실 목록을 가져오는 비동기 함수
        async fetchRooms() {
            try {
                const response = await axios.get(`${process.env.VUE_APP_API_ENDPOINT}/meetingrooms`);
                if (response.data.isSuccess) {
                    this.rooms = response.data.result;
                } else {
                    console.error('회의실 목록을 불러오는 데 실패했습니다:', response.data.message);
                }
            } catch (error) {
                console.error('서버 오류:', error);
            }
        },

        // 특정 회의실의 예약 상태를 가져오는 비동기 함수
        async fetchRoomReservations(roomIdx) {
            try {
                const response = await axios.get(`${process.env.VUE_APP_API_ENDPOINT}/meetingroom/select/` + roomIdx);
                if (response.data.isSuccess && response.data.result) {
                    // 선택된 회의실 정보 업데이트
                    this.selectedRoom = {
                        ...response.data.result,
                        reservations: response.data.result.reservations,
                    };
                } else {
                    // 오류 처리
                    console.error('회의실 예약 정보를 불러오는 데 실패했습니다:', response.data.message);
                }
            } catch (error) {
                console.error('서버 오류:', error);
            }
        },

        // 모달을 닫고 선택된 회의실 정보를 초기화하는 함수
        clearSelectedRoom() {
            this.selectedRoom = null;
        },
    },
});


