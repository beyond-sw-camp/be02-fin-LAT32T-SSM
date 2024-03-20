import { createRouter, createWebHistory } from "vue-router";


import CalendarPage from "@/pages/CalendarPage.vue";
import MainPage from "@/pages/MainPage.vue";
import LoginPage from "@/pages/LoginPage.vue";
import SignUpPage from "@/pages/SignUpPage.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: MainPage },
    { path: '/login', component: LoginPage },
    { path: '/signup', component: SignUpPage },
    { path: '/:roomId', component: MainPage },
    { path: '/calendar', component: CalendarPage },
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
      const token = storedTokenWithBearer.replace("Bearer ", "");
      const payload = token.split('.')[1];
      const decodePayload = (encodedPayload) => {
        let base64 = encodedPayload.replace(/-/g, '+').replace(/_/g, '/'); // URL 안전 Base64 문자열을 표준 Base64로 변환
        let jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
          return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));
        return JSON.parse(jsonPayload);
      };

      const tokenData = decodePayload(payload);

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