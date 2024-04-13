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
            if(member.memberId === '' || member.memberPw === ''){
                toast.error("ID나 비밀번호는 공백일 수 없습니다.", {
                    timeout: timeout,
                })
                return;
            }
            try{
                let response = await axios.post(`${backend}/member/login`, loginMember, {
                    headers:{
                        "Content-Type": "application/json",
                    }
                });

                if (response.data.code === 'MEMBER_002') {
                    localStorage.removeItem("accessToken")
                    localStorage.setItem("accessToken", "Bearer " + response.data.result.token);
                    window.location.href = "/";
                }
            }catch(error){
                if (error.message === 'Network Error') {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                } else if(error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003'){
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    });
                } else if (error.response.data.code === 'MEMBER-008' || error.response.data.code === 'MEMBER_009') {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    })
                    localStorage.removeItem("accessToken");
                    this.member.memberId="";
                    this.member.memberPw="";
                    
                } else {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                    this.sendErrorMessage(router);
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
                try{
                    let response = await axios.post(`${backend}/member/signup`, formData, {
                        headers:{
                            "Content-Type": "multipart/form-data",    
                        }
                    });
                    if (response.data.code === 'MEMBER_001') {
                        localStorage.setItem("toastMessage", response.data.message);
                        window.location.href = "/login";
                    }
                } catch(error){
                    if (error.message === 'Network Error') {
                        window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                    } else if(error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003'){
                        toast.error(error.response.data.message, {
                            timeout: timeout,
                        });
                    } else if (error.response.data.code === 'MEMBER-007') {
                        localStorage.removeItem("accessToken");
                        this.member.memberId="";
                        this.member.memberPw="";
                        toast.error(error.response.data.message, {
                            timeout: timeout,
                        })
                    } else {
                        this.sendErrorMessage(router);
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
                    if (response.data.code === 'MEMBER_004') {
                        localStorage.removeItem("accessToken")
                        localStorage.setItem("toastMessage", response.data.message);
                        window.location.href = "/login";
                    }
                }catch(error){
                    if (error.message === 'Network Error') {
                        window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                    } else if(error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003'){
                        toast.error(error.response.data.message, {
                            timeout: timeout,
                        });
                    } else if(error.response.data.code === "MEMBER_008" || error.response.data.code === "MEMBER_009" || error.response.data.code === "MEMBER_010"){
                        toast.error(error.response.data.message, {
                            timeout: timeout,
                        });
                    } else {
                        this.sendErrorMessage(router);
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
              });
              if (response.data.code === 'MEMBER_003') {
                  this.checkId = true;
              }
            } catch (error) {
                this.checkId = false;
                if (error.message === 'Network Error') {
                    window.location.href = '/error/500/서버가 예기치 못한 오류로 인해 종료되었습니다.';
                } else if(error.response.data.code === 'COMMON-001' || error.response.data.code === 'COMMON-002' || error.response.data.code === 'COMMON-003'){
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    });
                } else if (error.response.data.code === "MEMBER-007") {
                    toast.error(error.response.data.message, {
                        timeout: timeout,
                    });
                } else {
                    this.sendErrorMessage(router);
                }
            }
        },
        sendErrorMessage(router) {
            router.push({name: 'error', params: {errorStatus: 500, message: '서버와 연결이 끊어졌습니다. 다시 접속을 시도해주세요.'}})
        }
    },
})