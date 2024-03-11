import { createApp } from 'vue'
import App from './App.vue'
import router from "./router"
import PrimeVue from "primevue/config";
import 'v-calendar/style.css';
import VCalendar from 'v-calendar';


const app = createApp(App)

app.use(router);
app.use(PrimeVue);
app.use(VCalendar, {})
app.mount('#app')
