<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <div class="row">
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                  </div>
                  <form class="user">
                    <div class="form-group">
                      <input type="email" class="form-control form-control-user"
                             id="exampleInputEmail" aria-describedby="emailHelp"
                             placeholder="Enter Email Address...">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user"
                             id="exampleInputPassword" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">계정 기억</label>
                      </div>
                    </div>
                    <a href="index.html" class="btn btn-primary btn-user btn-block">
                      로그인
                    </a>
                    <hr>
                    <a href="index.html" class="btn btn-google btn-user btn-block">
                      <i class="fab fa-google fa-fw"></i> 구글로 로그인
                    </a>
                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="forgot-password.html">비밀번호를 잊으셨나요?</a>
                  </div>
                  <div class="text-center">
                    <router-link to="/signup">
                    <a class="small" href="register.html">계정을 만드세요!</a>
                    </router-link>
                  </div>
                  <!-- 채팅방 나가기 모달창 -->
<!--                  <ConfirmDialog></ConfirmDialog>-->
<!--                  <div class="card flex flex-wrap gap-2 justify-content-center">-->
<!--                    <Button @click="confirm()" label="Delete" severity="danger" outlined>채팅방 나가기</Button>-->
<!--                  </div>-->
<!--                  <Toast />-->
                  <!-- 사이드 탭 테스트-->
<!--                  <div class="card flex justify-content-center">-->
<!--                    <Button icon="pi pi-arrow-left" @click="visibleRight = true">탭 열기</Button>-->
<!--                  </div>-->
<!--                  <Sidebar v-model:visible="visibleRight" header="사이드 탭" position="right">-->
<!--                    <SideTabComponent/>-->
<!--                  </Sidebar>-->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
// import SideTabComponent from "@/components/SideTabComponent.vue";
// import Sidebar from "primevue/sidebar";
// import ConfirmDialog from "primevue/confirmdialog";

export default {
  name: 'LoginPage',
  // components: {
  //   SideTabComponent, Sidebar, ConfirmDialog
  // },
  data() {
    return {
      visibleRight: false
    }
  },
  // methods: {
  //   confirm() {
  //     this.$confirm.require({
  //       message: '정말로 채팅방에서 나가시겠습니까?',
  //       header: '채팅방 나가기',
  //       icon: 'pi pi-info-circle',
  //       rejectLabel: '취소하기',
  //       acceptLabel: '나가기',
  //       rejectClass: 'p-button-secondary p-button-outlined',
  //       acceptClass: 'p-button-danger',
  //       accept: () => {
  //         // 취소 이벤트
  //       },
  //       reject: () => {
  //         // 채팅방 나가기 이벤트
  //       }
  //     });
  //   }
  // }
}
</script>

<style>
.container,.container-lg,.container-md,.container-xl {
  width: 100%;
  padding-right: .75rem;
  padding-left: .75rem;
  margin-right: auto;
  margin-left: auto;
}

@media (min-width:576px) {
  .container {
    max-width: 540px;
  }
}

@media (min-width:768px) {
  .container,  .container-md {
    max-width: 720px;
  }
}

@media (min-width:992px) {
  .container,  .container-lg,  .container-md {
    max-width: 960px;
  }
}

@media (min-width:1200px) {
  .container,  .container-lg,  .container-md,  .container-xl {
    max-width: 1140px;
  }
}

.row {
  display: flex;
  text-align: center;
  flex-wrap: wrap;
  margin-right: -.75rem;
  margin-left: -.75rem;
}

.justify-content-center {
  justify-content: center!important;
}

.col,.col-1,.col-10,.col-11,.col-12,.col-2,.col-3,.col-4,.col-5,.col-6,.col-7,.col-8,.col-9,.col-lg,.col-lg-1,.col-lg-10,.col-lg-11,.col-lg-12,.col-lg-2,.col-lg-3,.col-lg-4,.col-lg-5,.col-lg-6,.col-lg-7,.col-lg-8,.col-lg-9,.col-md,.col-md-1,.col-md-10,.col-md-11,.col-md-12,.col-md-2,.col-md-3,.col-md-4,.col-md-5,.col-md-6,.col-md-7,.col-md-8,.col-md-9,.col-xl,.col-xl-1,.col-xl-10,.col-xl-11,.col-xl-12,.col-xl-2,.col-xl-3,.col-xl-4,.col-xl-5,.col-xl-6,.col-xl-7,.col-xl-8,.col-xl-9 {
  position: relative;
  width: 100%;
  padding-right: .75rem;
  padding-left: .75rem;
}

.card {
  position: relative;
  display: flex;
  flex-direction: column;
  min-width: 0;
  word-wrap: break-word;
  background-color: #fff;
  background-clip: border-box;
  border: 1px solid #e3e6f0;
  border-radius: .35rem;
}

.o-hidden {
  overflow: hidden!important;
}

.border-0 {
  border: 0!important;
}

.shadow-lg {
  box-shadow: 0 1rem 3rem rgba(0,0,0,.175)!important;
}

.my-5 {
  margin-top: 3rem!important;
  margin-bottom: 3rem!important;
}

.card-body {
  flex: 1 1 auto;
  min-height: 1px;
  padding: 1.25rem;
}

.p-0 {
  padding: 0!important;
}

.p-5 {
  padding: 15rem!important;
}

.text-center {
  text-align: center!important;
}

h1,h2,h3,h4,h5,h6 {
  margin-top: 0;
  margin-bottom: .5rem;
}

.text-gray-900 {
  color: #3a3b45!important;
}

.mb-4,.my-4 {
  margin-bottom: 1.5rem!important;
}

.form-group {
  margin-bottom: 1rem;
}

.form-control {
  display: block;
  width: 100%;
  height: calc(1.5em + .75rem + 2px);
  padding: .375rem .75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #6e707e;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #d1d3e2;
  border-radius: .35rem;
  transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

form.user .form-control-user {
  font-size: .8rem;
  border-radius: 10rem;
  padding: 1.5rem 1rem;
}

.custom-control {
  align-items: center;
  justify-content: center;
}

.custom-checkbox .custom-control-label::before {
  border-radius: .35rem;
}

small {
  font-size: 80%;
}

.small,small {
  font-size: 80%;
  font-weight: 400;
}

.btn {
  display: inline-block;
  font-weight: 400;
  color: #858796;
  text-align: center;
  vertical-align: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  background-color: transparent;
  border: 1px solid transparent;
  padding: .375rem .75rem;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: .35rem;
  transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
}

.btn-primary {
  color: #fff;
  background-color: #4e73df;
  border-color: #4e73df;
}

.btn-primary:hover {
  color: #fff;
  background-color: #2e59d9;
  border-color: #2653d4;
}

.btn-primary:focus {
  color: #fff;
  background-color: #2e59d9;
  border-color: #2653d4;
  box-shadow: 0 0 0 .2rem rgba(105,136,228,.5);
}

form.user .btn-user {
  font-size: .8rem;
  border-radius: 10rem;
  padding: .75rem 1rem;
}

.btn-block {
  display: block;
  width: 100%;
}

.btn-google {
  color: #fff;
  background-color: #ea4335;
  border-color: #fff;
}

.btn-google:hover {
  color: #fff;
  background-color: #e12717;
  border-color: #e6e6e6;
}

.btn-google:focus {
  color: #fff;
  background-color: #e12717;
  border-color: #e6e6e6;
  box-shadow: 0 0 0 .2rem rgba(255,255,255,.5);
}

</style>