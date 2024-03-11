import { createRouter, createWebHistory } from "vue-router";

import CalendarPage from "@/pages/CalendarPage.vue";


const router = createRouter({
    history: createWebHistory(),
    routes : [
        { path: '/calendar', component: CalendarPage },
    ]
})

export default router;