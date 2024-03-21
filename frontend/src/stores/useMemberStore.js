import { defineStore } from "pinia";
import axios from "axios";
// import VueJwtDecode from "vue-jwt-decode";

const backend = 'http://192.168.0.41/api'
// const storedToken = localStorage.getItem("accessToken");
export const useMemberStore = defineStore("member", {
    state: () => ({
        member:{
            memberId:"",
            memberPw:"",
            memberPwChecked:"",    
            name: "",
            department: "",
            position: "",
            profileImage: null,
        },
    }),
    actions: {
        async login(member) {
            let loginMember = { memberId: member.memberId, password: member.memberPw }
            try{
                let response = await axios.post(backend + "/member/login", loginMember, {
                    headers:{
                        "Content-Type": "application/json",
                    }
                });
                console.log(response.data);
                localStorage.removeItem("accessToken")
                localStorage.setItem("accessToken", "Bearer " + response.data.result.token);

                window.location.href = "/";
            }catch(e){
                localStorage.removeItem("accessToken");
                this.member.memberId="";
                this.member.memberPw="";
                alert(
                    "아이디 또는 비밀번호가 일치하지 않습니다."
                  );
            }          
          },
        async signup(){
            if(this.member.memberPw === this.member.memberPwChecked){
                let signupMember = {
                    memberId: this.member.memberId, 
                    password: this.member.memberPw,
                    memberName: this.member.name,
                    department: this.member.department,
                    position: this.member.position}

                let formData = new FormData();
                let json = JSON.stringify(signupMember);
                console.log(json)
                formData.append(
                    "member",
                    new Blob([json], { type: "application/json" })
                );

                formData.append("profileImage", this.member.profileImage);
                
                console.log(this.member.profileImage)
                try{
                    let response = await axios.post(backend + "/member/signup", formData, {
                        headers:{
                            "Content-Type": "multipart/form-data",
                        }
                    });
                    console.log(response.data);
                    alert(
                        "회원가입에 성공했습니다"
                      );
                      
                    window.location.href = "/login";

                }catch(e){
                    alert(
                        "회원가입에 실패했습니다."
                      );
                }
            }else{
                alert("비밀번호를 확인해주세요")
            }
            
        },
        // setMember(token) {
        //     token = VueJwtDecode.decode(token.split(" ")[1]);
        //     this.memberId = token.memberId;
        //     this.memberName = token.memberName;
        // }
    },
    getters: {

    }
})