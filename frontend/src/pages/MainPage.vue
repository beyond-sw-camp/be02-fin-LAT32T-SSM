<template>
  <HeaderComponent></HeaderComponent>
  <main class="main">
    <SidebarComponent></SidebarComponent>
    <section class="body">
      <section class="content">
        <section class="content-header" >
          <article class="channel-content-header-details" v-show="isFullcalendarVisible">
            <h4 class="channel-content-header-name">
              {{ mainStore.member.name }} 님의 일정입니다. <i class="fas fa-star"></i>
            </h4>            
          </article>
          <article class="channel-content-header-details" v-show="!isFullcalendarVisible">
            <h4 class="channel-content-header-name">
              {{ chatRoomName }} 채팅방 <i class="fas fa-star"></i>
            </h4>
          </article>
          <button class="btn-borderless btn-slack info" id="info" type="button">
            <div @click="showChatting" v-show="isFullcalendarVisible"> 채팅 </div>
            <div @click="fullCalendarDetails" v-show="!isFullcalendarVisible"> 달력 </div>
          </button>
        </section>
        <section class="feeds" ref="getAllMessage">
          <div v-show="isFullcalendarVisible">
            <FullCalendarComponent></FullCalendarComponent>
          </div>
          <div v-show="!isFullcalendarVisible">
            <div>
              <ChatBlockComponent v-for="(item, idx) in messageStore.recvList" :key="idx" v-bind:item="item" />
            </div>
          </div>
        </section>
        <div @keyup="sendMessage" v-show="!isFullcalendarVisible">
          <textarea id="summernote" v-model="message"></textarea>
        </div>
      </section>
      <section class="right-sidebar">
        <section class="right-sidebar-about">
          <article class="about-header">
            <h4>About Me</h4>
            <i class="fas fa-chevron-down" @click="aboutmeDetails"></i>
          </article>
          <article class="chat-room-list-detail" v-show="isAboutmeVisible">
            <div class="user-details">
              <div class="about-detail">
                <h5>이름</h5>
                <p>{{ mainStore.member.name }}</p>
              </div>
              <div class="about-detail">
                <h5>부서</h5>
                <p>{{ mainStore.member.department }}</p>
              </div>
              <div class="about-detail">
                <h5>직책</h5>
                <p>{{ mainStore.member.position }}</p>
              </div>
            </div>
            <div class="profile-container">
              <h5 id="profile-image">프로필 사진</h5>
              <img :src="mainStore.member.profileImage" @error="getDefaultImage" alt="Profile Image"
                class="profile-img">
            </div>
          </article>
        </section>
        <section class="other-section">
          <article class="about-header">
            <h4>필터</h4>
            <i class="fas fa-chevron-down" @click="filterDetails"></i>
          </article>
          <span v-show="isFilterVisible">
            <div class="chat-block-list">
              <FilterComponent></FilterComponent>
            </div>
          </span>
        </section>
        <section class="other-section">
          <article class="about-header">
            <h4>일정</h4>
            <i class="fas fa-chevron-down" @click="calendarDetails"></i>
          </article>
          <span v-show="isCalendarVisible">
            <CalendarComponent></CalendarComponent>
          </span>
        </section>
        <section class="other-section">
          <article class="about-header">
            <h4>회의실 현황</h4>
            <i class="fas fa-chevron-down" @click="meetingRoomDetails"></i>
          </article>
          <span v-show="isMeetingroomVisible">
            <MeetingRoomComponent></MeetingRoomComponent>
          </span>
        </section>
      </section>
    </section>
  </main>
</template>

<script>
import HeaderComponent from '@/components/utils/HeaderComponent.vue';
import SidebarComponent from '@/components/utils/SidebarComponent.vue';
import ChatBlockComponent from "@/components/chatting/ChatBlockComponent.vue";
import CalendarComponent from '@/components/calendar/CalendarComponent.vue';
import FullCalendarComponent from '@/components/calendar/FullCalendarComponent.vue';
import FilterComponent from '@/components/calendar/FilterComponent.vue';
import MeetingRoomComponent from "@/components/meetingroom/MeetingRoomComponent.vue";
import defaultImage from "../assets/basic_profile.jpg";

import { mapStores } from "pinia";
import { useMessageStore } from "@/stores/useMessageStore";
import { useStompStore } from "@/stores/useStompStore";
import { useMainStore } from "@/stores/useMainStore";
import { mapActions } from "pinia";
import { useChatRoomStore } from "@/stores/useChatRoomStore";
import {toast} from "vue3-toastify";

const timeout = 10000;

export default {
  name: 'MainPage',
  components: {
    HeaderComponent, SidebarComponent, ChatBlockComponent,
    MeetingRoomComponent, CalendarComponent, FullCalendarComponent,
    FilterComponent,
  },
  data() {
    return {
      memberName: "",
      memberId: "",
      message: "",
      recvList: [],
      chatRoomName: "",
      roomList: [],
      username: "",
      chatRoomId: "",
      isAboutmeVisible: true,
      isCalendarVisible: true,
      isMeetingroomVisible: true,
      isFullcalendarVisible: true,
      isFilterVisible: true,
    }
  },
  created() {
    this.mainStore.loadMemberData();
    this.mainStore.notificationData();
  },
  computed: {
    ...mapStores(useMainStore, useMessageStore, useStompStore)
  },
  methods: {
    ...mapActions(useStompStore, ['roomConnect']),
    ...mapActions(useChatRoomStore, ['getRoomList']),
    getDefaultImage(e) {
      e.target.src = defaultImage;
    },
    sendMessage(e) {
      if (this.$route.params.roomId === undefined) {
        toast.error('채팅방에 먼저 접속해주세요', {
          timeout: timeout,
          limit: 2
        });
        $('#summernote').summernote('disable');
      }

      this.message = $('#summernote').summernote('code')
      if (e.keyCode === 13 && this.memberId !== '' && this.message !== '') {
        this.message = this.message.replace(/<[^>]*>?/g, '');
        this.send(this.message);
        $('#summernote').summernote('reset');
      }
    },
    send(message) {
      const msg = {
        chatRoomId: this.$route.params.roomId,
        memberId: this.memberId,
        memberName: this.memberName,
        message: message
      };
      this.stompStore.chatStomp.send("/send/room/" + this.$route.params.roomId, JSON.stringify(msg), {});
      this.$nextTick(() => {
        let message = this.$refs.getAllMessage;
        message.scrollTo(0, message.scrollHeight);
      });
    },
    showChatting() {
      this.isFullcalendarVisible = !this.isFullcalendarVisible;
    },
    setMember(token) {
      token = token.split(" ")[1];
      const payload = token.split('.')[1];
      const tokenData = this.mainStore.base64UrlDecode(payload)
      this.memberId = tokenData.memberId;
      this.memberName = tokenData.memberName;
    },
    aboutmeDetails() {
      this.isAboutmeVisible = !this.isAboutmeVisible;
    },
    calendarDetails() {
      this.isCalendarVisible = !this.isCalendarVisible;
    },
    meetingRoomDetails() {
      this.isMeetingroomVisible = !this.isMeetingroomVisible;
    },
    fullCalendarDetails() {
      this.messageStore.recvList = [];
      this.isFullcalendarVisible = !this.isFullcalendarVisible;
    },
    filterDetails() {
      this.isFilterVisible = !this.isFilterVisible;
    },
    scrollToBottom() {
      this.$nextTick(() => {
        const container = this.$refs.getAllMessage;
        container.scrollTop = container.scrollHeight;
      });
    }
  },
  mounted() {
    this.$loadScript("https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js")
      .then(() => {
        // Script is loaded, do something
        $('#summernote').summernote({
          placeholder: '메시지를 입력해주세요',
          tabsize: 2,
          height: 80,
          toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['table', ['table']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview', 'help']]
          ]
        });
      })
      .catch(() => {
        window.location.href = 'error/404'
      });
    useChatRoomStore().getRoomList(this.$router);
    if (localStorage.getItem("accessToken") !== null) {
      this.setMember(localStorage.getItem("accessToken"));
    }

    this.mainStore.readMember();
    this.mainStore.readMeetingRooms();
    this.mainStore.getProfileImage();
  },
  watch: {
    getAllMessage() {
      this.scrollToBottom();
    }
  },
  updated() {
    this.scrollToBottom();
  },
}
</script>

<style scoped>
/* 마우스를 아이콘 위에 올렸을 때 커서 모양을 pointer로 변경합니다 */
.fas.fa-chevron-down {
  cursor: pointer;
}


.fa,
.fas,
.far {
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  display: inline-block;
  font-style: normal;
  font-variant: normal;
  text-rendering: auto;
  line-height: 1;
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

.fa-rotate-90 {
  -ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=1)";
  -webkit-transform: rotate(90deg);
  transform: rotate(90deg);
}

.fa-rotate-180 {
  -ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=2)";
  -webkit-transform: rotate(180deg);
  transform: rotate(180deg);
}

.fa-rotate-270 {
  -ms-filter: "progid:DXImageTransform.Microsoft.BasicImage(rotation=3)";
  -webkit-transform: rotate(270deg);
  transform: rotate(270deg);
}

:root .fa-rotate-90,
:root .fa-rotate-180,
:root .fa-rotate-270 {
  -webkit-filter: none;
  filter: none;
}

/* Font Awesome uses the Unicode Private Use Area (PUA) to ensure screen
 readers do not read off random characters that represent icons */

.fa-angle-double-down:before {
  content: "\f103";
}

.fa-angle-double-left:before {
  content: "\f100";
}

.fa-angle-double-right:before {
  content: "\f101";
}

.fa-angle-down:before {
  content: "\f107";
}

.fa-angle-left:before {
  content: "\f104";
}

.fa-angle-right:before {
  content: "\f105";
}

.fa-at:before {
  content: "\f1fa";
}

.fa-bold:before {
  content: "\f032";
}

.fa-bolt:before {
  content: "\f0e7";
}

.fa-chevron-circle-down:before {
  content: "\f13a";
}

.fa-chevron-circle-left:before {
  content: "\f137";
}

.fa-chevron-circle-right:before {
  content: "\f138";
}

.fa-chevron-down:before {
  content: "\f078";
}

.fa-chevron-left:before {
  content: "\f053";
}

.fa-chevron-right:before {
  content: "\f054";
}

.fa-circle:before {
  content: "\f111";
}

.fa-code:before {
  content: "\f121";
}

.fa-css3:before {
  content: "\f13c";
}

.fa-css3-alt:before {
  content: "\f38b";
}

.fa-edge:before {
  content: "\f282";
}

.fa-ellipsis-h:before {
  content: "\f141";
}

.fa-file:before {
  content: "\f15b";
}

.fa-file-alt:before {
  content: "\f15c";
}

.fa-file-code:before {
  content: "\f1c9";
}

.fa-home:before {
  content: "\f015";
}

.fa-html5:before {
  content: "\f13b";
}

.fa-icons:before {
  content: "\f86d";
}

.fa-images:before {
  content: "\f302";
}

.fa-info:before {
  content: "\f129";
}

.fa-info-circle:before {
  content: "\f05a";
}

.fa-italic:before {
  content: "\f033";
}

.fa-link:before {
  content: "\f0c1";
}

.fa-list:before {
  content: "\f03a";
}

.fa-list-alt:before {
  content: "\f022";
}

.fa-list-ol:before {
  content: "\f0cb";
}

.fa-list-ul:before {
  content: "\f0ca";
}

.fa-phone:before {
  content: "\f095";
}

.fa-phone-alt:before {
  content: "\f879";
}

.fa-plus:before {
  content: "\f067";
}

.fa-plus-circle:before {
  content: "\f055";
}

.fa-print:before {
  content: "\f02f";
}

.fa-quote-left:before {
  content: "\f10d";
}

.fa-quote-right:before {
  content: "\f10e";
}

.fa-search:before {
  content: "\f002";
}

.fa-search-plus:before {
  content: "\f00e";
}

.fa-slack:before {
  content: "\f198";
}

.fa-smile:before {
  content: "\f118";
}

.fa-sort:before {
  content: "\f0dc";
}

.fa-sort-down:before {
  content: "\f0dd";
}

.fa-stamp:before {
  content: "\f5bf";
}

.fa-star:before {
  content: "\f005";
}

.fa-strikethrough:before {
  content: "\f0cc";
}

.fa-sync:before {
  content: "\f021";
}

.fa-sync-alt:before {
  content: "\f2f1";
}

.fa-tag:before {
  content: "\f02b";
}

.fa-text-width:before {
  content: "\f035";
}

.fa-th:before {
  content: "\f00a";
}

.fa-th-list:before {
  content: "\f00b";
}

.fa-thumbtack:before {
  content: "\f08d";
}

.fa-times:before {
  content: "\f00d";
}

.fa-times-circle:before {
  content: "\f057";
}

.fa-user:before {
  content: "\f007";
}

.fa-user-alt:before {
  content: "\f406";
}

.fa-user-circle:before {
  content: "\f2bd";
}

.fa-user-plus:before {
  content: "\f234";
}

.fa-user-tag:before {
  content: "\f507";
}

.fa-user-times:before {
  content: "\f235";
}

@font-face {
  font-family: 'Font Awesome 5 Brands';
  font-style: normal;
  font-weight: 400;
  font-display: block;
  src: url("../webfonts/fa-brands-400.eot");
  src: url("../webfonts/fa-brands-400.eot?#iefix") format("embedded-opentype"), url("../webfonts/fa-brands-400.woff2") format("woff2"), url("../webfonts/fa-brands-400.woff") format("woff"), url("../webfonts/fa-brands-400.ttf") format("truetype"), url("../webfonts/fa-brands-400.svg#fontawesome") format("svg");
}

@font-face {
  font-family: 'Font Awesome 5 Free';
  font-style: normal;
  font-weight: 400;
  font-display: block;
  src: url("../webfonts/fa-regular-400.eot");
  src: url("../webfonts/fa-regular-400.eot?#iefix") format("embedded-opentype"), url("../webfonts/fa-regular-400.woff2") format("woff2"), url("../webfonts/fa-regular-400.woff") format("woff"), url("../webfonts/fa-regular-400.ttf") format("truetype"), url("../webfonts/fa-regular-400.svg#fontawesome") format("svg");
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
  src: url("../webfonts/fa-solid-900.eot");
  src: url("../webfonts/fa-solid-900.eot?#iefix") format("embedded-opentype"), url("../webfonts/fa-solid-900.woff2") format("woff2"), url("../webfonts/fa-solid-900.woff") format("woff"), url("../webfonts/fa-solid-900.ttf") format("truetype"), url("../webfonts/fa-solid-900.svg#fontawesome") format("svg");
}

.fa,
.fas {
  font-family: 'Font Awesome 5 Free';
  font-weight: 900;
}

html,
body,
div,
span,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
code,
em,
img,
small,
strong,
b,
i,
ol,
ul,
form,
th,
article,
details,
figure,
header,
section,
time {
  margin: 0;
  padding: 0;
  border: 0;
  font: inherit;
  font-size: 100%;
  vertical-align: baseline;
}

th {
  text-align: left;
  font-weight: normal;
  vertical-align: middle;
}

code {
  font-family: source-code-pro, Menlo, Monaco, Consolas, "Courier New",
    monospace;
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

blockquote {
  quotes: none;
}

blockquote:before {
  content: "";
  content: none;
}

blockquote:after {
  content: "";
  content: none;
}

a img {
  border: none;
}

ol {
  list-style: none;
}

ul {
  list-style: none;
}

article {
  display: block;
}

details {
  display: block;
}

figure {
  display: block;
}

header {
  display: block;
}

section {
  display: block;
}

main {
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

.fa-rotate-315 {
  -webkit-transform: rotate(315deg);
  -moz-transform: rotate(315deg);
  -ms-transform: rotate(315deg);
  -o-transform: rotate(315deg);
  transform: rotate(315deg);
}

.container {
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 2.375rem 1fr;
}

/* Header and navigation  */

.header {
  grid-row: 1 / 2;
  width: 100%;
}

/* main */

.main {
  grid-row: 2 / -1;
  display: grid;
  grid-template-columns: 16.25rem 2fr;
  overflow: hidden;
}

/* fixed sidebar */

.sidebar {
  border-top: 0.1rem solid var(--slack-border-color);
  grid-column: 1 / 2;
  height: 100vh;
  background-color: var(--slack-other-bckground);
  display: grid;
  grid-template-columns: 4rem minmax(6.25rem, 16.25rem);
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

.right-sidebar {
  grid-column: 2 /-1;
  background-color: var(--slack-main-white);
}

/* first left-sidebar */

.sidebar-1 {
  grid-column: 1 / 1;
  border-right: 0.1rem solid var(--slack-border-color);
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* second left-sidebar */

.sidebar-2 {
  grid-column: 2 / -1;
  overflow: auto;
}

/* first left-sidebar content */

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

/* user info ends */

/* unread starts */

/* unread ends */

/* channels starts */

/* channels ends */

/* direct messages  */

/* channels starts */

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

.channel-content-header-details {
  display: flex;
  flex-direction: column;
  margin: 1rem 0 0.1rem 1.5rem;
}

.content-header-icons {
  display: flex;
  align-items: center;
}

.channel-content-header-name {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.channel-content-header-name i {
  font-size: 0.8rem;
  color: var(--slack-dark-blue);
  margin-left: 0.5rem;
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

.content-header-text {
  font-size: 0.8rem;
  font-weight: 300;
}

.info {
  margin-left: auto;
  margin-right: 1rem;
  color: #9e9a9a;
  cursor: pointer;
}

/* feeds */

.feeds {
  display: grid;
  overflow: auto;
  padding: 0.9375rem 0.3125rem 0.625rem 0.3125rem;
  align-content: space-between;
}

.feeds2 {
  margin: 0 auto;
  /* 좌우 마진을 자동으로 설정하여 가운데 정렬 */
  position: fixed;
  /* 뷰포트에 대해 고정 */
  bottom: 0;
  /* 하단에 위치 */
  overflow: auto;
  padding: 0.9375rem 0.3125rem 0.625rem 0.3125rem;
  margin-bottom: 1.5rem;

}

.feed {
  display: flex;
  padding: 0.5rem;
  margin-left: 1rem;
  margin-right: 2rem;
}

.feeds-user-avatar {
  width: 2.5rem;
  height: 2.5rem;
  margin-right: 0.5rem;
  flex-shrink: 0;
  position: relative;
}

.feeds-user-avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 0.325rem;
}

.feeds-user-avatar span {
  width: 1.2rem;
  height: 1.2rem;
  border: 0.1rem solid var(--slack-yellow);
  border-radius: 0.275rem;
  padding: 0.2rem;
  box-shadow: 0 0 0 0.1rem hsl(0, 0%, 100%);
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--slack-yellow);
  color: var(--slack-main-white);
  position: absolute;
  top: 1.5rem;
  right: -0.3rem;
}

.feeds-user-info {
  display: flex;
  margin: 1.5rem 0;
}

.feed-user-info h4 {
  font-size: 1rem;
  margin-right: 0.5rem;
  font-weight: bold;
}

.feed-user-info h4 .time-stamp {
  font-size: 0.6rem;
  font-weight: 400;
  text-transform: uppercase;
}

.feed-user-info h4 .tag {
  padding: 0.2rem 0.5rem;
  text-transform: uppercase;
  font-size: 0.7rem;
  border-radius: 0.2rem;
  background-color: var(--slack-tag-background);
  color: var(--slack-tag-forecolor);
  line-height: 2.6;
  margin-right: 0.5rem;
}

.feed-text {
  font-size: 1rem;
  margin-bottom: 1rem;
  text-align: justify;
}

.quoted {
  border-left: 0.3rem solid rgb(7, 105, 185);
}

.quoted h5 {
  margin-left: 1rem;
  color: rgb(7, 105, 185);
  margin-bottom: 0.3rem;
}

.quoted-text {
  margin-left: 1rem;
}

.mention {
  padding: 0.1rem 0.2rem;
  color: var(--slack-blue);
  border-radius: 0.2rem;
  background-color: var(--slack-tag-background);
}

.preparatory-text {
  display: flex;
  align-items: center;
  font-weight: 300;
  margin-bottom: 0.2rem;
}

.preparatory-text i {
  margin-left: 0.3rem;
  color: var(--dark-grey);
}

.file-figure {
  border: 0.1rem solid var(--slack-white);
  padding: 0.8rem 20rem 0.8rem 0.8rem;
  border-radius: 0.375rem;
  display: flex;
  /* width: 34.5rem; */
}

.file-figure i {
  color: var(--slack-green);
  margin-right: 2rem;
}

.file-detail {
  display: flex;
  flex-direction: column;
}

.file-detail h5 {
  font-weight: bold;
  margin-bottom: 0.1rem;
}

.file-detail small {
  font-weight: 300;
  font-size: 0.8rem;
}

.message-info {
  display: flex;
  align-items: center;
}

.message-info .zenith-org {
  margin-right: 0.5rem;
}

.message-info small {
  font-size: 0.8rem;
  font-weight: 300;
}

.message-info strong {
  font-weight: bold;
}

/* end of feeds */

/* form/footer begins */

.form {
  grid-area: footer;
  height: 80%;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
}

.form .input {
  width: 90%;
  height: 40%;
  margin-top: 2%;
  margin-right: 5%;
  margin-left: 5%;
  padding: 0.6rem;
  border-top-left-radius: 0.3125rem;
  border-top-right-radius: 0.3125rem;
  outline: none;
  border-top: 0.0625rem solid var(--slack-input-border-color);
  border-left: 0.0625rem solid var(--slack-input-border-color);
  border-right: 0.0625rem solid var(--slack-input-border-color);
  border-bottom: none;
  overflow: auto;
}

.input-toolbar-icons {
  width: 90%;
  font-size: 1rem;
  padding: 0.2rem 0.5rem;
  display: flex;
  align-items: center;
  background-color: var(--slack-tag-background);
  position: absolute;
  border-bottom-left-radius: 0.3125rem;
  border-bottom-right-radius: 0.3125rem;
  border: 0.0625rem solid var(--slack-input-border-color);
  top: 70%;
  word-wrap: break-word;
  font-weight: 300;
}

.input-toolbar-icons i {
  padding: 0.3rem 0.45rem;
  margin-right: auto;
  cursor: pointer;
  color: var(--slack-tag-forecolor);
}

.move-right>i:first-of-type {
  border-right: 0.1rem solid var(--slack-tag-border-color);
}

.move-right {
  margin-right: auto;
}

.move-left {
  margin-left: auto;
  display: flex;
  align-items: center;
}

.btn-borderless {
  border: none;
  background-color: inherit;
  border-radius: 0.5rem;
  padding: 0;
  transition: all 0.5s ease-out;
}

.button:hover {
  background-color: var(--slack-green);
}

.button:hover i {
  color: var(--slack-main-white);
}

.btn-slack:hover {
  background-color: var(--slack-background);
}

.btn-slack:hover i {
  color: var(--slack-main-white);
}

/* end of feeds */

/* end of body content */

/* starts right-sidebar */

.right-sidebar {
  overflow: auto;
}

.right-sidebar section:not(:last-of-type) {
  border-bottom: 0.1rem solid var(--slack-white);
}

.right-sidebar-header {
  display: flex;
  align-items: center;
}

.right-sidebar-header-details {
  display: flex;
  flex-direction: column;
  margin: 1rem 0 0.1rem 1.5rem;
}

.right-sidebar-header-details h4 {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.right-sidebar-header-details p {
  font-size: 0.85rem;
  font-weight: 300;
  margin-bottom: 0.6rem;
}

.right-sidebar-header i {
  margin-left: auto;
  color: var(--slack-white);
  margin-right: 1rem;
  font-size: 1.2rem;
  cursor: pointer;
}

.right-sidebar-contact {
  display: block;
  align-items: center;
  justify-content: center;
  padding: 0.9375rem 0.3125rem 0.625rem 0.3125rem;
}

.right-sidebar-contact-details {
  display: flex;
  flex-direction: column;
  padding: 0.5rem;
  margin-left: 1rem;
  margin-right: 1rem;
}

.right-sidebar-contact-details span {
  width: 2.4rem;
  height: 2.4rem;
  border-radius: 50%;
  padding: 0.2rem;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--slack-tag-background);
  color: var(--slack-tag-border-color);
  margin-bottom: 0.2rem;
}

.right-sidebar-contact-details span i {
  padding: 1rem;
  font-size: 1.2rem;
}

.right-sidebar-contact-details p {
  color: var(--slack-tag-border-color);
}

.right-sidebar-about {
  margin-bottom: 1rem;
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-start;
}

.right-sidebar-about img {

  margin-left: 15px;
}

#profile-image {
  font-weight: bold;
}

.about-header {
  display: flex;
  align-items: center;
  margin: 1rem 0 0.1rem 1.5rem;
}

.about-header h4 {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.about-header i {
  margin-left: auto;
  color: var(--slack-white);
  margin-right: 1rem;
  font-size: 0.8rem;
}

.chat-room-list-detail {
  padding: 0.3rem 0.5rem;
  margin: 0.5rem 1rem;
  background-color: var(--slack-tag-background);
  border-radius: 0.625rem;
  color: var(--slack-tag-border-color);
  display: flex;
  align-items: flex-start;
  flex-grow: 1;
}

.user-info {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.about-img-container {
  display: flex;
  justify-content: flex-end;
  width: 100%;
}

.profile-img {
  width: 100%;
  /* 이미지 너비 */
  height: 100%;
  /* 이미지 높이 */
  margin-top: 10px;
  /* 위 여백 */
  object-fit: cover;
}

.profile-img {
  width: 200px;
  height: 200px;
  margin-top: 10px;
}

.profile-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-left: 1rem;
  margin-left: 100px;
  position: relative;
}

.about-detail {
  margin: 0.5rem;
  padding: 0.5rem;
}

.about-detail h5 {
  margin-bottom: 0.5rem;
  color: black;
  font-weight: bold;
  /* 굵은 글자로 설정 */
  font-size: 18px;
  /* 폰트 크기를 18px로 설정, 원하는 크기로 조절 가능 */
}

.about-img {
  display: flex;
  align-items: center;
  margin-bottom: 0.5rem;
}

.about-img-wrapper {
  width: 1.5rem;
  height: 1.5rem;
  margin-left: 1rem;
  margin-right: 0.5rem;
  flex-shrink: 0;
}

.about-img-wrapper img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 0.325rem;
}

.about-img small {
  font-size: 0.8rem;
}

.other-section-header {
  display: flex;
  align-items: flex-start;
  margin: 1rem 0 0.1rem 1.5rem;
}

.other-section-header h4 {
  font-size: 1rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.other-section-header div {
  display: flex;
  align-items: center;
  margin-left: auto;
  color: var(--slack-white);
  margin-right: 1rem;
  font-size: 0.8rem;
}

.other-section-header div span {
  margin-right: 0.5rem;
}

.other-section-header div i {
  margin-left: 0.5rem;
}

.other-section-header .cal {
  display: inline-block;
  margin-right: 10rem;
  margin-top: 2rem;
}

.zenith-org {
  width: 1.2rem;
  height: 1.2rem;
  border: 0.1rem solid var(--slack-yellow);
  border-radius: 0.275rem;
  padding: 0.2rem;
  box-shadow: 0 0 0 0.1rem hsl(0, 0%, 100%);
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--slack-yellow);
  color: var(--slack-main-white);
}

.acme-org {
  width: 1.2rem;
  height: 1.2rem;
  border: 0.1rem solid var(--slack-dark-blue);
  border-radius: 0.275rem;
  padding: 0.2rem;
  box-shadow: 0 0 0 0.1rem hsl(0, 0%, 100%);
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: var(--slack-dark-blue);
  color: var(--slack-main-white);
}

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

.channel-container {
  background: var(--slack-background);
  height: 100vh;
  position: relative;
}

.form-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.header-wrapper {
  position: relative;
}

.form-header {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

.btn {
  margin-right: 1rem;
  padding: 0.6rem 1rem;
  font-weight: bold;
  outline: none;
  border: none;
  border-radius: 0.225rem;
  cursor: pointer;
}

/* end of channel creation */

/* card */

.user-detail {
  margin-bottom: 1rem;
}

.user-details {
  display: flex;
  flex-direction: column;
  align-items: flex-start;

}

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

.sidebar-wrapper {
  position: fixed;
  background-color: rgba(0, 0, 0, 0.5);
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  opacity: 0;
  visibility: hidden;
  transition: all 0.5s;
}

.sidebar-wrapper section:not(:last-of-type) {
  border-bottom: 0.1rem solid var(--slack-border-color);
}

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

.right-sidebar-wrapper {
  position: fixed;
  background-color: rgba(0, 0, 0, 0.5);
  top: 0;
  bottom: 0;
  right: 0;
  left: 0;
  opacity: 0;
  visibility: hidden;
  transition: all 0.5s;
}

.channel-right-sidebar {
  position: fixed;
  top: 0;
  right: -20rem;
  width: 20rem;
  height: 100vh;
  background-color: #ffffff;
  box-shadow: -0.1rem 0 0.5rem rgba(0, 0, 0, 0.3);
  transition: right 0.5s cubic-bezier(1, 0, 0, 1);
  overflow: auto;
}

.input:empty::before {
  content: attr(data-placeholder);
  color: #9e9a9a;
}

@media (max-width: 1000px) {
  .body {
    grid-template-columns: 1.5fr;
  }

  .content {
    grid-column: 1 / -1;
  }

  .right-sidebar {
    display: none;
  }
}

@media (max-width: 918px) {
  .file-figure {
    padding: 0.8rem 15rem 0.8rem 0.8rem;
  }
}

@media (max-width: 834px) {
  .file-figure {
    padding: 0.8rem 12rem 0.8rem 0.8rem;
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

  .input-toolbar-icons {
    padding: 0.2rem 0.3rem;
  }

  .input-toolbar-icons i {
    padding: 0.3rem 0.3rem;
  }
}

@media (min-width: 800px) {
  .feeds {
    display: grid;
    align-items: end;
  }
}

@media (max-width: 724px) {
  .main {
    grid-template-columns: 1fr;
  }

  .body {
    grid-column: 1 / -1;
  }

  .sidebar {
    display: none;
  }
}

@media (max-width: 786px) {
  .file-figure {
    padding: 0.8rem 10rem 0.8rem 0.8rem;
  }
}

@media (max-width: 754px) {
  .file-figure {
    padding: 0.8rem 8rem 0.8rem 0.8rem;
  }
}

@media (max-width: 600px) {
  .channel-container {
    position: static;
  }

  .header-wrapper {
    position: static;
  }

  .form-header {
    font-size: 1rem;
    font-weight: bold;
    margin-bottom: 0.5rem;
  }
}

@media (max-width: 506px) {
  .form-container {
    width: 100%;
  }
}

@media (max-width: 495px) {
  .file-figure {
    padding: 0.8rem 5rem 0.8rem 0.8rem;
  }
}

@media (max-width: 466px) {
  .input-toolbar-icons {
    font-size: 0.8rem;
    padding: 0.2rem;
  }

  .input-toolbar-icons i {
    padding: 0.2rem;
  }
}

@media (max-width: 414px) {
  .file-figure {
    padding: 0.8rem;
  }

  .file-detail h5 {
    font-size: 0.8rem;
  }
}

@media (max-width: 358px) {
  .input-toolbar-icons {
    font-size: 0.8rem;
    padding: 0.1rem;
  }

  .input-toolbar-icons i {
    padding: 0.1rem;
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

  .content-header-text {
    font-size: 0.7rem;
  }

  .feed-text {
    font-size: 0.8rem;
    margin-bottom: 1rem;
  }

  .quoted h5 {
    font-size: 0.9rem;
  }

  .quoted-text {
    font-size: 0.8rem;
  }
}

@media (max-width: 324px) {
  .file-figure {
    padding: 0.5rem;
  }

  .file-figure i {
    margin-right: 0.5rem;
  }

  .right-sidebar-contact-details {
    margin-left: 0.5rem;
    margin-right: 0.5rem;
  }

  .right-sidebar-contact-details span {
    width: 1.5rem;
    height: 1.5rem;
  }

  .right-sidebar-contact-details span i {
    padding: 0.5rem;
    font-size: 1rem;
  }

  .about-detail {
    margin: 0.3rem;
    padding: 0.2rem;
  }

  .channel-right-sidebar {
    right: -15rem;
    width: 15rem;
  }
}

@media (max-width: 310px) {
  .input-toolbar-icons {
    font-size: 0.6rem;
  }
}

@media (max-width: 258px) {
  .channel-container {
    overflow: auto;
  }
}

@media (max-width: 254px) {
  .input-toolbar-icons {
    flex-wrap: wrap;
  }
}

.chat-block-list {
  align-items: end;
}
</style>