<template>
  <div class="calendar-layout">
    <v-date-picker v-model="date" :event-color="date => date[9] % 2 ? 'red' : 'yellow'" :events="functionEvents"
      @click="onDateClick"></v-date-picker>

    <div class="event-details">
      <h4>일정 현황</h4>
      <ul>
        <!-- selectedDateDetails로 전달받아 뿌려줌 -->
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
        // 메소드에서 mainStore의 onDateClick사용.
        const response = await this.mainStore.onDateClick(this.date);
        this.selectedDateDetails = response.data.result;
        console.log(this.selectedDateDetails);
      } catch (error) {
        console.error(error);
      }
    },
  },
}
</script>