<template>
  <section class="sidebar">
    <article class="sidebar-2">
      <section class="sidebar-user">
        <div class="sidebar-user-info">
          <h4>{{ mainStore.member.name }}</h4>
          <i class="fas fa-chevron-down"></i>
        </div>
        <p class="sidebar-user-info-additional">
          <i class="fas fa-circle"></i>{{ mainStore.member.department }}
        </p>
        <span class="user-edit-icon">
          <div class="card flex justify-content-center">
            <Button class="button-show" label="+" @click="chatRoomStore.closeModal()">+</Button>
            <CreateChatRoomComponent></CreateChatRoomComponent>  
          </div>
        </span>
      </section>
      <section class="channels">
        <h4 class="channels-header">
          <i class="fas fa-sort-down" @click="chatRoomStore.getRoomList(this.$router); chatRoomListHide(); toggleArrow();"  v-show="isArrowVisible"></i> 
          <i class="fas fa-caret-right" @click="chatRoomStore.getRoomList(this.$router); chatRoomListHide(); toggleArrow();" v-show="!isArrowVisible"></i>
          채널
        </h4>
        <ul>
          <li v-for="(item, idx) in chatRoomStore.roomList" :key="idx" v-show="isChatRoomListVisible">
            <router-link v-bind:to="`/${item.chatRoomId}`">
              <a href="#" @click="connectChatRoom(item)">
              <span class="make-white">
              <i class="fas fa-hashtag"></i>
                {{ item.chatRoomName }}
              </span>
              </a>
            </router-link>
          </li>
        </ul>
      </section>
    </article>
  </section>
</template>
<script>
import { useMessageStore } from "@/stores/useMessageStore";
import { useStompStore } from "@/stores/useStompStore";
import { useChatRoomStore } from "@/stores/useChatRoomStore";
import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";
import CreateChatRoomComponent from "@/components/chatting/CreateChatRoomComponent.vue"

export default {
  name: "SidebarComponent",
  components: { CreateChatRoomComponent },
  data() {
    return {
      member: {
        name: "",
        department: "",
        memberId: ""
      },
      memberId: "",
      chatRoomName: "",
      memberList: [],
      visible: false,
      recvList: [],
      isChatRoomListVisible: true,
      isArrowVisible: true,
    }
  },
  computed: {
    ...mapStores(useChatRoomStore, useMainStore, useStompStore, useMessageStore)
  },
  methods: {
    chatRoomListHide() {
      this.isChatRoomListVisible = !this.isChatRoomListVisible;
    },
    toggle(event) {
      this.$refs.op.toggle(event);
    },
    toggleArrow(){
      this.isArrowVisible = !this.isArrowVisible;
    },
    async connectChatRoom(item) {
      await this.stompStore.roomConnect(item.chatRoomId, this.$router)
      
    }
  },
  mounted() {
    this.mainStore.loadMemberData();
  }
};
</script>

<style scoped>
.fa-sort-down {
  cursor: pointer;
}
.fa-caret-right{
  cursor: pointer;
}

/* 기본 스타일링 */
body {
    font-family: 'Arial', sans-serif; /* 기본 글꼴 */
    padding: 20px; /* 페이지 내부 여백 */
    background-color: #f4f4f4; /* 배경색 */
}

/* 제목 스타일 */
.p-text-secondary {
    color: #333; /* 제목 글자색 */
    margin-bottom: 1.25rem; /* 아래쪽 여백 */
    font-size: 1.5rem; /* 글자 크기 */
    font-weight: bold; /* 글자 두께 */
}

/* 플렉스 컨테이너 */
.flex {
    display: flex; /* 플렉스 박스 사용 */
    align-items: center; /* 항목들을 가운데 정렬 */
    gap: 1rem; /* 항목들 사이의 간격 */
}

/* 입력 필드와 레이블 스타일 */
label {
    font-weight: bold; /* 레이블 글자 두께 */
    width: 6rem; /* 레이블 너비 */
}

.input-text {
    flex-grow: 1; /* 입력 필드가 남은 공간을 모두 차지하도록 */
    padding: 0.5rem; /* 입력 필드 내부 여백 */
    border: 1px solid #ccc; /* 테두리 스타일 */
    border-radius: 0.25rem; /* 테두리 모서리 둥글게 */
}

/* 버튼 스타일 */
.button {
    padding: 0.5rem 1rem; /* 버튼 내부 여백 */
    border: none; /* 테두리 없애기 */
    border-radius: 0.25rem; /* 모서리 둥글게 */
    color: white; /* 글자색 */
    cursor: pointer; /* 마우스 커서를 포인터로 */
    transition: background-color 0.3s; /* 배경색 변경시 애니메이션 효과 */
}

/* "추가" 버튼 스타일 */
.button-secondary {
    background-color: #6c757d; /* 배경색 */
}

.button-secondary:hover {
    background-color: #5a6268; /* 호버 시 배경색 */
}

/* "취소하기" 버튼 스타일 */
.button-cancel {
    background-color: #dc3545; /* 배경색 */
}

.button-cancel:hover {
    background-color: #c82333; /* 호버 시 배경색 */
}

/* "생성하기" 버튼 스타일 */
.button-create {
    background-color: #28a745; /* 배경색 */
}

.button-create:hover {
    background-color: #218838; /* 호버 시 배경색 */
}

/* 맨 아래 버튼 그룹 정렬 */
.flex.justify-content-end {
    justify-content: flex-end; /* 오른쪽 정렬 */
}

/* 하단 마진 조정 */
.mb-3, .mb-5 {
    margin-bottom: 1rem; /* 여백 조정 */
}

.gap-2, .gap-3 {
    gap: 0.5rem; /* 간격 조정 */
}

.fa,.fas,.far {
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  display: inline-block;
  font-style: normal;
  font-variant: normal;
  text-rendering: auto;
  line-height: 1;
}

.fa-xs {
  font-size: .75em;
}

.fa-sm {
  font-size: .875em;
}

.fa-1x {
  font-size: 1em;
}

.fa-2x {
  font-size: 2em;
}

.fa-3x {
  font-size: 3em;
}

.fa-4x {
  font-size: 4em;
}

.fa-5x {
  font-size: 5em;
}

.fa-6x {
  font-size: 6em;
}

.fa-7x {
  font-size: 7em;
}

.fa-8x {
  font-size: 8em;
}

.fa-9x {
  font-size: 9em;
}

.fa-10x {
  font-size: 10em;
}

.fa-ul {
  list-style-type: none;
  margin-left: 2.5em;
  padding-left: 0;
}

.fa-ul > li {
  position: relative;
}

.fa-li {
  left: -2em;
  position: absolute;
  text-align: center;
  width: 2em;
  line-height: inherit;
}

@-webkit-keyframes fa-spin {
  0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }

  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}

@keyframes fa-spin {
  0% {
    -webkit-transform: rotate(0deg);
    transform: rotate(0deg);
  }

  100% {
    -webkit-transform: rotate(360deg);
    transform: rotate(360deg);
  }
}

/* Font Awesome uses the Unicode Private Use Area (PUA) to ensure screen
 readers do not read off random characters that represent icons */

.fa-arrow-circle-down:before {
  content: "\f0ab";
}

.fa-arrow-down:before {
  content: "\f063";
}

.fa-at:before {
  content: "\f1fa";
}

.fa-box:before {
  content: "\f466";
}

.fa-chevron-circle-down:before {
  content: "\f13a";
}

.fa-chevron-down:before {
  content: "\f078";
}

.fa-circle:before {
  content: "\f111";
}

.fa-comment:before {
  content: "\f075";
}

.fa-comment-dots:before {
  content: "\f4ad";
}

.fa-css3:before {
  content: "\f13c";
}

.fa-edge:before {
  content: "\f282";
}

.fa-edit:before {
  content: "\f044";
}

.fa-hashtag:before {
  content: "\f292";
}

.fa-heart:before {
  content: "\f004";
}

.fa-html5:before {
  content: "\f13b";
}

.fa-hubspot:before {
  content: "\f3b2";
}

.fa-icons:before {
  content: "\f86d";
}

.fa-info:before {
  content: "\f129";
}

.fa-info-circle:before {
  content: "\f05a";
}

.fa-link:before {
  content: "\f0c1";
}

.fa-lock:before {
  content: "\f023";
}

.fa-minus:before {
  content: "\f068";
}

.fa-minus-circle:before {
  content: "\f056";
}

.fa-slack:before {
  content: "\f198";
}

.fa-sort:before {
  content: "\f0dc";
}

.fa-sort-down:before {
  content: "\f0dd";
}

.fa-user:before {
  content: "\f007";
}

.fa-user-circle:before {
  content: "\f2bd";
}

.fa-user-edit:before {
  content: "\f4ff";
}

.fa-user-lock:before {
  content: "\f502";
}

.fa-user-minus:before {
  content: "\f503";
}

*, :before, :after {
  box-sizing: inherit;
}

@font-face {
  font-family: 'Font Awesome 5 Brands';
  font-style: normal;
  font-weight: 400;
  font-display: block;
  src: url("../../webfonts/fa-brands-400.eot");
  src: url("../../webfonts/fa-brands-400.eot?#iefix") format("embedded-opentype"), url("../../webfonts/fa-brands-400.woff2") format("woff2"), url("../../webfonts/fa-brands-400.woff") format("woff"), url("../../webfonts/fa-brands-400.ttf") format("truetype"), url("../../webfonts/fa-brands-400.svg#fontawesome") format("svg");
}

@font-face {
  font-family: 'Font Awesome 5 Free';
  font-style: normal;
  font-weight: 400;
  font-display: block;
  src: url("../../webfonts/fa-regular-400.eot");
  src: url("../../webfonts/fa-regular-400.eot?#iefix") format("embedded-opentype"), url("../../webfonts/fa-regular-400.woff2") format("woff2"), url("../../webfonts/fa-regular-400.woff") format("woff"), url("../../webfonts/fa-regular-400.ttf") format("truetype"), url("../../webfonts/fa-regular-400.svg#fontawesome") format("svg");
}

.far {
  font-family: 'Font Awesome 5 Free';
  font-weight: 400;
}

@font-face {
  font-family: 'Font Awesome 5 Free';
  font-style: normal;
  font-weight: 900;
  font-display: block;
  src: url("../../webfonts/fa-solid-900.eot");
  src: url("../../webfonts/fa-solid-900.eot?#iefix") format("embedded-opentype"), url("../../webfonts/fa-solid-900.woff2") format("woff2"), url("../../webfonts/fa-solid-900.woff") format("woff"), url("../../webfonts/fa-solid-900.ttf") format("truetype"), url("../../webfonts/fa-solid-900.svg#fontawesome") format("svg");
}

.fa,.fas {
  font-family: 'Font Awesome 5 Free';
  font-weight: 900;
}

html,body,div,span,h1,h2,h3,h4,h5,h6,p,a,i,ul,li,article,header,section {
  margin: 0;
  padding: 0;
  border: 0;
  font: inherit;
  font-size: 100%;
  vertical-align: baseline;
}

html {
  line-height: 1;
  position: relative;
  height: 100%;
  font-size: 1rem;
  font-family: Lato, sans-serif;
  --slack-blue: #376cdf;
  --slack-dark-blue: darkblue;
  --slack-cyan: #6ecadc;
  --slack-green: #3eb991;
  --slack-red: #e01563;
  --slack-yellow: #e9a820;
  --slack-tag-background: #f8f8f8;
  --slack-tag-border-color: rgba(97, 96, 97, 1);
  --slack-tag-forecolor: rgba(134, 134, 134, 1);
  --slack-search-background: #073642;
  --slack-background: #350d36;
  --slack-input-border-color: rgba(29, 28, 29, 0.5);
  --dark-grey: #9e9a9a;
  --slack-other-bckground: #3f0e40;
  --slack-white: #cfc3cf;
  --slack-border-color: rgb(82, 38, 83);
  --slack-main-white: #ffffff;
  --light-gray: #f1f3f5;
}

body {
  margin: 0;
  font-family: Lato, -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto",
    "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue",
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100%;
  width: 100%;
  text-align: justify;
  overflow: hidden;
}

ul {
  list-style: none;
}

article {
  display: block;
}

header {
  display: block;
}

section {
  display: block;
}

* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  outline: none;
}

body::-webkit-scrollbar {
  width: 0.125rem !important;
}

body::-webkit-scrollbar-track {
  box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

body::-webkit-scrollbar-thumb {
  background-color: darkgray;
  outline: 1px solid slategray;
}

/* Header and navigation  */

.header {
  grid-row: 1 / 2;
  width: 100%;
}

/* main */

/* fixed sidebar */

.sidebar {
  border-top: 0.1rem solid var(--slack-border-color);
  grid-column: 1 / 2;
  height: 100vh;
  background-color: var(--slack-other-bckground);
  display: grid;
  grid-template-columns: 4rem minmax(6.25rem, 16.25rem);
  z-index: 100;
}

/* body  */

.body {
  grid-column: 2 / -1;
  background-color: var(--slack-main-white);
  border-right: 0.1rem solid rgba(29, 28, 29, 0.13);
  display: grid;
  grid-template-columns: 1.5fr 1fr;
}

/* body content */

.content {
  grid-column: 1 / 1;
  height: 100vh;
  border-right: 0.1rem solid var(--slack-white);
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto 1fr 10rem;
  grid-template-areas: "header"
    "main"
    "footer";
}

/* body right-sidebar */

/* first left-sidebar */

/* second left-sidebar */

.sidebar-2 {
  grid-column: 1 / -1;
  overflow: auto;
}

/* first left-sidebar content */

.sidebar-1 .box-1 {
  margin-top: 1rem;
}

.sidebar-1 .box-1,.sidebar-1 .box-2 {
  height: 2rem;
  width: 2rem;
  margin-bottom: 0.5rem;
  border: 0.125rem solid var(--slack-other-bckground);
  border-radius: 0.3rem;
}

.sidebar-1 .box-1 {
  background-color: var(--slack-red);
}

.sidebar-1 .box-2 {
  background-color: orangered;
}

.sidebar-1 .box-2:hover,.sidebar-1 .box-1:hover {
  box-shadow: 0 0 0 0.1rem hsl(0, 0%, 100%);
}

.sidebar-1 .box-3 {
  font-size: 1.2rem;
  color: var(--slack-white);
}

/* first left-sidebar ended */

/* second left-sidebar content */

/* user info */

/* adds border-bottom to all section elements except the last one*/

.sidebar-2 section:not(:last-of-type) {
  border-bottom: 0.1rem solid var(--slack-border-color);
}

.sidebar-user {
  color: var(--slack-main-white);
  position: relative;
}

.sidebar-user-info {
  display: flex;
  align-items: center;
  margin: 1rem 0 0.1rem 0.5rem;
  font-weight: bold;
}

.sidebar-user-info h4 {
  font-size: 1rem;
  margin-right: 0.5rem;
}

.sidebar-user-info i {
  font-size: 0.5rem;
}

.sidebar-user-info-additional {
  display: flex;
  align-items: center;
  margin-left: 0.5rem;
  margin-bottom: 1rem;
  font-size: 0.8rem;
  color: var(--slack-white);
}

.sidebar-user-info-additional i {
  color: var(--slack-green);
  font-size: 0.5rem;
  padding-right: 0.3rem;
}

.user-edit-icon {
  position: absolute;
  top: 0;
  right: 1rem;
  width: 2rem;
  height: 2rem;
  border: 0.1rem solid var(--slack-main-white);
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--slack-other-bckground);
}

.user-edit-icon i {
  color: var(--slack-other-bckground);
}

/* user info ends */

/* unread starts */

.unread-header {
  display: flex;
  align-items: center;
  color: var(--slack-main-white);
  margin-top: 0.7rem;
}

.unread-header .unread-icons {
  display: flex;
  flex-direction: column;
  /* align-items: center; */
  margin-right: 1rem;
  margin-left: 0.5rem;
}

.unread-header .unread-icons i {
  line-height: 0.3rem;
}

.unread ul {
  margin-left: 0.5rem;
  margin-bottom: 1rem;
}

.unread li {
  padding: 0.25rem;
}

.unread ul a {
  text-decoration: none;
  color: var(--slack-white);
  font-size: 0.8rem;
}

.unread ul i {
  margin-right: 1rem;
}

/* unread ends */

/* channels starts */

.channels-header {
  display: flex;
  align-items: center;
  color: var(--slack-main-white);
  margin-top: 0.7rem;
  /* text-transform: uppercase; */
}

.channels-header i {
  margin-right: 1rem;
  margin-left: 0.5rem;
}

.channels ul {
  margin-left: 0.5rem;
  margin-bottom: 1rem;
}

.channels li {
  padding: 0.25rem;
}

.channels ul a {
  text-decoration: none;
  color: var(--slack-white);
  font-size: 0.8rem;
  display: flex;
  align-items: center;
}

.channels ul i {
  margin-right: 1rem;
}

.channels .make-white {
  color: var(--slack-main-white);
}

.online {
  font-size: 0.5rem;
  color: var(--slack-green);
}

.offline {
  font-size: 0.5rem;
  color: var(--dark-grey);
}

.active {
  background-color: #376cdf;
  font-weight: bold;
}

.channels .active > a {
  color: var(--slack-green);
  font-size: 1rem;
}

/* channels ends */

/* direct messages  */

/* channels starts */

.direct-messages-header {
  display: flex;
  align-items: center;
  color: var(--slack-main-white);
  margin-top: 0.7rem;
  /* text-transform: uppercase; */
}

.direct-messages-header i {
  margin-right: 1rem;
  margin-left: 0.5rem;
}

.direct-messages ul {
  margin-left: 0.5rem;
  margin-bottom: 1rem;
}

.direct-messages li {
  display: flex;
  align-items: center;
  padding: 0.25rem;
}

.direct-messages ul a {
  text-decoration: none;
  color: var(--slack-white);
  font-size: 0.8rem;
  display: flex;
  align-items: center;
}

.direct-messages ul i {
  margin-right: 1rem;
}

.direct-messages .make-white {
  color: var(--slack-main-white);
}

.active {
  background-color: #2354bd;
  font-weight: bold;
}

.direct-messages .active > a {
  color: var(--slack-green);
  font-size: 1rem;
}

/* end of direct messages  */

/* body */

/* body content */

.content-header {
  /* position: fixed;
  width: 48%; */
  grid-area: header;
  display: flex;
  align-items: center;
  background-color: #fff;
  border-bottom: 0.1rem solid var(--slack-white);
  box-shadow: 0 0 0.2rem -0.2rem rgba(0, 0, 0, 0.3);
  overflow: hidden;
}

.content-header-icons {
  display: flex;
  align-items: center;
}

.content-header-icons {
  margin-bottom: 0.4rem;
  display: flex;
  align-items: center;
}

.content-header-icons i {
  font-size: 0.8rem;
  margin-right: 0.2rem;
}

.content-header-icons span {
  margin-right: 0.8rem;
  font-size: 0.8rem;
}

.info {
  margin-left: auto;
  margin-right: 1rem;
  color: #9e9a9a;
  cursor: pointer;
}

/* feeds */

/* end of feeds */

/* form/footer begins */

/* end of feeds */

/* end of body content */

/* starts right-sidebar */

/* ends right-sidebar */

/* end of body */

.counter {
  margin-left: auto;
  margin-right: 1.2rem;
  width: 1.2rem;
  height: 0.8rem;
  border: 0.1rem solid var(--slack-red);
  border-radius: 0.375rem;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--slack-red);
  color: var(--slack-main-white);
}

/* Channels creation */

/* end of channel creation */

/* card */

.user-name {
  font-weight: bold;
  display: flex;
  align-items: center;
  margin-bottom: 0.3rem;
}

.user-name i {
  margin-left: 0.5rem;
  font-size: 0.6rem;
  color: var(--slack-green);
}

.user-title {
  font-weight: normal;
  font-size: 1rem;
}

/* end of card */

.user-sidebar {
  position: fixed;
  top: 0;
  left: -16.256rem;
  width: 16.256rem;
  height: 100vh;
  background-color: var(--slack-other-bckground);
  box-shadow: -0.1rem 0 0.5rem rgba(0, 0, 0, 0.3);
  transition: left 0.5s cubic-bezier(1, 0, 0, 1);
  overflow: auto;
}

@media (max-width: 1250px) {
  .body {
    grid-template-columns: 1.5fr;
  }

  .content {
    grid-column: 1 / -1;
  }
}

@media (max-width: 806px) {
  .sidebar {
    grid-template-columns: minmax(6.25rem, 16.25rem);
  }

  .sidebar-2 {
    grid-column: 1/-1;
  }

  .sidebar-1 {
    display: none;
  }
}

@media (max-width: 724px) {
  .body {
    grid-column: 1 / -1;
  }

  .sidebar {
    display: none;
  }
}

@media (max-width: 326px) {
  .content-header-icons i {
    font-size: 0.7rem;
    margin-right: 0.1rem;
  }

  .content-header-icons span {
    margin-right: 0.5rem;
    font-size: 0.7rem;
  }
}

.chat-room-list-detail {
  padding: 0.3rem 0.5rem;
  margin: 0.5rem 1rem;
  //background-color: var(--slack-tag-background);
  border-radius: 0.625rem;
  color: var(--slack-tag-border-color);
  display: flex;
  align-items: flex-start;
  flex-grow: 1;
}
 
</style>
