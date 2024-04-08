import { defineStore } from "pinia";
import axios from "axios";
import { toast } from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

const backend = process.env.VUE_APP_API_ENDPOINT;
const storedToken = localStorage.getItem("accessToken");
const timeout = 10000;

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
        checkId: false,
    }),
    actions: {
        async login(member, router) {
            let loginMember = { memberId: member.memberId, password: member.memberPw }
            try{
                let response = await axios.post(`${backend}/member/login`, loginMember, {
                    headers:{
                        "Content-Type": "application/json",
                    }
                });
                localStorage.removeItem("accessToken")
                localStorage.setItem("accessToken", "Bearer " + response.data.result.token);
                toast(response.data.result.message, {
                    timeout: timeout
                });
                window.location.href = "/";
            }catch(error){
                if (error.code === 'ERR_NETWORK') {
                    localStorage.removeItem("accessToken");
                    this.member.memberId="";
                    this.member.memberPw="";
                    this.sendErrorMessage(router);
                } else {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                }
            }          
          },
        async signup(router){
            if(this.checkId === false){
                toast.error("아이디 중복체크를 하세요", {
                    timeout: timeout,
                })
            }
            if(this.member.memberPw !== this.member.memberPwChecked){
                toast.error("새롭게 입력하신 비밀번호가 서로 다릅니다.", {
                    timeout: timeout,
                })
            }

            if(this.member.memberPw === this.member.memberPwChecked && this.checkId){
                let signupMember = {
                    memberId: this.member.memberId, 
                    password: this.member.memberPw,
                    memberName: this.member.name,
                    department: this.member.department,
                    position: this.member.position}

                let formData = new FormData();
                let json = JSON.stringify(signupMember);
                formData.append(
                    "member",
                    new Blob([json], { type: "application/json" })
                );

                formData.append("profileImage", this.member.profileImage);
                
                console.log(this.member.profileImage)
                try{
                    let response = await axios.post(`${backend}/member/signup`, formData, {
                        headers:{
                            "Content-Type": "multipart/form-data",    
                        }
                    });                
                    localStorage.setItem("toastMessage", response.data.message);                      
                    window.location.href = "/login";
                } catch(error){
                    if (error.code === 'ERR_NETWORK') {
                        this.sendErrorMessage(router);
                    } else {
                        toast.error(error.response.data.message, {
                            timeout: timeout,
                        })
                    }
                }
            }
        },
        async changeInfo(router){
            if(this.member.memberPw === this.member.memberPwChecked){
                let changeInfoMember = {
                    password: this.member.memberOldPw, 
                    newPassword: this.member.memberPw,
                }

                let formData = new FormData();
                let json = JSON.stringify(changeInfoMember);
                formData.append(
                    "member",
                    new Blob([json], { type: "application/json" })
                );
                
                formData.append("profileImage", this.member.profileImage);
                try{
                    let response = await axios.patch(`${backend}/member/update`, formData, {
                        headers:{
                            "Content-Type": "multipart/form-data",
                            "Authorization": storedToken
                        }
                    });                 
                    localStorage.removeItem("accessToken")             
                    localStorage.setItem("toastMessage", response.data.message);
                    window.location.href = "/login";
                }catch(error){
                    if(error.response.data.code === "MEMBER_016" || error.response.data.code === "MEMBER_036"){
                        if (error.code === 'ERR_NETWORK') {
                            this.sendErrorMessage(router);
                        } else {
                            toast.error(error.response.data.message, {
                                timeout: timeout,
                            });
                        }
                    }    
                }
            }else{
                toast.error("새롭게 입력하신 비밀번호가 서로 다릅니다.", {
                    timeout: timeout,
                })
            }
        },
        checkForToastMessage() {
            const toastMessage = localStorage.getItem("toastMessage");
            if (toastMessage) {
              toast(toastMessage, {
                timeout: timeout,
              });
              localStorage.removeItem("toastMessage"); // 메시지를 표시한 후에는 삭제
            }
        },
        // 아이디 중복 확인
        async checkIdDuplicate(router) {
            const req = {
                memberId: this.member.memberId
            }
            try {
              const response = await axios.post(`${backend}/member/check/id`, req);
              toast(response.data.message, {
                timeout: timeout,
            })
                this.checkId = true;

            } catch (error) {
                this.checkId = false;
                if (error.code === 'ERR_NETWORK') {
                    this.sendErrorMessage(router);
                } else {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    });
                }
            }
        },
        sendErrorMessage(router) {
            router.push({name: 'error', params: {errorStatus: 500, message: '서버와 연결이 끊어졌습니다. 다시 접속을 시도해주세요.'}})
        }
    },
})