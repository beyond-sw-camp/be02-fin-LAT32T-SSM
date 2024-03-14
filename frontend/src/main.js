import { createApp } from 'vue'
import App from './App.vue'
import router from "./router"
import PrimeVue from "primevue/config";
import { createPinia } from "pinia";
import Button from "primevue/button";
import Dialog from "primevue/dialog";
import InputText from "primevue/inputtext";
// import Editor from "primevue/editor";

//in main.js
import 'primevue/resources/themes/aura-light-green/theme.css'
import "primevue/resources/primevue.min.css"
import "primevue/resources/primevue.css"

import 'v-calendar/style.css';
import VCalendar from 'v-calendar';


const pinia = createPinia();
const app = createApp(App)

app.component('SideButton', Button)
app.component('AddDialog', Dialog)
app.component('AddInputText', InputText)

app.use(router);
app.use(PrimeVue);
app.use(VCalendar, {})
app.use(pinia);
app.mount('#app')
