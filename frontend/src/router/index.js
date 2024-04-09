import { createRouter, createWebHistory } from "vue-router";

import MainPage from "@/pages/MainPage.vue";
import LoginPage from "@/pages/LoginPage.vue";
import SignUpPage from "@/pages/SignUpPage.vue";
import ChangeInfoPage from "@/pages/ChangeInfoPage.vue";
import ErrorPage from "@/pages/ErrorPage.vue";
import Error404Page from "@/pages/Error404Page.vue"; 

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: MainPage },
    { path: '/login', component: LoginPage },
    { path: '/signup', component: SignUpPage },
    // uuid만 허용 8 - 4 - 4 - 4 - 12
    { path: '/:roomId([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})', component: MainPage },
    { path: '/update', component: ChangeInfoPage },
    { path: '/error/:errorStatus/:message', name: 'error', component: ErrorPage },
    { path: '/error/:errorStatus/:message', name: 'error', component: Error404Page }, 
    // `/:pathMatch(.*)`는 Vue 라우터에서 제공하는 동적 세그먼트 매칭 패턴
    // 어떤 경로에도 매칭되지 않는 모든 요청을 Error404Page 컴포넌트로 리다이렉트
    // 존재하지 않는 페이지에 접근하려 할 때 404 페이지로
    { path: '/:pathMatch(.*)', component: Error404Page }, // 존재하지 않는 모든 경로에 대해 404 에러페이지
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
