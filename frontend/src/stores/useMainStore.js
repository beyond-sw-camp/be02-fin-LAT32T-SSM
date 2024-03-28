import { defineStore } from "pinia";
import axios from "axios";

const backend = 'http://localhost:8080'
const storedToken = localStorage.getItem("accessToken");
export const useMainStore = defineStore("main", {
    state: () => ({
        member:{
            memberId:"",  
            name: "",
            department: "",
            position: "",
            profileImage: "",
        },
        meetingRooms:[],
        members:[],
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
        async onDateClick(date) {
            date = new Date(date);
            let year = date.getFullYear();
            let month = ('0' + (date.getMonth() + 1)).slice(-2); // 월은 0부터 시작하므로 +1을 해주고, 두 자리로 표시하도록 포맷합니다.
            let day = ('0' + date.getDate()).slice(-2);
            const formattedDate = year + "-" + month + "-" + day;
            try {
                const response = await axios.get(backend + `/calendar/event/date/${formattedDate}`, {
                    headers: {
                        Authorization: localStorage.getItem('accessToken'),
                    }
                })
                console.log(response.data);
            } catch (error) {
                console.log(error);
            }
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
            const evtSource = new EventSource(backend+ "/notification/"+this.member.memberId);
            evtSource.addEventListener("notification", function (event) {
              // 사용자에게 알림 표시
              if (Notification.permission === "granted") {
                new Notification("알람 이벤트", {
                  body: event.data,
                  // icon: 'icon-url' // 알림에 표시할 아이콘 URL (선택 사항)
                });
              }
            }, false);
          },
          
          // 회의실 정보를 불러온다.
        async readMeetingRooms() {
          console.log("메서드 진입")  
          try {
                const response = await axios.get(backend + '/meetingroom/list');
                console.log(response.data);
                this.meetingRooms = response.data.result;

            } catch (error) {
                console.error('회의실 정보를 가져오지 못했습니다:', error);
            }
        },

          // 멤버 정보를 불러온다.
        async readMember() {
            try {
                const response = await axios.get(backend + '/member/read');
                this.members = response.data.result;
                } catch (error) {
                  console.error('멤버 정보를 가져오지 못했습니다:', error);
                }
            },
        async getProfileImage() {
            const response = await axios.post(backend + '/member/profile', {
                memberId: this.member.memberId
            })
            console.log(response.data[0].imageAddr);
            this.member.profileImage = response.data[0].imageAddr;
        }
    },
})