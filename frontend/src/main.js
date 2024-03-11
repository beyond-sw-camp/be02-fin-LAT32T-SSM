import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import PrimeVue from "primevue/config";
import OverlayPanel from "primevue/overlaypanel";
import InputGroup from "primevue/inputgroup";
import InputText from "primevue/inputtext";
import InputGroupAddon from "primevue/inputgroupaddon";
import Chips from "primevue/chips";
import Button from "primevue/button";

//in main.js
import 'primevue/resources/themes/aura-light-green/theme.css'


const app = createApp(App)
app.use(router)
app.use(PrimeVue)
app.component('OverlayPanel', OverlayPanel)
app.component('InputGroup', InputGroup)
app.component('InputGroupAddon', InputGroupAddon)
app.component('InputText', InputText)
app.component('SideChips', Chips)
app.component('SideButton', Button)
app.mount('#app')
