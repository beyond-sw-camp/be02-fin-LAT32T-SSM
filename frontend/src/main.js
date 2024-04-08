import { createApp } from 'vue'
import App from './App.vue'
import router from "./router"
import PrimeVue from "primevue/config";
import { createPinia } from "pinia";
import DialogService from "primevue/dialogservice";
import LoadScript from 'vue-plugin-load-script';
import { defineStore } from 'pinia';

export const useNetworkState = defineStore('networkState', {
  state: () => ({
    isOnline: true,
  }),
  actions: {
    setOnlineStatus(status) {
      if (this.isOnline !== status) {
        this.isOnline = status;
        if (!status) {
          log('서버 연결 끊김'); 
        }
      }
    },
  },
});

const checkNetworkStatus = () => {
  if (!navigator.onLine) {
    window.alert('서버 연결 끊김');
  }
};

window.addEventListener('load', checkNetworkStatus);

window.addEventListener('online', checkNetworkStatus);
window.addEventListener('offline', checkNetworkStatus);

//in main.js
import 'primevue/resources/themes/aura-light-green/theme.css'
import 'primevue/resources/themes/saga-blue/theme.css'
import "primevue/resources/primevue.min.css"
import "primevue/resources/primevue.css"

import 'v-calendar/style.css';
import VCalendar from 'v-calendar';

const pinia = createPinia();
const app = createApp(App);
app.use(router);
app.use(PrimeVue);
app.use(VCalendar, {});
app.use(pinia);
app.use(DialogService);
app.use(LoadScript);
app.mount('#app')

