<template>
  <div>
    <div class="c-sk-modal_portal">
      <div v-show="mainStore.memberSearchStatus"
        class="ReactModal__Overlay ReactModal__Overlay--after-open c-sk-overlay" style="padding: 28px;">
        <div
          class="ReactModal__Content ReactModal__Content--after-open c-sk-modal c-sk-modal--fixed c-sk-modal--responsive p-about_modal"
          role="dialog" aria-label="#테스트 채널 세부정보" aria-modal="false" aria-hidden="false"
          data-qa="channel_details_modal">
          <div class="c-sk-modal_header p-about_modal__header c-sk-modal_header--responsive">
            <div
              class="c-sk-modal_title_bar c-sk-modal_title_bar--pad_right c-sk-modal_title_bar--responsive p-about_modal__title">
              <div class="c-sk-modal_title_bar__text c-sk-modal_title_bar__text_responsive">
                <h1 class="">
                  <span class="p-view_header__channel_title_icon c-inline_channel_icon c-inline_channel_icon--space"
                    data-inline-channel-type-icon="channel">
                    <svg data-c8r="true" data-qa="channel-filled" aria-hidden="true" viewBox="0 0 20 20"
                      class="is-inline">
                      <path fill="currentColor" fill-rule="evenodd"
                        d="M9.984 4.176a1 1 0 0 0-1.968-.352L7.448 7H4a1 1 0 1 0 0 2h3.091l-.803 4.5H3a1 1 0 1 0 0 2h2.93l-.414 2.324a1 1 0 0 0 1.968.352l.478-2.676h2.719l-.415 2.324a1 1 0 1 0 1.968.352l.478-2.676H16a1 1 0 1 0 0-2h-2.93l.803-4.5H17a1 1 0 1 0 0-2h-2.77l.504-2.824a1 1 0 1 0-1.968-.352L12.198 7H9.48zm1.054 9.324L11.84 9H9.123l-.804 4.5z"
                        clip-rule="evenodd"></path>
                    </svg>
                  </span>
                  <span class="p-view_header__channel_title">멤버 검색</span>
                </h1>
              </div>
            </div>
          </div>
          <div class="p-about_modal__tabs" data-qa="tabs_full_height_class">
            <div role="tablist" class="c-tabs__tab_menu" data-qa="tabs_full_width_class" aria-orientation="horizontal">
              <button class="c-button-unstyled c-tabs__tab js-tab c-tabs__tab--active"
                data-qa="channel_details_members_tab" id="members" role="tab" aria-selected="true" tabindex="0"
                type="button"><span class="c-tabs__tab_content">멤버</span><span class="c-tabs__tab_count"
                  data-qa="tabs_item_render_count"></span></button>
            </div>
            <div class="search-form-container">
              <form id="searchForm" class="search-form">
                <div class="input-group">
                  <label for="memberName">이름:</label>
                  <input v-model="mainStore.searchMemberName" type="text" id="memberName" name="memberName"
                    placeholder="이름">
                </div>
              </form>

              <div class="button-container">
                <button @click="mainStore.searchMembers()" class="search-button">검색</button>
                <button @click="mainStore.addFilteredMemberName()" class="add-button">추가</button>
              </div>

            </div>
            <div class="checked-members">
              <h3>선택된 멤버:</h3>
              <span v-for="name in checkedMemberNames" :key="name">{{ name }}, </span>
            </div>
            <div class="members-list">
              <table>
                <thead>
                  <tr>
                    <th>체크</th>
                    <th>ID</th>
                    <th>이름</th>
                    <th>직책</th>
                    <th>부서</th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="(member, index) in mainStore.searchedMember" :key="index">
                    <td><input type="checkbox" v-model="member.checked" /></td>
                    <td>{{ member.memberId }}</td>
                    <td>{{ member.memberName }}</td>
                    <td>{{ member.position }}</td>
                    <td>{{ member.department }}</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
          <button @click="mainStore.openComponent"
            class="c-button-unstyled c-icon_button c-icon_button--size_medium c-sk-modal__close_button c-sk-modal__close_button--responsive c-icon_button--default"
            aria-label="닫기">
            <svg data-v-3885a0bb="" data-c8r="true" data-qa="close" aria-hidden="true" viewBox="0 0 20 20" class=""
              style="--s: 20px;">
              <path data-v-3885a0bb="" fill="currentColor" fill-rule="evenodd"
                d="M16.53 3.47a.75.75 0 0 1 0 1.06L11.06 10l5.47 5.47a.75.75 0 0 1-1.06 1.06L10 11.06l-5.47 5.47a.75.75 0 0 1-1.06-1.06L8.94 10 3.47 4.53a.75.75 0 0 1 1.06-1.06L10 8.94l5.47-5.47a.75.75 0 0 1 1.06 0"
                clip-rule="evenodd"></path>
            </svg>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import '@/styles/common.css';

import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";

export default {
  data() {
    return {
    };
  },
  computed: {
    ...mapStores(useMainStore),
    checkedMemberNames() {
      if (Array.isArray(this.mainStore.searchedMember)) {
        return this.mainStore.searchedMember
          .filter(member => member.checked)
          .map(member => member.memberName);
      } else {
        return [];
      }
    }
  },
  methods: {

  },
};
</script>


<style scoped>
.button-container {
  display: flex; /* Flexbox 레이아웃 사용 */
  justify-content: space-between; /* 자식 요소들 사이에 가능한 모든 공간을 분배 */
}
.add-button {
  background-color: #e21515;
  /* 배경색 */
  color: white;
  /* 글자색 */
  padding: 10px 24px;
  /* 상하, 좌우 패딩 */
  border: none;
  /* 테두리 제거 */
  border-radius: 5px;
  /* 둥근 모서리 */
  cursor: pointer;
  /* 마우스 오버 시 커서 변경 */
  font-size: 16px;
  /* 글자 크기 */
  transition: background-color 0.3s;
  /* 호버 효과를 위한 전환 효과 */
  margin-right: 0; /* 오른쪽 정렬을 위해 */
}

.add-button:hover {
  background-color: #922a2a;
  /* 호버 시 배경색 */
}

.members-list {
  max-width: 800px;
  /* 최대 너비 설정 */
  margin: auto;
  /* 중앙 정렬 */
  overflow-x: auto;
  /* 너비가 부족할 경우 스크롤 생성 */
}

table {
  width: 100%;
  /* 테이블 너비를 부모 요소의 너비로 설정 */
  border-collapse: collapse;
  /* 셀 사이의 경계선을 하나로 합침 */
  table-layout: fixed;
  /* 테이블 레이아웃 고정 */
}

th,
td {
  text-align: left;
  /* 텍스트 왼쪽 정렬 */
  padding: 8px;
  /* 셀 내부 여백 */
}

th {
  background-color: #d9810e;
  /* 헤더 배경색 */
  color: white;
  /* 헤더 글자색 */
}

tr:nth-child(even) {
  background-color: #f2f2f2;
  /* 짝수 행 배경색 */
}

tr:hover {
  background-color: #ddd;
  /* 마우스 호버 시 행 배경색 */
}

input[type="checkbox"] {
  margin-left: auto;
  /* 체크박스 중앙 정렬 */
  margin-right: auto;
  /* 체크박스 중앙 정렬 */
  display: block;
}

.search-form-container {
  max-width: 600px;
  /* margin: 0 auto; */
  padding: 20px;
  background-color: #f5f5f5;
}

.search-form {
  display: flex;
  flex-direction: column;
}

.input-group {
  margin-bottom: 5px;
}

.input-group label {
  display: block;
  margin-bottom: 1px;
  font-weight: bold;
}

.input-group input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.search-button:hover {
  background-color: #0056b3;
}

.position_relative {
  position: relative;
}

.position_fixed {
  position: fixed;
}

.block {
  display: block;
}

.inline_block {
  display: inline-block;
}

.inline_flex {
  display: inline-flex;
}

.inline {
  display: inline;
}

.align_center {
  text-align: center;
}

.align_right {
  text-align: right;
}

.align_top {
  vertical-align: top;
}

.full_width {
  width: 100%;
  max-width: 100%;
}

.full_height {
  height: 100%;
}

.padding_0 {
  padding: 0;
}

.padding_25 {
  padding: 4px;
}

.padding_50 {
  padding: 8px;
}

.padding_75 {
  padding: 12px;
}

.padding_100 {
  padding: 16px;
}

.padding_125 {
  padding: 20px;
}

.padding_150 {
  padding: 24px;
}

.padding_175 {
  padding: 28px;
}

.padding_200 {
  padding: 32px;
}

.padding_250 {
  padding: 40px;
}

.padding_300 {
  padding: 48px;
}

.padding_400 {
  padding: 64px;
}

.padding_500 {
  padding: 80px;
}

.padding_600 {
  padding: 96px;
}

.padding_top_0 {
  padding-top: 0;
}

.padding_top_25 {
  padding-top: 4px;
}

.padding_top_50 {
  padding-top: 8px;
}

.padding_top_75 {
  padding-top: 12px;
}

.padding_top_100 {
  padding-top: 16px;
}

.padding_top_125 {
  padding-top: 20px;
}

.padding_top_150 {
  padding-top: 24px;
}

.padding_top_175 {
  padding-top: 28px;
}

.padding_top_200 {
  padding-top: 32px;
}

.padding_top_250 {
  padding-top: 40px;
}

.padding_top_300 {
  padding-top: 48px;
}

.padding_top_400 {
  padding-top: 64px;
}

.padding_top_500 {
  padding-top: 80px;
}

.padding_top_600 {
  padding-top: 96px;
}

.padding_right_0 {
  padding-right: 0;
}

.padding_right_25 {
  padding-right: 4px;
}

.padding_right_50 {
  padding-right: 8px;
}

.padding_right_75 {
  padding-right: 12px;
}

.padding_right_100 {
  padding-right: 16px;
}

.padding_right_125 {
  padding-right: 20px;
}

.padding_right_150 {
  padding-right: 24px;
}

.padding_right_175 {
  padding-right: 28px;
}

.padding_right_200 {
  padding-right: 32px;
}

.padding_right_250 {
  padding-right: 40px;
}

.padding_right_300 {
  padding-right: 48px;
}

.padding_right_400 {
  padding-right: 64px;
}

.padding_right_500 {
  padding-right: 80px;
}

.padding_right_600 {
  padding-right: 96px;
}

.hidden {
  visibility: hidden;
  display: none;
}

.display_flex {
  display: flex;
}

.align_items_center {
  align-items: center;
}

.align_self_center {
  align-self: center;
}

.justify_content_center {
  justify-content: center;
}

.justify_content_between {
  justify-content: space-between;
}

.overflow_hidden {
  overflow: hidden;
}

.overflow_visible {
  overflow: visible;
}

.overflow_x_scroll {
  overflow-x: scroll;
}

@keyframes c-highlight {
  0% {
    background: #f2c74433;
  }

  to {
    background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  }
}

.small_padding {
  padding: 8px;
}

.small_top_padding {
  padding-top: 8px;
}

.small_right_padding {
  padding-right: 8px;
}

.top_padding {
  padding-top: 16px;
}

.right_padding {
  padding-right: 16px;
}

@font-face {
  font-family: Slack v2;
  src: url(https://a.slack-edge.com/bv1-12/slack-icons-v2-fe043a5.woff2)format("woff2"), url(https://a.slack-edge.com/bv1-12/slack-icons-v2-f1c27d6.woff)format("woff");
  font-style: normal;
  font-weight: 400;
}

.c-icon {
  justify-content: center;
  align-items: center;
  width: 20px;
  height: 20px;
  display: inline-flex;
  position: relative;
}

.c-icon:before {
  font-family: Slack v2;
  font-size: 20px;
  font-style: normal;
  font-weight: 400;
  line-height: 1;
  display: inline-block;
}

.c-icon--inline {
  font-size: inherit;
  font-family: inherit;
  line-height: inherit;
  width: 20px;
  height: auto;
}

.c-icon--inline:before {
  width: 1em;
  height: 1em;
  margin-top: -.5em;
  margin-left: -.5em;
  position: absolute;
  top: 50%;
  left: 50%;
}

.c-infinite_spinner {
  margin: 0 auto;
  position: relative;
}

.c-infinite_spinner--medium {
  width: 18px;
  height: 18px;
}

.c-infinite_spinner--small {
  width: 12px;
  height: 12px;
}

.c-infinite_spinner--inline {
  margin: 0;
  display: inline-block;
}

.c-infinite_spinner__spinner {
  width: 100%;
  height: 100%;
  animation: 1.2s cubic-bezier(.25, .29, .54, .86) infinite c-infinite_spinner__spin;
  position: absolute;
  top: 0;
  left: 0;
  transform: rotate(-45deg);
}

@keyframes c-infinite_spinner__spin {
  0% {
    transform: rotate(0);
  }

  to {
    transform: rotate(360deg);
  }
}

.c-infinite_spinner__tail {
  animation: 1.2s cubic-bezier(.41, .24, .64, .69) infinite c-infinite_spinner__spin;
}

.c-infinite_spinner__bg {
  fill: none;
  opacity: .2;
  stroke-width: 8px;
  stroke: gray;
}

.c-infinite_spinner__path {
  fill: none;
  stroke-width: 8px;
  stroke-dasharray: 55 200;
  stroke-dashoffset: 90px;
  stroke-linecap: round;
}

.c-infinite_spinner--blue .c-infinite_spinner__path {
  stroke: #50acf4;
}

.c-infinite_spinner--fast .c-infinite_spinner__spinner {
  animation-duration: .6s;
}

.c-card {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border: 1px solid var(--saf-0);
  border-radius: 5px;
  margin-bottom: 32px;
  position: relative;
}

.c-card__header {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  border-bottom: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  padding: 16px 24px;
}

.c-card__section {
  border-bottom: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  margin: 0 24px;
  padding: 20px 0;
}

.c-card__section:last-child {
  border-bottom: none;
}

[data-c8r] {
  font-size: var(--s, inherit);
  print-color-adjust: exact;
  flex-shrink: 0;
  width: 1em;
  height: 1em;
  display: block;
}

.is-inline {
  vertical-align: -.125em;
  display: inline-block;
}

@keyframes x-autoclog__viewer_icon--pulse {
  0% {
    opacity: 0;
    transform: scale(1);
  }

  50% {
    transform: scale(1.1);
  }

  to {
    opacity: .5;
    transform: scale(1);
  }
}

@keyframes clog {
  0% {
    box-shadow: inset 0 0 15px 5px #2870adbf;
  }

  to {
    box-shadow: none;
  }
}

.c-link--button {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  font: inherit;
  line-height: inherit;
  overflow: initial;
  text-align: initial;
  vertical-align: initial;
  cursor: pointer;
  vertical-align: baseline;
  background: 0 0;
  border: 0;
  margin: 0;
  padding: 0;
  text-decoration: none;
}

.c-link--button:hover,
.c-link--button:focus,
.c-link--button:active {
  outline: none;
}

.c-link--button:hover,
.c-link--button:active {
  color: rgba(var(--sk_highlight_hover, 11, 76, 140), 1);
  text-decoration: underline;
}

.c-link--disabled,
.c-link--disabled:hover,
.c-link--disabled:active,
.c-link--disabled:focus {
  color: rgba(var(--sk_foreground_high_solid, 134, 134, 134), 1);
  cursor: default;
  pointer-events: none;
  text-decoration: none;
}

.c-button {
  -webkit-user-select: none;
  user-select: none;
  cursor: pointer;
  text-align: center;
  white-space: nowrap;
  -webkit-appearance: none;
  -webkit-tap-highlight-color: transparent;
  border: none;
  border-radius: 4px;
  outline: none;
  justify-content: center;
  align-items: center;
  text-decoration: none;
  display: inline-flex;
  position: relative;
}

.c-button:hover,
.c-button:active,
.c-button:focus {
  text-decoration: none;
}

.c-button--primary {
  color: #fff;
  box-shadow: none;
  background: #007a5a;
  font-weight: 700;
  transition: all 80ms linear;
}

.c-button--primary:after {
  content: "";
  visibility: hidden;
  border-radius: 4px;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}

.c-button--primary:link,
.c-button--primary:visited {
  color: #fff;
}

.c-button--primary:hover {
  color: #fff;
  background: #148567;
  box-shadow: 0 1px 4px #0000004d;
}

.c-button--primary:active {
  box-shadow: none;
  background: #006e51;
}

.c-button--primary.c-button--disabled,
.c-button--primary.c-button--disabled:hover,
.c-button--primary.c-button--disabled:active {
  background: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), .75);
  cursor: default;
  pointer-events: none;
  text-shadow: none;
  border-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  background-clip: initial;
  box-shadow: none;
  transition: all 80ms linear;
}

.c-button--primary.c-button--disabled:hover,
.c-button--primary.c-button--disabled:hover:hover,
.c-button--primary.c-button--disabled:active:hover {
  background: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
}

.c-button--outline {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  --saf-0: rgba(var(--sk_primary_foreground, 29, 28, 29), .3);
  border: 1px solid var(--saf-0);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  background-clip: padding-box;
  font-weight: 700;
  transition: all 80ms linear;
}

.c-button--outline:link,
.c-button--outline:visited {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-button--outline:hover {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  box-shadow: 0 1px 3px #00000014;
}

.c-button--outline:active {
  box-shadow: none;
  border-color: rgba(var(--sk_primary_foreground, 29, 28, 29), .5);
  background: #fbfbfbd3;
}

.c-button--outline.c-button--disabled,
.c-button--outline.c-button--disabled:hover,
.c-button--outline.c-button--disabled:active {
  box-shadow: none;
}

.c-button--outline:active {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
}

.c-button--outline-primary {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  color: #007a5a;
  background-clip: padding-box;
  border: 1px solid #007a5a4d;
  font-weight: 700;
  transition: all 80ms linear;
}

.c-button--outline-primary:link,
.c-button--outline-primary:visited {
  color: #007a5a;
}

.c-button--outline-primary:hover {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  box-shadow: 0 1px 3px #00000014;
}

.c-button--outline-primary:active {
  box-shadow: none;
  background: #fbfbfbd3;
  border-color: #007a5a80;
}

.c-button--outline-primary.c-button--disabled,
.c-button--outline-primary.c-button--disabled:hover,
.c-button--outline-primary.c-button--disabled:active {
  box-shadow: none;
}

.c-button--small {
  min-width: 56px;
  height: 28px;
  padding: 0 12px 1px;
  font-size: 13px;
}

.c-button--medium {
  min-width: 80px;
  height: 36px;
  padding: 0 12px 1px;
  font-size: 15px;
}

.c-button--disabled {
  background: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), .75);
  cursor: default;
  pointer-events: none;
  text-shadow: none;
  border-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  background-clip: initial;
  transition: all 80ms linear;
}

.c-button--disabled:hover {
  background: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
}

.c-button--icon {
  min-width: 0;
  padding: 0;
}

.c-button--icon.c-button--small {
  width: 20px;
  height: 20px;
}

.c-button--icon.c-button--medium {
  width: 28px;
  height: 28px;
}

.c-button-unstyled {
  color: inherit;
  font: inherit;
  line-height: inherit;
  overflow: initial;
  text-align: initial;
  vertical-align: initial;
  cursor: pointer;
  background: 0 0;
  border: 0;
  margin: 0;
  padding: 0;
}

.c-button-unstyled:hover,
.c-button-unstyled:focus,
.c-button-unstyled:active {
  outline: none;
}

.c-button-loading__spinner {
  margin-left: 0;
  margin-right: 0;
  transition: width 80ms linear;
}

.c-button--loading_spinner--hidden {
  width: 0;
}

.c-button-loading__spinner--small {
  margin-left: 8px;
}

.c-button-loading__spinner--medium {
  margin-left: 12px;
}

.c-button--loading_spinner--loading {
  margin-left: 0;
}

.c-icon_button {
  border-radius: 4px;
  justify-content: center;
  align-items: center;
  display: inline-flex;
  position: relative;
}

.c-icon_button:link {
  text-decoration: none;
}

.c-icon_button--size_x-small {
  width: 28px;
  height: 28px;
}

.c-icon_button--size_x-small .c-icon:before {
  font-size: 16px;
}

.c-icon_button--size_small {
  width: 32px;
  height: 32px;
}

.c-icon_button--size_small .c-icon:before {
  font-size: 18px;
}

.c-icon_button--size_medium {
  width: 36px;
  height: 36px;
}

.c-icon_button.c-button--disabled {
  opacity: .5;
}

.c-icon_button--default,
.c-icon_button--default:link,
.c-icon_button--default.c-button-unstyled {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.c-icon_button--default:hover,
.c-icon_button--default:link:hover,
.c-icon_button--default.c-button-unstyled:hover {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-icon_button--default:active,
.c-icon_button--default:link:active,
.c-icon_button--default.c-button-unstyled:active {
  background: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
}

.c-sk-overlay {
  z-index: 1000;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  display: flex;
  position: fixed;
  top: 0;
  left: 0;
  overflow: auto;
}

.c-sk-overlay:before {
  content: "";
  opacity: 0;
  background: #0009;
  width: 100%;
  height: 100%;
  transition: opacity 80ms linear;
  position: absolute;
  top: 0;
  left: 0;
}

.c-sk-overlay--hidden:before {
  display: none;
}

.c-sk-modal {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 18px 48px 0 #00000059;
  border-radius: 8px;
  flex-direction: column;
  max-height: 100%;
  display: flex;
  position: relative;
  overflow: hidden;
}

.c-sk-modal:focus {
  outline: none;
}

.c-sk-modal--fixed {
  width: 100%;
  max-width: 520px;
  height: auto;
}

@media only screen and (max-width: 640px) {
  .c-sk-modal--responsive {
    max-width: 324px;
  }
}

.c-sk-modal__close_button {
  z-index: 1;
  position: absolute;
  top: 20px;
  right: 20px;
}

@media only screen and (max-width: 640px) {
  .c-icon_button--default.c-sk-modal__close_button--responsive {
    color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
    background: 0 0;
    width: 34px;
    height: 34px;
    top: 8px;
    right: 8px;
  }

  .c-icon_button--default.c-sk-modal__close_button--responsive:hover {
    background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
    color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  }
}

.c-sk-modal_title_bar {
  align-items: center;
  width: 100%;
  min-height: 70px;
  padding: 20px 28px;
  display: flex;
}

.c-sk-modal_title_bar__text h1 {
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
}

.c-sk-modal_title_bar__text h1:only-child {
  font-size: 22px;
  font-weight: 900;
  line-height: 1.36365;
}

.c-sk-modal_title_bar__text h2:nth-child(2) {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  margin-right: 24px;
}

.c-sk-modal_title_bar__icon {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 4px;
  align-items: center;
  height: 40px;
  margin-right: 16px;
  line-height: 0;
  display: flex;
}

.c-sk-modal_title_bar--pad_right {
  padding-right: 76px;
}

@media only screen and (max-width: 640px) {
  .c-sk-modal_title_bar--responsive {
    min-height: 36px;
    padding: 8px 8px 8px 16px;
  }

  .c-sk-modal_title_bar--responsive .c-sk-modal_title_bar__icon {
    align-items: center;
    display: flex;
  }

  .c-sk-modal_title_bar__text_responsive {
    flex-direction: column;
    justify-content: center;
    min-height: 36px;
    display: flex;
  }

  .c-sk-modal_title_bar__text_responsive h1:only-child {
    font-size: 18px;
  }
}

.c-sk-modal_content_section {
  padding: 0 28px;
}

@media only screen and (max-width: 640px) {
  .c-sk-modal_content_section--responsive {
    padding: 0 16px;
  }
}

@keyframes c-speedbump-slide-in {
  0% {
    transform: translateY(100%);
  }

  to {
    transform: translateY(0%);
  }
}

@keyframes c-speedbump-slide-out {
  0% {
    transform: translateY(0%);
  }

  to {
    transform: translateY(100%);
  }
}

@keyframes c-popover-fade {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

.c-popover--z_menu {
  z-index: 1042;
}

.c-popover--z_modal {
  z-index: 1000;
}

.c-popover--z_dialog {
  z-index: 1012;
}

.c-sk-modal_header {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 8px 8px 0 0;
  flex-shrink: 0;
  width: 100%;
  min-height: 70px;
  overflow: hidden;
}

@media only screen and (max-width: 640px) {
  .c-sk-modal_header--responsive {
    min-height: 52px;
  }
}

.c-sk-modal_image {
  width: 100%;
  height: auto;
  display: block;
}

.c-sk-modal_image__container {
  width: 100%;
  position: relative;
}

.c-sk-modal_image__container .c-sk-modal_image {
  position: absolute;
  top: 0;
  left: 0;
}

@media only screen and (max-height: 480px) {
  .c-sk-modal_image--responsive {
    display: none;
  }
}

.c-scrollbar {
  position: relative;
  overflow: hidden;
}

.c-scrollbar__hider {
  outline: none;
  height: 100%;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: -50px;
  overflow-x: hidden;
  overflow-y: scroll;
  transform: translateZ(0);
}

.c-scrollbar__hider::-webkit-scrollbar {
  display: none;
}

.c-scrollbar__track {
  width: 8px;
  position: absolute;
  top: 4px;
  bottom: 4px;
  right: 4px;
}

.c-scrollbar__track:before {
  content: "";
  background: 0 0;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: -4px;
}

.c-scrollbar--hidden>.c-scrollbar__track {
  display: none;
}

.c-scrollbar__bar {
  background: rgba(var(--sk_primary_foreground, 29, 28, 29), .52);
  opacity: 0;
  cursor: default;
  z-index: 1;
  will-change: transform;
  border-radius: 4px;
  outline: none;
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.c-scrollbar:hover .c-scrollbar__bar,
.c-scrollbar__bar:active {
  opacity: 1;
}

.c-scrollbar__bar:active:after {
  content: "";
  z-index: 1;
  cursor: default;
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}

.c-sk-modal_content {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  flex-shrink: 1;
  min-height: 50px;
  display: flex;
  position: relative;
  overflow: hidden;
}

.c-sk-modal_content:first-of-type {
  border-radius: 8px 8px 0 0;
}

.c-sk-modal_content:last-of-type {
  border-radius: 0 0 8px 8px;
}

.c-sk-modal_content:only-of-type {
  border-radius: 8px;
}

.c-sk-modal_content:after {
  box-sizing: border-box;
  content: "";
  pointer-events: none;
  border-top: 1px solid #0000;
  border-bottom: 1px solid #0000;
  width: 100%;
  height: 100%;
  transition: border 80ms linear;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}

@keyframes c-toast-fade-in {
  0% {
    opacity: 0;
    transform: translateY(20px);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes c-toast-fade-out {
  0% {
    opacity: 1;
    transform: translateY(0);
  }

  to {
    opacity: 0;
    transform: translateY(20px);
  }
}

@keyframes drop-top-right-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 42, 42);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: translate(61.2px, 22.8px)rotate(75deg);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: translate(61.2px, 22.8px)rotate(75deg);
  }
}

@keyframes drop-left-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 42, 42);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: translate(21.36px, 42px)rotate(254deg)scale(1);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: translate(21.36px, 42px)rotate(254deg)scale(1);
  }
}

@keyframes circle-top-right-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 48, 48);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: matrix(.5, 0, 0, .5, 74.4, 38.4);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: matrix(.5, 0, 0, .5, 74.4, 38.4);
  }
}

@keyframes circle-right-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 48, 48);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: matrix(.5, 0, 0, .5, 78.24, 54.72);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: matrix(.5, 0, 0, .5, 78.24, 54.72);
  }
}

@keyframes circle-bottom-right-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 48, 48);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: matrix(.8, 0, 0, .8, 60, 72);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: matrix(.8, 0, 0, .8, 60, 72);
  }
}

@keyframes circle-top-left-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 48, 48);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: matrix(.5, 0, 0, .5, 18.24, 38.4);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: matrix(.5, 0, 0, .5, 18.24, 38.4);
  }
}

@keyframes star-bottom-right-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 42, 42);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: translate(62.16px, 56.4px)rotate(360deg)scale(1);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: translate(62.16px, 56.4px)rotate(360deg)scale(1);
  }
}

@keyframes star-top-left-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 42, 42);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: translate(18px, 20.4px)rotate(-360deg)scale(1);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: translate(18px, 20.4px)rotate(-360deg)scale(1);
  }
}

@keyframes sprinkle-bottom-left-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 42, 42);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: translate(22.8px, 58.8px)rotate(130deg)scale(.7);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: translate(22.8px, 58.8px)rotate(130deg)scale(.7);
  }
}

@keyframes sprinkle-top-left-anim {
  0% {
    opacity: 0;
    transform: matrix(0, 0, 0, 0, 42, 42);
  }

  60% {
    visibility: visible;
    opacity: 1;
    transform: translate(34.8px, 18px)rotate(44deg)scale(.9);
  }

  to {
    visibility: hidden;
    opacity: 0;
    transform: translate(34.8px, 18px)rotate(44deg)scale(.9);
  }
}

.c-label {
  font-size: 15px;
  font-weight: 700;
  line-height: 1.46667;
}

.c-label--disabled {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-label__text {
  padding-bottom: 8px;
  display: block;
}

.c-label--block {
  margin: 0;
  display: block;
}

.c-label--inline {
  vertical-align: middle;
  align-items: baseline;
  margin-bottom: 4px;
  display: flex;
}

.c-label--inline .c-label__text {
  order: 1;
  padding-bottom: 0;
  font-weight: 400;
  position: relative;
  top: -1px;
}

.c-input_text {
  --saf-0: rgba(var(--sk_primary_foreground, 29, 28, 29), .3);
  border: 1px solid var(--saf-0);
  box-sizing: border-box;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 4px;
  width: 100%;
  height: 36px;
  margin: 0 0 20px;
  padding: 3px 12px 5px;
  font-size: 15px;
  line-height: normal;
  transition: border 80ms ease-out, box-shadow 80ms ease-out;
}

.c-input_text:focus {
  --saf-0: rgba(var(--sk_highlight, 18, 100, 163), 1);
  box-shadow: 0 0 0 1px var(--sk_focused-shadow-color, var(--saf-0)), 0 0 0 5px var(--sk_focused-shadow-color-opaque, #1d9bd14d);
  -webkit-appearance: none;
  border-color: #0000;
  border-radius: 4px;
  outline: none;
}

.c-input_text:focus::-webkit-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text:focus::-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text:focus:-ms-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text:focus:-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text[disabled] {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  --saf-0: rgba(var(--sk_foreground_high_solid, 134, 134, 134), 1);
  border: 1px solid var(--saf-0);
}

.c-input_text::-webkit-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text:-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text::-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text:-ms-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text::placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-input_text--with_default {
  --saf-0: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  border: 1px solid var(--saf-0);
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
  margin-bottom: 0;
}

.c-input_text--with_default:focus {
  --saf-0: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  --saf-1: rgba(var(--sk_foreground_max_solid, 97, 96, 97), .3);
  box-shadow: 0 0 0 1px var(--saf-0), 0 0 0 5px var(--saf-1);
  border-radius: 4px;
}

.c-input_text--small {
  height: 28px;
  padding: 7px 8px;
  font-size: 13px;
  line-height: 1.38462;
}

.c-input_text--with_icon {
  padding-left: 28px;
}

.c-base_icon {
  --sk_base_icon-border-radius: 4px;
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border-radius: var(--sk_base_icon-border-radius);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  flex-shrink: 0;
  position: relative;
}

.c-base_icon--image {
  background-repeat: no-repeat;
  background-size: 100%;
  display: inline-block;
}

.c-base_icon__width_only_container {
  --sk_base_icon-border-radius: 4px;
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border-radius: var(--sk_base_icon-border-radius);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  flex-shrink: 0;
  display: block;
  position: relative;
  overflow: hidden;
}

.c-presence--active {
  color: #007a5a;
}

.c-tabs__tab_container--full_height {
  flex-direction: column;
  flex-grow: 1;
  min-height: 0;
  display: flex;
}

.c-tabs__tab_menu {
  --saf-0: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  box-shadow: inset 0 -1px 0 0 var(--saf-0);
  z-index: 1;
  display: block;
  position: relative;
}

.c-tabs__tab_menu:before,
.c-tabs__tab_menu:after {
  content: "";
  line-height: 0;
  display: table;
}

.c-tabs__tab_menu:after {
  clear: both;
}

.c-tabs__tab_menu--hidden {
  visibility: hidden;
}

.c-tabs__tab_menu--full_width {
  flex-shrink: 0;
  width: 100%;
  display: flex;
}

.c-tabs__tab {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  -webkit-tap-highlight-color: transparent;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  cursor: pointer;
  text-align: center;
  white-space: nowrap;
  background: 0 0;
  border: 0;
  justify-content: center;
  align-items: center;
  margin: 0 8px;
  padding: 9px 0;
  font-weight: 700;
  transition: box-shadow .125s ease-out;
  display: inline-flex;
  box-shadow: inset 0 -2px #0000;
}

.c-tabs__tab:hover {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  text-decoration: none;
}

.c-tabs__tab.c-tabs__tab--active,
.c-tabs__tab:active {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  outline: 0;
  text-decoration: none;
}

.c-tabs__tab:not(:last-child) {
  margin-right: 20px;
}

.c-tabs__tab.c-tabs__tab--disabled {
  pointer-events: none;
}

.c-tabs__tab--full_width {
  width: 100%;
}

.c-tabs__tab_overflow {
  background: 0 0;
  border-radius: 0;
  margin-right: 20px;
  display: inline-flex;
}

.c-tabs__tab_overflow:hover.c-icon_button--default.c-button-unstyled:hover,
.c-tabs__tab_overflow :hover.c-icon_button--default:hover {
  background: 0 0;
}

.c-tabs__tab_overflow.c-tabs__tab--active,
.c-tabs__tab_overflow:active {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  box-shadow: inset 0 -2px 0 0 var(--dt_color-theme-base-inv-hgl-1, #007a5a);
  outline: 0;
  text-decoration: none;
}

.c-tabs__tab_overflow_menu_item .c-menu_item__icon {
  margin-right: 8px;
}

.c-tabs__tab_panel {
  width: 100%
}

.c-tabs__tab_panel--active {
  outline: none;
  display: block;
}

.c-tabs__tab_panel--active.c-tabs__tab_panel--full_height {
  flex-direction: column;
  display: flex;
}

.c-tabs__tab_panel--full_height {
  flex-grow: 1;
  min-height: 0;
}

.c-tabs__tab_icon--right {
  margin-left: 4px;
}

.c-tabs__tab_image {
  vertical-align: middle;
  background-color: #0000;
}

.c-tabs__tab_count {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  margin-left: 4px;
}

.c-tabs__tab_placeholder {
  font-size: 12px;
  line-height: 1.50001;
  font-weight: initial;
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border-radius: 8px;
  width: 80px;
  height: 8px;
  margin: 4px 0;
  display: inline-block;
}

.c-tabs__tab_count_placeholder {
  font-size: 12px;
  line-height: 1.50001;
  font-weight: initial;
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border-radius: 8px;
  width: 20px;
  height: 8px;
  margin-left: 4px;
  display: inline-block;
}

.c-menu_item__button,
.c-menu_item__button:link,
.c-menu_item__button:visited {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  font: inherit;
  cursor: pointer;
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  background: 0 0;
  border: 0;
  border-radius: 0;
  align-items: center;
  width: 100%;
  min-height: 28px;
  padding: 0 24px;
  line-height: normal;
  text-decoration: none;
  display: flex;
  overflow-x: hidden;
  overflow-y: visible;
}

.c-menu_item__button:hover,
.c-menu_item__button:link:hover,
.c-menu_item__button:visited:hover,
.c-menu_item__button:focus,
.c-menu_item__button:link:focus,
.c-menu_item__button:visited:focus,
.c-menu_item__button:active,
.c-menu_item__button:link:active,
.c-menu_item__button:visited:active {
  outline: none;
}

[lang] .c-menu_item__button,
[lang] .c-menu_item__button:link,
[lang] .c-menu_item__button:visited {
  font-size: 15px;
}

[lang=ja-JP] .c-menu_item__button,
[lang=ja-JP] .c-menu_item__button:link,
[lang=ja-JP] .c-menu_item__button:visited {
  font-size: 14px;
}

[lang] .c-menu_item__button,
[lang] .c-menu_item__button:link,
[lang] .c-menu_item__button:visited {
  line-height: 28px;
}

[lang=ja-JP] .c-menu_item__button,
[lang=ja-JP] .c-menu_item__button:link,
[lang=ja-JP] .c-menu_item__button:visited {
  line-height: 30.8px;
}

.c-menu_item__icon {
  text-align: center;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  min-width: 20px;
  max-width: 28px;
  margin-right: 12px;
}

.c-menu_item__icon img {
  --saf-0: rgba(var(--sk_primary_foreground, 29, 28, 29), .11);
  border: 1px solid var(--saf-0);
  border-radius: 4px;
  width: 100%;
  height: 100%;
  display: block;
  overflow: hidden;
}

.c-menu_item__link_icon {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.c-menu_item__link_icon {
  font-size: 16px;
}

.c-menu_item__button--disabled,
.c-menu_item__button--disabled:link,
.c-menu_item__button--disabled:visited {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  cursor: initial;
}

.c-menu_item__button--disabled .c-icon,
.c-menu_item__button--disabled:link .c-icon,
.c-menu_item__button--disabled:visited .c-icon,
.c-menu_item__button--disabled .c-menu_item__icon,
.c-menu_item__button--disabled:link .c-menu_item__icon,
.c-menu_item__button--disabled:visited .c-menu_item__icon {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.c-menu_item__label {
  text-overflow: ellipsis;
  flex: auto;
  position: relative;
  top: -1px;
  overflow: hidden;
}

.c-menu_item__placeholder {
  font-size: 12px;
  line-height: 1.50001;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  margin-top: -4px;
}

.c-menu_item_action_button__container {
  margin-top: 8px;
  padding: 0 16px;
}

.c-menu_item_action_button {
  width: 100%;
}

.c-menu_item__header {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  padding: 4px 24px;
}

.c-menu {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #0000001f;
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  -webkit-user-select: none;
  user-select: none;
  z-index: 1012;
  border-radius: 6px;
  width: 300px;
  min-width: 200px;
  max-width: 100%;
  max-height: calc(100vh - 62px);
  padding: .1px 0;
  overflow-y: auto;
}

[lang] .c-menu {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ja-JP] .c-menu {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ko-KR] .c-menu {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-CN] .c-menu {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-TW] .c-menu {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.c-menu.c-menu--responsive {
  width: 256px;
}

@media (min-width: 640px) {
  .c-menu.c-menu--responsive {
    width: 300px;
  }
}

.c-menu__items {
  margin: 0;
  padding: 12px 0;
}

.c-menu__items:focus {
  outline: 0;
}

.c-truncate {
  --lines: 1;
  -webkit-line-clamp: var(--lines);
  white-space: break-spaces;
  -webkit-box-orient: vertical;
  display: -webkit-box;
  overflow: hidden;
}

.c-truncate--break_words {
  word-break: break-all;
}

.c-input_text_overlay {
  box-sizing: border-box;
  z-index: 3;
  color: #0000;
  pointer-events: none;
  text-align: left;
  white-space: nowrap;
  align-items: center;
  height: 36px;
  margin: 0 0 20px;
  padding: 3px 12px 5px;
  font-size: 15px;
  font-weight: 400;
  line-height: 1.86667;
  display: flex;
  position: absolute;
  left: 0;
  right: 0;
  overflow: hidden;
}

.c-input_text_overlay:before {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  content: attr(data-overlay-prefix);
}

.c-input_text_overlay:after {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  content: attr(data-overlay-suffix);
  background: 0 0;
  margin-left: 1px;
  font-weight: 400;
  display: inline-block;
}

.c-input_text_overlay--icon {
  margin-left: 16px;
}

.c-input_text_icon {
  box-sizing: border-box;
  height: 36px;
  margin: 0;
  padding: 0;
  position: relative;
}

.c-input_text_icon__icon {
  z-index: 3;
  box-sizing: border-box;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  height: 36px;
  margin: 0 0 0 4px;
  padding: 4px 12px;
  font-size: 15px;
  line-height: 1.86667;
  position: absolute;
}

.c-input_text_icon__icon--small {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  width: 1em;
  height: 28px;
}

.c-avatar {
  --sk_avatar-border-radius: 3px;
  cursor: default;
  outline: none;
  display: inline-block;
  position: relative;
}

.c-avatar[data-mask] .c-avatar__presence {
  position: absolute;
  bottom: 0;
  right: 0;
}

.c-avatar[data-mask*=small] .c-avatar__presence {
  font-size: calc(var(--avatar-image-size)*.75);
  transform: translate(43.333%, 23.333%);
}

.c-avatar[data-mask*=base] .c-avatar__presence {
  font-size: calc(var(--avatar-image-size)*.555);
  transform: translate(30%, 30%);
}

.c-avatar[data-mask=mask__base-heart] [class^=c-base_icon] {
  clip-path: url(#mask__base-heart);
}

.c-avatar[data-mask=mask__small-heart] [class^=c-base_icon] {
  clip-path: url(#mask__small-heart);
}

.c-avatar[data-mask=mask__base-single-channel-guest-dnd] [class^=c-base_icon] {
  clip-path: url(#mask__base-single-channel-guest-dnd);
}

.c-avatar[data-mask=mask__base-single-channel-guest] [class^=c-base_icon] {
  clip-path: url(#mask__base-single-channel-guest);
}

.c-avatar[data-mask=mask__small-single-channel-guest-dnd] [class^=c-base_icon] {
  clip-path: url(#mask__small-single-channel-guest-dnd);
}

.c-avatar[data-mask=mask__small-single-channel-guest] [class^=c-base_icon] {
  clip-path: url(#mask__small-single-channel-guest);
}

.c-avatar[data-mask=mask__base-guest-dnd] [class^=c-base_icon] {
  clip-path: url(#mask__base-guest-dnd);
}

.c-avatar[data-mask=mask__base-guest] [class^=c-base_icon] {
  clip-path: url(#mask__base-guest);
}

.c-avatar[data-mask=mask__small-guest-dnd] [class^=c-base_icon] {
  clip-path: url(#mask__small-guest-dnd);
}

.c-avatar[data-mask=mask__small-guest] [class^=c-base_icon] {
  clip-path: url(#mask__small-guest);
}

.c-avatar[data-mask=mask__base-member-dnd] [class^=c-base_icon] {
  clip-path: url(#mask__base-member-dnd);
}

.c-avatar[data-mask=mask__base-member] [class^=c-base_icon] {
  clip-path: url(#mask__base-member);
}

.c-avatar[data-mask=mask__small-member-dnd] [class^=c-base_icon] {
  clip-path: url(#mask__small-member-dnd);
}

.c-avatar[data-mask=mask__small-member] [class^=c-base_icon] {
  clip-path: url(#mask__small-member);
}

.c-avatar__image {
  border-radius: var(--sk_avatar-border-radius);
  display: block;
  width: 100% !important;
  height: 100% !important;
}

.c-avatar .c-avatar__icon {
  position: absolute;
  bottom: -2px;
  right: -2px;
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-huddle_icon__slash {
  to {
    stroke-dashoffset: 0;
  }
}

.c-base_inline_entity {
  white-space: pre;
  display: inline;
}

.c-base_inline_entity__avatar {
  margin-right: 1.6px;
}

.c-base_inline_entity__primary_content {
  white-space: pre-wrap;
  overflow-wrap: break-word;
  display: inline;
}

.c-base_inline_entity--truncate_block {
  display: inline-flex;
}

.c-base_inline_entity__inline_wrapper {
  flex: 1;
  min-width: 0;
  display: inline-flex;
}

.c-base_inline_entity__inline_wrapper .c-base_inline_entity__primary_content {
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.c-inline_channel_icon--space {
  margin-right: 2px;
}

.c-medium_channel_entity {
  flex-direction: column;
  justify-content: center;
  display: flex;
}

.c-medium_channel_entity__name {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  flex: 0 auto;
  align-items: baseline;
  display: flex;
}

.c-medium_channel_entity__channel {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  word-break: break-all;
  overflow-wrap: break-word;
  margin-right: 8px;
  font-weight: 700;
}

.c-base_entity__avatar {
  flex: none;
}

.c-base_entity__text {
  min-width: 0;
}

.c-base_entity__text-contents {
  justify-content: space-between;
  width: 100%;
  min-width: 0;
  display: flex;
}

.c-base_entity--has-avatar {
  justify-content: flex-start;
  align-items: center;
  display: flex;
}

.c-base_entity--medium {
  min-height: 36px;
}

.c-base_entity--medium .c-base_entity__text-contents {
  flex-direction: column;
}

.c-base_entity--medium.c-base_entity--has-avatar .c-base_entity__text-contents {
  margin-top: -4px;
  margin-bottom: -4px;
}

.c-base_entity--medium .c-base_entity__avatar {
  margin-right: 12px;
}

.c-base_entity--small {
  align-items: center;
  line-height: 20px;
  display: flex;
}

.c-base_entity--small .c-base_entity__avatar {
  margin-right: 8px;
}

.c-member_name {
  margin-right: 4px;
}

.c-inline_member_entity .c-member_name {
  margin-right: 0;
}

.c-member_name__indicator {
  margin-left: 4px;
}

.c-member__primary_content {
  align-items: center;
  display: flex;
}

.c-member__primary_content {
  min-width: 0;
  max-width: 100%;
}

.c-member__presence {
  margin-right: 4px;
}

.c-small_member_list_entity .c-member__details {
  margin-left: 8px;
}

.c-member__details {
  font-size: 12px;
  line-height: 1.50001;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.c-base_list_entity {
  box-sizing: border-box;
  align-items: center;
  width: 100%;
  display: flex;
}

.c-base_list_entity__primary_content {
  flex: 1 2;
  min-width: 0;
}

.c-base_list_entity--small {
  padding: 6px;
}

.c-base_list_entity--small.c-base_list_entity--active {
  color: #fff;
  background-color: #1264a3;
}

.c-base_list_entity--medium {
  padding: 12px;
}

.c-base_list_entity--medium.c-base_list_entity--active {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
}

.c-small_channel_entity__content {
  display: flex;
}

.c-small_channel_entity__icon {
  margin-right: 8px;
}

.p-inline_channel_section {
  text-overflow: ellipsis;
  display: inline;
  overflow: hidden;
}

.c-virtual_list {
  position: relative;
  overflow-x: hidden;
  overflow-y: scroll;
}

.c-virtual_list__item {
  width: 100%;
  position: absolute;
}

.c-virtual_list--scrollbar {
  overflow: hidden;
}

.c-virtual_list__item:focus {
  outline-width: 0;
  outline-style: none;
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

html {
  height: 100%;
}

.p-search_button {
  height: 28px;
  margin-right: 0;
}

.p-search_button .c-input_text_icon__icon,
.p-search_button .c-input_text_icon,
.p-search_button .p-search_button__icon,
.p-search_button .p-search_button__input {
  height: 28px;
}

.p-search_button .c-input_text_icon__icon {
  font-size: 20px;
}

.p-search_button .p-search_button__icon {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-search_button .p-search_button__icon,
.p-search_button .p-search_button__input {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border: 1px solid var(--saf-0);
}

.p-search_button .p-search_button__input {
  font-size: 13px;
}

.p-search_button__icon__wrapper {
  align-items: center;
  display: flex;
}

.p-search_button__icon {
  height: 28px;
}

.p-list_header {
  border-bottom: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  align-items: center;
  width: 100%;
  padding: 10px 16px 9px 12px;
  display: flex;
}

.p-list_header__title {
  white-space: nowrap;
  align-items: center;
  font-size: 18px;
  font-weight: 900;
  line-height: 1.3333;
  display: flex;
}

.p-list_header__list_title {
  align-items: center;
  display: flex;
}

.p-list_header__icon {
  margin-right: 6px;
}

.p-list_header__outline_button {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border: 1px solid var(--saf-0);
}

@keyframes c-mrkdwn__snitch {
  0% {
    background: #f0f;
  }

  to {
    background: 0 0;
  }
}

.c-dialog {
  opacity: 0;
  z-index: 1012;
  background: #0009;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  font-size: 15px;
  line-height: 1.46667;
  transition: opacity 80ms linear;
  display: flex;
  position: fixed;
  top: 0;
  left: 0;
}

.c-dialog.ReactModal__Overlay--after-open {
  opacity: 1;
  padding: 36px;
}

.c-dialog__content {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  opacity: 0;
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 18px 48px 0 #00000059;
  border-radius: .5rem;
  outline: none;
  flex-direction: column;
  width: 32.5rem;
  max-width: calc(100% - 32px);
  max-height: 640px;
  transition: opacity 80ms linear, transform 80ms cubic-bezier(.36, .19, .29, 1);
  display: flex;
  position: relative;
  transform: scale(.95);
}

@media only screen and (max-height: 656px) {
  .c-dialog__content {
    max-height: 96%;
  }
}

.ReactModal__Overlay--after-open .c-dialog__content {
  opacity: 1;
  position: fixed;
  transform: scale(1);
}

.c-dialog__header {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  background-clip: padding-box;
  border-radius: 8px 8px 0 0;
  flex-shrink: 0;
  justify-content: space-between;
  align-items: center;
  padding: 16px 24px;
  display: flex;
  position: relative;
}

.c-dialog__header--overflow {
  border-bottom: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
}

.c-dialog__close.c-button-unstyled {
  flex: none;
  align-self: flex-start;
  margin-left: 20px;
  margin-right: -8px;
}

.c-dialog__title {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  width: 100%;
  min-width: 0;
  margin: 0;
  font-size: 22px;
  font-weight: 900;
  line-height: 1.36364;
}

.c-dialog__title_image {
  border-radius: 4px;
  flex-shrink: 0;
  width: 24px;
  height: 24px;
  margin-right: 12px;
  position: relative;
  top: 3px;
}

.c-dialog__body {
  -webkit-user-select: text;
  user-select: text;
  flex-shrink: 1;
  padding: 0 24px;
  overflow-y: auto;
}

@media (-ms-high-contrast:none) {
  .c-dialog__body {
    max-height: 26.5rem;
  }
}

[data-gantry][data-app=app-popouts] .c-dialog__body {
  flex-grow: 1;
}

.c-dialog__overflow_padding {
  padding: 8px 24px;
}

.p-list_icon {
  color: rgb(var(--dt_color-plt-honeycomb-0));
  background-color: rgb(var(--dt_color-plt-honeycomb-40));
  border-radius: 8px;
  justify-content: center;
  align-items: center;
  display: inline-flex;
}

.p-list_icon--search {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  background: 0 0;
}

@keyframes fadeIn {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-setup_prog_disc_success_coachmark--slideInTop {
  0% {
    opacity: 0;
    transform: translateY(-90%);
  }

  to {
    opacity: 1;
    transition: opacity .1s linear, transform .3s cubic-bezier(.36, .19, .29, 1);
    transform: translateY(-100%);
  }
}

@keyframes p-setup_prog_disc_success_coachmark--slideInLeft {
  0% {
    opacity: 0;
    transform: translate(-100%, -50%);
  }

  to {
    opacity: 1;
    transition: opacity .1s linear, transform .3s cubic-bezier(.36, .19, .29, 1);
    transform: translate(-110%, -50%);
  }
}

@keyframes p-setup_prog_disc_success_coachmark--slideInBottomLeft {
  0% {
    opacity: 0;
    transform: translateY(10%);
  }

  to {
    opacity: 1;
    transition: opacity .1s linear, transform .3s cubic-bezier(.36, .19, .29, 1);
    transform: translate(0);
  }
}

@keyframes p-setup_prog_disc_success_coachmark_emoji--fadeOutTop {
  0% {
    opacity: 1;
    transform: translateY(-100%);
  }

  to {
    opacity: 0;
    transition: opacity .2s ease-in-out, transform .2s ease-in-out cubic-bezier(.65, 0, .35, 1);
    transform: translateY(-90%);
  }
}

@keyframes p-setup_prog_disc_success_coachmark_emoji--fadeOutLeft {
  0% {
    opacity: 1;
    transform: translate(-110%, -50%);
  }

  to {
    opacity: 0;
    transition: opacity .2s ease-in-out, transform .2s ease-in-out cubic-bezier(.65, 0, .35, 1);
    transform: translate(-100%, -50%);
  }
}

@keyframes p-setup_prog_disc_success_coachmark_emoji--fadeOutBottomLeft {
  0% {
    opacity: 1;
    transform: translate(0);
  }

  to {
    opacity: 0;
    transition: opacity .2s ease-in-out, transform .2s ease-in-out cubic-bezier(.65, 0, .35, 1);
    transform: translateY(10%);
  }
}

@keyframes p-setup_prog_disc_success_coachmark_emoji--bounceIn {
  0% {
    opacity: 0;
    animation-timing-function: cubic-bezier(.215, .61, .355, 1);
    transform: scale3d(.3, .3, .3);
  }

  20% {
    animation-timing-function: cubic-bezier(.215, .61, .355, 1);
    transform: scale3d(1.1, 1.1, 1.1);
  }

  40% {
    animation-timing-function: cubic-bezier(.215, .61, .355, 1);
    transform: scale3d(.9, .9, .9);
  }

  60% {
    opacity: 1;
    animation-timing-function: cubic-bezier(.215, .61, .355, 1);
    transform: scale3d(1.03, 1.03, 1.03);
  }

  80% {
    animation-timing-function: cubic-bezier(.215, .61, .355, 1);
    transform: scale3d(.97, .97, .97);
  }

  to {
    opacity: 1;
    animation-timing-function: cubic-bezier(.215, .61, .355, 1);
    transform: scale(1);
  }
}

.c-link_entity__title {
  text-overflow: ellipsis;
  white-space: nowrap;
  max-width: 100%;
  overflow: hidden;
}

.c-link_entity__title {
  font-weight: 700;
}

.c-link_entity__img_icon {
  background-size: cover;
}

/*!
 * Quill Editor v1.2.6
 * https://quilljs.com/
 * Copyright (c) 2014, Jason Chen
 * Copyright (c) 2013, salesforce.com
 */

@keyframes shouty-rooster__body {

  0%,
  to {
    transform: rotate(0);
  }

  30%,
  50% {
    transform: rotate(-4deg);
  }
}

@keyframes right-wing {

  0%,
  to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-15deg);
  }
}

@keyframes left-wing {

  0%,
  to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(15deg);
  }
}

@keyframes yellow-tail {

  0%,
  to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-4deg);
  }
}

@keyframes pink-tail {

  0%,
  to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-6deg);
  }
}

@keyframes shout {

  0%,
  to {
    transform-origin: 50%;
    transform: scale(1);
  }

  50% {
    transform: scale(1.05);
  }
}

@keyframes left-cloud {

  0%,
  to {
    transform: translate(0);
  }

  50% {
    transform: translate(10px);
  }
}

@keyframes right-cloud {

  0%,
  to {
    transform: translate(0);
  }

  50% {
    transform: translate(-10px);
  }
}

@keyframes prudent_pigeon__body {

  0%,
  to {
    transform: translateY(0);
  }

  30%,
  50% {
    transform: translateY(-12px);
  }
}

@keyframes prudent_pigeon__envelope {

  0%,
  to {
    transform-origin: 100%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-3deg);
  }
}

@keyframes prudent_pigeon__wing {

  0%,
  to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(10deg);
  }
}

@keyframes prudent_pigeon__envelope_back {

  0%,
  to {
    transform: translate(0, 0);
  }

  50% {
    transform: translate(-4px, -6px);
  }
}

@keyframes prudent_pigeon__envelope_front {

  0%,
  to {
    transform: translate(0, 0);
  }

  50% {
    transform: translate(6px, -8px);
  }
}

@keyframes prudent_pigeon__hat {

  0%,
  to {
    transform: translate(0, 0);
  }

  50% {
    transform: translate(-1px, 3px);
  }
}

@keyframes prudent_pigeon__clouds--left {

  0%,
  to {
    transform: translate(0);
  }

  50% {
    transform: translate(-10px);
  }
}

@keyframes prudent_pigeon__clouds--right {

  0%,
  to {
    transform: translate(0);
  }

  50% {
    transform: translate(10px);
  }
}

@keyframes prudent_pigeon__star--yellow {

  0%,
  to {
    transform: translateY(0);
  }

  50% {
    transform: translateY(-4px);
  }
}

@keyframes prudent_pigeon__star--pink {

  0%,
  to {
    transform: translateY(0);
  }

  50% {
    transform: translateY(4px);
  }
}

@keyframes bounceIn {
  0% {
    opacity: 0;
    transform: translateY(4px);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes p-video_recorder_canvas__pause_icon_fade_in_out {
  0% {
    opacity: 0;
    transform: translate(-50%, -40%);
  }

  25% {
    opacity: 1;
    transform: translate(-50%, -50%);
  }

  75% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-video_recorder_minipanel__fade_in {
  0% {
    opacity: 0;
    transform: scale(.9);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes prog_disc_icon_action_reacji--bg-color {
  0% {
    background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  }

  to {
    background-color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }
}

@keyframes prog_disc_icon_action_reacji--bg-color--ia4 {
  0% {
    background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  }

  to {
    background-color: var(--dt_color-theme-base-inv-hgl-1, rgb(var(--dt_color-plt-ocean-70)));
  }
}

@keyframes prog_disc_icon_action_reacji--bg-color--dark-ia4 {
  0% {
    background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  }

  to {
    background-color: var(--dt_color-theme-base-inv-hgl-1, rgb(var(--dt_color-plt-ocean-70)));
  }
}

@keyframes prog_disc_icon_action_reacji_bg_color--dark {
  0% {
    background-color: #0000;
  }

  to {
    background-color: #f8f8f8;
  }
}

@keyframes prog_disc_icon_action_reacji--width {
  0% {
    width: 36px;
  }

  to {
    width: 100%;
  }
}

@keyframes prog_disc_icon_action_reacji--text-opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes prog_disc_icon_action_reacji--text-slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes prog_disc_icon_action_reacji--text-fade-out {
  0% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes prog_disc_icon_action_reacji--text-slide-down {
  0% {
    transform: translateY(0);
  }

  to {
    transform: translateY(4px);
  }
}

@keyframes prog_disc_icon_action_reacji--bg-color-restore {
  0% {
    background-color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }

  to {
    background-color: #0000;
  }
}

@keyframes prog_disc_icon_action_reacji_bg_color_restore--dark {
  0% {
    background-color: #f8f8f8;
  }

  to {
    background-color: #0000;
  }
}

@keyframes prog_disc_icon_action_reacji--width-collapse {
  0% {
    width: 100%;
  }

  to {
    width: 36px;
  }
}

@keyframes prog_disc_icon_action_texty_button--bg-color {
  0% {
    background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  }

  to {
    background-color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }
}

@keyframes prog_disc_icon_action_texty_button_bg_color--dark {
  0% {
    background-color: #0000;
  }

  to {
    background-color: #f8f8f8;
  }
}

@keyframes prog_disc_icon_action_texty_button--text-opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes prog_disc_icon_action_texty_button--text-slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes clips-button-shake {

  0%,
  to {
    transform: translateY(0);
  }

  40% {
    transform: translateY(-2px);
  }

  60% {
    transform: translateY(2px);
  }
}

.p-channel_name_input__label_title {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  margin-right: 8px;
  display: inline-block;
}

.p-channel_name_input__label_title strong {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-channel_name_input__input {
  margin-top: 8px;
  margin-bottom: 20px;
}

.c-card_container {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  position: relative;
}

.c-card_container__action:active,
.c-card_container__action:focus {
  z-index: 1;
  position: relative;
}

.c-card_container--size_small {
  border-radius: 4px;
  padding: 4px;
}

.c-card_container--size_medium {
  border-radius: 12px;
  padding: 12px;
}

.p-channel_invite_modal__base_modal {
  max-width: 600px;
}

.p-channel_invite_modal__header {
  padding: 12px 28px;
}

.p-channel_invite_modal__link {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  text-decoration: underline;
}

.p-channel_invite_modal__content_section {
  padding: 0 24px;
}

@keyframes fade-background-highlight {
  0% {
    background: #f2c74433;
  }

  to {
    background: 0 0;
  }
}

@keyframes c-message--to-grey {
  0% {
    color: inherit;
  }

  to {
    color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  }
}

@keyframes c-message__reply_bar_prog_disc_flag_text--opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes c-message__reply_bar_prog_disc_flag_text--slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes skintone-emoji-wave {
  50% {
    transform: rotate(15deg);
  }
}

@keyframes skintone-emoji-fade {
  0% {
    opacity: 0;
  }

  50% {
    opacity: .5;
  }

  to {
    opacity: 1;
  }
}

.c-filter_input {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  --saf-0: rgba(var(--sk_primary_foreground, 29, 28, 29), .3);
  border: 1px solid var(--saf-0);
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  border-radius: 4px;
  align-items: center;
  height: 36px;
  padding: 0 8px;
  transition: border 80ms ease-out, box-shadow 80ms ease-out;
  display: flex;
}

.c-filter_input:hover {
  border-color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input.c-filter_input--active {
  --saf-0: rgba(var(--sk_highlight, 18, 100, 163), 1);
  box-shadow: 0 0 0 1px var(--sk_focused-shadow-color, var(--saf-0)), 0 0 0 5px var(--sk_focused-shadow-color-opaque, #1d9bd14d);
  -webkit-appearance: none;
  border-color: #0000;
  border-radius: 4px;
  outline: none;
}

.c-filter_input.c-filter_input--active::-webkit-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input.c-filter_input--active::-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input.c-filter_input--active:-ms-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input.c-filter_input--active:-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input--small {
  height: 28px;
  padding: 0 4px;
  font-size: 13px;
}

.c-filter_input--small .c-filter_input__input[type=text] {
  padding: 0 4px;
}

.c-filter_input__input[type=text] {
  font-size: inherit;
  outline: none;
  width: 100%;
  margin: 0;
  padding: 0 8px;
  border: 0 !important;
}

.c-filter_input__input[type=text]:active,
.c-filter_input__input[type=text]:focus {
  box-shadow: none;
}

.c-filter_input__input[type=text][placeholder] {
  text-overflow: ellipsis;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  background-color: inherit;
}

.c-filter_input__input[type=text]::-webkit-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input__input[type=text]:-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input__input[type=text]::-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input__input[type=text]:-ms-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input__input[type=text]::placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-filter_input__reset_button {
  cursor: pointer;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  font-size: 18px;
  line-height: 1.50001;
  font-weight: initial;
  display: none;
}

.c-filter_input__reset_button:hover {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-filter_input__loading_indicator {
  display: none;
}

.c-filter_input__reset_button--visible,
.c-filter_input__loading_indicator--visible {
  display: inline-flex;
}

.c-filter_input__right_icons {
  width: 20px;
  display: flex;
}

@keyframes row_highlight {
  10% {
    background-color: #f2c74433;
  }
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

input[type=checkbox]:disabled {
  cursor: auto;
}

@keyframes p-toggle_channel_space_action__bg--fade-in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-toggle_channel_space_action__bg--bounce-in {
  0% {
    transform: scale(.5);
  }

  25% {
    transform: scale(1.1);
  }

  50% {
    transform: scale(.92);
  }

  75% {
    transform: scale(1.05);
  }

  to {
    transform: scale(1);
  }
}

@keyframes p-toggle_channel_space_action__bg--bounce-back {
  0% {
    transform: scale(.5);
  }

  25% {
    transform: scale(1.1);
  }

  50% {
    transform: scale(.92);
  }

  75% {
    transform: scale(1.05);
  }

  to {
    transform: scale(1);
  }
}

@keyframes p-toggle_channel_space_action__bg--scale-down {
  0% {
    transform: scale(1);
  }

  to {
    transform: scale(.75);
  }
}

@keyframes p-toggle_channel_space_action__bg--fade-out {
  0% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes blue-pulse {

  0%,
  20% {
    transform: scale(.75);
  }

  80%,
  to {
    transform: scale(1);
  }
}

@keyframes p-toggle_channel_space_action__avatar__toast {
  0% {
    opacity: 0;
    transform: scale(0);
  }

  5% {
    opacity: 1;
  }

  10% {
    opacity: 1;
    transform: scale(1);
  }

  95% {
    opacity: 1;
    transform: scale(1);
  }

  to {
    opacity: 0;
    transform: scale(0);
  }
}

@keyframes p-toggle_channel_space_action__avatar__toast_fade {
  0% {
    opacity: 1;
    transform: scale(1);
  }

  5% {
    opacity: 0;
    transform: scale(0);
  }

  95% {
    opacity: 0;
    transform: scale(0);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

.p-section_block__image {
  background-position: 50%;
  background-repeat: no-repeat;
  background-size: cover;
  border-radius: 8px;
  width: 88px;
  height: 88px;
  margin-left: 4px;
  overflow: hidden;
}

.p-image_block__title {
  display: inline-block;
}

.p-action_block__icons {
  position: absolute;
  top: 13px;
  right: -19px;
}

.p-action_block__icons--small {
  right: -13px;
}

.p-section_block {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  flex-direction: row-reverse;
  width: 100%;
  margin: 8px 0 4px;
  display: flex;
}

.p-section_block__text {
  width: 100%;
}

.p-section_block_text_content {
  flex: 1;
}

.p-section_block__icons {
  position: absolute;
  top: 2px;
  right: -30px;
}

.p-section_block__icons--small {
  top: 3px;
  right: -19px;
}

.p-section_block_wrapper--modal_view .p-section_block {
  margin: 0;
}

.p-section_block_wrapper--modal_view .p-section_block_text_content {
  width: 340px;
}

.p-section_block_wrapper--modal_view .p-section_block__icons--small {
  right: -18px;
}

.p-section_block_wrapper--modal_view .p-section_block__icons--small .c-icon {
  width: 12px;
}

.p-section_block_wrapper--modal_view .p-section_block__image {
  margin-left: 0;
}

.p-image_block_image {
  border-radius: 4px;
  display: block;
  overflow: hidden;
}

.p-image_block {
  margin: 8px 0;
  display: block;
}

.p-image_block_container {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  display: inline-block;
}

.p-image_block_container--full_width,
.p-image_block--full_width {
  width: 100%;
}

.p-image_block__title {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
}

.p-image_block_wrapper--modal_view .p-image_block {
  margin: 0;
}

.p-image_block_wrapper--modal_view .p-image_block__title {
  text-align: center;
  width: 100%;
}

@keyframes p-media_reactions_reel__item_fade_in_out {
  0% {
    opacity: 0;
    pointer-events: none;
  }

  10% {
    opacity: 1;
    pointer-events: all;
  }

  75% {
    opacity: 1;
    pointer-events: all;
  }

  to {
    opacity: 0;
    pointer-events: none;
  }
}

@keyframes p-media_reactions_reel__item_container_grow {
  0% {
    height: 0;
  }

  10% {
    height: 38px;
  }

  to {
    height: 38px;
  }
}

@keyframes p-media_reactions_confetti__animation {
  0% {
    opacity: 0;
    transform: matrix(1, 0, 0, 1, 0, 0);
  }

  10% {
    opacity: 1;
  }

  50% {
    opacity: 1;
  }

  to {
    opacity: 0;
    transform: translate(var(--media_reactions_confetti_x), var(--media_reactions_confetti_y))rotateZ(var(--media_reactions_confetti_rotation));
  }
}

@keyframes open-in-new-window-pulse {

  0%,
  20% {
    transform: scale(.75);
  }

  80%,
  to {
    transform: scale(1);
  }
}

@keyframes blink {
  50% {
    background-color: #0000;
  }
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

.p-call_block {
  width: 100%;
}

.p-block_kit_input_block {
  position: relative;
}

.p-block_kit_input_block .c-label__text .p-block_kit_input_block__label {
  font-weight: 700;
  display: inline;
}

.p-block_kit_input_block .c-input_text {
  margin-bottom: 0;
}

.p-block_kit_input_block__label_container {
  justify-content: space-between;
  align-items: center;
  display: flex;
}

.p-block_kit_input_block--full_width {
  width: 100%;
}

.p-block_kit_input_block__icons {
  position: absolute;
  top: 35px;
  right: -30px;
}

.p-block_kit_input_block__icons--small {
  top: 4px;
  right: -18px;
}

.p-header_block {
  width: 100%;
  margin: 1em 0 4px;
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
}

@keyframes p-video_button_icon--blink {
  0% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

.p-channel_section_modal_input__dialog .c-dialog__header {
  padding-bottom: 11px;
}

.p-channel_section_modal_input__dialog .c-dialog__body {
  padding-top: 5px;
  padding-bottom: 5px;
}

.p-channel_section_modal_input__dialog .c-dialog__body {
  padding-left: 0;
  padding-right: 0;
}

.p-channel_section_modal_input__text_input {
  padding-left: 50px;
  padding-right: 33px;
  line-height: 1.4667;
}

.p-channel_section_modal_input__text_input.c-input_text {
  text-overflow: ellipsis;
  margin: 0;
  font-weight: 700;
}

.p-channel_section_modal_input__label {
  white-space: pre-wrap;
}

.p-channel_section_modal_input__dialog {
  top: 20vh;
}

.p-channel_section_modal_input__dialog .p-channel_section_modal_input__text_input {
  height: initial;
  min-height: initial;
  max-height: initial;
  padding: 10px 50px;
}

.p-channel_section_modal_input__dialog .p-channel_section_modal_input__text_input p {
  font-size: 1.25rem;
  font-weight: 700;
  line-height: 1.4667;
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

@keyframes fade-in-90 {
  0% {
    opacity: 0;
    animation-timing-function: step-end;
  }

  to {
    opacity: 1;
  }
}

@keyframes fade-in-180 {
  0% {
    opacity: 0;
    animation-timing-function: step-end;
  }

  to {
    opacity: 1;
  }
}

@keyframes fade-in-270 {
  0% {
    opacity: 0;
    animation-timing-function: step-end;
  }

  to {
    opacity: 1;
  }
}

@keyframes fade-in-360 {
  0% {
    opacity: 0;
    animation-timing-function: step-end;
  }

  to {
    opacity: 1;
  }
}

.c-search_modal {
  z-index: 1001;
  width: 100vw;
  height: 100%;
  font-size: 16px;
  line-height: 16px;
}

.c-search_modal>.popover {
  top: 12px !important;
}

.c-search_modal>.popover {
  min-width: 744px;
  right: 108px;
  left: 108px !important;
}

@media screen and (max-width: 960px) {
  .c-search_modal>.popover {
    right: 12px;
    left: 12px !important;
  }
}

.c-search_modal .popover>div {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #0000001f;
  border-radius: 8px;
  flex-direction: column;
  height: 100%;
  display: flex;
  overflow: hidden;
}

.c-search_modal__wrapper {
  flex-direction: column;
  height: 100%;
  display: flex;
  position: relative;
}

.c-search__container {
  flex: 1 0 0;
  position: relative;
}

.c-search {
  background-color: #0000;
  flex-direction: column;
  height: 100%;
  display: flex;
}

.c-search__close_btn {
  z-index: 3;
  position: absolute;
  top: -46px;
  right: 20px;
}

.c-search__close_btn--ia_details_popover {
  top: -42px;
  right: 12px;
}

.c-search__view {
  display: flex;
}

.c-search__section+.c-search__section {
  margin-top: 1rem;
}

.c-search__expand {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  font: inherit;
  line-height: inherit;
  overflow: initial;
  text-align: initial;
  vertical-align: initial;
  cursor: pointer;
  background: 0 0;
  border: 0;
  margin: 0 4px;
  padding: 0;
  font-size: 13px;
  display: inline;
  position: relative;
}

.c-search__expand:hover,
.c-search__expand:focus,
.c-search__expand:active {
  outline: none;
}

.c-search__expand:hover {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
}

.c-search__section_header {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  justify-content: space-between;
  margin-bottom: 0;
  font-size: 15px;
  font-weight: 700;
  display: flex;
}

.c-search__section_header+* {
  margin-top: 8px;
}

.c-search__tabs {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  flex: none;
  padding: 2px 12px 0;
}

.c-search__tabs .c-tabs__tab {
  padding: 12px 0;
}

.c-search__tabs_wrapper {
  padding-right: 60px;
}

.c-search__tabs--ia4 {
  background-color: #0000;
}

.c-search__tabs--ia4 .c-search__tabs_wrapper {
  max-width: 1000px;
  margin: auto;
}

.c-search__tabs--ia4 .c-tabs__tab {
  height: 48px;
}

.c-search__tabs_label {
  display: flex;
}

.c-search_modal {
  -webkit-app-region: no-drag;
  z-index: 1000;
  background: 0 0;
}

@media screen and (min-width: 960px) {
  .c-search_modal>.popover {
    min-width: 800px;
    max-width: 800px;
    right: auto;
    transform: translate(-50%);
    left: 50% !important;
  }
}

@media screen and (min-width: 1092px) {
  .c-search_modal>.popover {
    min-width: 924px;
    max-width: 924px;
  }
}

@media screen and (max-width: 959px) {
  .c-search_modal.c-search_modal--ia4>.popover {
    min-width: unset;
    left: 76px !important;
    right: 76px !important;
  }
}

@keyframes pulse {
  0% {
    box-shadow: 0 0 #1264a3a3;
  }

  40% {
    box-shadow: 0 0 16px #1264a3a3;
  }

  80% {
    box-shadow: 0 0 36px #1264a300;
  }

  to {
    box-shadow: 0 0 36px #1264a300;
  }
}

@keyframes messagePaneDragOverlayOverlayTransition {
  0% {
    background: rgba(var(--sk_primary_background, 255, 255, 255), 0);
    opacity: 0;
  }

  to {
    background: rgba(var(--sk_primary_background, 255, 255, 255), .95);
    opacity: 1;
  }
}

@keyframes circleAnim {
  0% {
    opacity: 0;
    transform: scale(.5);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes card3Anim {
  0% {
    transform: scale(.5)rotate(4.99999deg);
  }

  to {
    transform: translateY(-30px);
  }
}

@keyframes card2Anim {
  0% {
    transform: scale(.5)rotate(15deg);
  }

  to {
    transform: translate(-20px);
  }
}

@keyframes card1Anim {
  0% {
    transform: scale(.5)rotate(-10deg)translate(0);
  }

  to {
    transform: translate(30px);
  }
}

@keyframes threadTextAnim {
  0% {
    opacity: 0;
    transform: scale(.85);
  }

  to {
    opacity: 1;
    transform: translateY(10px);
  }
}

@keyframes threadCard1Anim {
  0% {
    opacity: 0;
    transform: scale(.5);
  }

  to {
    opacity: 1;
    transform: translateY(10px);
  }
}

@keyframes threadCircleAnim {
  0% {
    opacity: 0;
    transform: scale(.5);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes textAnim {
  0% {
    opacity: 0;
    transform: scale(.85);
  }

  to {
    opacity: 1;
    transform: translateY(10px);
  }
}

@keyframes card1Anim {
  0% {
    opacity: 0;
    transform: scale(.5);
  }

  to {
    opacity: 1;
    transform: translateY(10px);
  }
}

@keyframes p-setup_prog_disc_empty_reply_bar__text--opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-setup_prog_disc_empty_reply_bar__text--slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes c-message_kit--highlight {
  20% {
    background: #f2c74433;
  }

  60% {
    background: #f2c74433;
  }
}

@keyframes p-flexpane--highlight {
  20% {
    background: #f2c74433;
  }

  60% {
    background: #f2c74433;
  }
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

input[type=text].c-input_text.p-channel_name_input--input {
  margin-bottom: 0;
}

.p-about_modal {
  flex-direction: column;
  max-width: 580px;
  height: min(85vh, 820px);
  display: flex;
}

.p-about_modal.p-about_modal--min_height {
  height: auto;
  min-height: 184px;
  max-height: 820px;
}

.p-about_modal__contents {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  width: 100%;
  height: 100%;
}

.p-about_modal__contents.c-sk-modal_content:only-of-type,
.p-about_modal__contents.c-sk-modal_content:last-of-type {
  border-radius: 0;
}

.p-about_modal__contents--members {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
}

.p-about_modal__section {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border: 1px solid var(--saf-0);
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 12px;
  margin: 16px 28px;
  padding: 20px;
  position: relative;
}

.p-about_modal__tabs {
  flex-direction: column;
  min-height: 0;
  display: flex;
}

.p-about_modal__tabs .c-tabs__tab_panel {
  flex-grow: 1;
  min-height: 0;
}

.p-about_modal__tab_panel {
  background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  display: flex;
}

.p-about_modal .c-tabs__tab_menu {
  padding-left: 20px;
}

.p-about_modal__header {
  min-height: 0;
}

.p-about_modal__action_button--disabled {
  pointer-events: unset;
}

.p-about_modal__title {
  min-height: 0;
  padding-bottom: 0;
}

.p-about_modal__title .c-sk-modal_title_bar__text {
  white-space: nowrap;
  width: 100%;
}

.p-about_modal__title .p-view_header__channel_title_icon {
  vertical-align: baseline;
  position: relative;
}

.p-about_modal__title .p-view_header__channel_title {
  white-space: break-spaces;
  word-break: break-word;
}

.p-about_modal__title .p-view_header__icon--small,
.p-about_modal__title .p-view_header__channel_title--small {
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
}

.p-about_modal__title_controls:not(:empty) {
  align-items: center;
  margin: 12px 0 8px 28px;
  display: flex;
}

.p-about_modal__title_controls:not(:empty)>* {
  margin-right: 8px;
}

.p-about_modal__title_controls:empty {
  margin-top: 12px;
}

.p-about_modal__section_picker {
  padding-left: 6px;
  padding-right: 4px;
  font-size: 15px;
}

.p-about_modal__section_picker .c-icon--star {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
}

.p-about_modal__section_picker--star_only {
  min-width: 40px;
  padding-left: 4px;
}

.p-about_modal__member_title {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
}

.p-about_modal__member_title_meta {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.p-about_modal__member_profile_section_item {
  align-items: center;
  display: flex;
}

.p-about_modal__member_profile_section_item+.p-about_modal__member_profile_section_item {
  margin-top: 8px;
}

.p-about_modal__member_profile_section_item_icon {
  margin-right: 8px;
}

.p-about_modal__member_profile_section_inline_link {
  display: contents;
}

.p-ia_details_popover__members {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  z-index: 1;
  border-bottom-right-radius: 8px;
  border-bottom-left-radius: 8px;
  flex-direction: column;
  width: 100%;
  padding-top: 16px;
  display: flex;
  overflow: hidden;
}

.p-ia_details_popover__members_header__title {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  justify-content: space-between;
  margin: 0 20px;
  display: flex;
}

.p-ia_details_popover__members_list {
  flex: 1;
}

.p-ia_details_popover__members_list--loading {
  overflow: hidden;
}

.p-ia_details_popover__members_list--loading .p-ia_details_popover__members_list_container {
  display: none;
}

.p-ia_details_popover__members_loading {
  color: rgba(var(--sk_foreground_high, 29, 28, 29), .5);
  justify-content: center;
  align-items: center;
  padding: 32px 0 52px;
  display: flex;
}

.p-ia_details_popover__members_list_item {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  align-items: center;
  height: 60px;
  padding: 0 16px;
  display: flex;
}

.p-ia_details_popover__members_list_item .c-avatar {
  cursor: pointer;
}

.p-ia_details_popover__members_list_item_anchor {
  height: 1px;
}

.p-ia_details_popover__members_list_item_add {
  align-items: center;
  padding: 12px 28px;
  font-weight: 700;
  display: flex;
}

.p-ia_details_popover__members_list_item_action {
  padding: 0 16px;
  font-size: 12px;
  font-weight: 700;
}

.p-ia_details_popover__members_list_item_action_menu {
  visibility: hidden;
  position: absolute;
  right: 16px;
}

.p-ia_details_popover__members_list_item_action_menu--visible {
  visibility: visible;
}

.p-ia_details_popover__members_list_item_spinner {
  position: relative;
  top: 2px;
}

.p-ia_details_popover__icon {
  border-radius: 4px;
  width: 36px;
  height: 36px;
  margin-right: 12px;
}

.p-ia_details_popover__icon:before {
  position: relative;
  right: -1px;
}

.p-ia_details_popover__add_member_icon {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  background: #1d9bd11a;
}

.p-ia_details_popover__invite_icon {
  background: rgba(var(--sk_foreground_soft, 29, 28, 29), .06);
}

.p-ia_details_popover__members_search_input_wrapper {
  padding: 0 28px 16px;
  display: flex;
}

.p-ia_details_popover__members_header__search_input {
  flex: 1;
}

.p-ia_details_popover__item_placeholder {
  height: 60px;
  margin-left: 28px;
  position: relative;
}

.p-ia_details_popover__item_placeholder__avatar,
.p-ia_details_popover__item_placeholder__name,
.p-ia_details_popover__item_placeholder__title {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  border-radius: 5px;
  position: absolute;
}

.p-ia_details_popover__item_placeholder__avatar {
  width: 36px;
  height: 36px;
  top: 12px;
  left: 0;
}

.p-ia_details_popover__item_placeholder__name,
.p-ia_details_popover__item_placeholder__title {
  height: 12px;
  left: 48px;
}

.p-ia_details_popover__item_placeholder__name {
  width: 160px;
  top: 12px;
}

.p-ia_details_popover__item_placeholder__title {
  width: 80px;
  top: 34px;
}

.p-ia_details_popover__filter .p-ia_details_popover__filter_icon,
.p-ia_details_popover__filter .p-ia_details_popover__filter_item_member_count {
  display: none;
}

.p-ia_details_popover__filter_list_overlay {
  z-index: 1001;
  width: 100%;
  height: 100%;
  position: absolute;
  top: 12px;
  left: -130px;
}

.p-ia_details_popover__loading_text {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  font-weight: 700;
}

@keyframes c-fullscreen_modal_breadcrumb_header--color_fade {
  0% {
    color: rgba(var(--sk_foreground_high_solid, 134, 134, 134), 1);
  }

  to {
    color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }
}

@keyframes c-fullscreen_modal_breadcrumb_header--breadcrumb_step {
  0% {
    visibility: visible;
    transform: translate(-165px);
  }

  40% {
    width: 60px;
  }

  to {
    width: 0;
    transform: translate(0);
  }
}

@keyframes c-fullscreen_modal_breadcrumb_header--breadcrumb_step_reverse {
  0% {
    visibility: visible;
    transform: translate(165px);
  }

  40% {
    width: 60px;
  }

  to {
    width: 0;
    transform: translate(0);
  }
}

@supports (-ms-ime-align:auto) {
  .p-apps_browser__app_limit_meter {
    max-width: 624px;
  }
}

@supports (-ms-ime-align:auto) {
  .p-apps_browser__app_limit_meter__apps {
    margin-left: 2.4rem;
  }
}

.p-channel_details__title {
  font-size: 22px;
  font-weight: 900;
  line-height: 1.36365;
}

.p-channel_details__placeholder {
  margin-bottom: 2px;
  padding: 12px 20px;
  display: flex;
}

.p-channel_details__placeholder_avatar {
  background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  border-radius: 3px;
  flex: 0 0 36px;
  width: 36px;
  height: 36px;
  margin-right: 12px;
}

.p-integrations__icon_container {
  background-color: #1d9bd11a;
  border-radius: 4px;
  justify-content: center;
  align-items: center;
  width: 36px;
  height: 36px;
  margin-top: 4px;
  display: flex;
}

.p-integrations__icon {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
}

.p-integrations__list_entity_row:not(.p-integrations__list_entity_row--disabled):hover {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  cursor: pointer;
}

.p-integrations__list_entity_row.c-base_list_entity,
.p-integrations__list_entity_row .c-base_list_entity {
  padding-left: 20px;
  padding-right: 20px;
}

.p-integrations__list_entity_row .c-avatar {
  cursor: pointer;
}

.p-integrations__list_entity_row--disabled,
.p-integrations__list_entity_row--disabled .c-avatar {
  cursor: default;
}

.p-integrations__list_entity_row__button_container {
  flex-direction: row;
  justify-content: flex-end;
  align-items: flex-end;
  display: flex;
}

.p-integrations__list_entity_row__button {
  margin-left: 10px;
}

@keyframes c-educational_context_bar--slideIn {
  0% {
    opacity: 0;
    transform: translateY(20%);
  }

  to {
    opacity: 1;
    transition: opacity .16s linear, transform .16s cubic-bezier(.36, .19, .29, 1);
    transform: translate(0);
  }
}

@keyframes c-educational_context_bar_container--opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes c-educational_context_bar_container--slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes p-setup_prog_disc_explainer_tip_container--slideIn {
  0% {
    opacity: 0;
    max-height: 0;
  }

  to {
    opacity: 1;
    max-height: 200px;
    transition: max-height .3s cubic-bezier(.36, .19, .29, 1);
  }
}

@keyframes p-setup_prog_disc_explainer_tip--slideIn {
  0% {
    opacity: 0;
    transform: translateY(20%);
  }

  to {
    opacity: 1;
    transition: opacity .16s linear, transform .16s cubic-bezier(.36, .19, .29, 1);
    transform: translate(0);
  }
}

@keyframes c-message_kit--to-grey {
  0% {
    color: inherit;
  }

  to {
    color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

.p-member_profile_card {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #00000014;
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 8px;
  width: 300px;
}

.p-member_profile_card__header {
  border-bottom: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  position: relative;
}

.p-member_profile_card__name {
  padding: 16px;
}

.p-channel_details__contents {
  flex: 1;
}

.p-channel_details__block {
  margin: 20px 16px 0;
}

.p-channel_details__block:last-child {
  margin-bottom: 20px;
}

.p-ia__channel_details__details {
  border-bottom: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  padding: 16px;
}

.p-channel_details__header {
  text-align: center;
  margin-bottom: 4px;
}

.p-channel_details__header__title {
  text-align: center;
  width: 100%;
  margin-top: 16px;
  padding: 0 16px;
}

.p-channel_details__header__title__presence {
  margin: 0 -8px 0 4px;
}

.p-channel_details__header__avatar {
  width: 120px;
  height: 120px;
  margin: 28px auto 0;
}

.p-ia__channel_details__action {
  text-align: center;
  width: 80px;
}

.p-ia__channel_details__action.p-ia__channel_details__action--member_profile {
  text-align: unset;
}

.p-ia__channel_details__action.active .p-ia__channel_details__action_icon {
  background-color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
}

.p-ia__channel_details__action_tooltip {
  max-width: 140px;
}

.p-ia__channel_details__action_icon {
  text-align: center;
  background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  border-radius: 100%;
  width: 40px;
  height: 40px;
  margin-bottom: 4px;
  transition: background-color 80ms, color 80ms;
}

.p-ia__channel_details__action_icon.p-ia__channel_details__action_icon--member_profile {
  justify-content: center;
  align-items: center;
  display: flex;
}

.p-ia__channel_details__action_icon:hover {
  background-color: rgba(var(--sk_primary_foreground, 29, 28, 29), .1);
}

.p-ia__channel_details__action_icon:active {
  background-color: rgba(var(--sk_primary_foreground, 29, 28, 29), .15);
}

.p-ia__channel_details__action_label {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  font-size: 13px;
}

.p-member_profile__name {
  margin-top: 16px;
  padding-bottom: 16px;
  padding-left: 16px;
  padding-right: 16px;
}

.p-member_profile_name__title {
  word-break: break-word;
  font-size: 22px;
  font-weight: 900;
  line-height: 1.36365;
}

.p-member_profile_name__link {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-member_profile_name__link:focus {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  text-decoration: underline;
}

.p-member_profile_name__link:hover {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-member_profile_name__text {
  padding-right: 12px;
}

.p-member_profile_name__presence {
  display: inline;
}

.p-member_profile_card__full_profile_link {
  margin: -16px 16px 16px;
  padding-top: 16px;
  display: block;
}

.p-member_profile_hover_card__modal {
  z-index: 999;
}

.p-member_profile_hover_card {
  width: -moz-fit-content;
  width: fit-content;
  height: -moz-fit-content;
  height: fit-content;
  display: inline-flex;
}

.p-member_profile_hover_card__popover {
  z-index: 1001;
  position: absolute;
}

.p-member_profile_hover_card__container {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #00000014;
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 8px;
  flex-direction: column;
  width: 320px;
  display: flex;
  overflow: hidden;
}

.p-member_profile_hover_card__status {
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-left: 0;
  display: block;
  overflow: hidden;
}

.p-member_profile_base_entity {
  padding: 16px;
}

.p-member_profile_base_entity__avatar {
  align-self: flex-start;
  width: 72px;
  height: 72px;
  margin-right: 12px;
}

.p-member_profile_base_entity__name {
  margin-right: 2px;
}

.p-member_profile_base_entity__name strong {
  font-size: 15px;
  font-weight: 900;
}

.p-member_profile_base_entity__name--link:hover {
  text-decoration: underline;
}

.p-member_profile_base_entity__title {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-member_profile_base_entity__title--full {
  white-space: initial;
}

.p-dnd_button {
  opacity: .6;
}

.p-dnd_button:hover,
.p-dnd_button:active,
.p-dnd_button:focus {
  opacity: 1;
}

.p-dnd_menu {
  border-radius: 0 0 6px 6px;
}

.p-dnd_menu__header_status {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  color: #fff;
  margin: 48px 24px 16px;
}

.p-dnd_header {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  color: #fff;
  justify-content: flex-start;
  align-items: center;
  margin: -8px 0 8px;
  display: flex;
}

.p-dnd_header__status {
  margin: 12px 24px;
}

@keyframes fade-in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-resizer-pulse {
  0% {
    --saf-0: rgba(var(--sk_highlight_accent, 29, 155, 209), 1);
    box-shadow: 0 0 0 1px var(--saf-0);
  }

  50% {
    --saf-0: rgba(var(--sk_highlight_accent, 29, 155, 209), 1);
    box-shadow: 0 0 0 3px var(--saf-0);
  }

  to {
    --saf-0: rgba(var(--sk_highlight_accent, 29, 155, 209), 1);
    box-shadow: 0 0 0 1px var(--saf-0);
  }
}

@keyframes p-file_upload_banner--progress_bar {
  0% {
    background-position: 0 0;
  }

  to {
    background-position: -36px 0;
  }
}

@keyframes fadeInOpacity {
  0% {
    opacity: 0;
    background: #1d9bd11a;
  }

  60% {
    opacity: 1;
    background: #1d9bd11a;
  }
}

.p-r_member_profile__container {
  flex-direction: column;
  align-items: center;
  display: flex;
}

.p-r_member_profile__avatar_content {
  flex-direction: column;
  justify-content: center;
  width: 100%;
  max-width: 288px;
  margin-left: auto;
  margin-right: auto;
  padding: 16px 16px 0;
  display: flex;
}

.p-r_member_profile__avatar__img_container {
  background-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  border-radius: 8px;
  width: 100%;
  height: 0;
  padding-top: 100%;
  position: relative;
  overflow: hidden;
}

.p-r_member_profile__avatar__img_container:after {
  content: "";
  pointer-events: none;
  border-radius: 6px;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: inset 0 0 0 1px #1d1c1d0d;
}

.p-r_member_profile__avatar__img {
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
}

.p-r_member_profile__name {
  align-items: center;
  margin-top: -4px;
  display: flex;
}

.p-r_member_profile__name__text {
  font-size: 22px;
  font-weight: 900;
  line-height: 1.36365;
}

.p-r_member_profile--link.p-r_member_profile--link {
  color: inherit;
  background: 0 0;
  margin-top: 12px;
  display: block;
}

.p-r_member_profile--link.p-r_member_profile--link:first-child {
  margin-top: 0;
}

.p-r_member_profile--link.p-r_member_profile--link:hover {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  text-decoration: none;
}

.p-r_member_profile--link.p-r_member_profile--link img:hover {
  cursor: pointer;
}

.p-r_member_profile--link.p-r_member_profile--link .c-member__primary_content:hover {
  text-decoration: underline;
}

.p-r_member_profile_channel--link {
  color: inherit;
  background: 0 0;
  margin-top: 6px;
  display: block;
}

.p-r_member_profile_channel--link:first-child {
  margin-top: 0;
}

.p-r_member_profile_channel--link:hover {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  text-decoration: none;
}

.p-r_member_profile_channel--name {
  margin-left: 8px;
}

.p-r_member_profile_section {
  border-top: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  flex-direction: column;
  flex: 1;
  width: 100%;
  padding: 16px;
  display: flex;
}

.p-r_member_profile_section:first-child,
.p-r_member_profile_section:nth-child(2) {
  border: none;
}

.p-r_member_profile_section:last-child {
  padding-bottom: 24px;
}

.p-r_member_profile_list_entity {
  padding: 0;
}

.p-r_member_profile_section_header {
  align-items: center;
  margin-bottom: 16px;
  font-size: 15px;
  font-weight: 900;
  display: flex;
}

.p-r_member_profile_section_content_item {
  margin-top: 8px;
  display: block;
}

.p-r_member_profile_section_content_item:first-child {
  margin-top: 0;
}

.p-r_member_profile_entity__title {
  white-space: normal;
  font-size: 13px;
}

.p-r_member_profile__presence_row {
  display: flex;
}

.p-r_member_profile__status .p-ia_member_profile__status {
  text-align: left;
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  color: unset;
  margin: 0;
  display: inline-block;
}

.p-r_member_profile__status .p-ia_member_profile__status.display_flex {
  display: flex;
}

.p-r_member_profile__status .p-ia_member_profile__status__wrapper {
  padding: 0;
}

@keyframes p-animated-sound-icon {

  0%,
  to {
    justify-content: flex-start;
  }

  33.33% {
    justify-content: center;
  }

  66.66% {
    justify-content: flex-end;
  }
}

@keyframes p-context_bar__prog_disc_tip_flag--opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-context_bar__prog_disc_tip_flag--slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes p-context_bar__prog_disc_tip_flag--slide-down {
  0% {
    transform: translateY(0);
  }

  to {
    transform: translateY(32px);
  }
}

@keyframes p-avatar_stack__animation--fade-in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
    transition: opacity .1s linear, transform .3s cubic-bezier(.36, .19, .29, 1);
  }
}

@keyframes p-progressive_disclosure_huddle_channel_header_button_flag__text--opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-progressive_disclosure_huddle_channel_header_button_flag__text--slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes p-huddle_channel_header__animation_pulsing {
  0% {
    box-shadow: 0 0 0 0 rgb(var(--dt_color-plt-jade-20));
  }

  70% {
    box-shadow: 0 0 0 8px #f000;
  }

  to {
    box-shadow: 0 0 #f000;
  }
}

@keyframes p-huddle_channel_header__animation_slide_in {
  0% {
    transform: scaleX(0);
  }

  to {
    transform: scaleX(1);
  }
}

@keyframes p-huddle_channel_header__animation_slide_out {
  0% {
    transform: scaleX(1);
  }

  to {
    transform: scaleX(0);
  }
}

@keyframes p-huddle_channel_header__border_color_fade_in {
  0% {
    border-color: #0000;
  }

  to {
    border-color: rgb(var(--dt_color-plt-jade-50));
  }
}

.c-profile_image__img_container {
  border-radius: 6px;
  max-width: 256px;
  margin: 16px;
  position: relative;
  overflow: hidden;
}

.c-profile_image__img_container:after {
  content: "";
  pointer-events: none;
  border-radius: 6px;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: inset 0 0 0 1px #0000000d;
}

.c-profile_image__circle {
  border-radius: 50%;
}

.c-profile_image__img {
  width: 100%;
  display: block;
}

.p-search_filter__close {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  position: absolute;
  top: 8px;
  left: calc(100% + 3px);
}

.p-search_filter__placeholder_avatar {
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border-radius: 5px;
  width: 18px;
  height: 18px;
  margin-right: 16px;
  display: inline-block;
}

.p-search_filter__placeholder_name {
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border-radius: 10px;
  height: 10px;
  display: inline-block;
}

.p-search_filter__placeholder_name--0 {
  width: 40%;
}

.p-search_filter__placeholder_name--1 {
  width: 50%;
}

.c-channel_filter {
  text-align: left;
  display: flex;
}

.c-channel_filter__text {
  text-overflow: ellipsis;
  flex: 1 0 0;
  max-width: 100%;
  overflow: hidden;
}

.c-channel_filter__icon {
  flex: 0 1 0;
}

.c-channel_filter__item {
  padding-left: 4px;
}

.p_search_filter__block_container {
  flex-flow: wrap;
  align-items: center;
  margin-top: -8px;
  margin-bottom: 10px;
  margin-left: -8px;
  display: flex;
}

.p_search_filter__block_container--ia4 {
  flex-flow: row;
  flex-grow: 1;
  margin: 0;
}

.p-search_filter__block_item_wrapper {
  margin-top: 8px;
  margin-left: 8px;
  display: flex;
  position: relative;
}

.p-search_filter__block_item_wrapper--ia4 {
  margin: 0;
}

.p-search_filter__block_item_wrapper--ia4:not(:first-child) {
  margin-left: 8px;
}

.p-search_filter__block_item {
  justify-content: flex-start;
  align-items: center;
  max-width: 205px;
  display: flex;
}

.p-search_filter__block_item .c-member_name__indicator {
  display: none;
}

.p-search_filter__block_item--disabled {
  pointer-events: none;
  opacity: .5;
}

.p-search_filter__block_item_close {
  width: 16px;
  height: 16px;
  position: absolute;
  top: 50%;
  right: 6px;
  transform: translateY(-50%);
}

.p-search_filter__block_item_close .c-icon {
  color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  width: 16px;
  height: 16px;
}

.p-search_filter__block_item_close .c-icon:before {
  font-size: 15px;
}

.p-search_filter__block_item_full_width {
  width: 100%;
}

.p-search_filter__block_item_icon {
  font-size: 14px;
}

.p-search_filter__block_item_icon:before {
  color: inherit;
}

.p-search_filter__panel {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 5px 10px #0000001f;
  border-radius: 6px;
  padding: 16px;
}

.p-search_filter__block_label_wrapper {
  white-space: nowrap;
  text-overflow: ellipsis;
  text-align: left;
  align-items: center;
  min-width: 0;
  line-height: 1.5;
  display: flex;
  overflow: hidden;
}

.p-search_filter__block_label_wrapper .c-base_inline_entity {
  min-width: 0;
}

.p-search_filter__list_item {
  align-items: center;
  line-height: 32px;
  display: flex;
}

.p-search_filter__list_item .c-icon:before {
  color: inherit;
}

.p-search_filter__list_item--selected {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  font-weight: 700;
}

.p-search_filter__list_item--active.p-search_filter__list_item--selected {
  color: inherit;
}

.p-search_filter__list_item--active .c-icon:before {
  color: inherit;
}

.p-search_filter__list_item_content {
  text-overflow: ellipsis;
  white-space: nowrap;
  flex: 1 1 0;
  min-width: 0;
  display: block;
  overflow: hidden;
}

.p-search_filter__list_item_content img {
  vertical-align: text-top;
}

.p-search_filter__list_item_icon {
  margin-right: 8px;
  font-size: 20px;
}

.p-search_filter__modal_trigger {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  align-self: center;
  margin-left: 4px;
  padding: 0 2px;
}

.p-search_filter__modal_trigger--ia4 {
  color: var(--dt_color-content-hgl-1);
  white-space: nowrap;
  border-radius: 5px;
  align-items: center;
  height: 26px;
  padding: 4px 7px;
  font-size: 13px;
  font-weight: 700;
  display: flex;
}

.p-search_filter__modal_trigger--ia4:hover {
  text-decoration: underline;
}

.p-search_filter__modal_section {
  padding-bottom: 5px;
}

.p-search_filter__modal_padding {
  padding: 8px 28px 28px;
}

.p-search_filter__placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-modal_entity__text {
  font-weight: 700;
}

@media screen and (max-width: 800px) {
  .c-base_entity__text-contents {
    flex-flow: wrap;
  }
}

@keyframes unread-highlight {
  0% {
    background: #f2c74433;
  }

  60% {
    background: #f2c74433;
  }
}

@keyframes shimmer_search_summary_loading {
  0% {
    opacity: .3;
  }

  50% {
    opacity: .2;
  }

  to {
    opacity: .3;
  }
}

@keyframes shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

.c-search_filter_section {
  margin-bottom: 20px;
  font-size: 15px;
}

.c-search_filter_section__title {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  margin-bottom: 8px;
  font-weight: 700;
  display: block;
}

.c-channel_filter {
  border-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
}

.c-channel_filter__item {
  padding-left: 16px;
  font-size: 15px;
  line-height: 1.8;
}

.c-channel_filter__item_header {
  padding-left: 16px;
}

.c-channel_filter__item--selected {
  padding-left: 4px;
}

@keyframes p-user_group_base_row--highlighter {
  0% {
    background: 0 0;
  }

  10% {
    background: #f2c74433;
  }

  to {
    background: 0 0;
  }
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

@keyframes p-welcome-place__sidebar_animation {
  0% {
    font-weight: 900;
  }

  50% {
    color: #fff;
    font-weight: 900;
  }

  to {
    color: inherit;
    font-weight: 900;
  }
}

@keyframes p-channel_sidebar__saved__toast {
  0% {
    opacity: 0;
    transform: scale(0);
  }

  15% {
    opacity: 1;
  }

  30% {
    opacity: 1;
    transform: scale(1);
  }

  85% {
    opacity: 1;
    transform: scale(1);
  }

  to {
    opacity: 0;
    transform: scale(0);
  }
}

@keyframes p-channel_sidebar__saved__toast_fade {
  0% {
    opacity: 1;
    transform: scale(1);
  }

  15% {
    opacity: 0;
    transform: scale(0);
  }

  85% {
    opacity: 0;
    transform: scale(0);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes p-channel_sidebar__activity__toast {
  0% {
    opacity: 0;
    transform: scale(0);
  }

  5% {
    opacity: 1;
  }

  10% {
    opacity: 1;
    transform: scale(1);
  }

  95% {
    opacity: 1;
    transform: scale(1);
  }

  to {
    opacity: 0;
    transform: scale(0);
  }
}

@keyframes p-channel_sidebar__activity__toast_fade {
  0% {
    opacity: 1;
    transform: scale(1);
  }

  5% {
    opacity: 0;
    transform: scale(0);
  }

  95% {
    opacity: 0;
    transform: scale(0);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

.p-icon_avatar-container {
  background: rgba(var(--sk_foreground_low_solid, 221, 221, 221), .5);
  border-radius: 4px;
  justify-content: center;
  align-items: center;
  width: 36px;
  height: 36px;
  display: flex;
}

.p-section_header {
  margin: 0 0 16px;
}

.p-section_header__title {
  margin-right: 4px;
}

@media (max-width: 1440px) {
  .p-section_header__title {
    min-width: 100%;
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes tab--highlight {
  0% {
    background: 0 0;
  }

  50% {
    background: #f2c74433;
  }

  to {
    background: 0 0;
  }
}

@keyframes summarize-button-pulse {

  0%,
  20% {
    transform: scale(.75);
  }

  80%,
  to {
    transform: scale(1);
  }
}

@keyframes p-saved_item--highlight {
  20% {
    background: #f2c74433;
  }

  60% {
    background: #f2c74433;
  }
}

@keyframes c-message_list__spinner--fade {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-message_pane__setup_calendar_banner_slidein {
  0% {
    opacity: 0;
    margin-top: 20px;
  }

  to {
    opacity: 1;
    margin-top: 0;
  }
}

@keyframes p-message_pane__setup_calendar_banner_fadeout {
  0% {
    opacity: 1;
    margin-top: 0;
  }

  to {
    opacity: 0;
    margin-top: -10px;
  }
}

@keyframes p-message_pane__channel_foreword--fadeIn {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes fade {

  30%,
  85% {
    opacity: 1;
    visibility: visible;
  }

  0%,
  to {
    opacity: 0;
    visibility: hidden;
  }
}

@keyframes p-peek_card__slide_in {
  0% {
    transform: translate(-8px);
  }

  to {
    transform: translate(0);
  }
}

@keyframes p-peek_card__fade_in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

.p-action_panel_menu_item:hover {
  color: #fff;
  background-color: #1264a3;
  text-decoration: none;
}

.p-action_panel_menu_item:hover .c-menu_item__icon,
.p-action_panel_menu_item:hover .c-menu_item__icon .c-icon:before,
.p-action_panel_menu_item:hover .c-menu_item__label {
  color: #fff;
}

.p-action_panel_menu_item__active,
.p-action_panel_menu_item__active .c-menu_item__icon,
.p-action_panel_menu_item__active .c-menu_item__icon .c-icon:before,
.p-action_panel_menu_item__active .c-menu_item__label {
  color: var(--dt_color-base-inv-hgl-1);
}

.p-action_panel--search-input {
  border-radius: 8px;
  width: 100%;
}

.p-action_panel--blue-link {
  margin: 4px 0;
  font-size: 13px;
}

.p-action_panel--menu-item .c-menu_item__label {
  align-items: center;
  gap: 8px;
  display: flex;
}

.p-action_panel--container {
  height: unset;
  overflow: auto;
}

.p-action_panel--wrapper {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #0000001f;
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  border: 1px solid var(--light-core-outline-tertiary, #5e5d6021);
  border-radius: 12px;
  overflow: auto;
  box-shadow: 0 4px 12px #0000001a;
}

.p-filter_menu_header {
  justify-content: space-between;
  padding: 0 20px;
  display: flex;
}

:root {
  --dsg-selection-border-radius: 4px;
  --dsg-selection-border-width: 1px;
  --dsg-selection-background-color: #4580e60a;
  --dsg-selection-disabled-border-color: #9da6ab;
  --dsg-selection-disabled-background-color: #0000000a;
  --dsg-corner-indicator-width: 10px;
}

.p-filter_menu_header {
  justify-content: space-between;
  padding: 0 20px;
  display: flex;
}

.p-action_panel_menu_item:hover {
  color: #fff;
  background-color: #1264a3;
  text-decoration: none;
}

.p-action_panel_menu_item:hover .c-menu_item__icon,
.p-action_panel_menu_item:hover .c-menu_item__icon .c-icon:before,
.p-action_panel_menu_item:hover .c-menu_item__label {
  color: #fff;
}

.p-action_panel_menu_item .p-action_panel-menu_item__label {
  display: flex;
}

.p-action_panel_menu_item .p-action_panel-menu_item__label-content {
  text-overflow: ellipsis;
  flex-grow: 1;
  overflow: hidden;
}

.p-row_container {
  padding-left: 4px;
  padding-right: 4px;
}

.c-channel-section {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  --saf-0: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  border: solid 1px var(--saf-0);
  border-radius: 8px;
  margin-bottom: 24px;
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

.c-channel-section__row {
  border-bottom: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  min-height: 58px;
  padding: 12px;
  display: flex;
  position: relative;
}

.c-channel-section__row:hover,
.c-channel-section__row:active,
.c-channel-section__row:focus {
  cursor: pointer;
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes overlayAnimation {
  0% {
    opacity: 0;
    transform: scale(.85);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes placeHolderShimmer {

  0%,
  to {
    opacity: 1;
  }

  50% {
    opacity: .4;
  }
}

@keyframes slideInComposer {
  0% {
    opacity: 0;
    transform: translateY(-4px);
  }

  to {
    opacity: 1;
    transform: translate(0);
  }
}

@keyframes slideOutComposer {
  0% {
    opacity: 1;
    transform: translate(0);
  }

  to {
    opacity: 0;
    transform: translateY(-4px);
  }
}

@keyframes slideInStandalone {
  0% {
    opacity: 0;
    transform: translate(2px, -8px);
  }

  to {
    opacity: 1;
    transform: translate(2px, -4px);
  }
}

@keyframes slideOutStandalone {
  0% {
    opacity: 1;
    transform: translate(2px, -4px);
  }

  to {
    opacity: 0;
    transform: translate(2px, -8px);
  }
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

@keyframes p-quip_loading_skeleton--fade-in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-quip_loading_skeleton--delayed-fade-in {
  0% {
    opacity: 0;
  }

  75% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

.p-add_row_button {
  align-items: center;
  width: 100%;
  min-height: 58px;
  margin-top: 0;
  margin-bottom: 4px;
  padding-left: 10px;
  display: flex;
}

.p-add_row_button>svg {
  border: 1px solid rgb(var(--dt_color-plt-gray-70));
  border-radius: 50%;
  width: 20px;
  height: 20px;
}

.p-add_row_button>svg path {
  fill: rgb(var(--dt_color-plt-gray-70));
}

.p-add_row_button__label {
  color: rgb(var(--dt_color-plt-gray-70));
  margin-left: 6px;
  font-weight: 700;
}

.p-list_view {
  border-top: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  width: 100%;
  height: 100%;
  position: relative;
}

.p-list_view__content {
  width: 100%;
  height: calc(100% - 42px);
}

.p-list_view__row {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0);
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  align-items: center;
  min-height: 46px;
  padding: 12px 0 12px 12px;
  display: flex;
}

.p-list_view__row:hover {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
  cursor: pointer;
}

@keyframes dolphinSwim {
  0% {
    transform: translate(80%);
  }

  to {
    transform: translate(-100%);
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-hub--shimmer {
  0% {
    opacity: 1;
  }

  50% {
    opacity: .65;
  }

  to {
    opacity: 1;
  }
}

@keyframes bookmarkBarLoadingAnimation {
  0% {
    background-position: -78px 0;
  }

  to {
    background-position: 78px 0;
  }
}

.p-list_picker__modal .p-list_picker__header {
  border-bottom: 1px solid rgba(var(--sk_primary_foreground, 29, 28, 29), .1);
}

@keyframes toggle-switch-pulse-inner {

  0%,
  5% {
    opacity: 0;
  }

  60% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes toggle-switch-pulse-outer {

  0%,
  5% {
    opacity: 0;
    transform: scale(1);
  }

  10%,
  50% {
    opacity: 1;
  }

  95% {
    opacity: 0;
  }

  to {
    transform: scale(1.2, 1.3);
  }
}

@keyframes quipFloatingFormattingBarInAnimation {
  0% {
    opacity: 0;
    transform: translateY(8px);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

.p-view_header_hover_card__overlay {
  z-index: 999;
}

.p-view_header_hover_card__popover {
  z-index: 1000;
  transition: opacity 80ms linear;
  position: absolute;
}

.p-view_header_hover_card__container {
  word-break: break-word;
  width: -moz-fit-content;
  width: fit-content;
  height: -moz-fit-content;
  height: fit-content;
  display: inline-flex;
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}

@keyframes sparkle-twinkle {

  0%,
  to {
    opacity: 1;
    transform: scale(1);
  }

  50% {
    opacity: .5;
    transform: scale(.975);
  }
}

@keyframes p-setup_tada_coachmark--slideIn {
  0% {
    opacity: 0;
    transform: translate(0, 0)translate(40px, -20%)scaleY(.85);
  }

  to {
    opacity: 1;
    transition: opacity .2s ease-out, transform .25s cubic-bezier(.095, .965, .55, 1.115);
    transform: translateY(-20%)scale(1);
  }
}

.p-section_menu {
  max-height: 500px;
}

@keyframes c-sound_prefs__sample_message_animation {
  0% {
    transform: translateY(100px);
  }

  to {
    transform: translateY(0);
  }
}

.image--size-5 {
  width: 5%;
}

.image--size-10 {
  width: 10%;
}

.image--size-15 {
  width: 15%;
}

.image--size-20 {
  width: 20%;
}

.image--size-25 {
  width: 25%;
}

.image--size-30 {
  width: 30%;
}

.image--size-35 {
  width: 35%;
}

.image--size-40 {
  width: 40%;
}

.image--size-45 {
  width: 45%;
}

.image--size-50 {
  width: 50%;
}

.image--size-55 {
  width: 55%;
}

.image--size-60 {
  width: 60%;
}

.image--size-65 {
  width: 65%;
}

.image--size-70 {
  width: 70%;
}

.image--size-75 {
  width: 75%;
}

.image--size-80 {
  width: 80%;
}

.image--size-85 {
  width: 85%;
}

.image--size-90 {
  width: 90%;
}

.image--size-95 {
  width: 95%;
}

.image--size-100 {
  width: 100%;
}

.image--size-5 {
  width: 5%;
}

.image--size-10 {
  width: 10%;
}

.image--size-15 {
  width: 15%;
}

.image--size-20 {
  width: 20%;
}

.image--size-25 {
  width: 25%;
}

.image--size-30 {
  width: 30%;
}

.image--size-35 {
  width: 35%;
}

.image--size-40 {
  width: 40%;
}

.image--size-45 {
  width: 45%;
}

.image--size-50 {
  width: 50%;
}

.image--size-55 {
  width: 55%;
}

.image--size-60 {
  width: 60%;
}

.image--size-65 {
  width: 65%;
}

.image--size-70 {
  width: 70%;
}

.image--size-75 {
  width: 75%;
}

.image--size-80 {
  width: 80%;
}

.image--size-85 {
  width: 85%;
}

.image--size-90 {
  width: 90%;
}

.image--size-95 {
  width: 95%;
}

.image--size-100 {
  width: 100%;
}

@keyframes p-floating_sidebar_coachmark_delay {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

.p-view_header {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 1px 0 0 var(--saf-0);
  z-index: 3;
  flex-shrink: 0;
  align-items: center;
  height: 49px;
  padding: 0 16px 0 20px;
  display: flex;
}

.p-view_header--with-channel-tabs {
  box-shadow: none;
  border: none;
}

.p-view_header__text {
  flex: 1 1 0;
  align-items: baseline;
  min-width: 0;
  display: flex;
}

.p-view_header__title {
  align-items: baseline;
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
  display: flex;
}

.p-view_header__channel_title_icon {
  vertical-align: text-bottom;
  margin-right: 2px;
}

.p-view_header__member_name {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-view_header__avatar {
  height: 24px;
  margin-right: 8px;
  position: relative;
}

.p-view_header__avatar .c-avatar {
  cursor: pointer;
}

.p-view_header__menu .c-menu_item__button {
  align-items: baseline;
}

.p-view_header__menu .p-about_modal__member_name {
  white-space: initial;
}

.p-view_header__menu .p-about_modal__member_title {
  line-height: 1.46668;
}

.p-ia__view_header__fixed_space {
  margin-left: auto;
  margin-right: 12px;
}

.p-ia__view_header__button {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  border-radius: 4px;
  flex: none;
  align-items: center;
  margin-left: 4px;
  padding: 8px;
  font-size: 13px;
  font-weight: 700;
  line-height: 1.38463;
  display: flex;
}

.p-ia__view_header__button:hover {
  background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-ia__view_header__button:active {
  background: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
}

.p-ia__view_header__button--icon_only {
  display: none;
}

.p-ia__view_header__button--with_label .p-ia__view_header__button_icon {
  margin-right: 8px;
}

@media screen and (max-width: 1070px) {

  .p-ia__view_header__button_text,
  .p-ia__view_header__button--with_label {
    display: none;
  }

  .p-ia__view_header__button--icon_only {
    display: inline;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes fadeIn {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-download-illo__steam-line {
  0% {
    opacity: 0;
    transform: translateY(12px);
  }

  50% {
    opacity: 1;
  }

  85% {
    stroke-dashoffset: 0;
  }

  to {
    stroke-dashoffset: 0;
    opacity: 0;
    transform: translateY(0);
  }
}

@keyframes p-download-illo__connecting-line {
  0% {
    stroke-dashoffset: 1100px;
  }

  50%,
  to {
    stroke-dashoffset: 370px;
  }
}

@keyframes p-download-illo__logo {

  0%,
  47.5% {
    opacity: 0;
    transform: scale(.7);
  }

  55% {
    opacity: 1;
    transform: scale(1.035);
  }

  60% {
    transform: scale(1);
  }

  95% {
    opacity: 1;
    transform: scale(1);
  }

  to {
    opacity: 0;
    transform: scale(1);
  }
}

@media (max-width: 670px) {
  @-moz-document url-prefix() {
    .p-workspace_banner__download .p-workspace_banner__download_content_main {
      max-width: 100px;
    }

    .p-workspace_banner__download .p-workspace_banner__download_content_download_button {
      max-width: 130px;
    }
  }
}

@keyframes sidebar-channel-input-enter {
  0% {
    opacity: 0;
    transform: scale(.5);
  }

  60% {
    opacity: 1;
    transform: scale(1.15);
  }

  to {
    transform: scale(1);
  }
}

@keyframes p-ia__sidebar_header__user__status_toast {
  0% {
    opacity: 0;
    transform: scale(0);
  }

  50% {
    opacity: 1;
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes p-ia_sidebar_subtext_fade_in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

.p-ia_member_profile__details {
  flex-direction: column;
  align-items: center;
  display: flex;
}

.p-ia_member_profile__name {
  text-align: center;
  margin: 0 16px;
}

.p-ia_member_profile__name .p-member_profile_name__title {
  margin-bottom: 2px;
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
}

.p-ia_member_profile__status__wrapper {
  overflow-wrap: anywhere;
  max-width: 100%;
  padding: 0 36px;
  position: relative;
}

.p-ia_member_profile__status {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  text-align: center;
  margin: 4px 0;
  display: block;
}

@keyframes huddles_temporary_control_banner_transcript__icon_fade {
  0% {
    opacity: 1;
  }

  35% {
    opacity: .5;
  }

  70% {
    opacity: 1;
  }
}

@keyframes p-huddle_icon__slash {
  to {
    stroke-dashoffset: 0;
  }
}

@keyframes p-video_button_icon--blink {
  0% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-huddle_participants_menu_trigger--fade-in {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes p-huddle_participants_menu_trigger--slide-up {
  0% {
    transform: translateY(20px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes p-huddle_participants_menu_trigger--slide-down {
  0% {
    transform: translateY(-20px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-huddle_reaction_list__enter {
  0% {
    opacity: 0;
    transform: scale(.8);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes p-huddle_reaction_list__enter {
  0% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes fadeInHuddleClosedCaptionEvent {
  0% {
    opacity: 0;
    transform: translateY(20%);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes huddle_event_log__active_speaker {
  0% {
    opacity: 1;
    transform: scale(1);
  }

  to {
    opacity: .4;
    transform: scale(1.1);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes nextPageOpacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes nextPageTransform {
  0% {
    transform: translate(10em);
  }

  to {
    transform: translate(0);
  }
}

@keyframes prevPageOpacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes prevPageTransform {
  0% {
    transform: translate(-10em);
  }

  to {
    transform: translate(0);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes c-huddle-invite-window-toast-fade-in {
  0% {
    opacity: 0;
    transform: translate(-50%);
  }

  to {
    opacity: 1;
    transform: translate(-50%, 4px);
  }
}

@keyframes c-huddle-invite-window-toast-fade-out {
  0% {
    opacity: 1;
    transform: translate(-50%, 4px);
  }

  to {
    opacity: 0;
    transform: translate(-50%);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-huddle_popover__scale {
  0% {
    transform: matrix(1, 0, 0, 1, 0, 0);
  }

  to {
    transform: matrix(.8, 0, 0, .8, -16, 0);
  }
}

@keyframes huddle_active_speaker {
  0% {
    opacity: .4;
    transform: scale(.9091);
  }

  to {
    opacity: 1;
    transform: scale(1);
  }
}

@keyframes huddle_join {
  0% {
    opacity: 0;
    transform: scale(.4444);
  }

  50% {
    opacity: 1;
    transform: scale(1);
  }

  to {
    opacity: 1;
    transform: translate(.6666px);
  }
}

@keyframes p-setup_prog_disc_huddles_explainer_tip_container--slide_in {
  0% {
    max-height: 0;
  }

  to {
    max-height: 400px;
    transition: max-height .3s cubic-bezier(.36, .19, .29, 1);
  }
}

@keyframes p-setup_prog_disc_huddles_explainer_tip--slide_in {
  0% {
    opacity: 0;
    transform: translateY(20%);
  }

  to {
    opacity: 1;
    transition: opacity .16s linear, transform .16s cubic-bezier(.36, .19, .29, 1);
    transform: translate(0);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-huddle_switch__toggle_on {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
    transform: matrix(2, 0, 0, 2, 21, 0);
  }
}

@keyframes p-huddle_switch__toggle_off {
  0% {
    opacity: 1;
  }

  to {
    opacity: 1;
    transform: matrix(.5, 0, 0, .5, -21, 0);
  }
}

@keyframes p-huddle_switch__headphones_icon__shake {
  50% {
    transform: translate(-50%, -50%)rotate(10deg);
  }

  to {
    transform: translate(-50%, -50%)rotate(-10deg);
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes hoverNameFade {
  2% {
    opacity: 1;
  }

  98% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes p-huddle_sidebar_footer_buttons__pop {
  0% {
    transform: scale(1);
  }

  67% {
    transform: scale(1.03);
  }

  to {
    transform: scale(1);
  }
}

@keyframes p-peer_tile_active {
  0% {
    opacity: .4;
    border-radius: 4px;
    transform: scale(.9091);
  }

  to {
    opacity: 1;
    border-radius: 8px;
    transform: scale(1);
  }
}

@keyframes p-huddle_spinner__rotate {
  0% {
    transform: rotate(0);
  }

  to {
    transform: rotate(360deg);
  }
}

@keyframes p-huddle_spinner__draw_red {
  0% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  0% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  13.0435% {
    stroke-dashoffset: 0;
    transform: rotate(0);
  }

  to {
    stroke-dashoffset: 0;
    transform: rotate(0);
  }
}

@keyframes p-huddle_spinner__draw_yellow {
  0% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  1.28755% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  14.1631% {
    stroke-dashoffset: 37.385px;
    transform: rotate(0);
  }

  to {
    stroke-dashoffset: 26.7035px;
    transform: rotate(0);
  }
}

@keyframes p-huddle_spinner__draw_green {
  0% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  2.54237% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  15.2542% {
    stroke-dashoffset: 42.7257px;
    transform: rotate(0);
  }

  to {
    stroke-dashoffset: 53.4071px;
    transform: rotate(0);
  }
}

@keyframes p-huddle_spinner__draw_blue {
  0% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  2.54237% {
    stroke-dashoffset: 106.814px;
    transform: rotate(-90deg);
  }

  15.2542% {
    stroke-dashoffset: 64.0885px;
    transform: rotate(0);
  }

  to {
    stroke-dashoffset: 74.7699px;
    transform: rotate(0);
  }
}

@keyframes p-huddle_sidebar_footer__diagonal {
  0% {
    opacity: 0;
    transform: matrix(.8, 0, 0, .8, 20, 0);
  }

  33% {
    opacity: 0;
    transform: matrix(.8, 0, 0, .8, 20, 0);
  }

  to {
    opacity: 1;
    transform: matrix(1, 0, 0, 1, 0, 0);
  }
}

@keyframes p-huddle_sidebar_footer__up {
  0% {
    opacity: 0;
  }

  1% {
    opacity: 0;
    transform: translateY(80%);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes p-huddle_sidebar_footer__up_always_on {
  0% {
    opacity: 0;
  }

  .1% {
    opacity: 0;
    transform: translateY(48px);
  }

  .2% {
    opacity: 1;
    transform: translateY(48px);
  }

  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes prog_disc_user_flag_tip--bg-color {
  0% {
    background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  }

  to {
    background-color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }
}

@keyframes prog_disc_user_flag_tip_bg_color--dark {
  0% {
    background-color: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  }

  to {
    background-color: #f8f8f8;
  }
}

@keyframes prog_disc_user_flag_tip--width {
  0% {
    transform: translate(100%);
  }

  to {
    transform: translate(0);
  }
}

@keyframes prog_disc_user_flag_tip--text-opacity {
  0% {
    opacity: 0;
  }

  to {
    opacity: 1;
  }
}

@keyframes prog_disc_user_flag_tip--text-slide-up {
  0% {
    transform: translateY(4px);
  }

  to {
    transform: translateY(0);
  }
}

@keyframes prog_disc_user_flag_tip--text-fade-out {
  0% {
    opacity: 1;
  }

  to {
    opacity: 0;
  }
}

@keyframes prog_disc_user_flag_tip--text-slide-down {
  0% {
    transform: translateY(0);
  }

  to {
    transform: translateY(4px);
  }
}

@keyframes prog_disc_user_flag_tip--bg-color-restore {
  0% {
    background-color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }

  to {
    background-color: #0000;
  }
}

@keyframes prog_disc_user_flag_tip_bg_color_restore--dark {
  0% {
    background-color: #f8f8f8;
  }

  to {
    background-color: #0000;
  }
}

@keyframes prog_disc_user_button--border {
  0% {
    border-color: #0000;
  }

  to {
    border-color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  }
}

@keyframes prog_disc_user_button_border--dark {
  0% {
    border-color: #0000;
  }

  to {
    border-color: #f8f8f8;
  }
}

.p-block_kit_modal {
  width: 520px;
  overflow: hidden;
}

@media only screen and (min-height: 657px) {
  .p-block_kit_modal {
    max-height: 640px;
  }
}

.p-block_kit_modal .c-dialog__body {
  min-height: 90px;
}

.p-block_kit_modal .c-dialog__body.c-dialog__body--slack_scrollbar {
  padding: 8px 20px 16px 24px;
}

[data-gantry][data-app=app-popouts] .p-block_kit_modal {
  border-radius: 0;
  width: 100vw;
  max-width: 100vw;
  height: 100vh;
  max-height: 100vh;
}

.p-block_kit_modal__title {
  justify-content: space-between;
  align-items: center;
  width: 100%;
  display: flex;
}

.p-block_kit_modal__title_icon {
  border-radius: .25rem;
  flex-shrink: 0;
  width: 2.25rem;
  height: 2.25rem;
  margin-right: 16px;
}

.p-block_kit_modal__title_text {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 100%;
  display: block;
  overflow: hidden;
}

.p-block_kit_modal--loading .c-dialog__body {
  opacity: .7;
}

.p-block_kit_modal__spinner {
  z-index: 2;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.p-block_kit_modal .p-block_wrapper--modal_view:not(:first-of-type) {
  margin: 12px 0 0;
}

@font-face {
  font-family: appleLogo;
  src: local(Lucida Grande);
  unicode-range: U+F8FF;
}
</style>