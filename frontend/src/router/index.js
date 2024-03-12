import { createRouter, createWebHistory } from "vue-router";

import LoginPage from "@/pages/LoginPage.vue";
import SignUpPage from "@/pages/SignUpPage.vue";
import MainPage from "@/pages/MainPage.vue";

const router = createRouter({
    history:createWebHistory(),
    routes: [
        { path: '/login', component: LoginPage },
        { path: '/signup', component: SignUpPage },
        { path: '/', component: MainPage },
        { path: '/:roomId', component: MainPage }
    ]
})

export default router;