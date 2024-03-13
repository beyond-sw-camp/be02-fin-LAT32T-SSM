import { createApp } from 'vue'
import App from './App.vue'
import router from "./router"
import PrimeVue from "primevue/config";
import { createPinia } from "pinia";
import OverlayPanel from "primevue/overlaypanel";
import InputGroup from "primevue/inputgroup";
import InputText from "primevue/inputtext";
import InputGroupAddon from "primevue/inputgroupaddon";
import Chips from "primevue/chips";
import Button from "primevue/button";

//in main.js
import 'primevue/resources/themes/aura-light-green/theme.css'

import 'v-calendar/style.css';
import VCalendar from 'v-calendar';


const pinia = createPinia();
const app = createApp(App)

app.component('OverlayPanel', OverlayPanel)
app.component('InputGroup', InputGroup)
app.component('InputGroupAddon', InputGroupAddon)
app.component('InputText', InputText)
app.component('SideChips', Chips)
app.component('SideButton', Button)
app.use(router);
app.use(PrimeVue);
app.use(VCalendar, {})
app.use(pinia);
app.mount('#app')
