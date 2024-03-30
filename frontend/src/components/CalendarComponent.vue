<template>
  <div class="calendar-layout">
    <v-date-picker v-model="date" :event-color="date => date[9] % 2 ? 'red' : 'yellow'" :events="functionEvents"
      @click="onDateClick"></v-date-picker>

    <!-- result가 null인경우 랜더링 안함 null값을 반환중이므로 내용 확인 불가 -->
    <div class="event-details" v-if="selectedDateDetails">
      <h4 id="status-board">일정 현황</h4>
      <ul class="status-board-details">
        <li v-for="(detail, index) in selectedDateDetails" :key="index">
          {{ detail }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";

export default {
  data() {
    return {
      date: '',
      selectedDateDetails: [],
    }
  },
  computed: {
    ...mapStores(useMainStore)
  },
  mounted() {
    this.arrayEvents = [...Array(6)].map(() => {
      const day = Math.floor(Math.random() * 30)
      const d = new Date()
      d.setDate(day)
      return d.toISOString().substr(0, 10)
    })
  },

  methods: {
    functionEvents(date) {
      const [, , day] = date.split('-')
      if ([12, 17, 28].includes(parseInt(day, 10))) return true
      if ([1, 19, 22].includes(parseInt(day, 10))) return ['red', '#00f']
      return false
    },
    async onDateClick() {
      try {
        // 스토어 응답 데이터 가져옴
        const responseData = await this.mainStore.onDateClick(this.date);
        console.log(responseData)
        if (!responseData) {
          console.error('반환된 데이터 없음.');
          this.selectedDateDetails = [];
          return;
        }
        console.log(responseData);
        if (responseData.result && responseData.result) {
          // title만 추출
          this.selectedDateDetails = responseData.result.map(event => event.title);
        } else {
          console.error('반환된 데이터 없음.');
          this.selectedDateDetails = [];
        }
      } catch (error) {
        console.error('HTTP 요청 실패:', error);
        this.selectedDateDetails = [];
      }
    },
  },
}
</script>

<style scoped>
.calendar-layout {
  display: flex;
  /* margin-left: 20px; */
}

.event-details {
  width: 370px;
}

#status-board {
  text-align: center;
}

.status-board-details li {
  background-color: #FF6464;
  color: white;
  padding: 10px 20px;
  border-radius: 25px;
  margin: 10px 0;
  list-style-type: none;
  text-align: center;
  cursor: default;
}


.status-board-details li:hover {
  background-color: #FF8585;
}
</style>