import { createRouter, createWebHistory } from "vue-router";
import VueJwtDecode from "vue-jwt-decode";

import CalendarPage from "@/pages/CalendarPage.vue";
import MainPage from "@/pages/MainPage.vue";
import LoginPage from "@/pages/LoginPage.vue";
import SignUpPage from "@/pages/SignUpPage.vue";


const router = createRouter({
    history:createWebHistory(),
    routes: [
        { path: '/', component: MainPage },
        { path: '/login', component: LoginPage },
        { path: '/signup', component: SignUpPage },
        { path: '/:roomId', component: MainPage },
        { path: '/calendar', component: CalendarPage }
    ]
})

export default router;

router.beforeEach((to, from, next) => {
    // 로그인이 필요한 페이지
    const authPages = [
      "/",
      "/:roomId",
      "/calendar",
    ];
  
    if (authPages.includes(to.fullPath)) {
      const storedTokenWithBearer = localStorage.getItem("accessToken");
      
      if (storedTokenWithBearer === null) {
        next("/login");
      } else {
        const storedToken = storedTokenWithBearer.replace("Bearer ", "");
        const tokenData = VueJwtDecode.decode(storedToken);
  
        console.log(tokenData);
        const currentTime = Math.floor(Date.now() / 1000);
        if (tokenData.exp < currentTime) {
            localStorage.removeItem("accessToken");
          next("/login");
        } else {
          next();
        }
      }
    } else {
      next();
    }
  });