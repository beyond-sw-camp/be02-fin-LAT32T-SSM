import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import PrimeVue from "primevue/config";
import ConfirmationService from "primevue/confirmationservice";
//in main.js
import 'primevue/resources/themes/aura-light-green/theme.css'


const app = createApp(App)
app.use(router)
app.use(PrimeVue)
app.use(ConfirmationService)
app.mount('#app')
