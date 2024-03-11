import {createRouter, createWebHistory} from "vue-router";

import LoginPage from "@/pages/LoginPage.vue";
import SignUpPage from "@/pages/SignUpPage.vue";

const router = createRouter({
    history:createWebHistory(),
    routes: [
        { path: '/login', component: LoginPage },
        { path: '/signup', component: SignUpPage },
    ]
})

export default router;