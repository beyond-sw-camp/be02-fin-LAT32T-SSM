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
                      <input v-model="memberStore.member.memberId" type="text" class="form-control form-control-user"
                        placeholder="아이디를 입력해주세요">
                    </div>
                    <div class="form-group">
                      <input v-model="memberStore.member.memberPw" type="password" class="form-control form-control-user"
                        placeholder="비밀번호를 입력해주세요">
                    </div>
                  </form>
                  <hr>
                  <div class="text-center">
                    <router-link to="/signup">
                      <a class="small">계정을 만드세요!</a>
                    </router-link>
                  </div>
                  <hr>
                  <button @click="memberStore.login(memberStore.member)" class="btn btn-primary btn-user btn-block">
                    로그인
                  </button>              
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
import { mapStores } from "pinia";
import { useMemberStore } from "@/stores/useMemberStore";


export default {
  name: 'LoginPage',
  components: {
    
  },
  data() {
    return {
      visibleRight: false,
      
    }
  },
  computed: {
    ...mapStores(useMemberStore,),
  },
  methods: {
    
  },
  mounted() {
    this.memberStore.checkForToastMessage();
  }
}
</script>

<style scoped>
/* 모바일 화면 크기에 대한 미디어 쿼리 */
@media (max-width: 768px) {
  /* 로그인 화면을 감싸고 있는 컨테이너에 대한 스타일 */
  .container, .container-lg, .container-md, .container-xl {
    height: 100vh; /* 뷰포트의 높이와 동일하게 설정 */
    display: flex; /* Flexbox 레이아웃 사용 */
    flex-direction: column; /* 아이템을 세로로 정렬 */
    justify-content: center; /* 수직 방향으로 가운데 정렬 */
    align-items: center; /* 수평 방향으로 가운데 정렬 */
  }

  .card {
    width: 90%; /* 카드의 너비를 화면 너비의 90%로 설정 */
    margin: auto; /* 수평 중앙 정렬 */
  }

  .p-5 {
    padding: 2rem !important; /* 패딩을 줄임 */
  }

  form.user .form-control-user {
    width: auto; /* 입력 필드의 너비를 자동으로 설정 */
    padding: 1rem; /* 패딩 조정 */
  }

  .btn-user {
    padding: 0.75rem; /* 버튼의 패딩 조정 */
  }
}

/* 추가적으로, 다음과 같이 로그인 화면의 요소에 대해 모바일 화면에서 적합한 스타일을 적용할 수 있습니다. */
.card {
  overflow: hidden; /* 카드 내부의 오버플로를 숨김 */
}

.row {
  margin: 0; /* row의 마진 제거 */
}

.col-lg-6 {
  flex: 0 0 100%; /* 모바일에서는 너비를 100%로 설정 */
  max-width: 100%; /* 최대 너비를 100%로 설정 */
}

.text-center a {
  color: #dd1010; /* 링크 색상 */
  text-decoration: none; /* 언더라인 제거 */
  font-size: 1.3rem; /* 폰트 크기 */
  margin-left: 3%;
}
.text-center a:hover {
  color: #1d31b6; /* 호버 시 색상 변경 */
}

.text-center h1 {
  font-size: 2.5rem; /* 헤더 크기 조정 */
  color: #4a4e69; /* 헤더 색상 조정 */
  font-weight: 700; /* 폰트 두께 */
  margin-bottom: 1.5rem; /* 하단 요소와의 간격 */
}

.container,
.container-lg,
.container-md,
.container-xl {
  width: 100%;
  padding-right: .75rem;
  padding-left: .75rem;
  margin-right: auto;
  margin-left: auto;
  display: flex; /* Flexbox 사용 */
  align-items: center; /* 세로 방향 가운데 정렬 */
  justify-content: center; /* 가로 방향 가운데 정렬 */
  height: 100vh; /* 부모 컨테이너의 높이를 화면 높이로 설정 */
}

.row {
  display: flex;
  text-align: center;
  flex-wrap: wrap;
  margin-right: -.75rem;
  margin-left: -.75rem;
  justify-content: center; /* 가운데 정렬 활성화 */
}

.justify-content-center {
  justify-content: center !important;
}

.col,
.col-1,
.col-10,
.col-11,
.col-12,
.col-2,
.col-3,
.col-4,
.col-5,
.col-6,
.col-7,
.col-8,
.col-9,
.col-lg,
.col-lg-1,
.col-lg-10,
.col-lg-11,
.col-lg-12,
.col-lg-2,
.col-lg-3,
.col-lg-4,
.col-lg-5,
.col-lg-6,
.col-lg-7,
.col-lg-8,
.col-lg-9,
.col-md,
.col-md-1,
.col-md-10,
.col-md-11,
.col-md-12,
.col-md-2,
.col-md-3,
.col-md-4,
.col-md-5,
.col-md-6,
.col-md-7,
.col-md-8,
.col-md-9,
.col-xl,
.col-xl-1,
.col-xl-10,
.col-xl-11,
.col-xl-12,
.col-xl-2,
.col-xl-3,
.col-xl-4,
.col-xl-5,
.col-xl-6,
.col-xl-7,
.col-xl-8,
.col-xl-9 {
  position: relative;
  width: 100%;
  padding-right: .75rem;
  padding-left: .75rem;
}

.card {
  margin: auto; /* 수평 중앙 정렬 */
  position: relative;
  display: flex;
  flex-direction: column;
  min-width: 0;
  word-wrap: break-word;
  background-color: #fff;
  background-clip: border-box;
  border: 1px solid #e3e6f0;
  border-radius: .35rem;
  min-width: 100px; /* 최소 너비 설정 */
  max-width: 1000px; /* 최대 너비 설정 */
}

.o-hidden {
  overflow: visible;
}

.border-0 {
  border: 0 !important;
}

.shadow-lg {
  box-shadow: 0 1rem 3rem rgba(0, 0, 0, .175) !important;
}

.my-5 {
  margin-top: 3rem !important;
  margin-bottom: 3rem !important;
}

.card-body {
  flex: 1 1 auto;
  min-height: 1px;
  padding: 1.25rem;
}

.p-0 {
  padding: 0 !important;
}

.p-5 {
  padding: 10rem !important;
}

.text-center {
  text-align: center !important;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  margin-top: 0;
  margin-bottom: .5rem;
}

.text-gray-900 {
  color: #3a3b45 !important;
}

.mb-4,
.my-4 {
  margin-bottom: 1.5rem !important;
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
  transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

form.user .form-control-user {
  font-size: .8rem;
  border-radius: 10rem;
  padding: 1.5rem 1rem;
  width: 30rem;
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

.small,
small {
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
  transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

.btn-primary {
  color: #fff;
  background-color: #4e73df;
  border-color: #4e73df;
  background-color: #4e73df; /* 배경 색상 */
  border: none; /* 테두리 제거 */
  padding: 0.75rem 1.25rem; /* 패딩 조정 */
  font-size: 1rem; /* 폰트 크기 */
  border-radius: 20px; /* 둥근 모서리 */
  transition: background-color 0.3s; /* 배경 색상 변화 애니메이션 */
}

.btn-primary:hover {
  color: #fff;
  background-color: #2e59d9; /* 호버 시 배경 색상 */
  border-color: #2653d4;
}

.btn-primary:focus {
  color: #fff;
  background-color: #2e59d9;
  border-color: #2653d4;
  box-shadow: 0 0 0 .2rem rgba(105, 136, 228, .5);
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
  box-shadow: 0 0 0 .2rem rgba(255, 255, 255, .5);
}
</style>