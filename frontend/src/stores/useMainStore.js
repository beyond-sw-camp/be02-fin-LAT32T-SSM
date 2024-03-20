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
    },
    getters: {

    }
})