import { defineStore } from "pinia";
import axios from "axios";
// import VueJwtDecode from "vue-jwt-decode";

// const backend = 'http://192.168.0.41/api'
const backend = 'http://localhost:8080';
const storedToken = localStorage.getItem("accessToken");
export const useMemberStore = defineStore("member", {
    state: () => ({
        member:{
            memberId:"",
            memberPw:"",
            memberPwChecked:"",
            memberOldPw:"", 
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
            }catch(error){
                console.log("에러 발생", error);
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
        async changeInfo(){
            if(this.member.memberPw === this.member.memberPwChecked){
                let changeInfoMember = {
                    password: this.member.memberOldPw, 
                    newPassword: this.member.memberPw,
                }

                let formData = new FormData();
                let json = JSON.stringify(changeInfoMember);
                console.log(json)
                formData.append(
                    "member",
                    new Blob([json], { type: "application/json" })
                );
                
                formData.append("profileImage", this.member.profileImage);
                console.log(this.member.profileImage);

                try{
                    let response = await axios.patch(backend + "/member/update", formData, {
                        headers:{
                            "Content-Type": "multipart/form-data",
                            "Authorization": storedToken
                        }
                    });
                    console.log(response.data);    
                    window.location.href = "/login";             
                }catch(e){
                    if(e.response.data.code === "MEMBER_36" || e.response.data.code === "MEMBER_37"){
                        alert(
                            e.response.data.message
                          );
                    }else if(e.response.data.code === "MEMBER_35"){
                        alert(
                            e.response.data.message
                          );
                          
                    }     

                    alert(
                        "회원정보 변경에 실패했습니다."
                      );
                }
            }else{
                alert("비밀번호를 확인해주세요")
            }
        },
    },
})