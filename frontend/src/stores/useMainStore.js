import { defineStore } from "pinia";
import axios from "axios";
import { toast } from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

const backend = process.env.VUE_APP_API_ENDPOINT
const storedToken = localStorage.getItem("accessToken");
const timeout = 10000;
export const useMainStore = defineStore("main", {
  state: () => ({
    // 토큰 데이터 들어가는 곳
    member: {
      memberId: "",
      name: "",
      department: "",
      position: "",
      profileImage: "",
    },
    meetingRooms: [],
    // readMember 데이터 들어가는 곳
    members: [],

    // 멤버찾기 모달을 위한 변수
    memberSearchStatus: false,


    searchMemberName: "",
    // 검색 된 데이터가 들어가는 변수
    searchedMember: {
      memberId: "",
      name: "",
      department: "",
      position: "",
    },
    // 필터 목록에 멤버이름 들어가는 곳
    filteredMemberNames: [],
    checkedMembers: [],

    // 필터 그룹의 채팅룸 객체가 들어가는곳
    selectedChatRoom: "",
  }),
  actions: {
    base64UrlDecode(input) {
      let base64 = input.replace(/-/g, '+').replace(/_/g, '/');
      let jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      }).join(''));
      return JSON.parse(jsonPayload);
    },
    loadMemberData() {
      if (storedToken !== null) {
        const token = storedToken.replace("Bearer ", "");
        const payload = token.split('.')[1]; // JWT의 두 번째 부분이 페이로드입니다.
        const tokenData = this.base64UrlDecode(payload);

        this.member.memberId = tokenData.memberId;
        this.member.name = tokenData.memberName;
        this.member.department = tokenData.department;
        this.member.position = tokenData.position;

        // 태초의 필터 목록에 본인 이름을 넣는다.
        this.filteredMemberNames = [];
        this.filteredMemberNames.push(this.member.name);
      }
    },
    async onDateClick(date) {
      date = new Date(date);
      let year = date.getFullYear();
      let month = ('0' + (date.getMonth() + 1)).slice(-2); // 월은 0부터 시작하므로 +1을 해주고, 두 자리로 표시하도록 포맷합니다.
      let day = ('0' + date.getDate()).slice(-2);
      const formattedDate = year + "-" + month + "-" + day;
      try {
        const response = await axios.get(`${backend}/calendar/event/date/${formattedDate}`, {
          headers: {
            Authorization: localStorage.getItem('accessToken'),
          }
        })
        if (response.data.code === 'CALENDAR-003') {
          toast(response.data.message, {
            timeout: timeout
          });
          return response.data;
        } else if (response.data.code === 'CALENDAR-004') {
          toast(response.data.message, {
            timeout: timeout
          });
          return response.data;
        }
      } catch (error) {
        if (error.message === 'Network Error') {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        } else if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-003') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'COMMON-002') {
          window.location.href = '/error/500/서버에서 에러가 발생하였습니다.';
        }
        else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'MEMBER-008') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        }
      }
    },
    requestNotificationPermission() {
      if (!("Notification" in window)) {
        alert("이 브라우저는 알림을 지원하지 않습니다.");
      } else if (Notification.permission === "granted") {
        console.log("알림 권한이 이미 부여되었습니다.");
      } else if (Notification.permission !== "denied") {
        Notification.requestPermission().then(function (permission) {
          if (permission === "granted") {
            console.log("알림 권한이 부여되었습니다.");
          }
        });
      }
    },
    notificationData() {
      this.requestNotificationPermission();

      const evtSource = new EventSource(`${backend}/notification/` + this.member.memberId);
      evtSource.addEventListener("test", function (event) {
        console.log(event.data)
      })
      evtSource.addEventListener("notification", function (event) {
        if (Notification.permission === "granted") {
          new Notification("알람 이벤트", {
            body: event.data,
          });
        }
      }, false);
      let reconnectAttempts = 0;
      const maxReconnectAttempts = 5; // 최대 재연결 시도 횟수
      evtSource.addEventListener("error", function () {
        if (evtSource.readyState === EventSource.CONNECTING) {
          reconnectAttempts++;
          console.log(`재연결 시도 중... (${reconnectAttempts}/${maxReconnectAttempts})`);
      
          if (reconnectAttempts >= maxReconnectAttempts) {
            evtSource.close(); // 더 이상 재연결 시도를 하지 않음
            toast.error("서버와의 연결을 실패하였습니다.", {
              timeout: 10000,
            });
            window.location.href = 'error/500/서버와의 연결이 끊어졌습니다. 다시 로그인해주세요.';
          }
        } else if (evtSource.readyState === EventSource.CLOSED) {
          window.location.href = 'error/500/서버와의 연결이 끊어졌습니다. 다시 로그인해주세요.';
        }
      }, false);

       // 'open' 이벤트 리스너 추가
        evtSource.addEventListener("open", function() {
          console.log("연결이 성공적으로 다시 수립되었습니다.");
          reconnectAttempts = 0; // 재연결 시도 횟수 초기화
      }, false);
    },

    // 회의실 정보를 불러온다.
    async readMeetingRooms() {
      try {
        const response = await axios.get(backend + '/meetingroom/current');
        if (response.data.code === 'MEETING_002') {
          this.meetingRooms = response.data.result;
          toast(response.data.message, {
            timeout: timeout
          });
        }
      } catch (error) {
        if (error.message === 'Network Error') {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        } else if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-003') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'COMMON-002') {
          window.location.href = '/error/500/서버에서 에러가 발생하였습니다.';
        }
        else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'MEMBER-008') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        }
      }
    },

    // 멤버 정보를 불러온다.
    async readMember() {
      try {
        const response = await axios.get(backend + '/member/read');
        if (response.data.code === 'MEMBER_007') {
          this.members = response.data.result;
          toast(response.data.message, {
            timeout: timeout
          });
        }
      } catch (error) {
        if (error.message === 'Network Error') {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        } else if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-003') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'COMMON-002') {
          window.location.href = '/error/500/서버에서 에러가 발생하였습니다.';
        }
        else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'MEMBER-008') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        }
      }
    },
    async getProfileImage() {
      try {
        const response = await axios.post(backend + '/member/profile', {
          memberId: this.member.memberId
        })
        if (response.data.code === 'CHATTING-008') {
          if (response.data.result[0].imageAddr !== null) {
            this.member.profileImage = response.data.result[0].imageAddr;
          } else {
            this.member.profileImage = '';
          }
        }
      } catch (error) {
        if (error.message === 'Network Error') {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        } else if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-003') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'COMMON-002') {
          window.location.href = '/error/500/서버에서 에러가 발생하였습니다.';
        }
        else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'MEMBER-008') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        }
      }
    },


    // 멤버찾기 컴포넌트 open, close
    openComponent() {
      this.searchedMember = [];
      this.memberSearchStatus = !this.memberSearchStatus;
    },

    // 멤버찾기 메서드
    async searchMembers() {
      try {
        const response = await axios.get(`${backend}/search/member/${this.searchMemberName}`);
        if (response.data.code === 'SEARCH-001') {
          this.searchedMember = response.data;
          toast(response.data.message, {
            timeout: timeout
          });
        }
      } catch (error) {
        if (error.message === 'Network Error') {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        } else if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-003') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else if (error.response.data.code === 'COMMON-002') {
          window.location.href = '/error/500/서버에서 에러가 발생하였습니다.';
        } else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
          toast.error(error.response.data.message, {
            timeout: timeout,
          })
        } else {
          window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
        }
      }
    },

    // 필터목록에 멤버 넣는 함수
    addFilteredMemberName() {
      this.searchedMember.forEach(member => {
        if (member.checked && !this.filteredMemberNames.includes(member.memberName)) {
          this.filteredMemberNames.push(member.memberName);
        }
      });
    },

    // 그룹명에 따라서 멤버 선택 ????
    async onChatRoomChange() {
      if (this.selectedChatRoom === '일반일정' || this.selectedChatRoom === '') {
        this.filteredMemberNames = []
        this.filteredMemberNames.push(this.member.name)
      } else {
        try {
          // 선택된 채팅방 ID를 사용하여 Axios 요청
          const response = await axios.get(`${backend}/member/chatroommembers?chatRoomId=${this.selectedChatRoom.chatRoomId}`);
          if (response.data.code === 'MEMBER-006') {
            this.filteredMemberNames = []
            this.filteredMemberNames = response.data.result.map(member => member.memberName);
          }
        }
        catch (error) {
          if (error.message === 'Network Error') {
            window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
          } else if (error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-003') {
            toast.error(error.response.data.message, {
              timeout: timeout,
            })
          } else if (error.response.data.code === 'COMMON-002') {
            window.location.href = '/error/500/서버에서 에러가 발생하였습니다.';
          } else if (error.response.data.code === 'ACCOUNT-001' || error.response.data.code === 'ACCOUNT-002' || error.response.data.code === 'ACCOUNT-003' || error.response.data.code === 'ACCOUNT-004') {
            toast.error(error.response.data.message, {
              timeout: timeout,
            })
          } else {
            window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
          }
        }
      }
    },
  },
})