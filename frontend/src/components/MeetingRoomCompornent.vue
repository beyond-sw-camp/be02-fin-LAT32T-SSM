<template>
    <div id="app">
      <div class="meeting-room-container">
        <div class="meeting-rooms">
          <div v-for="room in meetingRooms" :key="room.roomIdx" 
               :class="{'room': true, 'available': room.status, 'unavailable': !room.status}"
          >
            <button @click="selectMeetingRoom(room.roomIdx)">{{ room.roomName }}</button>
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
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";  
  export default {
    data() {
      return {
      };
    },
    computed: {
        ...mapStores(useMainStore)
    },
    methods: {
      async fetchMeetingRooms() {
        try {
          const response = await axios.get('http://localhost:8080/meetingroom/list');
          this.meetingRooms = response.data.result.map(room => ({
            ...room
          }));
          console.log('===========회의실 조회===========')
          console.log(this.meetingRooms);
        } catch (error) {
          console.error('회의실 정보를 가져오지 못했습니다:', error);
        }
      },

      async selectMeetingRoom(roomIdx) {
        console.log(roomIdx);
        const response = await axios.get('http://localhost:8080/meetingroom/select/' + roomIdx);
        console.log(response);
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