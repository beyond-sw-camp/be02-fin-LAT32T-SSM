<template>
  <div id="app">
    <div class="meeting-room-container">
      <div class="meeting-rooms">
        <div v-for="(room, index) in mainStore.meetingRooms" :key="index"
             :class="{ 'room': true, 'available': room.isAvailable, 'unavailable': !room.isAvailable }">
          <button @click="selectMeetingRoom(room.meetingRoomIdx)">{{ room.meetingRoomName }}</button>
        </div>
      </div>
      <div class="status-indicator">
        <div class="status available">
          <div class="color-box"></div>
          이용 가능
        </div>
        <div class="status unavailable">
          <div class="color-box"></div>
          이용 불가
        </div>
        <MeetingRoomModalComponent v-if="showModal" @close="showModal = false"/>
      </div>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";
import { useMeetingRoomStore } from '@/stores/useMeetingRoomStore'; // 스토어 import
import MeetingRoomModalComponent from './MeetingRoomModalComponent.vue'; // 모달 컴포넌트 import
//import axios from "axios";
//const backend = process.env.VUE_APP_API_ENDPOINT;
export default {
  components: {
    MeetingRoomModalComponent, // 컴포넌트 등록
  },
  data() {
    return {
      showModal: false, // 모달 제어를 위한 데이터
    };
  },
  computed: {
    ...mapStores(useMainStore)
  },
  methods: {
    async selectMeetingRoom(roomIdx) {
      const meetingRoomStore = useMeetingRoomStore(); // 스토어 사용
      await meetingRoomStore.fetchRoomReservations(roomIdx); // 회의실 예약 정보 가져오기
      this.showModal = true; // 모달 창 보이기
      //console.log(roomIdx);
      //const response = await axios.get(`${backend}/meetingroom/select/` + roomIdx);
      //console.log(response);
    },
  },
};
</script>

<style scoped>
.meeting-room-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
  font-family: 'Noto Sans KR', sans-serif;
}

.meeting-rooms {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 15px;
  justify-items: center;
  max-width: 650px;
}

.room {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 60px;
  border: none;
  background-color: #f9f9f9;
  border-radius: 12px;
  text-align: center;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.room:hover {
  transform: translateY(-5px);
}

.available {
  background-color: gray;
  color: white;
}

.unavailable {
  background-color: black;
  color: white;
}

.status-indicator {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  margin-left: 10px;
}

.status {
  display: flex;
  align-items: center;
  margin-right: 15px;
}

.color-box {
  height: 20px;
  margin-right: 5px;
  border-radius: 50%;
}

.available .color-box {
  background-color: gray;
}

.unavailable .color-box {
  background-color: black;
}

#title {
  text-align: center;
  margin-left: 10px;
  font-size: 24px;
  color: #333;
  margin-bottom: 20px;
  font-weight: bold;
}
</style>