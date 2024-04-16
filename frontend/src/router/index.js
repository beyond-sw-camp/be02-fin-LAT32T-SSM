import { createRouter, createWebHistory } from "vue-router";

import MainPage from "@/pages/MainPage.vue";
import LoginPage from "@/pages/member/LoginPage.vue";
import SignUpPage from "@/pages/member/SignUpPage.vue";
import ChangeInfoPage from "@/pages/member/ChangeInfoPage.vue";
import ErrorPage from "@/pages/error/ErrorPage.vue";
import Error404Page from "@/pages/error/Error404Page.vue";


const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: MainPage },
    { path: '/login', component: LoginPage },
    { path: '/signup', component: SignUpPage },
    { path: '/:roomId([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})', component: MainPage },
    { path: '/update', component: ChangeInfoPage },
    { path: '/error/:errorStatus/:message', name: 'error', component: ErrorPage },
    { path: '/:pathMatch(.*)', component: Error404Page },
  ]
})

export default router;

router.beforeEach((to, from, next) => {
  // 로그인이 필요한 페이지
  const authPages = [
    "/",
    "/:roomId",
    "/update",
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