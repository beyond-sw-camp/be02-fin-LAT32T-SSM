<template>
    <v-date-picker v-model="date" :event-color="date => date[9] % 2 ? 'red' : 'yellow'" :events="functionEvents"
      @click="mainStore.onDateClick(date)"></v-date-picker>

</template>

<script>
import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";

export default {
  data () {
    return {
      date: '',
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
  },
}
</script>