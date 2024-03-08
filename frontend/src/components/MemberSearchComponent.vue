<template>
    <div class="c-sk-modal_portal">
        <div v-show="isModalOpen" class="ReactModal__Overlay ReactModal__Overlay--after-open c-sk-overlay"
            style="padding: 28px;">
            <div class="ReactModal__Content ReactModal__Content--after-open c-sk-modal c-sk-modal--fixed c-sk-modal--responsive p-about_modal"
                role="dialog" aria-label="#테스트 채널 세부정보" aria-modal="false" aria-hidden="false"
                data-qa="channel_details_modal">
                <div class="c-sk-modal_header p-about_modal__header c-sk-modal_header--responsive">
                    <div
                        class="c-sk-modal_title_bar c-sk-modal_title_bar--pad_right c-sk-modal_title_bar--responsive p-about_modal__title">
                        <div class="c-sk-modal_title_bar__text c-sk-modal_title_bar__text_responsive">
                            <h1 class="">
                                <span
                                    class="p-view_header__channel_title_icon c-inline_channel_icon c-inline_channel_icon--space"
                                    data-inline-channel-type-icon="channel">
                                    <svg data-c8r="true" data-qa="channel-filled" aria-hidden="true" viewBox="0 0 20 20"
                                        class="is-inline">
                                        <path fill="currentColor" fill-rule="evenodd"
                                            d="M9.984 4.176a1 1 0 0 0-1.968-.352L7.448 7H4a1 1 0 1 0 0 2h3.091l-.803 4.5H3a1 1 0 1 0 0 2h2.93l-.414 2.324a1 1 0 0 0 1.968.352l.478-2.676h2.719l-.415 2.324a1 1 0 1 0 1.968.352l.478-2.676H16a1 1 0 1 0 0-2h-2.93l.803-4.5H17a1 1 0 1 0 0-2h-2.77l.504-2.824a1 1 0 1 0-1.968-.352L12.198 7H9.48zm1.054 9.324L11.84 9H9.123l-.804 4.5z"
                                            clip-rule="evenodd"></path>
                                    </svg>
                                </span>
                                <span class="p-view_header__channel_title">테스트</span>
                            </h1>
                        </div>
                    </div>
                    <div class="p-about_modal__title_controls">
                        <button class="c-button c-button--outline c-button--small" data-qa="control_button" delay="150"
                            data-sk="tooltip_parent" type="button">알림 활성화</button>
                    </div>
                </div>
                <div class="p-about_modal__tabs" data-qa="tabs_full_height_class">
                    <div role="tablist" class="c-tabs__tab_menu" data-qa="tabs_full_width_class"
                        aria-orientation="horizontal">
                        <button class="c-button-unstyled c-tabs__tab js-tab" data-qa="channel_details_about_tab"
                            id="about" role="tab" aria-selected="false" tabindex="-1" type="button"><span
                                class="c-tabs__tab_content">정보</span></button>
                        <button class="c-button-unstyled c-tabs__tab js-tab c-tabs__tab--active"
                            data-qa="channel_details_members_tab" id="members" role="tab" aria-selected="true"
                            tabindex="0" type="button"><span class="c-tabs__tab_content">멤버</span><span
                                class="c-tabs__tab_count" data-qa="tabs_item_render_count">1</span></button>
                        <button class="c-button-unstyled c-tabs__tab js-tab" data-qa="channel_details_integrations_tab"
                            id="integrations" role="tab" aria-selected="false" tabindex="-1" type="button"><span
                                class="c-tabs__tab_content">통합</span></button>
                        <button class="c-button-unstyled c-tabs__tab js-tab" data-qa="channel_details_settings_tab"
                            id="settings" role="tab" aria-selected="false" tabindex="-1" type="button"><span
                                class="c-tabs__tab_content">설정</span></button>
                    </div>
                    <div role="tabpanel" class="p-about_modal__tab_panel c-tabs__tab_panel c-tabs__tab_panel--active"
                        data-qa="tabs_content_container" aria-label="멤버">
                        <div class="p-ia_details_popover__members" data-qa="ia-details-popover-members-content">
                            <div class="p-ia_details_popover__members_header">
                                <div class="p-ia_details_popover__members_search_input_wrapper">
                                    <div class="c-filter_input p-ia_details_popover__members_header__search_input"
                                        data-qa="members_dialog_filter" role="presentation">
                                        <input class="c-filter_input__input mousetrap"
                                            data-qa="members_dialog_filter_input" type="text" placeholder="멤버 찾기"
                                            aria-label="멤버 찾기" role="searchbox" value="">
                                        <div class="c-filter_input__right_icons">
                                            <button class="c-button-unstyled c-filter_input__reset_button"
                                                data-qa="close_input" aria-label="텍스트 지우기" type="button"></button>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="p-ia_details_popover__members_list" style="position: relative;">
                                <div style="overflow: visible; height: 0px; width: 0px;">
                                    <div role="presentation">
                                        <div role="presentation"
                                            class="c-virtual_list c-virtual_list--scrollbar c-scrollbar c-scrollbar--hidden"
                                            style="width: 580px; height: 572px;">
                                            <div data-qa="slack_kit_scrollbar" role="presentation"
                                                class="c-scrollbar__hider">
                                                <div role="presentation" class="c-scrollbar__child"
                                                    style="width: 580px;">
                                                    <div data-qa="slack_kit_list"
                                                        class="c-virtual_list__scroll_container" role="list"
                                                        tabindex="-1" aria-label="채널 내 멤버"
                                                        style="position: relative; height: 121px;">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <button @click="memberSearchCloseModal" data-v-3885a0bb=""
                    class="c-button-unstyled c-icon_button c-icon_button--size_medium c-sk-modal__close_button c-sk-modal__close_button--responsive c-icon_button--default"
                    data-qa="sk_close_modal_button" aria-label="닫기" type="button">
                    <svg data-v-3885a0bb="" data-c8r="true" data-qa="close" aria-hidden="true" viewBox="0 0 20 20"
                        class="" style="--s: 20px;">
                        <path data-v-3885a0bb="" fill="currentColor" fill-rule="evenodd"
                            d="M16.53 3.47a.75.75 0 0 1 0 1.06L11.06 10l5.47 5.47a.75.75 0 0 1-1.06 1.06L10 11.06l-5.47 5.47a.75.75 0 0 1-1.06-1.06L8.94 10 3.47 4.53a.75.75 0 0 1 1.06-1.06L10 8.94l5.47-5.47a.75.75 0 0 1 1.06 0"
                            clip-rule="evenodd"></path>
                    </svg>
                </button>
            </div>
        </div>
    </div>
</template>


<script>
import '@/styles/common.css';
export default {
    data() {
        return {
            isModalOpen: false
        };
    },
    methods: {
        memberSearchOpenModal() {
            this.isModalOpen = true;
        },
        memberSearchCloseModal() {
            this.isModalOpen = false;
        }
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>
.position_relative {
  position: relative;
}

.position_fixed {
  position: fixed;
}

.inline {
  display: inline;
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

.overflow_hidden {
  overflow: hidden;
}

.overflow_visible {
  overflow: visible;
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

.small_right_padding {
  padding-right: 8px;
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

@keyframes c-infinite_spinner__spin {
  0% {
    transform: rotate(0);
  }

  to {
    transform: rotate(360deg);
  }
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

.c-link--button:hover,.c-link--button:focus,.c-link--button:active {
  outline: none;
}

.c-link--button:hover,.c-link--button:active {
  color: rgba(var(--sk_highlight_hover, 11, 76, 140), 1);
  text-decoration: underline;
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

.c-button:hover,.c-button:active,.c-button:focus {
  text-decoration: none;
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

.c-button--outline:link,.c-button--outline:visited {
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

.c-button--outline:active {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
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

.c-button-unstyled:hover,.c-button-unstyled:focus,.c-button-unstyled:active {
  outline: none;
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

.c-icon_button--default,.c-icon_button--default:link,.c-icon_button--default.c-button-unstyled {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.c-icon_button--default:hover,.c-icon_button--default:link:hover,.c-icon_button--default.c-button-unstyled:hover {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-icon_button--default:active,.c-icon_button--default:link:active,.c-icon_button--default.c-button-unstyled:active {
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

.c-scrollbar:hover .c-scrollbar__bar,.c-scrollbar__bar:active {
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

.c-label__text {
  padding-bottom: 8px;
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

.c-input_text--small {
  height: 28px;
  padding: 7px 8px;
  font-size: 13px;
  line-height: 1.38462;
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

.c-tabs__tab_menu:before,.c-tabs__tab_menu:after {
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

.c-tabs__tab.c-tabs__tab--active,.c-tabs__tab:active {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  box-shadow: inset 0 -2px 0 0 var(--dt_color-theme-base-inv-hgl-1, #007a5a);
  outline: 0;
  text-decoration: none;
}

.c-tabs__tab:not(:last-child) {
  margin-right: 20px;
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

.c-tabs__tab_overflow:hover.c-icon_button--default.c-button-unstyled:hover,.c-tabs__tab_overflow :hover.c-icon_button--default:hover {
  background: 0 0;
}

.c-tabs__tab_overflow.c-tabs__tab--active,.c-tabs__tab_overflow:active {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  box-shadow: inset 0 -2px 0 0 var(--dt_color-theme-base-inv-hgl-1, #007a5a);
  outline: 0;
  text-decoration: none;
}

.c-tabs__tab_overflow_menu_item .c-menu_item__icon {
  margin-right: 8px;
}

.c-tabs__tab_panel {
  width: 100%;
  display: none;
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

.c-menu_item__button,.c-menu_item__button:link,.c-menu_item__button:visited {
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

.c-menu_item__button:hover,.c-menu_item__button:link:hover,.c-menu_item__button:visited:hover,.c-menu_item__button:focus,.c-menu_item__button:link:focus,.c-menu_item__button:visited:focus,.c-menu_item__button:active,.c-menu_item__button:link:active,.c-menu_item__button:visited:active {
  outline: none;
}

[lang] .c-menu_item__button,[lang] .c-menu_item__button:link,[lang] .c-menu_item__button:visited {
  font-size: 15px;
}

[lang=ja-JP] .c-menu_item__button,[lang=ja-JP] .c-menu_item__button:link,[lang=ja-JP] .c-menu_item__button:visited {
  font-size: 14px;
}

[lang] .c-menu_item__button,[lang] .c-menu_item__button:link,[lang] .c-menu_item__button:visited {
  line-height: 28px;
}

[lang=ja-JP] .c-menu_item__button,[lang=ja-JP] .c-menu_item__button:link,[lang=ja-JP] .c-menu_item__button:visited {
  line-height: 30.8px;
}

.c-menu_item__icon {
  text-align: center;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
  min-width: 20px;
  max-width: 28px;
  margin-right: 12px;
}

.c-menu_item__link_icon {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), .7);
}

.c-menu_item__link_icon {
  font-size: 16px;
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

.c-inline_channel_icon--space {
  margin-right: 2px;
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

.p-search_button .c-input_text_icon__icon,.p-search_button .c-input_text_icon,.p-search_button .p-search_button__icon,.p-search_button .p-search_button__input {
  height: 28px;
}

.p-search_button .c-input_text_icon__icon {
  font-size: 20px;
}

.p-search_button .p-search_button__icon {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-search_button .p-search_button__icon,.p-search_button .p-search_button__input {
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

/*!
 * Quill Editor v1.2.6
 * https://quilljs.com/
 * Copyright (c) 2014, Jason Chen
 * Copyright (c) 2013, salesforce.com
 */

@keyframes shouty-rooster__body {
  0%, to {
    transform: rotate(0);
  }

  30%, 50% {
    transform: rotate(-4deg);
  }
}

@keyframes right-wing {
  0%, to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-15deg);
  }
}

@keyframes left-wing {
  0%, to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(15deg);
  }
}

@keyframes yellow-tail {
  0%, to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-4deg);
  }
}

@keyframes pink-tail {
  0%, to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-6deg);
  }
}

@keyframes shout {
  0%, to {
    transform-origin: 50%;
    transform: scale(1);
  }

  50% {
    transform: scale(1.05);
  }
}

@keyframes left-cloud {
  0%, to {
    transform: translate(0);
  }

  50% {
    transform: translate(10px);
  }
}

@keyframes right-cloud {
  0%, to {
    transform: translate(0);
  }

  50% {
    transform: translate(-10px);
  }
}

@keyframes prudent_pigeon__body {
  0%, to {
    transform: translateY(0);
  }

  30%, 50% {
    transform: translateY(-12px);
  }
}

@keyframes prudent_pigeon__envelope {
  0%, to {
    transform-origin: 100%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(-3deg);
  }
}

@keyframes prudent_pigeon__wing {
  0%, to {
    transform-origin: 50%;
    transform: rotate(0);
  }

  50% {
    transform: rotate(10deg);
  }
}

@keyframes prudent_pigeon__envelope_back {
  0%, to {
    transform: translate(0, 0);
  }

  50% {
    transform: translate(-4px, -6px);
  }
}

@keyframes prudent_pigeon__envelope_front {
  0%, to {
    transform: translate(0, 0);
  }

  50% {
    transform: translate(6px, -8px);
  }
}

@keyframes prudent_pigeon__hat {
  0%, to {
    transform: translate(0, 0);
  }

  50% {
    transform: translate(-1px, 3px);
  }
}

@keyframes prudent_pigeon__clouds--left {
  0%, to {
    transform: translate(0);
  }

  50% {
    transform: translate(-10px);
  }
}

@keyframes prudent_pigeon__clouds--right {
  0%, to {
    transform: translate(0);
  }

  50% {
    transform: translate(10px);
  }
}

@keyframes prudent_pigeon__star--yellow {
  0%, to {
    transform: translateY(0);
  }

  50% {
    transform: translateY(-4px);
  }
}

@keyframes prudent_pigeon__star--pink {
  0%, to {
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
  0%, to {
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

.p-channel_name_input__input {
  margin-top: 8px;
  margin-bottom: 20px;
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

.c-filter_input__input[type=text]:active,.c-filter_input__input[type=text]:focus {
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

.c-filter_input__reset_button--visible {
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
  0%, 20% {
    transform: scale(.75);
  }

  80%, to {
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
  0%, 20% {
    transform: scale(.75);
  }

  80%, to {
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

.c-search__view {
  display: flex;
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

input[type=text].c-input_text.p-channel_name_input--input {
  margin-bottom: 0;
}

.p-about_modal {
  flex-direction: column;
  max-width: 580px;
  height: min(85vh, 820px);
  display: flex;
}

.p-about_modal__tabs {
  flex-direction: column;
  flex-grow: 1;
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

.p-about_modal__title .p-view_header__icon--small,.p-about_modal__title .p-view_header__channel_title--small {
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

.p-ia_details_popover__members_list_item {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  align-items: center;
  height: 60px;
  padding: 0 16px;
  display: flex;
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

.p-ia_details_popover__item_placeholder__name,.p-ia_details_popover__item_placeholder__title {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  border-radius: 5px;
  position: absolute;
}

.p-ia_details_popover__item_placeholder__name,.p-ia_details_popover__item_placeholder__title {
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

.p-ia_details_popover__filter .p-ia_details_popover__filter_icon {
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

.p-search_filter__close {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  position: absolute;
  top: 8px;
  left: calc(100% + 3px);
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

.p-search_filter__panel {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 5px 10px #0000001f;
  border-radius: 6px;
  padding: 16px;
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

.p-search_filter__list_item_icon {
  margin-right: 8px;
  font-size: 20px;
}

.p-search_filter__modal_padding {
  padding: 8px 28px 28px;
}

.p-search_filter__placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
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

.p-view_header__menu .c-menu_item__button {
  align-items: baseline;
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

</style>