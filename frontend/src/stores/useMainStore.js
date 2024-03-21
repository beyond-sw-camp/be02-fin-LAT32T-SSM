import { defineStore } from "pinia";

const storedToken = localStorage.getItem("accessToken");
export const useMainStore = defineStore("main", {
    state: () => ({
        member:{
            memberId:"",  
            name: "",
            department: "",
            position: "",
        },
    }),
    actions: {
        base64UrlDecode(input) {
            let base64 = input.replace(/-/g, '+').replace(/_/g, '/');
            let jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
                return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
            }).join(''));
            return JSON.parse(jsonPayload);
        },
        loadMemberData(){
            if(storedToken !== null){
                const token = storedToken.replace("Bearer ", "");
                const payload = token.split('.')[1]; // JWT의 두 번째 부분이 페이로드입니다.
                const tokenData = this.base64UrlDecode(payload);
                
                this.member.memberId = tokenData.memberId;
                this.member.name = tokenData.memberName;
                this.member.department = tokenData.department;
                this.member.position = tokenData.position;
            }
        },
        onDateClick(date) {
            console.log("선택된 날짜: ", date);
            // 여기에 사용자가 날짜를 클릭했을 때 실행하고 싶은 코드를 추가하세요.
        },
        requestNotificationPermission() {
            // 알림 기능을 지원하는지 확인
            if (!("Notification" in window)) {
              alert("이 브라우저는 알림을 지원하지 않습니다.");
            } else if (Notification.permission === "granted") {
              // 이미 권한이 부여된 경우
              console.log("알림 권한이 이미 부여되었습니다.");
            } else if (Notification.permission !== "denied") {
              // 권한 요청
              Notification.requestPermission().then(function (permission) {
                // 사용자가 알림을 허용하면
                if (permission === "granted") {
                  console.log("알림 권한이 부여되었습니다.");
                }
              });
            }
          },
          notificaiton() {
            this.requestNotificationPermission();  
            const evtSource = new EventSource("http://localhost:8080/notification");
            evtSource.addEventListener("notification", function (event) {
              // 사용자에게 알림 표시
              if (Notification.permission === "granted") {
                new Notification("알람 이벤트", {
                  body: event.data,
                  // icon: 'icon-url' // 알림에 표시할 아이콘 URL (선택 사항)
                });
              }
            }, false);
          }        
    },
    getters: {

    }
})