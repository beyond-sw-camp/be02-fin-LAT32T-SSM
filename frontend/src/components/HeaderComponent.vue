<template>
  <body
    tabindex="-1"
    class="p-ia4_body windows webkit-lineage blink chrome use-slack-font"
  >
    <div aria-hidden="true" style="position: absolute" tabindex="1"></div>
    <div class="p-client_container">
      <div class="p-ia4_client_container">
        <div
          class="p-ia4_client p-ia4_client--with-search-in-top-nav p-ia4_client--workspace-switcher-rail-visibletest p-ia4_client--browser p-ia4_client--narrow p-ia4_client--narrow-feature-on"
        >
          <div class="p-theme_background"></div>
          <div
            role="none"
            class="active-managed-focus-container"
            style="display: contents"
          >
            <div class="offscreen" aria-hidden="true" tabindex="-1"></div>
            <div
              role="toolbar"
              aria-orientation="horizontal"
              aria-label="내역 탐색"
              class="p-ia4_top_nav p-ia4_top_nav--windows"
              data-qa="top-nav"
            >
              <div class="p-ia4_top_nav__native_ui_spacer"></div>
              <div class="p-flexpane__preview-mode-overlay hidden"></div>
              <div class="p-ia4_top_nav__container_wrapper">
                <div
                  class="p-ia4_top_nav__left_container"
                  style="flex-basis: 180px"
                >
                  <div
                    class="p-ia4_top_nav__left_container--start"
                    style="flex-basis: 180px"
                  ></div>
                  <div
                    class="p-ia4_top_nav__left_container--end"
                    style="flex-basis: 180px"
                  >
                    <div class="p-ia4_history_buttons">
                      <button
                        class="c-button-unstyled p-ia4_history_buttons__button"
                        data-qa="unstyled-button"
                        aria-disabled="true"
                        aria-label="내역으로 돌아가기"
                        delay="300"
                        data-sk="tooltip_parent"
                        type="button"
                        tabindex="0"
                      >
                        뒤
                      </button>
                      <button
                        class="c-button-unstyled p-ia4_history_buttons__button"
                        data-qa="unstyled-button"
                        aria-disabled="true"
                        aria-label="내역에서 앞으로 가기"
                        delay="300"
                        data-sk="tooltip_parent"
                        type="button"
                        tabindex="-1"
                      >
                        앞
                      </button>
                    </div>
                    <div class="p-ia4_history_menu_button">
                      <button
                        class="c-button-unstyled p-ia4_history_buttons__button"
                        data-qa="top-nav-history-menu"
                        aria-label="내역 표시"
                        aria-disabled="false"
                        delay="150"
                        aria-haspopup="menu"
                        data-sk="tooltip_parent"
                        type="button"
                        tabindex="-1"
                      >
                        내역
                      </button>
                    </div>
                  </div>
                </div>
                <div class="p-ia4_top_nav__middle_container">
                  <div class="p-top_nav__search__container">
                    <button
                      class="c-button-unstyled p-top_nav__search p-top_nav__search--windows-linux"
                      data-qa="top_nav_search"
                      aria-disabled="false"
                      aria-label="검색"
                      delay="150"
                      data-sk="tooltip_parent"
                      type="button"
                      tabindex="-1"
                    >
                      <div class="p-top_nav__search__icon p-top_nav__search__icon--advanced-search">
                        검색버튼 원래는 돋보기
                      </div>
                      <span class="p-top_nav__search__text" id="search-text">
                        clone용 검색
                      </span>
                    </button>
                  </div>
                </div>
                <div class="p-ia4_top_nav__right_container">
                  <div
                    role="none"
                    id="c-coachmark-anchor_8997aece-80ff-454e-a521-7433ff0005cd"
                    class="c-coachmark-anchor"
                  >
                    <div
                      role="none"
                      id="c-coachmark-anchor_3ef0b004-88f8-41ff-ac97-aff7c37cc6b8"
                      class="c-coachmark-anchor"
                    >
                      <div delay="150" data-sk="tooltip_parent">
                        <div
                          class="p-top_nav__windows_controls_container"
                          data-qa="top-nav-help-button"
                        >
                          <div
                            role="none"
                            id="c-coachmark-anchor_f65cae11-3754-4a75-bc39-72ffb15eabd5"
                            class="c-coachmark-anchor"
                          >
                            <button
                              class="c-button-unstyled p-top_nav__button p-top_nav__help"
                              data-qa="highlight-btn"
                              aria-label="도움말"
                              type="button"
                              tabindex="-1"
                            >
                              도움말
                            </button>
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
      </div>
    </div>
  </body>
</template>
<script>
export default {
  name: "HeaderComponent",
};
</script>

<style>
:root {
  --p-huddle__bg: #350d36;
  --p-huddle__bg_opacity_50: rgba(53, 13, 54, 0.5);
  --p-huddle__hover_item: #4d2a51;
  --p-huddle__hover_text_color: #ffffff;
  --p-huddle__hover_text_color_opacity_50: rgba(255, 255, 255, 50);
  --p-huddle__hover_text_color_opacity_70: rgba(255, 255, 255, 70);
  --p-huddle__active_item: #1164a3;
  --p-huddle__active_item_opacity_13: rgba(17, 100, 163, 0.13);
  --p-huddle__active_item_opacity_70: rgba(17, 100, 163, 0.7);
  --p-huddle__active_item_text: #ffffff;
  --p-huddle__active_item_text_opacity_13: rgba(255, 255, 255, 0.13);
  --p-huddle__active_item_text_opacity_25: rgba(255, 255, 255, 0.25);
  --p-huddle__active_item_text_opacity_50: rgba(255, 255, 255, 0.5);
  --p-huddle__active_item_text_opacity_70: rgba(255, 255, 255, 0.7);
  --p-huddle__text_color: #ffffff;
  --p-huddle__border_color: rgb(73, 37, 74);
  --p-huddle__text_color_opacity_13: rgba(255, 255, 255, 0.13);
  --p-huddle__text_color_opacity_30: rgba(255, 255, 255, 0.3);
  --p-huddle__text_color_opacity_50: rgba(255, 255, 255, 0.5);
  --p-huddle__text_color_opacity_70: rgba(255, 255, 255, 0.7);
}

:root {
  /* DO NOT REMOVE ☠️ #feat-sk-tokens */
  --dt_color-theme-surf-pry: rgba(255, 255, 255, 0.7);
  --dt_color-theme-surf-pry-hover: rgba(29, 28, 29, 0.13);
  --dt_color-theme-surf-pry-pressed: rgba(29, 28, 29, 0.22);
  --dt_color-theme-surf-sec: rgba(97, 31, 105, 0.13);
  --dt_color-theme-surf-sec-hover: rgba(57, 6, 58, 0.22);
  --dt_color-theme-surf-sec-pressed: rgba(57, 6, 58, 0.28);
  --dt_color-theme-surf-ter: rgba(255, 255, 255, 0.95);
  --dt_color-theme-surf-ter-hover: rgba(131, 56, 138, 0.09);
  --dt_color-theme-surf-ter-pressed: rgba(131, 56, 138, 0.13);
  --dt_color-theme-surf-inv-pry: rgba(249, 237, 255, 0.25);
  --dt_color-theme-surf-inv-pry-hover: rgba(131, 56, 138, 0.06);
  --dt_color-theme-surf-inv-pry-pressed: rgba(131, 56, 138, 0.13);
  --dt_color-theme-surf-inv-sec: rgba(249, 237, 255, 0.1);
  --dt_color-theme-surf-inv-sec-hover: rgba(131, 56, 138, 0.06);
  --dt_color-theme-surf-inv-sec-pressed: rgba(131, 56, 138, 0.13);
  --dt_color-theme-base-pry: rgba(249, 237, 255, 1);
  --dt_color-theme-base-pry-hover: rgba(131, 56, 138, 0.06);
  --dt_color-theme-base-pry-pressed: rgba(131, 56, 138, 0.13);
  --dt_color-theme-base-inv-pry: rgba(74, 21, 75, 1);
  --dt_color-theme-base-inv-pry-hover: rgba(57, 6, 58, 0.22);
  --dt_color-theme-base-inv-pry-pressed: rgba(57, 6, 58, 0.28);
  --dt_color-theme-base-inv-sec: rgba(131, 56, 138, 1);
  --dt_color-theme-base-inv-sec-hover: rgba(57, 6, 58, 0.13);
  --dt_color-theme-base-inv-sec-pressed: rgba(57, 6, 58, 0.22);
  --dt_color-theme-base-inv-hgl-1: rgba(11, 76, 140, 1);
  --dt_color-theme-base-inv-hgl-1-hover: rgba(18, 42, 89, 0.22);
  --dt_color-theme-base-inv-hgl-1-pressed: rgba(18, 42, 89, 0.28);
  --dt_color-theme-base-inv-hgl-2: rgba(32, 162, 113, 1);
  --dt_color-theme-base-inv-hgl-2-hover: rgba(10, 64, 50, 0.09);
  --dt_color-theme-base-inv-hgl-2-pressed: rgba(10, 64, 50, 0.22);
  --dt_color-theme-base-inv-imp: rgba(192, 19, 67, 1);
  --dt_color-theme-base-inv-imp-hover: rgba(89, 0, 15, 0.13);
  --dt_color-theme-base-inv-imp-pressed: rgba(89, 0, 15, 0.22);
  --dt_color-theme-content-pry: rgba(57, 6, 58, 1);
  --dt_color-theme-content-sec: rgba(97, 31, 105, 1);
  --dt_color-theme-content-ter: rgba(57, 6, 58, 1);
  --dt_color-theme-content-imp: rgba(192, 19, 67, 1);
  --dt_color-theme-content-inv-pry: rgba(255, 255, 255, 1);
  --dt_color-theme-content-inv-sec: rgba(249, 237, 255, 1);
  --dt_color-theme-content-inv-ter: rgba(249, 237, 255, 0.7);
  --dt_color-theme-content-hgl-1: rgba(57, 6, 58, 1);
  --dt_color-theme-content-inv-imp: rgba(255, 232, 239, 1);
  --dt_color-theme-otl-pry: rgba(97, 31, 105, 1);
  --dt_color-theme-otl-inv-pry: rgba(255, 255, 255, 0.22);
  --dt_color-theme-base-pry: rgba(var(--dt_color-plt-aubergine-0), 1);
  --dt_color-theme-base-pry-hover: rgba(var(--dt_color-plt-aubergine-70), 0.06);
  --dt_color-theme-base-pry-pressed: rgba(
    var(--dt_color-plt-aubergine-70),
    0.13
  );
  --dt_color-theme-base-inv-pry: rgba(var(--dt_color-plt-aubergine-90), 1);
  --dt_color-theme-base-inv-pry-hover: rgba(
    var(--dt_color-plt-aubergine-100),
    0.22
  );
  --dt_color-theme-base-inv-pry-pressed: rgba(
    var(--dt_color-plt-aubergine-100),
    0.28
  );
  --dt_color-theme-base-inv-sec: rgba(var(--dt_color-plt-aubergine-70), 1);
  --dt_color-theme-base-inv-sec-hover: rgba(
    var(--dt_color-plt-aubergine-100),
    0.13
  );
  --dt_color-theme-base-inv-sec-pressed: rgba(
    var(--dt_color-plt-aubergine-100),
    0.22
  );
  --dt_color-theme-surf-pry-hover: rgba(var(--dt_color-plt-aubergine-70), 0.13);
  --dt_color-theme-surf-pry-pressed: rgba(
    var(--dt_color-plt-aubergine-70),
    0.22
  );
  --dt_color-theme-surf-sec: rgba(var(--dt_color-plt-aubergine-80), 0.13);
  --dt_color-theme-surf-sec-hover: rgba(
    var(--dt_color-plt-aubergine-100),
    0.22
  );
  --dt_color-theme-surf-sec-pressed: rgba(
    var(--dt_color-plt-aubergine-100),
    0.28
  );
  --dt_color-theme-surf-ter-hover: rgba(var(--dt_color-plt-aubergine-70), 0.09);
  --dt_color-theme-surf-ter-pressed: rgba(
    var(--dt_color-plt-aubergine-70),
    0.13
  );
  --dt_color-theme-surf-inv-pry: rgba(var(--dt_color-plt-aubergine-0), 0.25);
  --dt_color-theme-surf-inv-pry-hover: rgba(
    var(--dt_color-plt-aubergine-70),
    0.06
  );
  --dt_color-theme-surf-inv-pry-pressed: rgba(
    var(--dt_color-plt-aubergine-70),
    0.13
  );
  --dt_color-theme-surf-inv-sec: rgba(var(--dt_color-plt-aubergine-0), 0.1);
  --dt_color-theme-surf-inv-sec-hover: rgba(
    var(--dt_color-plt-aubergine-70),
    0.06
  );
  --dt_color-theme-surf-inv-sec-pressed: rgba(
    var(--dt_color-plt-aubergine-70),
    0.13
  );
  --dt_color-theme-content-pry: rgba(var(--dt_color-plt-aubergine-100), 1);
  --dt_color-theme-content-sec: rgba(var(--dt_color-plt-aubergine-80), 1);
  --dt_color-theme-content-ter: rgba(var(--dt_color-plt-aubergine-100), 1);
  --dt_color-theme-content-inv-pry: rgba(255, 255, 255, 1);
  --dt_color-theme-content-inv-sec: rgba(var(--dt_color-plt-aubergine-0), 1);
  --dt_color-theme-content-inv-ter: rgba(var(--dt_color-plt-aubergine-0), 0.7);
  --dt_color-theme-otl-inv-pry: rgba(255, 255, 255, 0.22);
  --dt_color-theme-base-inv-hgl-1: rgba(var(--dt_color-plt-aubergine-80), 1);
  --dt_color-theme-base-inv-hgl-1-hover: rgba(
    var(--dt_color-plt-aubergine-100),
    0.22
  );
  --dt_color-theme-base-inv-hgl-1-pressed: rgba(
    var(--dt_color-plt-aubergine-100),
    0.28
  );
  --dt_color-theme-content-hgl-1: rgba(var(--dt_color-plt-aubergine-0), 1);
  --dt_color-theme-base-inv-hgl-2: rgba(var(--dt_color-plt-jade-50), 1);
  --dt_color-theme-base-inv-hgl-2-hover: rgba(
    var(--dt_color-plt-jade-100),
    0.09
  );
  --dt_color-theme-base-inv-hgl-2-pressed: rgba(
    var(--dt_color-plt-jade-100),
    0.22
  );
  --dt_color-theme-base-inv-imp: rgba(var(--dt_color-plt-aubergine-70), 1);
  --dt_color-theme-base-inv-imp-hover: rgba(
    var(--dt_color-plt-aubergine-100),
    0.13
  );
  --dt_color-theme-base-inv-imp-pressed: rgba(
    var(--dt_color-plt-aubergine-100),
    0.22
  );
  --dt_color-theme-content-imp: rgba(var(--dt_color-plt-aubergine-70), 1);
  --dt_color-theme-content-inv-imp: rgba(var(--dt_color-plt-aubergine-0), 1);
}

.p-theme_background {
  background: radial-gradient(
      circle at 50% 50%,
      rgb(var(--dt_color-plt-aubergine-70)) 20%,
      transparent 80%
    ),
    conic-gradient(
      from 45deg at 50% 50%,
      rgb(var(--dt_color-plt-aubergine-90)) 0%,
      rgb(var(--dt_color-plt-aubergine-70)) 25%,
      rgb(var(--dt_color-plt-aubergine-90)) 50%,
      rgb(var(--dt_color-plt-aubergine-70)) 75%,
      rgb(var(--dt_color-plt-aubergine-90)) 100%
    );
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

.hidden {
  visibility: hidden;
  display: none;
}

:root {
  --dt_color-base-pry: #fff;
  --dt_color-base-pry-hover: #4544470f;
  --dt_color-base-pry-pressed: #45444721;
  --dt_color-base-sec: #f8f8f8;
  --dt_color-base-sec-hover: #4544470f;
  --dt_color-base-sec-pressed: #45444721;
  --dt_color-base-ter: #eaeaea;
  --dt_color-base-ter-hover: #4544470f;
  --dt_color-base-ter-pressed: #45444721;
  --dt_color-base-hgl-1: #e3f8ff;
  --dt_color-base-hgl-1-hover: #0071a40f;
  --dt_color-base-hgl-1-pressed: #0071a421;
  --dt_color-base-hgl-2: #e3fff3;
  --dt_color-base-hgl-2-hover: #007a5a0f;
  --dt_color-base-hgl-2-pressed: #007a5a21;
  --dt_color-base-hgl-3: #fffae0;
  --dt_color-base-hgl-3-hover: #aa80000f;
  --dt_color-base-hgl-3-pressed: #aa800021;
  --dt_color-base-imp: #ffe8ef;
  --dt_color-base-imp-hover: #c013430f;
  --dt_color-base-imp-pressed: #c0134321;
  --dt_color-base-modal: #1d1c1db3;
  --dt_color-base-modal-hover: #1d1c1d38;
  --dt_color-base-modal-pressed: #1d1c1d47;
  --dt_color-base-inv-pry: #1d1c1d;
  --dt_color-base-inv-pry-hover: #1d1c1d38;
  --dt_color-base-inv-pry-pressed: #1d1c1d47;
  --dt_color-base-inv-hgl-1: #1264a3;
  --dt_color-base-inv-hgl-1-hover: #122a5921;
  --dt_color-base-inv-hgl-1-pressed: #122a5938;
  --dt_color-base-inv-hgl-2: #007a5a;
  --dt_color-base-inv-hgl-2-hover: #0a403221;
  --dt_color-base-inv-hgl-2-pressed: #0a403238;
  --dt_color-base-inv-hgl-3: #f1b900;
  --dt_color-base-inv-hgl-3-hover: #4d390017;
  --dt_color-base-inv-hgl-3-pressed: #4d390038;
  --dt_color-base-inv-imp: #e01e5a;
  --dt_color-base-inv-imp-hover: #59000f17;
  --dt_color-base-inv-imp-pressed: #59000f38;
  --dt_color-surf-pry: #1d1c1d0f;
  --dt_color-surf-pry-hover: #1d1c1d38;
  --dt_color-surf-pry-pressed: #1d1c1d47;
  --dt_color-surf-sec: #1d1c1d40;
  --dt_color-surf-sec-hover: #1d1c1d38;
  --dt_color-surf-sec-pressed: #1d1c1d47;
  --dt_color-surf-hgl-1: #36c5f021;
  --dt_color-surf-hgl-1-hover: #0071a417;
  --dt_color-surf-hgl-1-pressed: #0071a421;
  --dt_color-surf-hgl-2: #4cc89440;
  --dt_color-surf-hgl-2-hover: #007a5a17;
  --dt_color-surf-hgl-2-pressed: #007a5a21;
  --dt_color-surf-hgl-3: #ffc6002e;
  --dt_color-surf-hgl-3-hover: #aa800017;
  --dt_color-surf-hgl-3-pressed: #aa800021;
  --dt_color-surf-imp: #ff81aa21;
  --dt_color-surf-imp-hover: #c0134317;
  --dt_color-surf-imp-pressed: #c0134321;
  --dt_color-surf-inv: #ffffff2e;
  --dt_color-surf-inv-hover: #4544470f;
  --dt_color-surf-inv-pressed: #45444721;
  --dt_color-ctr-pry: #fff;
  --dt_color-ctr-pry-hover: #4544470f;
  --dt_color-ctr-pry-pressed: #45444721;
  --dt_color-ctr-sec: #f8f8f8;
  --dt_color-ctr-sec-hover: #4544470f;
  --dt_color-ctr-sec-pressed: #45444721;
  --dt_color-content-pry: #1d1c1d;
  --dt_color-content-sec: #454447;
  --dt_color-content-ter: #7c7a7f;
  --dt_color-content-hgl-1: #1264a3;
  --dt_color-content-hgl-2: #007a5a;
  --dt_color-content-hgl-3: #6b5000;
  --dt_color-content-imp: #c01343;
  --dt_color-content-inv-pry: #fff;
  --dt_color-content-inv-sec: #eaeaea;
  --dt_color-content-inv-hgl-1: #9ed6fa;
  --dt_color-content-inv-hgl-2: #4cc894;
  --dt_color-content-inv-hgl-3: #ffd738;
  --dt_color-content-inv-imp: #ffa3c2;
  --dt_color-otl-pry: #7c7a7f;
  --dt_color-otl-sec: #5e5d6073;
  --dt_color-otl-ter: #5e5d6021;
  --dt_color-otl-hgl-1: #1264a3;
  --dt_color-otl-hgl-1-sec: #0e9dd333;
  --dt_color-otl-hgl-2: #007a5a;
  --dt_color-otl-hgl-2-sec: #007a5a1a;
  --dt_color-otl-hgl-3: #c79600;
  --dt_color-otl-hgl-3-sec: #f1b90033;
  --dt_color-otl-imp: #e01e5a;
  --dt_color-otl-imp-sec: #e01e5a4d;
  --dt_color-plt-gray-0: 248, 248, 248;
  --dt_color-plt-gray-5: 234, 234, 234;
  --dt_color-plt-gray-10: 215, 215, 218;
  --dt_color-plt-gray-20: 203, 204, 207;
  --dt_color-plt-gray-30: 181, 181, 186;
  --dt_color-plt-gray-40: 154, 154, 159;
  --dt_color-plt-gray-50: 124, 122, 127;
  --dt_color-plt-gray-60: 94, 93, 96;
  --dt_color-plt-gray-70: 69, 68, 71;
  --dt_color-plt-gray-80: 51, 49, 51;
  --dt_color-plt-gray-90: 38, 36, 38;
  --dt_color-plt-gray-100: 29, 28, 29;
  --dt_color-plt-gray-hover: #1d1c1d21;
  --dt_color-plt-gray-pressed: #1d1c1d38;
  --dt_color-plt-tomato-0: 255, 235, 235;
  --dt_color-plt-tomato-5: 255, 214, 213;
  --dt_color-plt-tomato-10: 255, 194, 190;
  --dt_color-plt-tomato-20: 254, 156, 146;
  --dt_color-plt-tomato-30: 247, 124, 105;
  --dt_color-plt-tomato-40: 237, 98, 70;
  --dt_color-plt-tomato-50: 222, 78, 43;
  --dt_color-plt-tomato-60: 199, 60, 28;
  --dt_color-plt-tomato-70: 173, 46, 18;
  --dt_color-plt-tomato-80: 146, 34, 12;
  --dt_color-plt-tomato-90: 120, 26, 9;
  --dt_color-plt-tomato-100: 97, 19, 7;
  --dt_color-plt-tomato-hover: #61130721;
  --dt_color-plt-tomato-pressed: #61130738;
  --dt_color-plt-paprika-0: 255, 240, 235;
  --dt_color-plt-paprika-5: 251, 223, 213;
  --dt_color-plt-paprika-10: 244, 201, 185;
  --dt_color-plt-paprika-20: 232, 169, 145;
  --dt_color-plt-paprika-30: 222, 137, 105;
  --dt_color-plt-paprika-40: 220, 114, 75;
  --dt_color-plt-paprika-50: 214, 93, 48;
  --dt_color-plt-paprika-60: 204, 75, 27;
  --dt_color-plt-paprika-70: 187, 60, 12;
  --dt_color-plt-paprika-80: 162, 48, 4;
  --dt_color-plt-paprika-90: 132, 37, 0;
  --dt_color-plt-paprika-100: 97, 27, 0;
  --dt_color-plt-paprika-hover: #611b0021;
  --dt_color-plt-paprika-pressed: #611b0038;
  --dt_color-plt-tangerine-0: 255, 237, 229;
  --dt_color-plt-tangerine-5: 255, 227, 214;
  --dt_color-plt-tangerine-10: 254, 212, 190;
  --dt_color-plt-tangerine-20: 251, 184, 149;
  --dt_color-plt-tangerine-30: 248, 155, 108;
  --dt_color-plt-tangerine-40: 242, 128, 69;
  --dt_color-plt-tangerine-50: 233, 104, 37;
  --dt_color-plt-tangerine-60: 220, 84, 12;
  --dt_color-plt-tangerine-70: 200, 70, 0;
  --dt_color-plt-tangerine-80: 172, 61, 0;
  --dt_color-plt-tangerine-90: 139, 50, 0;
  --dt_color-plt-tangerine-100: 102, 37, 0;
  --dt_color-plt-tangerine-hover: #66250021;
  --dt_color-plt-tangerine-pressed: #66250038;
  --dt_color-plt-campfire-0: 255, 242, 224;
  --dt_color-plt-campfire-5: 253, 226, 190;
  --dt_color-plt-campfire-10: 251, 204, 145;
  --dt_color-plt-campfire-20: 246, 180, 101;
  --dt_color-plt-campfire-30: 237, 144, 39;
  --dt_color-plt-campfire-40: 222, 122, 13;
  --dt_color-plt-campfire-50: 207, 108, 2;
  --dt_color-plt-campfire-60: 188, 96, 0;
  --dt_color-plt-campfire-70: 163, 82, 0;
  --dt_color-plt-campfire-80: 134, 67, 0;
  --dt_color-plt-campfire-90: 104, 52, 0;
  --dt_color-plt-campfire-100: 77, 38, 0;
  --dt_color-plt-campfire-hover: #4d260021;
  --dt_color-plt-campfire-pressed: #4d260038;
  --dt_color-plt-honeycomb-0: 252, 242, 217;
  --dt_color-plt-honeycomb-5: 253, 227, 170;
  --dt_color-plt-honeycomb-10: 255, 213, 126;
  --dt_color-plt-honeycomb-20: 244, 195, 96;
  --dt_color-plt-honeycomb-30: 236, 178, 46;
  --dt_color-plt-honeycomb-40: 225, 155, 6;
  --dt_color-plt-honeycomb-50: 211, 141, 0;
  --dt_color-plt-honeycomb-60: 192, 127, 0;
  --dt_color-plt-honeycomb-70: 168, 110, 0;
  --dt_color-plt-honeycomb-80: 142, 91, 0;
  --dt_color-plt-honeycomb-90: 115, 73, 0;
  --dt_color-plt-honeycomb-100: 89, 57, 0;
  --dt_color-plt-honeycomb-hover: #59390021;
  --dt_color-plt-honeycomb-pressed: #59390038;
  --dt_color-plt-sunflower-0: 255, 250, 224;
  --dt_color-plt-sunflower-5: 255, 244, 184;
  --dt_color-plt-sunflower-10: 255, 236, 129;
  --dt_color-plt-sunflower-20: 255, 215, 56;
  --dt_color-plt-sunflower-30: 255, 198, 0;
  --dt_color-plt-sunflower-40: 241, 185, 0;
  --dt_color-plt-sunflower-50: 222, 169, 0;
  --dt_color-plt-sunflower-60: 199, 150, 0;
  --dt_color-plt-sunflower-70: 170, 128, 0;
  --dt_color-plt-sunflower-80: 139, 104, 0;
  --dt_color-plt-sunflower-90: 107, 80, 0;
  --dt_color-plt-sunflower-100: 77, 57, 0;
  --dt_color-plt-sunflower-hover: #4d390021;
  --dt_color-plt-sunflower-pressed: #4d390038;
  --dt_color-plt-grass-0: 244, 255, 219;
  --dt_color-plt-grass-5: 229, 245, 184;
  --dt_color-plt-grass-10: 210, 235, 140;
  --dt_color-plt-grass-20: 180, 215, 88;
  --dt_color-plt-grass-30: 155, 195, 57;
  --dt_color-plt-grass-40: 133, 175, 38;
  --dt_color-plt-grass-50: 114, 156, 26;
  --dt_color-plt-grass-60: 96, 136, 19;
  --dt_color-plt-grass-70: 80, 116, 14;
  --dt_color-plt-grass-80: 64, 96, 10;
  --dt_color-plt-grass-90: 50, 76, 8;
  --dt_color-plt-grass-100: 36, 56, 6;
  --dt_color-plt-grass-hover: #24380621;
  --dt_color-plt-grass-pressed: #24380638;
  --dt_color-plt-cilantro-0: 240, 255, 233;
  --dt_color-plt-cilantro-5: 215, 245, 200;
  --dt_color-plt-cilantro-10: 192, 236, 170;
  --dt_color-plt-cilantro-20: 148, 216, 116;
  --dt_color-plt-cilantro-30: 111, 197, 74;
  --dt_color-plt-cilantro-40: 80, 177, 42;
  --dt_color-plt-cilantro-50: 55, 158, 21;
  --dt_color-plt-cilantro-60: 34, 139, 7;
  --dt_color-plt-cilantro-70: 19, 119, 0;
  --dt_color-plt-cilantro-80: 11, 100, 0;
  --dt_color-plt-cilantro-90: 4, 81, 0;
  --dt_color-plt-cilantro-100: 0, 61, 0;
  --dt_color-plt-cilantro-hover: #003d0021;
  --dt_color-plt-cilantro-pressed: #003d0038;
  --dt_color-plt-mojito-0: 233, 255, 236;
  --dt_color-plt-mojito-5: 208, 246, 215;
  --dt_color-plt-mojito-10: 184, 238, 194;
  --dt_color-plt-mojito-20: 135, 220, 155;
  --dt_color-plt-mojito-30: 96, 202, 126;
  --dt_color-plt-mojito-40: 67, 184, 104;
  --dt_color-plt-mojito-50: 47, 166, 89;
  --dt_color-plt-mojito-60: 34, 149, 77;
  --dt_color-plt-mojito-70: 26, 131, 67;
  --dt_color-plt-mojito-80: 26, 113, 60;
  --dt_color-plt-mojito-90: 24, 95, 52;
  --dt_color-plt-mojito-100: 0, 69, 34;
  --dt_color-plt-mojito-hover: #00452221;
  --dt_color-plt-mojito-pressed: #00452238;
  --dt_color-plt-jade-0: 227, 255, 243;
  --dt_color-plt-jade-5: 195, 246, 224;
  --dt_color-plt-jade-10: 165, 237, 206;
  --dt_color-plt-jade-20: 116, 219, 175;
  --dt_color-plt-jade-30: 76, 200, 148;
  --dt_color-plt-jade-40: 46, 182, 125;
  --dt_color-plt-jade-50: 32, 162, 113;
  --dt_color-plt-jade-60: 23, 143, 101;
  --dt_color-plt-jade-70: 0, 122, 90;
  --dt_color-plt-jade-80: 14, 103, 77;
  --dt_color-plt-jade-90: 12, 83, 64;
  --dt_color-plt-jade-100: 10, 64, 50;
  --dt_color-plt-jade-hover: #0a403221;
  --dt_color-plt-jade-pressed: #0a403238;
  --dt_color-plt-aquarium-0: 227, 255, 255;
  --dt_color-plt-aquarium-5: 197, 246, 247;
  --dt_color-plt-aquarium-10: 169, 237, 239;
  --dt_color-plt-aquarium-20: 120, 215, 221;
  --dt_color-plt-aquarium-30: 83, 191, 201;
  --dt_color-plt-aquarium-40: 55, 168, 182;
  --dt_color-plt-aquarium-50: 35, 146, 162;
  --dt_color-plt-aquarium-60: 22, 125, 142;
  --dt_color-plt-aquarium-70: 13, 106, 123;
  --dt_color-plt-aquarium-80: 8, 88, 103;
  --dt_color-plt-aquarium-90: 5, 71, 83;
  --dt_color-plt-aquarium-100: 3, 54, 64;
  --dt_color-plt-aquarium-hover: #03364021;
  --dt_color-plt-aquarium-pressed: #03364038;
  --dt_color-plt-lagoon-0: 227, 248, 255;
  --dt_color-plt-lagoon-5: 193, 240, 254;
  --dt_color-plt-lagoon-10: 159, 232, 253;
  --dt_color-plt-lagoon-20: 103, 215, 248;
  --dt_color-plt-lagoon-30: 54, 197, 240;
  --dt_color-plt-lagoon-40: 28, 182, 235;
  --dt_color-plt-lagoon-50: 14, 157, 211;
  --dt_color-plt-lagoon-60: 4, 135, 190;
  --dt_color-plt-lagoon-70: 0, 113, 164;
  --dt_color-plt-lagoon-80: 11, 82, 123;
  --dt_color-plt-lagoon-90: 28, 64, 95;
  --dt_color-plt-lagoon-100: 13, 46, 69;
  --dt_color-plt-lagoon-hover: #0d2e4521;
  --dt_color-plt-lagoon-pressed: #0d2e4538;
  --dt_color-plt-ocean-0: 230, 245, 254;
  --dt_color-plt-ocean-5: 194, 230, 253;
  --dt_color-plt-ocean-10: 158, 214, 250;
  --dt_color-plt-ocean-20: 115, 189, 243;
  --dt_color-plt-ocean-30: 84, 169, 234;
  --dt_color-plt-ocean-40: 59, 151, 221;
  --dt_color-plt-ocean-50: 41, 133, 205;
  --dt_color-plt-ocean-60: 27, 116, 185;
  --dt_color-plt-ocean-70: 18, 100, 163;
  --dt_color-plt-ocean-80: 11, 76, 140;
  --dt_color-plt-ocean-90: 9, 58, 115;
  --dt_color-plt-ocean-100: 18, 42, 89;
  --dt_color-plt-ocean-hover: #122a5921;
  --dt_color-plt-ocean-pressed: #122a5938;
  --dt_color-plt-indigo-0: 240, 243, 252;
  --dt_color-plt-indigo-5: 220, 227, 250;
  --dt_color-plt-indigo-10: 200, 212, 248;
  --dt_color-plt-indigo-20: 160, 179, 243;
  --dt_color-plt-indigo-30: 125, 149, 235;
  --dt_color-plt-indigo-40: 95, 123, 225;
  --dt_color-plt-indigo-50: 72, 100, 210;
  --dt_color-plt-indigo-60: 54, 81, 192;
  --dt_color-plt-indigo-70: 40, 64, 169;
  --dt_color-plt-indigo-80: 30, 50, 143;
  --dt_color-plt-indigo-90: 17, 35, 119;
  --dt_color-plt-indigo-100: 9, 24, 97;
  --dt_color-plt-indigo-hover: #09186121;
  --dt_color-plt-indigo-pressed: #09186138;
  --dt_color-plt-aubergine-0: 249, 237, 255;
  --dt_color-plt-aubergine-5: 246, 228, 255;
  --dt_color-plt-aubergine-10: 244, 218, 255;
  --dt_color-plt-aubergine-20: 234, 189, 251;
  --dt_color-plt-aubergine-30: 223, 159, 244;
  --dt_color-plt-aubergine-40: 211, 137, 231;
  --dt_color-plt-aubergine-50: 196, 116, 211;
  --dt_color-plt-aubergine-60: 163, 80, 175;
  --dt_color-plt-aubergine-70: 131, 56, 138;
  --dt_color-plt-aubergine-80: 97, 31, 105;
  --dt_color-plt-aubergine-90: 74, 21, 75;
  --dt_color-plt-aubergine-100: 57, 6, 58;
  --dt_color-plt-aubergine-hover: #39063a21;
  --dt_color-plt-aubergine-pressed: #39063a38;
  --dt_color-plt-sangria-0: 255, 240, 246;
  --dt_color-plt-sangria-5: 250, 225, 236;
  --dt_color-plt-sangria-10: 246, 210, 226;
  --dt_color-plt-sangria-20: 237, 180, 206;
  --dt_color-plt-sangria-30: 226, 150, 185;
  --dt_color-plt-sangria-40: 211, 120, 163;
  --dt_color-plt-sangria-50: 192, 91, 140;
  --dt_color-plt-sangria-60: 180, 73, 126;
  --dt_color-plt-sangria-70: 148, 51, 100;
  --dt_color-plt-sangria-80: 124, 40, 82;
  --dt_color-plt-sangria-90: 94, 18, 55;
  --dt_color-plt-sangria-100: 77, 0, 37;
  --dt_color-plt-sangria-hover: #4d002521;
  --dt_color-plt-sangria-pressed: #4d002538;
  --dt_color-plt-flamingo-0: 255, 232, 239;
  --dt_color-plt-flamingo-5: 255, 214, 228;
  --dt_color-plt-flamingo-10: 255, 196, 217;
  --dt_color-plt-flamingo-20: 255, 163, 194;
  --dt_color-plt-flamingo-30: 255, 129, 170;
  --dt_color-plt-flamingo-40: 250, 95, 144;
  --dt_color-plt-flamingo-50: 239, 62, 117;
  --dt_color-plt-flamingo-60: 224, 30, 90;
  --dt_color-plt-flamingo-70: 192, 19, 67;
  --dt_color-plt-flamingo-80: 158, 11, 46;
  --dt_color-plt-flamingo-90: 123, 4, 28;
  --dt_color-plt-flamingo-100: 89, 0, 15;
  --dt_color-plt-flamingo-hover: #59000f21;
  --dt_color-plt-flamingo-pressed: #59000f38;
  --dt_color-plt-rose-0: 255, 232, 234;
  --dt_color-plt-rose-5: 255, 221, 224;
  --dt_color-plt-rose-10: 255, 209, 214;
  --dt_color-plt-rose-20: 255, 182, 189;
  --dt_color-plt-rose-30: 250, 157, 166;
  --dt_color-plt-rose-40: 250, 124, 134;
  --dt_color-plt-rose-50: 242, 96, 106;
  --dt_color-plt-rose-60: 217, 69, 77;
  --dt_color-plt-rose-70: 187, 44, 51;
  --dt_color-plt-rose-80: 146, 29, 33;
  --dt_color-plt-rose-90: 121, 10, 13;
  --dt_color-plt-rose-100: 89, 0, 1;
  --dt_color-plt-rose-hover: #59000121;
  --dt_color-plt-rose-pressed: #59000138;
  --dt_color-plt-horchata-0: 244, 237, 228;
  --dt_color-plt-horchata-5: 236, 222, 204;
  --dt_color-plt-horchata-10: 227, 206, 181;
  --dt_color-plt-horchata-20: 209, 177, 139;
  --dt_color-plt-horchata-30: 191, 150, 104;
  --dt_color-plt-horchata-40: 174, 127, 77;
  --dt_color-plt-horchata-50: 156, 108, 57;
  --dt_color-plt-horchata-60: 138, 91, 42;
  --dt_color-plt-horchata-70: 120, 76, 31;
  --dt_color-plt-horchata-80: 102, 63, 24;
  --dt_color-plt-horchata-90: 84, 51, 18;
  --dt_color-plt-horchata-100: 66, 40, 13;
  --dt_color-plt-horchata-hover: #42280d21;
  --dt_color-plt-horchata-pressed: #42280d38;
  --dt_color-brand-core-aubergine: #4a154b;
  --dt_color-brand-core-horchatta: #f4ede4;
  --dt_color-brand-core-black: #1d1c1d;
  --dt_color-brand-core-white: #fff;
  --dt_color-brand-core-slack-blue: #36c5f0;
  --dt_color-brand-core-slack-green: #2eb67d;
  --dt_color-brand-core-slack-yellow: #ecb22e;
  --dt_color-brand-core-slack-red: #e01e5a;
  --dt_color-brand-sec-inactive-gray: #eaeaea;
  --dt_color-brand-sec-legal: #5e5d60;
  --dt_color-brand-sec-small-text: #454447;
  --dt_color-brand-sec-text: #1d1c1d;
  --dt_color-brand-sec-terracotta: #de8969;
  --dt_color-brand-sec-peach: #fed4be;
  --dt_color-brand-sec-sandbar: #ffd57e;
  --dt_color-brand-sec-moss: #608813;
  --dt_color-brand-sec-evergreen: #185f34;
  --dt_color-brand-sec-pool: #78d7dd;
  --dt_color-brand-sec-teal: #167d8e;
  --dt_color-brand-sec-cobalt: #112377;
  --dt_color-brand-sec-bright-aubergine: #611f69;
  --dt_color-brand-sec-mauve: #c05b8c;
  --dt_color-brand-sec-berry: #5e1237;
  --dt_color-brand-sec-bubblegum: #ffb6bd;
  --dt_color-brand-sec-salmon: #f2606a;
  --dt_color-brand-sec-crimson: #921d21;
  --dt_color-brand-sec-bg-gray: #f8f8f8;
  --dt_color-constants-white: #fff;
  --dt_color-constants-black: #000;
  --dt_static_shadow-a11y: 0px 0px 0px 1px #1264a3, 0px 0px 0px 5px #0e9dd333;
  --dt_static_shadow-sm: 0px 1px 2px 0px #0000000c;
  --dt_static_shadow-base: 0px 1px 3px 0px #00000019, 0px 1px 2px -1px #00000019;
  --dt_static_shadow-md: 0px 2px 4px -2px #00000019, 0px 4px 6px -1px #00000019;
  --dt_static_shadow-lg: 0px 4px 6px -4px #00000019,
    0px 10px 15px -3px #00000019;
  --dt_static_shadow-xl: 0px 20px 25px -5px #00000019,
    0px 8px 10px -6px #00000019;
  --dt_static_shadow-2xl: 0px 25px 50px -12px #00000040;
  --dt_static_shadow-inner: inset 0px 2px 4px 0px #0000000c;
  --dt_static_radius-none: 0px;
  --dt_static_radius-small: 2px;
  --dt_static_radius-base: 4px;
  --dt_static_radius-large: 8px;
  --dt_static_radius-xlarge: 12px;
  --dt_static_radius-rounded: 9999px;
  --dt_static_radius-ia: clamp(4px, min(22.222%, 12px), 12px);
  --dt_static_space-0: 0px;
  --dt_static_space-100: 16px;
  --dt_static_space-125: 20px;
  --dt_static_space-150: 24px;
  --dt_static_space-175: 28px;
  --dt_static_space-200: 32px;
  --dt_static_space-225: 36px;
  --dt_static_space-250: 40px;
  --dt_static_space-275: 44px;
  --dt_static_space-300: 48px;
  --dt_static_space-325: 52px;
  --dt_static_space-350: 56px;
  --dt_static_space-375: 60px;
  --dt_static_space-400: 64px;
  --dt_static_space-500: 80px;
  --dt_static_space-550: 88px;
  --dt_static_space-600: 96px;
  --dt_static_space-1200: 192px;
  --dt_static_space-1600: 256px;
  --dt_static_space-3200: 512px;
  --dt_static_space-scale: 4px;
  --dt_static_space-0125: 2px;
  --dt_static_space-025: 4px;
  --dt_static_space-050: 8px;
  --dt_static_space-075: 12px;
  --dt_static_space-px: 1px;
  --dt_static_opacity-0: 0;
  --dt_static_opacity-25: 0.25;
  --dt_static_opacity-50: 0.5;
  --dt_static_opacity-75: 0.75;
  --dt_static_opacity-100: 1;
  --dt_static_type-family-lato: Lato;
  --dt_static_type-leading-small: 1.25;
  --dt_static_type-leading-base: 1.5;
  --dt_static_type-size-micro: 12px;
  --dt_static_type-size-caption: 13px;
  --dt_static_type-size-base: 15px;
  --dt_static_type-size-subtitle: 18px;
  --dt_static_type-size-title: 22px;
  --dt_static_type-size-headline: 28px;
  --dt_static_type-weight-base: 400;
  --dt_static_type-weight-semibold: 600;
  --dt_static_type-weight-bold: 700;
  --dt_static_type-weight-black: 900;
  --dt_blend-mode-interaction: multiply;
}

body,
h1,
h2,
h3,
h4,
h5,
h6,
p,
dd {
  margin: 0;
  padding: 0;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  font-weight: 400;
}

html,
body {
  box-sizing: border-box;
  width: 100%;
}

*,
:before,
:after {
  box-sizing: inherit;
}

body {
  font-size: 15px;
  font-weight: 400;
  line-height: 1.46668;
  font-weight: initial;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  font-variant-ligatures: common-ligatures;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
}

[lang] body {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] body {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

a {
  color: rgba(var(--sk_highlight, 18, 100, 163), 1);
  text-decoration: none;
}

a:hover,
a:active,
a:focus {
  color: rgba(var(--sk_highlight_hover, 11, 76, 140), 1);
  text-decoration: underline;
}

h1 {
  font-size: 28px;
  font-weight: 900;
  line-height: 1.2143;
}

h2 {
  font-size: 22px;
  font-weight: 900;
  line-height: 1.36365;
}

h3 {
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
}

h4 {
  font-size: 15px;
  line-height: 1.46668;
  font-weight: initial;
}

p {
  margin-bottom: 16px;
}

[data-c8r] {
  font-size: var(--s, inherit);
  print-color-adjust: exact;
  flex-shrink: 0;
  width: 1em;
  height: 1em;
  display: block;
}

.c-button-unstyled {
  color: inherit;
  font: inherit;
  line-height: initial;
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

html {
  height: 100%;
}

.p-search_button .p-search_button__icon {
  height: 28px;
}

.p-search_button .p-search_button__icon {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.p-search_button .p-search_button__icon {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  border: 1px solid var(--saf-0);
}

.c-coachmark-anchor {
  position: relative;
}

.c-coachmark-anchor {
  position: relative;
}

/*!
 * Quill Editor v1.2.6
 * https://quilljs.com/
 * Copyright (c) 2014, Jason Chen
 * Copyright (c) 2013, salesforce.com
 */

.overlay__T39j8 {
  pointer-events: none;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
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

.p-history_preview__label {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  margin-bottom: 8px;
  padding-left: 4px;
  font-weight: 700;
}

.p-flexpane {
  flex-direction: column;
  flex-grow: 1;
  height: 100%;
  display: flex;
}

.p-flexpane--highlight {
  animation: 3s forwards p-flexpane--highlight;
}

.p-flexpane__title_container {
  min-width: 0;
}

.p-flexpane__title_container.p-flexpane__title_container--ia2022 {
  align-items: initial;
}

.p-flexpane__body {
  flex: 1;
  min-height: 0;
  position: relative;
}

.p-flexpane__preview-mode-overlay {
  opacity: 0.3;
  z-index: 1000;
  background: #1d1c1d;
  width: 100%;
  height: 100%;
  position: absolute;
}

:root {
  --dsg-selection-border-radius: 4px;
  --dsg-selection-border-width: 1px;
  --dsg-selection-background-color: #4580e60a;
  --dsg-selection-disabled-border-color: #9da6ab;
  --dsg-selection-disabled-background-color: #0000000a;
  --dsg-corner-indicator-width: 10px;
}

.p-theme_background {
  width: 100vw;
  height: 100vh;
  position: absolute;
}

.p-top_nav button,
.p-top_nav a {
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
  background: rgba(var(--sk_foreground_min, 29, 28, 29), 0.04);
  opacity: 1;
}

.p-top_nav .p-top_nav__history_menu,
.p-top_nav .p-top_nav__help {
  color: var(--dt_color-theme-content-inv-pry);
  opacity: 1;
  background-blend-mode: var(--dt_blend-mode-interaction);
  background: 0 0;
  background-image: linear-gradient(
    var(--dt_color-theme-surf-inv-pry-hover),
    var(--dt_color-theme-surf-inv-pry-hover)
  );
  border-radius: 4px;
  flex-shrink: 0;
  justify-content: center;
  align-items: center;
  width: 26px;
  height: 26px;
  margin: 0;
  padding: 0;
  display: flex;
}

.p-top_nav .p-top_nav__history_menu:hover,
.p-top_nav .p-top_nav__help:hover {
  color: var(--dt_color-theme-content-inv-pry);
  background: rgba(var(--sk_foreground_min, 29, 28, 29), 0.04);
  opacity: 1;
}

.p-top_nav .p-top_nav__history_menu:active,
.p-top_nav .p-top_nav__help:active {
  background-color: var(--dt_color-theme-base-pry);
}

.p-top_nav .p-top_nav__history_menu {
  margin-left: 0;
}

.p-top_nav__search {
  color: var(--dt_color-theme-content-inv-pry);
  --saf-0: rgba(var(--sk_foreground_mid, 29, 28, 29), 0.3);
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
  --saf-0: rgba(var(--sk_foreground_high, 29, 28, 29), 0.5);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
}

.p-top_nav__search--windows-linux {
  border-radius: 4px;
}

.p-top_nav__search--windows-linux .p-top_nav__search__icon--advanced-search {
  opacity: 0.6;
  transform: translateY(-1px);
}

.p-top_nav__search__text {
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin-right: auto;
  padding-right: 12px;
  display: block;
  overflow: hidden;
}

.p-top_nav__search__container {
  flex: 2;
  align-items: center;
  min-width: 0;
  max-width: 732px;
  display: flex;
  position: relative;
}

.p-ia4_client .p-top_nav__search__container {
  --sk_focused-shadow-color: var(--dt_color-brand-core-white);
  --sk_focused-shadow-color-opaque: var(--dt_color-theme-otl-inv-pry);
}

.p-top_nav__windows_controls_container {
  position: relative;
}

.p-ia4_client .p-top_nav__windows_controls_container {
  --sk_focused-shadow-color: var(--dt_color-brand-core-white);
  --sk_focused-shadow-color-opaque: var(--dt_color-theme-otl-inv-pry);
}

.p-top_nav .p-ia__nav__user {
  height: 26px;
}

.p-top_nav .p-ia__nav__user__button {
  opacity: 1;
  width: 28px;
  height: 28px;
}

.p-top_nav .p-ia__nav__user__button:focus {
  z-index: 1;
}

.p-ia4_history_buttons {
  align-items: center;
  gap: 10px;
  display: flex;
}

.p-ia4_history_buttons__button {
  opacity: 1;
  color: var(--dt_color-theme-content-inv-pry);
  border-radius: 4px;
  margin: 1px;
  padding: 3px;
}

.p-ia4_client .p-ia4_history_buttons__button {
  --sk_focused-shadow-color: var(--dt_color-brand-core-white);
  --sk_focused-shadow-color-opaque: var(--dt_color-theme-otl-inv-pry);
}

.p-ia4_history_buttons__button[aria-disabled="true"] {
  cursor: default;
  opacity: 0.45;
}

.p-ia4_history_buttons__button[aria-disabled="false"]:hover {
  background-color: var(--dt_color-theme-surf-inv-pry);
}

.p-ia4_history_buttons__button[aria-disabled="false"]:active {
  background-color: var(--dt_color-theme-surf-inv-sec);
}

.p-ia4_history_menu_button {
  align-items: center;
  margin-right: 8px;
  display: flex;
}

.p-ia4_history_menu_button__button {
  opacity: 1;
  color: var(--dt_color-theme-content-inv-pry);
  border-radius: 4px;
  margin: 1px;
  padding: 3px;
}

.p-ia4_client .p-ia4_history_menu_button__button {
  --sk_focused-shadow-color: var(--dt_color-brand-core-white);
  --sk_focused-shadow-color-opaque: var(--dt_color-theme-otl-inv-pry);
}

.p-ia4_history_menu_button__button:hover {
  background-color: var(--dt_color-theme-surf-inv-pry);
}

.p-ia4_history_menu_button__button:active {
  background-color: var(--dt_color-theme-surf-inv-sec);
}

.p-workspace_switcher_container .p-workspace_switcher_container__button {
  -webkit-app-region: no-drag;
  opacity: 1;
  color: var(--dt_color-theme-content-inv-pry);
  border-radius: 4px;
  margin: 1px;
  position: relative;
}

.p-ia4_client
  .p-workspace_switcher_container
  .p-workspace_switcher_container__button {
  --sk_focused-shadow-color: var(--dt_color-brand-core-white);
  --sk_focused-shadow-color-opaque: var(--dt_color-theme-otl-inv-pry);
}

.p-workspace_switcher_container .p-workspace_switcher_container__button:hover {
  background-color: var(--dt_color-theme-surf-inv-pry);
  border-radius: 4px;
}

.p-workspace_switcher_container
  .p-workspace_switcher_container__button[aria-disabled="true"] {
  cursor: default;
  opacity: 0.45;
}

.p-workspace_switcher_container
  .p-workspace_switcher_container__button[aria-disabled="false"]:hover {
  background-color: var(--dt_color-theme-surf-inv-pry);
}

.p-workspace_switcher_container
  .p-workspace_switcher_container__button[aria-disabled="false"]:active {
  background-color: var(--dt_color-theme-surf-inv-sec);
}

.p-workspace_switcher_container
  .p-workspace_switcher_container_top_nav__button-top-nav {
  color: var(--dt_color-theme-content-inv-pry);
  margin-left: 16px;
  padding: 3px;
}

.p-ia4_client_container {
  grid-template: "p-ia4_client" "p-client__banners" max-content/auto;
  grid-area: p-ia4_client_container;
  width: 100vw;
  height: 100vh;
  display: grid;
}

.p-ia4_client {
  width: 100vw;
  height: 100vh;
  position: relative;
}

.p-ia4_client.p-ia4_client--browser,
.p-ia4_client.p-ia4_client--browser .p-ia4_client_container {
  min-width: 668px;
}

.p-ia4_client.p-ia4_client--narrow-feature_on {
  grid-template-columns: 70px auto;
}

.p-ia4_client.p-ia4_client--narrow {
  grid-template-columns: 48px auto;
}

.p-ia4_client.p-ia4_client--with-search-in-top-nav {
  grid-template-rows: 40px auto;
  grid-template-areas: "p-ia4_top_nav p-ia4_top_nav" "p-tab-rail p-client-workspace";
}

.p-ia4_client .p-client_workspace_wrapper {
  grid-template: "p-tab-rail p-client-workspace" /76px auto;
  grid-area: p-client_workspace_wrapper;
  width: 100vw;
  height: calc(100vh - 40px);
  display: grid;
}

.p-ia4_client .p-client_workspace_wrapper.p-ia4_client--narrow-feature-on {
  grid-template-columns: 70px auto;
}

.p-ia4_client.p-ia4_client--narrow-feature-on .p-client_workspace_wrapper {
  grid-template-columns: 70px auto;
}

.p-ia4_client.p-ia4_client--narrow .p-client_workspace_wrapper {
  grid-template-columns: 48px auto;
}

.p-ia4_client .p-client_workspace {
  grid-template: "p-client_workspace__layout" 1fr "p-client__banners" / auto;
  grid-area: p-client-workspace;
  padding-bottom: 4px;
  padding-right: 4px;
  display: grid;
  position: relative;
}

.p-ia4_client .p-ia4_top_nav {
  -webkit-app-region: drag;
  grid-column: 1 / span 2;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  height: 40px;
  padding-right: 4px;
  display: flex;
  position: relative;
}

.p-ia4_client .p-ia4_client .p-ia4_top_nav {
  --sk_focused-shadow-color: var(--dt_color-brand-core-white);
  --sk_focused-shadow-color-opaque: var(--dt_color-theme-otl-inv-pry);
}

.p-ia4_client .p-ia4_top_nav--workspace_switcher {
  grid-column: 1 / span 3;
}

.p-ia4_client.p-ia4_client--narrow-feature-on
  .p-workspace_switcher_container
  .p-workspace_switcher_container_top_nav__button-top-nav {
  margin-left: 12px;
}

.p-ia4_client.p-ia4_client--narrow
  .p-workspace_switcher_container
  .p-workspace_switcher_container_top_nav__button-top-nav {
  margin-left: 22px;
}

.p-ia4_client.p-ia4_client--narrow.p-ia4_client--browser
  .p-workspace_switcher_container
  .p-workspace_switcher_container_top_nav__button-top-nav {
  margin-left: 12px;
}

.p-ia4_client .p-ia4_top_nav__native_ui_spacer {
  flex: none;
  width: 76px;
  height: 40px;
  margin-right: auto;
}

.p-ia4_client.p-ia4_client--narrow-feature-on .p-ia4_top_nav__native_ui_spacer {
  width: 70px;
}

.p-ia4_client.p-ia4_client--narrow .p-ia4_top_nav__native_ui_spacer {
  width: 48px;
}

.p-ia4_client .p-ia4_top_nav--windows .p-ia4_top_nav__native_ui_spacer {
  -webkit-app-region: no-drag;
}

.p-ia4_client .p-ia4_top_nav__container_wrapper {
  flex: auto;
  align-items: center;
  display: flex;
}

.p-ia4_client .p-ia4_top_nav__left_container {
  -webkit-app-region: drag;
  flex-direction: row;
  flex: none;
  display: flex;
  position: relative;
}

.p-ia4_client
  .p-ia4_top_nav__left_container
  .p-ia4_top_nav__left_container--start {
  flex-direction: row;
  justify-content: flex-start;
  display: flex;
}

.p-ia4_client
  .p-ia4_top_nav__left_container
  .p-ia4_top_nav__left_container--end {
  flex-direction: row;
  justify-content: flex-end;
  display: flex;
}

.p-ia4_client
  .p-ia4_top_nav__left_container
  .p-ia4_top_nav__left_container--end
  > div {
  -webkit-app-region: no-drag;
}

.p-ia4_client .p-ia4_top_nav__left_container:after {
  content: "";
  width: 8px;
  top: 0;
  bottom: 0;
  left: 0;
}

.p-ia4_client .p-ia4_top_nav__left_container .p-ia4_history_menu_button {
  margin-left: 4px;
  margin-right: 0;
}

.p-ia4_client .p-ia4_top_nav__right_container {
  flex: 1 0 auto;
  justify-content: flex-end;
  align-items: center;
  margin-right: 4px;
  display: flex;
}

.p-ia4_client .p-ia4_top_nav__middle_container {
  flex: 2 1 0;
  min-width: 280px;
  max-width: 1000px;
}

.p-ia4_client .p-ia4_top_nav__middle_container .p-top_nav__search__container {
  background-color: var(--dt_color-theme-surf-inv-pry);
  background-blend-mode: var(--dt_blend-mode-interaction);
  background-image: linear-gradient(
    var(--dt_color-theme-surf-inv-pry-hover),
    var(--dt_color-theme-surf-inv-pry-hover)
  );
  border-color: #0000;
  border-radius: 6px;
  align-items: center;
  max-width: 100%;
  display: flex;
}

.p-ia4_client .p-ia4_top_nav__middle_container .p-top_nav__search {
  justify-content: left;
  max-width: 100%;
  height: 28px;
}

.p-ia4_client .p-ia4_top_nav__middle_container .p-top_nav__search:not(:focus) {
  box-shadow: none;
}

.p-ia4_client .p-ia4_top_nav__middle_container > *,
.p-ia4_client .p-ia4_top_nav__right_container > * {
  -webkit-app-region: no-drag;
}

.p-ia4_client .p-top_nav__button.p-top_nav__help:hover {
  background-color: var(--dt_color-theme-surf-inv-pry);
}

.p-ia4_client .p-top_nav__button.p-top_nav__help:active {
  background-color: var(--dt_color-theme-surf-inv-sec);
}

.p-ia4_client .p-ia4_top_nav__windows_controls {
  -webkit-app-region: no-drag;
  flex: none;
  width: 138px;
  height: 32px;
}

.p-ia4_client .p-ia4_app_menu_button {
  width: 100%;
  height: 100%;
}

html,
body {
  overflow: hidden;
}
</style>
