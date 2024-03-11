import { createRouter, createWebHistory } from "vue-router";

import CalendarPage from "@/pages/CalendarPage.vue";


const router = createRouter({
    history:createWebHistory(),
    routes: [
        { path: '/login', component: LoginPage },
        { path: '/signup', component: SignUpPage },
        { path: '/', component: MainPage },
        { path: '/calendar', component: CalendarPage },
})

export default router;