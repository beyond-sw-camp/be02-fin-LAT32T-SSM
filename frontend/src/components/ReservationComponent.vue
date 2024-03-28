<template>
    <div>
        <button @click="reservationOpenModal">예약</button>
        <div v-show="isModalOpen" class="meeting-room">
            <div class="meeting-room-reservation">
                <h3>회의실 예약</h3>
                <form @submit.prevent="reserveMeetingRoom">
                    <label for="room">회의실 선택:</label>
                    <select v-model="selectedRoom">
                        <option v-for="room in rooms" :key="room.roomIdx" :value="room.roomIdx">{{ room.meetingRoomIdx }}
                        </option>
                    </select>

                    <label for="startDate">시작 일자:</label>
                    <input type="datetime-local" v-model="startDateTime" required>

                    <label for="endDate">종료 일자:</label>
                    <input type="datetime-local" v-model="endDateTime" required>

                    <label for="search">검색:</label>
                    <input type="text" v-model="keyword" @input="searchMembers" placeholder="유저명을 입력하세요">
                    <ul>
                        <li v-for="result in searchResults" :key="result.memberIdx" @click="addMember(result)">
                            {{ result.memberName }}
                        </li>
                    </ul>

                    <label for="selectedMembers">선택된 인원:</label>
                    <ul>
                        <li v-for="(member, index) in selectedMembers" :key="index">
                            {{ member.memberName }} 
                            <button @click.prevent="removeMember(index)">삭제</button>
                        </li>
                    </ul>

                    <button type="submit">예약</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            isModalOpen: false,
            selectedRoom: null,
            rooms: [],
            startDateTime: '',
            endDateTime: '',
            keyword: '',
            searchResults: [],
            selectedMembers: []
        };
    },
    methods: {
        async searchMembers() {
            try {
                const response = await axios.get(`http://localhost:8080/search/member/${this.keyword}`);
                this.searchResults = response.data;
            } catch (error) {
                console.error('검색 실패:', error);
            }
        },
        async fetchMeetingRooms() {
            try {
                const response = await axios.get('http://localhost:8080/meetingroom/current');
                this.rooms = response.data.result;
            } catch (error) {
                //
            }
        },
        reservationOpenModal() {
            this.isModalOpen = true;
        },
        addMember(member) {
            if (!this.selectedMembers.find(m => m.memberIdx === member.memberIdx)) {
                this.selectedMembers.push(member);
            }
        },
        removeMember(index) {
            this.selectedMembers.splice(index, 1);
        },
        async reserveMeetingRoom() {
            try {
                const requestData = {
                    meetingRoomIdx: this.selectedRoom,
                    members: this.selectedMembers,
                    startedAt: this.startDateTime,
                    closedAt: this.endDateTime
                };

                const response = await axios.post('http://localhost:8080/meetingroom/reservation', requestData);

                console.log('예약 성공:', response.data.result);

                this.selectedRoom = null;
                this.startDateTime = '';
                this.endDateTime = '';
                this.keyword = '';
                this.searchResults = [];
                this.selectedMembers = [];
                this.isModalOpen = false;
            } catch (error) {
                console.error('예약 실패:', error);
            }
        }
    },
    created() {
        this.fetchMeetingRooms();
    }
};
</script>

<style scoped>
h3 {
    margin: 40px 0 0;
}

label {
    display: block;
    margin-top: 10px;
}

input,
select {
    width: 30%; 
    padding: 10px;
    margin-top: 5px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button {
    background-color: #42b983;
    color: white;
    padding: 10px 15px;
    margin-top: 10px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

button:hover {
    background-color: #36846e;
}

ul {
    list-style: none;
    padding: 0;
}

li {
    margin-top: 5px;
    cursor: pointer;
}
.meeting-room-reservation {
    width: 50%; 
    justify-content: center; 
}
.meeting-room {
    display: flex;
    justify-content: center; 
    height: 100vh; 
}
</style>

