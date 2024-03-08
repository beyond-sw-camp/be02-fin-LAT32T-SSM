<template>
      <div class="ReactModalPortal" v-show="isModalOpen">
        <div
            class="ReactModal__Overlay ReactModal__Overlay--after-open c-popover c-search_modal c-search_modal--autocomplete c-search_modal--ia4 c-search_modal--onboarding_tip c-popover--z_above_fs">
            <div class="ReactModal__Content ReactModal__Content--after-open popover c-popover__content" tabindex="-1"
                role="dialog" aria-label="검색" aria-modal="false"
                style="position: absolute; left: 0px; top: 0px; outline: none;">
                <div role="presentation">
                    <div class="c-search_modal__wrapper">
                        <div class="c-search__input_and_close c-search__input_and_close--focused_input_box"
                            data-qa="floating_omniswitcher_input">
                            <div class="c-search__input_box" data-qa="search_input_box" role="presentation">
                                <div
                                    class="c-search__input_box__container c-basic_container c-basic_container--size_medium c-basic_container--prefixed c-basic_container--suffixed">
                                    <div class="c-basic_container__body">
                                        <div class="c-search__input_box__icon c-search__input_box__icon--ia4">
                                            <svg data-c8r="true" data-qa="search" aria-hidden="true" viewBox="0 0 20 20"
                                                class="">
                                                <path fill="currentColor" fill-rule="evenodd"
                                                    d="M9 3a6 6 0 1 0 0 12A6 6 0 0 0 9 3M1.5 9a7.5 7.5 0 1 1 13.307 4.746l3.473 3.474a.75.75 0 1 1-1.06 1.06l-3.473-3.473A7.5 7.5 0 0 1 1.5 9"
                                                    clip-rule="evenodd"></path>
                                            </svg>
                                        </div>
                                        <div class="c-texty_input_unstyled__container c-texty_input_unstyled__container--size_medium c-texty_input_unstyled__container--single_line c-texty_input_unstyled__container--use_focus_ring c-texty_input_unstyled__container--no_actions"
                                            data-buttons="1">
                                            <div data-qa="focusable_search_input" data-min-lines="1"
                                                class="texty_single_line_input texty_hide_tooltips c-texty_input_unstyled ql-container focus">
                                                <div class="ql-editor ql-blank" data-gramm="false"
                                                    contenteditable="true" dir="auto" role="combobox" tabindex="0"
                                                    data-team-id="T06MHP7AY5U" data-input-metric-boundary="qs"
                                                    aria-label="검색" aria-multiline="false"
                                                    aria-controls="c-search_autocomplete__suggestion_list"
                                                    aria-expanded="true" aria-autocomplete="list"
                                                    aria-activedescendant="c-search_autcomplete__suggestion_0"
                                                    spellcheck="true">
                                                    <p><br></p>
                                                </div>
                                                <div class="ql-placeholder" aria-hidden="true" tabindex="-1"
                                                    data-reactroot="">메시지 및 파일 검색</div>
                                            </div>
                                            <button
                                                class="c-button-unstyled c-search__input_box__clear c-search__input_box__clear__hidden"
                                                data-qa="search_input_clear" type="button">지우기</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button @click="chatSearchCloseModal" data-v-6f84ed3d=""
                                class="c-button-unstyled c-search__input_and_close__close" data-qa="search_input_close"
                                aria-label="닫기" delay="300" data-sk="tooltip_parent" type="button">
                                <svg data-v-6f84ed3d="" data-c8r="true" data-qa="close" aria-hidden="true"
                                    viewBox="0 0 20 20" class="" style="--s: 20px;">
                                    <path data-v-6f84ed3d="" fill="currentColor" fill-rule="evenodd"
                                        d="M16.53 3.47a.75.75 0 0 1 0 1.06L11.06 10l5.47 5.47a.75.75 0 0 1-1.06 1.06L10 11.06l-5.47 5.47a.75.75 0 0 1-1.06-1.06L8.94 10 3.47 4.53a.75.75 0 0 1 1.06-1.06L10 8.94l5.47-5.47a.75.75 0 0 1 1.06 0"
                                        clip-rule="evenodd"></path>
                                </svg>
                            </button>
                        </div>
                        <div class="c-search_autocomplete__container c-search_autocomplete__container--query-ordered"
                            data-qa="search_autocomplete">
                            <div class="c-search_autocomplete c-search_autocomplete--nav-attached">
                                <div class="offscreen"><span id="search-autocomplete-query-label-prefix-node">검색</span>
                                </div>
                                <ol
                                    class="c-search_autocomplete__suggestion_list c-search_autocomplete__suggestion_list--taller">
                                    <li role="presentation">
                                        <header class="p-setup_tip__header">
                                            <div class="p-setup_tip__tip--search display_flex">
                                                <div class="display_flex align_items_center flex_direction_column">
                                                    <div class="p-slack_tip__header display_flex">
                                                        <img alt="전구 아이콘" class="p-slack_tip__icon"
                                                            srcset="https://a.slack-edge.com/bv1-12/lightbulb-1f13342.png, https://a.slack-edge.com/bv1-12/lightbulb@2x-94e9db4.png 2x">
                                                        메시지, 파일 등 검색
                                                    </div>
                                                    <div class="p-slack_tip__body align_center">특정 메시지, 문서를 찾고 있나요? 검색을
                                                        사용하여 찾을 수 있습니다.</div>
                                                </div>
                                            </div>
                                        </header>
                                       
                                    </li>
                                </ol>
                        
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import '@/styles/common.css';
export default {
    name: 'ChatSearchComponent',
    props: {
        msg: String
    },
    data() {
        return {
            isModalOpen: false
        };
    },
    methods: {
        chatSearchOpenModal() {
            this.isModalOpen = true;
        },
        chatSearchCloseModal() {
            this.isModalOpen = false;
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>
.clear_left {
  clear: left;
}

.position_absolute {
  position: absolute;
}

.position_absolute_top {
  position: absolute;
  top: 0;
}

.position_absolute_left {
  position: absolute;
  left: 0;
}

.offscreen {
  clip: rect(0 0 0 0);
  -webkit-user-select: none;
  user-select: none;
  border: 0;
  width: 1px;
  height: 1px;
  margin: -1px;
  padding: 0;
  position: absolute;
  overflow: hidden;
}

.display_none {
  display: none;
}

.content_box {
  box-sizing: content-box;
}

.align_left {
  text-align: left;
}

.align_center {
  text-align: center;
}

.align_top {
  vertical-align: top;
}

.no_min_width {
  min-width: 0;
}

.auto_width {
  width: auto;
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

.flex_direction_column {
  flex-direction: column;
}

.flex_none {
  flex: none;
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

[data-c8r] {
  font-size: var(--s, inherit);
  print-color-adjust: exact;
  flex-shrink: 0;
  width: 1em;
  height: 1em;
  display: block;
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

.c-button--outline.focus-ring:focus:not(:hover) {
  background-clip: initial;
  border: 1px solid #fff0;
}

.c-button--outline:active {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
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

.c-icon_button--size_medium {
  width: 36px;
  height: 36px;
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

.c-sk-modal__close_button {
  z-index: 1;
  position: absolute;
  top: 20px;
  right: 20px;
}

.c-popover--z_above_fs {
  z-index: 1053;
}

.c-popover--z_fs {
  z-index: 1041;
}

.c-popover--z_modal {
  z-index: 1000;
}

.c-popover--z_dialog {
  z-index: 1012;
}

.c-tooltip__tip {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: #fff;
  text-align: center;
  word-wrap: break-word;
  background-color: #000;
  border-radius: 8px;
  max-width: 200px;
  padding: 8px 12px 10px;
  font-weight: 700;
  display: inline-block;
  position: relative;
}

.c-tooltip__tip--left {
  margin-right: 8px;
}

.c-tooltip__tip--top {
  margin-bottom: 8px;
}

.c-tooltip__tip--top-left {
  margin-bottom: 8px;
}

.c-tooltip__tip--left-align-content {
  text-align: left;
}

.c-tooltip__tip--link {
  text-align: left;
  max-width: 400px;
}

.c-team_icon {
  --sk_team_icon-border-radius: 3px;
  border-radius: var(--sk_team_icon-border-radius);
  background-repeat: no-repeat;
  background-size: 100%;
  display: inline-block;
  position: relative;
}

.c-team_icon:after {
  content: "";
  border-radius: var(--sk_team_icon-border-radius);
  display: block;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  box-shadow: inset 0 0 0 1px #00000014;
}

.c-sk-modal_header {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 8px 8px 0 0;
  flex-shrink: 0;
  width: 100%;
  min-height: 70px;
  overflow: hidden;
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

.c-label {
  font-size: 15px;
  font-weight: 700;
  line-height: 1.46667;
}

html {
  height: 100%;
}

.p-search_button {
  height: 28px;
  margin-right: 0;
}

.p-search_button .p-search_button__icon,.p-search_button .p-search_button__input {
  height: 28px;
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

.p-list_header__actions {
  align-items: center;
  gap: 8px;
  display: flex;
}

.p-list_header__outline_button {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  border: 1px solid var(--saf-0);
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

[data-gantry][data-app=app-popouts] .c-dialog__body {
  flex-grow: 1;
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

.c-basic_container {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
}

[lang] .c-basic_container {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ja-JP] .c-basic_container {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ko-KR] .c-basic_container {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-CN] .c-basic_container {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-TW] .c-basic_container {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.c-basic_container__body {
  display: flex;
  position: relative;
}

.c-basic_container--size_medium .ql-editor {
  padding-bottom: 8px;
  padding-right: 12px;
}

.c-basic_container--size_medium .ql-placeholder {
  right: 12px;
}

.c-basic_container--size_medium .ql-editor {
  padding-top: 8px;
}

.c-basic_container--size_medium .ql-placeholder {
  top: 8px;
}

.c-basic_container--size_medium .ql-editor {
  padding-left: 12px;
}

.c-basic_container--size_medium .ql-placeholder {
  left: 12px;
}

.c-basic_container--size_medium[data-min-lines="1"] .ql-editor {
  min-height: 38px;
}

.c-basic_container--size_medium[data-min-lines="2"] .ql-editor {
  min-height: 60px;
}

.c-basic_container--size_medium[data-min-lines="3"] .ql-editor {
  min-height: 82px;
}

.c-basic_container--size_medium[data-min-lines="4"] .ql-editor {
  min-height: 104px;
}

.c-basic_container--size_medium[data-min-lines="5"] .ql-editor {
  min-height: 126px;
}

.c-basic_container--size_medium[data-max-lines="1"] .c-texty_input_unstyled__container {
  max-height: 38px;
}

.c-basic_container--size_medium[data-max-lines="2"] .c-texty_input_unstyled__container {
  max-height: 60px;
}

.c-basic_container--size_medium[data-max-lines="3"] .c-texty_input_unstyled__container {
  max-height: 82px;
}

.c-basic_container--size_medium[data-max-lines="4"] .c-texty_input_unstyled__container {
  max-height: 104px;
}

.c-basic_container--size_medium[data-max-lines="5"] .c-texty_input_unstyled__container {
  max-height: 126px;
}

.c-basic_container--size_medium[data-max-lines="6"] .c-texty_input_unstyled__container {
  max-height: 148px;
}

.c-basic_container--size_medium[data-max-lines="7"] .c-texty_input_unstyled__container {
  max-height: 170px;
}

.c-basic_container--size_medium[data-max-lines="8"] .c-texty_input_unstyled__container {
  max-height: 192px;
}

.c-basic_container--size_medium[data-max-lines="9"] .c-texty_input_unstyled__container {
  max-height: 214px;
}

.c-basic_container--size_medium[data-max-lines="10"] .c-texty_input_unstyled__container {
  max-height: 236px;
}

.c-basic_container--size_medium[data-max-lines="11"] .c-texty_input_unstyled__container {
  max-height: 258px;
}

.c-basic_container--size_medium[data-max-lines="12"] .c-texty_input_unstyled__container {
  max-height: 280px;
}

.c-basic_container--size_medium[data-max-lines="13"] .c-texty_input_unstyled__container {
  max-height: 302px;
}

.c-basic_container--size_medium[data-max-lines="14"] .c-texty_input_unstyled__container {
  max-height: 324px;
}

.c-basic_container--size_medium[data-max-lines="15"] .c-texty_input_unstyled__container {
  max-height: 346px;
}

.c-basic_container--size_medium[data-max-lines="16"] .c-texty_input_unstyled__container {
  max-height: 368px;
}

.c-basic_container--prefixed .ql-editor {
  padding-left: 0;
}

.c-basic_container--prefixed .ql-placeholder {
  left: 0;
}

.c-basic_container--suffixed .ql-editor {
  padding-right: 0;
}

.c-basic_container--suffixed .ql-placeholder {
  right: 0;
}

.c-texty_autocomplete {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), .13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #00000014;
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  border-radius: 6px;
  flex-direction: column;
  min-width: 420px;
  max-width: 540px;
  max-height: 220px;
  line-height: 1.4rem;
  display: flex;
  overflow: hidden;
}

.c-texty_autocomplete__body {
  padding: 8px 0;
  overflow-x: hidden;
  overflow-y: auto;
}

.ql-container {
  box-sizing: border-box;
  height: auto;
  margin: 0;
  font-family: Helvetica, Arial, sans-serif;
  font-size: 13px;
  position: relative;
}

.ql-editor {
  box-sizing: border-box;
  cursor: text;
  -moz-tab-size: 4;
  tab-size: 4;
  text-align: left;
  white-space: pre-wrap;
  word-wrap: break-word;
  outline: none;
  height: 100%;
  padding: 12px 15px;
  line-height: 1.42;
  overflow-y: auto;
}

.ql-editor p,.ql-editor ol {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
  margin: 0;
  padding: 0;
}

.ql-editor ol {
  padding-left: 1.5em;
}

.ql-editor ol>li {
  list-style-type: none;
}

.ql-editor li:before {
  white-space: nowrap;
  text-align: right;
  width: 1.2em;
  margin-left: -1.5em;
  margin-right: .3em;
  display: inline-block;
}

.ql-editor ol li {
  padding-left: 1.5em;
}

.ql-editor ol li {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
  counter-increment: list-num;
}

.ql-editor ol li:before {
  content: counter(list-num, decimal)". ";
}

.ql-editor .ql-align-center {
  text-align: center;
}

.ql-editor.ql-blank:before {
  color: #0009;
  content: attr(data-placeholder);
  pointer-events: none;
  font-style: italic;
  position: absolute;
}

.c-texty_input {
  --saf-0: rgba(var(--sk_foreground_high_solid, 134, 134, 134), 1);
  border: 1px solid var(--saf-0);
  border-radius: 4px;
  padding: 8px 2px 8px 8px;
  position: relative;
}

[lang] .c-texty_input {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ja-JP] .c-texty_input {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ko-KR] .c-texty_input {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-CN] .c-texty_input {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-TW] .c-texty_input {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.c-texty_input.focus {
  border-color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-texty_input.focus .c-texty_input__button {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-texty_input .ql-editor,.c-texty_input .ql-placeholder {
  padding: 0;
}

[lang] .c-texty_input .ql-editor,[lang] .c-texty_input .ql-placeholder {
  font-size: 15px;
}

[lang=ja-JP] .c-texty_input .ql-editor,[lang=ja-JP] .c-texty_input .ql-placeholder {
  font-size: 14px;
}

[lang] .c-texty_input .ql-editor,[lang] .c-texty_input .ql-placeholder {
  line-height: 1.46668;
}

[lang=ja-JP] .c-texty_input .ql-editor,[lang=ja-JP] .c-texty_input .ql-placeholder {
  line-height: 1.6337;
}

.c-texty_input .ql-editor {
  font-variant-ligatures: none;
  box-sizing: content-box;
  -webkit-tab-size: 8;
  -moz-tab-size: 8;
  tab-size: 8;
  -webkit-user-select: text;
  user-select: text;
  width: 100%;
  overflow: auto;
}

.c-texty_input .ql-editor p,.c-texty_input .ql-editor ol {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
}

.c-texty_input .ql-editor p+ol,.c-texty_input .ql-editor ol:first-of-type {
  counter-reset: list-0;
}

.c-texty_input .ql-editor ol,.c-texty_input .ql-editor li {
  margin: 0;
  padding: 0;
  list-style-type: none;
}

.c-texty_input .ql-editor ol>li {
  margin-left: 26px;
}

.c-texty_input .ql-editor ol>li:before {
  white-space: nowrap;
  text-align: center;
  width: 24px;
  margin-left: -24px;
  margin-right: 0;
  line-height: normal;
  display: inline-block;
  position: relative;
  left: -3px;
}

.c-texty_input .ql-editor ol>li:before {
  counter-increment: list-0;
  content: counter(list-0, decimal)". ";
}

.c-texty_input .ql-editor ol[class*=ql-border-] {
  margin-top: 4px;
  margin-bottom: 4px;
  padding-left: 11px;
  position: relative;
}

.c-texty_input .ql-editor ol[class*=ql-border-]:before {
  content: "";
  background-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  border-radius: 8px;
  width: 4px;
  height: 100%;
  display: block;
  position: absolute;
  top: 0;
  left: 0;
}

.c-texty_input .ql-placeholder {
  text-overflow: ellipsis;
  white-space: nowrap;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  filter: grayscale();
  -ms-filter: grayscale(100%);
  opacity: .5;
  pointer-events: none;
  max-height: 100%;
  font-style: normal;
  display: none;
  position: absolute;
  top: 8px;
  left: 8px;
  right: 8px;
  overflow: hidden;
}

.c-texty_input .ql-placeholder ::selection {
  background: 0 0;
}

.c-texty_input .ql-blank:before {
  display: none;
}

.c-texty_input .ql-blank~.ql-placeholder {
  display: block;
}

.c-texty_input .ql-buttons {
  height: 32px;
  position: absolute;
  bottom: 4px;
  right: 4px;
}

.c-texty_input__placeholder {
  text-overflow: ellipsis;
  white-space: nowrap;
  display: block;
  overflow: hidden;
}

.c-texty_input__button {
  border-radius: 2px;
  transition: opacity .2s, background-color .2s, color .2s;
  position: absolute;
  top: 0;
  right: 0;
}

.c-texty_input__button .c-icon:before {
  font-size: 16px;
}

.c-texty_input__button~.c-texty_input__button {
  right: 33px;
}

.c-texty_input__button~.c-texty_input__button~.c-texty_input__button {
  right: 66px;
}

.c-texty_input__button~.c-texty_input__button~.c-texty_input__button~.c-texty_input__button {
  right: 99px;
}

.c-texty_input__button~.c-texty_input__button~.c-texty_input__button~.c-texty_input__button~.c-texty_input__button {
  right: 131px;
}

.c-texty_input__button~.c-texty_input__button~.c-texty_input__button~.c-texty_input__button~.c-texty_input__button~.c-texty_input__button {
  right: 164px;
}

.c-icon_button.c-texty_input__button:hover {
  box-shadow: none;
}

.c-texty_input_unstyled__container {
  flex: 1;
  align-self: stretch;
  min-width: 0;
  display: flex;
}

.c-texty_input_unstyled__container .ql-editor,.c-texty_input_unstyled__container .ql-placeholder {
  height: unset;
  flex: 1;
}

.c-texty_input_unstyled__container .ql-editor {
  -webkit-tab-size: 8;
  -moz-tab-size: 8;
  tab-size: 8;
  -webkit-user-select: text;
  user-select: text;
  font-variant-ligatures: none;
}

.c-texty_input_unstyled__container .ql-editor p,.c-texty_input_unstyled__container .ql-editor ol {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
}

.c-texty_input_unstyled__container .ql-editor p+ol,.c-texty_input_unstyled__container .ql-editor ol:first-of-type {
  counter-reset: list-0;
}

.c-texty_input_unstyled__container .ql-editor ol,.c-texty_input_unstyled__container .ql-editor li {
  margin: 0;
  padding: 0;
  list-style-type: none;
}

.c-texty_input_unstyled__container .ql-editor ol>li {
  margin-left: 26px;
}

.c-texty_input_unstyled__container .ql-editor ol>li:before {
  white-space: nowrap;
  text-align: center;
  width: 24px;
  margin-left: -24px;
  margin-right: 0;
  line-height: normal;
  display: inline-block;
  position: relative;
  left: -3px;
}

.c-texty_input_unstyled__container .ql-editor ol>li:before {
  counter-increment: list-0;
  content: counter(list-0, decimal)". ";
}

.c-texty_input_unstyled__container .ql-editor ol[class*=ql-border-] {
  margin-top: 4px;
  margin-bottom: 4px;
  padding-left: 11px;
  position: relative;
}

.c-texty_input_unstyled__container .ql-editor ol[class*=ql-border-]:before {
  content: "";
  background-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  border-radius: 8px;
  width: 4px;
  height: 100%;
  display: block;
  position: absolute;
  top: 0;
  left: 0;
}

.c-texty_input_unstyled__container .ql-placeholder {
  filter: grayscale();
  -ms-filter: grayscale(100%);
  text-overflow: ellipsis;
  white-space: nowrap;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  opacity: .5;
  pointer-events: none;
  font-style: normal;
  display: none;
  position: absolute;
  overflow: hidden;
}

.c-texty_input_unstyled__container .ql-placeholder ::selection {
  background: 0 0;
}

.c-texty_input_unstyled__container .ql-blank~.ql-placeholder {
  display: block;
}

[lang] .c-texty_input_unstyled__container--size_medium .ql-editor,[lang] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  font-size: 15px;
}

[lang=ja-JP] .c-texty_input_unstyled__container--size_medium .ql-editor,[lang=ja-JP] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  font-size: 14px;
}

[lang] .c-texty_input_unstyled__container--size_medium .ql-editor,[lang] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  line-height: 1.46668;
}

[lang=ja-JP] .c-texty_input_unstyled__container--size_medium .ql-editor,[lang=ja-JP] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  line-height: 1.6337;
}

.c-texty_input_unstyled__container--size_medium.c-texty_input_unstyled__container--single_line .ql-editor {
  height: 38px;
  min-height: 38px;
  max-height: 38px;
}

.c-texty_input_unstyled__container--single_line .ql-editor,.c-texty_input_unstyled__container--single_line .ql-placeholder {
  white-space: pre;
  overflow: hidden;
}

.c-texty_input_unstyled__container--expanded {
  overflow: auto;
}

.c-texty_input_unstyled {
  flex-grow: 1;
  min-width: 0;
  display: flex;
}

[lang] .c-texty_input_unstyled {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ja-JP] .c-texty_input_unstyled {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=ko-KR] .c-texty_input_unstyled {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-CN] .c-texty_input_unstyled {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang=zh-TW] .c-texty_input_unstyled {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.c-texty_buttons {
  align-items: center;
  display: flex;
  position: relative;
}

input[type=checkbox]:disabled {
  cursor: auto;
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

.c-search_modal:not(.c-search_modal--autocomplete) {
  background-color: #0009;
}

.c-search_modal:not(.c-search_modal--autocomplete)>.popover {
  bottom: 12px;
}

.c-search_modal--autocomplete>.popover {
  height: auto;
}

.c-search_modal__tip_wrapper {
  text-align: center;
  width: 100%;
  position: absolute;
  bottom: -60px;
}

.c-search_modal__tip {
  color: rgba(var(--sk_inverted_foreground, 255, 255, 255), 1);
  background: rgba(var(--sk_inverted_background, 29, 28, 29), 1);
  border-radius: 50px;
  padding: 8px 16px;
  font-size: 15px;
  display: inline-block;
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

.c-search__input_and_close {
  border-bottom: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  flex-direction: row;
  flex: none;
  justify-content: stretch;
  width: 100%;
  display: flex;
}

.c-search__input_and_close--focused {
  --saf-0: rgba(var(--sk_highlight, 18, 100, 163), 1);
  box-shadow: 0 0 0 1px var(--sk_focused-shadow-color, var(--saf-0)), 0 0 0 5px var(--sk_focused-shadow-color-opaque, #1d9bd14d);
  border-radius: 8px;
}

.c-search__input_and_close__close {
  z-index: 1;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  align-self: center;
  margin-right: 28px;
  position: relative;
}

.c-search__input_and_close__close:hover {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-search_modal--onboarding_tip .c-search__input_and_close {
  margin-bottom: 0;
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

.c-search_modal {
  -webkit-app-region: no-drag;
  z-index: 1000;
  background: 0 0;
}

.c-search_modal .c-search_autocomplete__suggestion_list {
  max-height: 40vh;
}

.c-search_modal .c-search_autocomplete__suggestion_list--taller {
  max-height: 60vh;
}

.p-slack_tip__icon {
  background-image: url(https://a.slack-edge.com/bv1-12/lightbulb-1f13342.png);
  background-size: 15px 15px;
  flex-shrink: 0;
  width: 15px;
  height: 15px;
  margin-top: 4px;
  margin-right: 12px;
}

.p-slack_tip__header {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  margin-bottom: 4px;
  font-weight: 700;
}

.p-slack_tip__body {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.p-setup_tip__tip--search {
  max-width: 340px;
  margin: 0 auto;
}

.p-setup_tip__header {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  border-bottom: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  width: 100%;
  padding: 24px 0;
}

.p-setup_tip__suggestion {
  margin-bottom: 4px;
  padding: 4px 0;
  font-size: 15px;
  line-height: 24px;
}

.p-setup_tip__suggestion_icon {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  border-radius: 4px;
  width: 20px;
  margin-right: 12px;
  font-size: 14px;
}

.p-setup_tip__suggestion_link {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-search_autocomplete {
  padding: 0;
}

.c-search_autocomplete--nav-attached {
  flex-direction: column;
  height: 100%;
  display: flex;
}

.c-search_autocomplete__container {
  margin-top: 12px;
}

.c-search_autocomplete__container--query-ordered {
  margin-top: 8px;
}

.c-search_autocomplete__suggestion_list {
  max-height: 60vh;
  margin: 0;
  padding: 0;
  list-style: none;
  overflow-y: auto;
}

.c-search_autocomplete__query_wrapper {
  white-space: nowrap;
  flex: 0 auto;
  height: 30px;
  margin-left: 12px;
  font-weight: 700;
  position: relative;
  overflow: hidden;
}

.c-search__input_box {
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  flex-grow: 1;
  align-items: center;
  min-width: 0;
  height: 44px;
  margin: 0;
  padding-right: 16px;
  display: flex;
  position: relative;
}

.c-search__input_box__container {
  flex: 1;
  min-width: 0;
}

.c-search__input_box__clear {
  border-right: 1px solid rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
}

.c-search__input_box__icon {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  align-self: center;
  margin-left: 28px;
  margin-right: 12px;
  position: relative;
}

.c-search__input_box__icon--ia4 {
  margin-left: 20px;
}

.c-search__input_box__clear {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  align-self: center;
  padding: 0 16px;
  font-size: 13px;
}

.c-search__input_box__clear:hover {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-search__input_box__clear.c-search__input_box__clear__hidden {
  display: none;
}

.p-ia4_top_nav__search_container .c-search__input_and_close--focused {
  box-shadow: 0 0 0 3px var(--dt_color-theme-surf-inv-pry);
  border-radius: 6px;
}

.p-ia4_top_nav__search_container .c-search__input_box__icon {
  font-size: 18px;
}

.p-ia4_top_nav__search_container .c-search__input_and_close .c-search__input_box {
  border: none;
  border-radius: 6px;
  height: 26px;
}

.p-ia4_top_nav__search_container .c-search__input_and_close .c-search__input_box .ql-editor,.p-ia4_top_nav__search_container .c-search__input_and_close .c-search__input_box .ql-placeholder {
  font-size: 13px;
  line-height: 22px;
}

.p-ia4_top_nav__search_container .c-search_autocomplete__container {
  min-width: 520px;
  margin-top: 0;
}

.p-lightbulb_icon {
  vertical-align: bottom;
  justify-content: center;
  align-items: center;
  display: inline-flex;
  position: relative;
}

.p-lightbulb_icon__icon {
  width: 20px;
  height: auto;
  position: relative;
  top: -2px;
}

.p-column_editor_label {
  margin: 8px 0;
  font-weight: 700;
}

:root {
  --dsg-selection-border-radius: 4px;
  --dsg-selection-border-width: 1px;
  --dsg-selection-background-color: #4580e60a;
  --dsg-selection-disabled-border-color: #9da6ab;
  --dsg-selection-disabled-background-color: #0000000a;
  --dsg-corner-indicator-width: 10px;
}

.p-column_editor {
  flex-direction: column;
  width: 270px;
  padding: 4px 0;
  display: flex;
  overflow: auto;
}

.p-top_nav {
  background: rgba(var(--sk_primary_foreground, 29, 28, 29), .07);
  -webkit-app-region: drag;
  z-index: 203;
  color: var(--dt_color-theme-content-inv-pry);
  grid-area: p-top_nav;
  justify-content: center;
  align-items: center;
  min-width: 0;
  display: flex;
  position: relative;
}

.p-top_nav button,.p-top_nav a {
  -webkit-app-region: no-drag;
}

.p-top_nav__button {
  color: var(--dt_color-theme-content-inv-pry);
  opacity: 1;
  border-radius: 4px;
  flex-shrink: 0;
  justify-content: center;
  align-items: center;
  width: 26px;
  height: 26px;
  display: flex;
}

.p-top_nav__button:hover {
  color: var(--dt_color-theme-content-inv-pry);
  background: rgba(var(--sk_foreground_min, 29, 28, 29), .04);
  opacity: 1;
}

.p-top_nav__search {
  color: var(--dt_color-theme-content-inv-pry);
  --saf-0: rgba(var(--sk_foreground_mid, 29, 28, 29), .3);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
  background: 0 0;
  border-radius: 6px;
  flex-direction: row-reverse;
  flex: 5;
  justify-content: space-between;
  align-items: center;
  min-width: 0;
  max-width: 732px;
  height: 26px;
  padding: 0 8px;
  display: flex;
}

.p-top_nav__search:hover {
  --saf-0: rgba(var(--sk_foreground_high, 29, 28, 29), .5);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
}

.p-top_nav__search__container {
  flex: 2;
  align-items: center;
  min-width: 0;
  max-width: 732px;
  display: flex;
  position: relative;
}

.p-top_nav__search__clear {
  width: 26px;
  height: 26px;
}

.p-top_nav__search__clear {
  color: var(--dt_color-theme-content-inv-pry);
  justify-content: center;
  align-items: center;
  display: flex;
  position: absolute;
  right: 0;
}

</style>