<template>
  <body
    tabindex="-1"
    class="p-ia4_body windows webkit-lineage blink chrome use-slack-font"
  >
    <div
      class="workspace__primary_view_footer p-workspace__primary_view_footer--float"
    >
      <div class="p-message_pane_input" data-qa="message_input_container">
        <div class="p-message_pane_input_inner">
          <div class="p-message_pane_input_inner_top"></div>
          <div class="p-message_pane_input_inner_main">
            <div
              class="p-workspace__input p-message_input_unstyled"
              role="group"
              aria-label="작성기"
            >
              <div
                class="p-message_input__input_container_unstyled c-wysiwyg_container c-wysiwyg_container--theme_light c-wysiwyg_container--with_footer c-wysiwyg_container--theme_light_bordered c-wysiwyg_container--double_decker c-basic_container c-basic_container--size_medium"
              >
                <div class="c-basic_container__body">
                  <div
                    role="toolbar"
                    aria-orientation="horizontal"
                    aria-label="서식"
                    class="c-wysiwyg_container__formatting"
                    data-qa="wysiwyg-container_formatting-enabled"
                  >
                    <div class="p-texty_sticky_formatting_bar">
                      <div style="overflow: visible; width: 0px">
                        <div
                          class="p-composer__body p-composer__body--visible p-composer__body--unstyled"
                        >
                          <button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="bold-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="굵게"
                            data-format="bold"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="bold"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M4 2.75A.75.75 0 0 1 4.75 2h6.343a3.91 3.91 0 0 1 3.88 3.449A2 2 0 0 1 15 5.84l.001.067a3.9 3.9 0 0 1-1.551 3.118A4.627 4.627 0 0 1 11.875 18H4.75a.75.75 0 0 1-.75-.75V9.5a.8.8 0 0 1 .032-.218A.8.8 0 0 1 4 9.065zm2.5 5.565h3.593a2.157 2.157 0 1 0 0-4.315H6.5zm4.25 1.935H6.5v5.5h4.25a2.75 2.75 0 1 0 0-5.5"
                                clip-rule="evenodd"
                              ></path>
                            </svg></button
                          ><button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="italic-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="기울임꼴"
                            data-format="italic"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="italic"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M7 2.75A.75.75 0 0 1 7.75 2h7.5a.75.75 0 0 1 0 1.5H12.3l-2.6 13h2.55a.75.75 0 0 1 0 1.5h-7.5a.75.75 0 0 1 0-1.5H7.7l2.6-13H7.75A.75.75 0 0 1 7 2.75"
                                clip-rule="evenodd"
                              ></path>
                            </svg></button
                          ><button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="strike-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="취소선"
                            data-format="strike"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="strikethrough"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M11.721 3.84c-.91-.334-2.028-.36-3.035-.114-1.51.407-2.379 1.861-2.164 3.15C6.718 8.051 7.939 9.5 11.5 9.5l.027.001h5.723a.75.75 0 0 1 0 1.5H2.75a.75.75 0 0 1 0-1.5h3.66c-.76-.649-1.216-1.468-1.368-2.377-.347-2.084 1.033-4.253 3.265-4.848l.007-.002.007-.002c1.252-.307 2.68-.292 3.915.16 1.252.457 2.337 1.381 2.738 2.874a.75.75 0 0 1-1.448.39c-.25-.925-.91-1.528-1.805-1.856m2.968 9.114a.75.75 0 1 0-1.378.59c.273.64.186 1.205-.13 1.674-.333.492-.958.925-1.82 1.137-.989.243-1.991.165-3.029-.124-.93-.26-1.613-.935-1.858-1.845a.75.75 0 0 0-1.448.39c.388 1.441 1.483 2.503 2.903 2.9 1.213.338 2.486.456 3.79.135 1.14-.28 2.12-.889 2.704-1.753.6-.888.743-1.992.266-3.104"
                                clip-rule="evenodd"
                              ></path>
                            </svg></button
                          ><span class="p-composer__separator"></span
                          ><button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="link-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="링크"
                            data-format="link"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="link"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M12.306 3.756a2.75 2.75 0 0 1 3.889 0l.05.05a2.75 2.75 0 0 1 0 3.889l-3.18 3.18a2.75 2.75 0 0 1-3.98-.095l-.03-.034a.75.75 0 0 0-1.11 1.009l.03.034a4.25 4.25 0 0 0 6.15.146l3.18-3.18a4.25 4.25 0 0 0 0-6.01l-.05-.05a4.25 4.25 0 0 0-6.01 0L9.47 4.47a.75.75 0 1 0 1.06 1.06zm-4.611 12.49a2.75 2.75 0 0 1-3.89 0l-.05-.051a2.75 2.75 0 0 1 0-3.89l3.18-3.179a2.75 2.75 0 0 1 3.98.095l.03.034a.75.75 0 1 0 1.11-1.01l-.03-.033a4.25 4.25 0 0 0-6.15-.146l-3.18 3.18a4.25 4.25 0 0 0 0 6.01l.05.05a4.25 4.25 0 0 0 6.01 0l1.775-1.775a.75.75 0 0 0-1.06-1.06z"
                                clip-rule="evenodd"
                              ></path>
                            </svg></button
                          ><span class="p-composer__separator"></span
                          ><button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="ordered-list-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="순서가 지정된 목록"
                            data-format="ordered-list"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="numbered-list"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M3.792 2.094A.5.5 0 0 1 4 2.5V6h1a.5.5 0 1 1 0 1H2a.5.5 0 1 1 0-1h1V3.194l-.842.28a.5.5 0 0 1-.316-.948l1.5-.5a.5.5 0 0 1 .45.068M7.75 3.5a.75.75 0 0 0 0 1.5h10a.75.75 0 0 0 0-1.5zM7 10.75a.75.75 0 0 1 .75-.75h10a.75.75 0 0 1 0 1.5h-10a.75.75 0 0 1-.75-.75m0 6.5a.75.75 0 0 1 .75-.75h10a.75.75 0 0 1 0 1.5h-10a.75.75 0 0 1-.75-.75m-4.293-3.36a1 1 0 0 1 .793-.39c.49 0 .75.38.75.75 0 .064-.033.194-.173.409a5 5 0 0 1-.594.711c-.256.267-.552.548-.87.848l-.088.084a42 42 0 0 0-.879.845A.5.5 0 0 0 2 18h3a.5.5 0 0 0 0-1H3.242l.058-.055c.316-.298.629-.595.904-.882a6 6 0 0 0 .711-.859c.18-.277.335-.604.335-.954 0-.787-.582-1.75-1.75-1.75a2 2 0 0 0-1.81 1.147.5.5 0 1 0 .905.427 1 1 0 0 1 .112-.184"
                                clip-rule="evenodd"
                              ></path>
                            </svg></button
                          ><button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="bullet-list-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="글머리 기호 목록"
                            data-format="bullet-list"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="bulleted-list"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M4 3a1 1 0 1 1-2 0 1 1 0 0 1 2 0m3 0a.75.75 0 0 1 .75-.75h10a.75.75 0 0 1 0 1.5h-10A.75.75 0 0 1 7 3m.75 6.25a.75.75 0 0 0 0 1.5h10a.75.75 0 0 0 0-1.5zm0 7a.75.75 0 0 0 0 1.5h10a.75.75 0 0 0 0-1.5zM3 11a1 1 0 1 0 0-2 1 1 0 0 0 0 2m0 7a1 1 0 1 0 0-2 1 1 0 0 0 0 2"
                                clip-rule="evenodd"
                              ></path>
                            </svg></button
                          ><span class="p-composer__separator"></span
                          ><button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small p-composer__button p-composer__button--composer_ia p-composer__selection_button p-composer__button--sticky p-composer__button--no_pointer_events c-icon_button--default"
                            data-qa="overflow-composer-button"
                            role="button"
                            tabindex="-1"
                            aria-label="추가 옵션"
                            data-format="overflow"
                            aria-pressed="false"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="ellipsis-horizontal-filled"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                            >
                              <path
                                fill="currentColor"
                                d="M14.5 10a1.75 1.75 0 1 1 3.5 0 1.75 1.75 0 0 1-3.5 0m-6.25 0a1.75 1.75 0 1 1 3.5 0 1.75 1.75 0 0 1-3.5 0M2 10a1.75 1.75 0 1 1 3.5 0A1.75 1.75 0 0 1 2 10"
                              ></path>
                            </svg>
                          </button>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div
                    class="c-texty_input_unstyled__container c-texty_input_unstyled__container--size_medium c-texty_input_unstyled__container--multi_line c-texty_input_unstyled__container--no_actions"
                    data-buttons="1"
                  >
                    <div
                      data-qa="message_input"
                      data-message-input="true"
                      data-channel-id="C06MWG5F67R"
                      data-view-context="Channel"
                      data-min-lines="1"
                      class="c-texty_input_unstyled ql-container"
                    >
                      <div
                        class="ql-editor ql-blank"
                        data-gramm="false"
                        contenteditable="true"
                        dir="auto"
                        role="textbox"
                        tabindex="0"
                        data-team-id="T06MWG3SF3R"
                        data-input-metric-boundary="composer"
                        aria-label="Message to project"
                        aria-describedby="context_bar_text-340c606c"
                        aria-multiline="true"
                        spellcheck="true"
                      >
                        <p><br /></p>
                      </div>
                      <div
                        class="ql-clipboard"
                        contenteditable="true"
                        tabindex="-1"
                        aria-hidden="true"
                      ></div>
                      <div
                        class="ql-placeholder"
                        aria-hidden="true"
                        tabindex="-1"
                        data-reactroot=""
                      >
                        <div class="c-texty_input__placeholder">
                          <i
                            class="c-icon c-texty_input__placeholder_icon--public c-icon--hash-small c-icon--inline"
                            data-qa="slack_kit_icon"
                            type="hash-small"
                            aria-hidden="true"
                          ></i
                          >project에 메시지 보내기
                        </div>
                      </div>
                    </div>
                  </div>
                  <div
                    role="toolbar"
                    aria-orientation="horizontal"
                    aria-label="작성기 작업"
                    class="c-wysiwyg_container__footer c-wysiwyg_container__footer--with_formatting"
                  >
                    <div
                      class="c-wysiwyg_container__prefix"
                      data-qa="wysiwyg-container_prefix"
                    >
                      <div class="">
                        <div
                          class="p-shortcuts_menu_trigger_button_container--composer_ia p-shortcuts_menu_trigger_button_container_unstyled p-shortcuts_menu_trigger_button_container_unstyled--composer_ia"
                        >
                          <div
                            data-shortcuts-button-wrapper="true"
                            class="p-shortcuts_menu_trigger_button_container--composer_ia_icon_button"
                            delay="150"
                            data-sk="tooltip_parent"
                          >
                            <button
                              class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--shortcuts p-shortcuts_menu_trigger_button--composer_ia c-icon_button--default"
                              data-qa="shortcuts_menu_trigger__Channel"
                              aria-label="첨부"
                              type="button"
                              tabindex="0"
                            >
                              <svg
                                data-c8r="true"
                                data-qa="plus"
                                aria-hidden="true"
                                viewBox="0 0 20 20"
                                class=""
                              >
                                <path
                                  fill="currentColor"
                                  fill-rule="evenodd"
                                  d="M10.75 3.25a.75.75 0 0 0-1.5 0v6H3.251L3.25 10v-.75a.75.75 0 0 0 0 1.5V10v.75h6v6a.75.75 0 0 0 1.5 0v-6h6a.75.75 0 0 0 0-1.5h-6z"
                                  clip-rule="evenodd"
                                ></path>
                              </svg>
                            </button>
                          </div>
                          <input
                            type="file"
                            class="p-hidden_file_input"
                            multiple=""
                            aria-hidden="true"
                            data-qa="file_upload"
                            tabindex="-1"
                          />
                        </div>
                      </div>
                    </div>
                    <div
                      class="c-wysiwyg_container__toolbar_buttons"
                      data-qa="wysiwyg-container_toolbar-buttons"
                    >
                      <div class="c-texty_buttons">
                        <button
                          class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--composer c-wysiwyg_container__button--composer_active c-icon_button--default"
                          data-qa="texty_composer_button"
                          aria-disabled="false"
                          tabindex="-1"
                          aria-label="서식 표시"
                          aria-pressed="true"
                          delay="500"
                          data-sk="tooltip_parent"
                          type="button"
                        >
                          <svg
                            data-c8r="true"
                            data-qa="formatting"
                            aria-hidden="true"
                            viewBox="0 0 20 20"
                            class=""
                            style="--s: 18px"
                          >
                            <path
                              fill="currentColor"
                              fill-rule="evenodd"
                              d="M6.941 3.952c-.459-1.378-2.414-1.363-2.853.022l-4.053 12.8a.75.75 0 0 0 1.43.452l1.101-3.476h6.06l1.163 3.487a.75.75 0 1 0 1.423-.474zm1.185 8.298L5.518 4.427 3.041 12.25zm6.198-5.537a4.74 4.74 0 0 1 3.037-.081A3.74 3.74 0 0 1 20 10.208V17a.75.75 0 0 1-1.5 0v-.745a8 8 0 0 1-2.847 1.355 3 3 0 0 1-3.15-1.143C10.848 14.192 12.473 11 15.287 11H18.5v-.792c0-.984-.641-1.853-1.581-2.143a3.24 3.24 0 0 0-2.077.056l-.242.089a2.22 2.22 0 0 0-1.34 1.382l-.048.145a.75.75 0 0 1-1.423-.474l.048-.145a3.72 3.72 0 0 1 2.244-2.315zM18.5 12.5h-3.213c-1.587 0-2.504 1.801-1.57 3.085.357.491.98.717 1.572.57a6.5 6.5 0 0 0 2.47-1.223l.741-.593z"
                              clip-rule="evenodd"
                            ></path>
                          </svg></button
                        ><button
                          class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--emoji skin-tone- c-icon_button--default"
                          data-qa="texty_emoji_button"
                          tabindex="-1"
                          aria-label="이모티콘"
                          delay="500"
                          data-sk="tooltip_parent"
                          type="button"
                        >
                          <div class="is-first">
                            <svg
                              data-c8r="true"
                              data-qa="emoji"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                              style="--s: 18px"
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M2.5 10a7.5 7.5 0 1 1 15 0 7.5 7.5 0 0 1-15 0M10 1a9 9 0 1 0 0 18 9 9 0 0 0 0-18M7.5 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3M14 8a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0m-6.385 3.766a.75.75 0 1 0-1.425.468C6.796 14.08 8.428 15 10.027 15s3.23-.92 3.838-2.766a.75.75 0 1 0-1.425-.468c-.38 1.155-1.38 1.734-2.413 1.734s-2.032-.58-2.412-1.734"
                                clip-rule="evenodd"
                              ></path>
                            </svg>
                          </div>
                          <div class="is-second">
                            <svg
                              data-c8r="true"
                              data-qa="emoji-filled"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                              style="--s: 18px"
                            >
                              <path
                                fill="currentColor"
                                fill-rule="evenodd"
                                d="M2.5 10a7.5 7.5 0 1 1 15 0 7.5 7.5 0 0 1-15 0M10 1a9 9 0 1 0 0 18 9 9 0 0 0 0-18M7.5 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3M14 8a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0m-.523 4.597c-.616 1.576-2.046 2.364-3.477 2.364-1.43 0-2.86-.788-3.477-2.364-.22-.56.258-1.097.86-1.097h5.234c.602 0 1.08.537.86 1.097"
                                clip-rule="evenodd"
                              ></path>
                            </svg>
                          </div></button
                        ><button
                          class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-icon_button--default"
                          data-qa="texty_mention_button"
                          tabindex="-1"
                          aria-label="다른 사람에게 멘션"
                          delay="500"
                          data-sk="tooltip_parent"
                          type="button"
                        >
                          <svg
                            data-c8r="true"
                            data-qa="mentions"
                            aria-hidden="true"
                            viewBox="0 0 20 20"
                            class=""
                            style="--s: 18px"
                          >
                            <path
                              fill="currentColor"
                              fill-rule="evenodd"
                              d="M2.5 10a7.5 7.5 0 1 1 15 0v.645c0 1.024-.83 1.855-1.855 1.855a1.145 1.145 0 0 1-1.145-1.145V6.75a.75.75 0 0 0-1.494-.098 4.5 4.5 0 1 0 .465 6.212A2.64 2.64 0 0 0 15.646 14 3.355 3.355 0 0 0 19 10.645V10a9 9 0 1 0-3.815 7.357.75.75 0 1 0-.865-1.225A7.5 7.5 0 0 1 2.5 10m7.5 3a3 3 0 1 0 0-6 3 3 0 0 0 0 6"
                              clip-rule="evenodd"
                            ></path>
                          </svg>
                        </button>
                        <div class="c-texty_buttons__overflow_container">
                          <button
                            class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-icon_button--default"
                            data-qa="slash_commands_overflow_button"
                            tabindex="-1"
                            aria-label="추가 옵션"
                            aria-haspopup="menu"
                            delay="500"
                            data-sk="tooltip_parent"
                            type="button"
                          >
                            <svg
                              data-c8r="true"
                              data-qa="ellipsis-horizontal-filled"
                              aria-hidden="true"
                              viewBox="0 0 20 20"
                              class=""
                              style="--s: 18px"
                            >
                              <path
                                fill="currentColor"
                                d="M14.5 10a1.75 1.75 0 1 1 3.5 0 1.75 1.75 0 0 1-3.5 0m-6.25 0a1.75 1.75 0 1 1 3.5 0 1.75 1.75 0 0 1-3.5 0M2 10a1.75 1.75 0 1 1 3.5 0A1.75 1.75 0 0 1 2 10"
                              ></path>
                            </svg>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div
                      class="c-wysiwyg_container__suffix"
                      data-qa="wysiwyg-container_suffix"
                    >
                      <span
                        class="c-wysiwyg_container__send_button--with_options c-wysiwyg_container__send_button--with_options_disabled"
                        ><button
                          class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--send c-wysiwyg_container__button--disabled c-button--disabled c-icon_button--default"
                          data-qa="texty_send_button"
                          tabindex="-1"
                          aria-disabled="true"
                          aria-label="지금 보내기"
                          delay="150"
                          data-sk="tooltip_parent"
                          type="button"
                        >
                          <svg
                            data-c8r="true"
                            data-qa="send-filled"
                            aria-hidden="true"
                            viewBox="0 0 20 20"
                            class=""
                            style="--s: 16px"
                          >
                            <path
                              fill="currentColor"
                              d="M1.5 2.25a.755.755 0 0 1 1-.71l15.596 7.808a.73.73 0 0 1 0 1.305L2.5 18.462l-.076.018a.75.75 0 0 1-.924-.728v-4.54c0-1.21.97-2.229 2.21-2.25l6.54-.17c.27-.01.75-.24.75-.79s-.5-.79-.75-.79l-6.54-.17A2.253 2.253 0 0 1 1.5 6.79z"
                            ></path>
                          </svg></button
                        ><button
                          class="c-button-unstyled c-icon_button c-icon_button--size_small c-wysiwyg_container__button c-wysiwyg_container__button--send_options c-wysiwyg_container__button--disabled c-button--disabled c-icon_button--default"
                          data-qa="texty_send_options_button"
                          tabindex="-1"
                          aria-disabled="true"
                          aria-label="나중에 예약"
                          delay="150"
                          aria-haspopup="menu"
                          data-sk="tooltip_parent"
                          type="button"
                        >
                          <svg
                            data-c8r="true"
                            data-qa="caret-down"
                            aria-hidden="true"
                            viewBox="0 0 20 20"
                            class=""
                          >
                            <path
                              fill="currentColor"
                              fill-rule="evenodd"
                              d="M5.72 7.47a.75.75 0 0 1 1.06 0L10 10.69l3.22-3.22a.75.75 0 1 1 1.06 1.06l-3.75 3.75a.75.75 0 0 1-1.06 0L5.72 8.53a.75.75 0 0 1 0-1.06"
                              clip-rule="evenodd"
                            ></path>
                          </svg></button
                      ></span>
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
  name: "ChatInputComponent",
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

.bold {
  font-weight: 700;
}

.italic {
  font-style: italic;
}

.float_left {
  float: left;
}

.float_right {
  float: right;
}

.inline {
  display: inline;
}

.no_max_width {
  max-width: none;
}

.no_min_width {
  min-width: 0;
}

.auto_width {
  width: auto;
}

.bordered {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  border: 1px solid var(--saf-0);
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

.overflow_ellipsis {
  text-overflow: ellipsis;
  white-space: nowrap;
  display: block;
  overflow: hidden;
}

.sk_primary_foreground {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.sk_foreground_max {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
}

.sk_foreground_min {
  color: rgba(var(--sk_foreground_min, 29, 28, 29), 0.04);
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
p {
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

[lang="ja-JP"] body {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] body {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-CN"] body {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-TW"] body {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
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

.is-inline {
  vertical-align: -0.125em;
  display: inline-block;
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
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.75);
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

.c-icon_button.c-button--disabled {
  opacity: 0.5;
}

.c-icon_button--default,
.c-icon_button--default:link,
.c-icon_button--default.c-button-unstyled {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
}

.c-icon_button--default:hover,
.c-icon_button--default:link:hover,
.c-icon_button--default.c-button-unstyled:hover {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), 0.04);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-icon_button--default:active,
.c-icon_button--default:link:active,
.c-icon_button--default.c-button-unstyled:active {
  background: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
}

.c-icon_button--light,
.c-icon_button--light:link,
.c-icon_button--light.c-button-unstyled {
  color: #1d1c1db3;
}

.c-icon_button--light:hover,
.c-icon_button--light:link:hover,
.c-icon_button--light.c-button-unstyled:hover {
  color: #1d1c1d;
  background: #1d1c1d0d;
}

.c-icon_button--light:active,
.c-icon_button--light:link:active,
.c-icon_button--light.c-button-unstyled:active {
  background: #1d1c1d1a;
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

.c-team_icon--default {
  background-color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  color: rgba(var(--sk_inverted_foreground, 255, 255, 255), 1);
  text-shadow: 0 1px 1px #0003;
  flex-shrink: 0;
  justify-content: center;
  align-items: center;
  font-style: normal;
  font-weight: 700;
  display: flex;
  overflow: hidden;
}

.c-menu_separator__separator {
  border-top: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  border-bottom: 0;
  margin: 0;
}

.c-menu {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
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
  padding: 0.1px 0;
  overflow-y: auto;
}

[lang] .c-menu {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ja-JP"] .c-menu {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] .c-menu {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-CN"] .c-menu {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-TW"] .c-menu {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
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

.c-emoji {
  vertical-align: top;
  object-fit: contain;
  align-items: center;
  display: inline-flex;
  overflow: hidden;
}

.c-emoji__small {
  width: 16px;
  height: 16px;
}

.c-emoji__medium {
  width: 22px;
  height: 22px;
}

.c-emoji--inline {
  vertical-align: baseline;
  height: auto;
  position: relative;
  overflow: visible;
}


.c-emoji__emoji-tooltip {
  margin-bottom: 4px;
}

.c-channel_team {
  display: flex;
}

.c-channel_team__icon {
  flex: none;
  margin-right: 4px;
}

.c-channel_team__icon {
  align-self: center;
}

.p-inline_channel_section {
  text-overflow: ellipsis;
  display: inline;
  overflow: hidden;
}

html {
  height: 100%;
}

.p-list_icon {
  color: rgb(var(--dt_color-plt-honeycomb-0));
  background-color: rgb(var(--dt_color-plt-honeycomb-40));
  border-radius: 8px;
  justify-content: center;
  align-items: center;
  display: inline-flex;
}

.c-basic_container {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
}

[lang] .c-basic_container {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ja-JP"] .c-basic_container {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] .c-basic_container {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-CN"] .c-basic_container {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-TW"] .c-basic_container {
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

.c-basic_container--size_medium[data-max-lines="1"]
  .c-texty_input_unstyled__container {
  max-height: 38px;
}

.c-basic_container--size_medium[data-max-lines="2"]
  .c-texty_input_unstyled__container {
  max-height: 60px;
}

.c-basic_container--size_medium[data-max-lines="3"]
  .c-texty_input_unstyled__container {
  max-height: 82px;
}

.c-basic_container--size_medium[data-max-lines="4"]
  .c-texty_input_unstyled__container {
  max-height: 104px;
}

.c-basic_container--size_medium[data-max-lines="5"]
  .c-texty_input_unstyled__container {
  max-height: 126px;
}

.c-basic_container--size_medium[data-max-lines="6"]
  .c-texty_input_unstyled__container {
  max-height: 148px;
}

.c-basic_container--size_medium[data-max-lines="7"]
  .c-texty_input_unstyled__container {
  max-height: 170px;
}

.c-basic_container--size_medium[data-max-lines="8"]
  .c-texty_input_unstyled__container {
  max-height: 192px;
}

.c-basic_container--size_medium[data-max-lines="9"]
  .c-texty_input_unstyled__container {
  max-height: 214px;
}

.c-basic_container--size_medium[data-max-lines="10"]
  .c-texty_input_unstyled__container {
  max-height: 236px;
}

.c-basic_container--size_medium[data-max-lines="11"]
  .c-texty_input_unstyled__container {
  max-height: 258px;
}

.c-basic_container--size_medium[data-max-lines="12"]
  .c-texty_input_unstyled__container {
  max-height: 280px;
}

.c-basic_container--size_medium[data-max-lines="13"]
  .c-texty_input_unstyled__container {
  max-height: 302px;
}

.c-basic_container--size_medium[data-max-lines="14"]
  .c-texty_input_unstyled__container {
  max-height: 324px;
}

.c-basic_container--size_medium[data-max-lines="15"]
  .c-texty_input_unstyled__container {
  max-height: 346px;
}

.c-basic_container--size_medium[data-max-lines="16"]
  .c-texty_input_unstyled__container {
  max-height: 368px;
}

.c-basic_container--bordered {
  --saf-0: rgba(var(--sk_foreground_high_solid, 134, 134, 134), 1);
  border: 1px solid var(--saf-0);
  border-radius: 4px;
}

.c-basic_container--bordered:focus-within {
  --saf-0: rgba(var(--sk_highlight, 18, 100, 163), 1);
  box-shadow: 0 0 0 1px var(--sk_focused-shadow-color, var(--saf-0)),
    0 0 0 5px var(--sk_focused-shadow-color-opaque, #1d9bd14d);
  -webkit-appearance: none;
  border-color: #0000;
  border-radius: 4px;
}

.c-basic_container--bordered:focus-within::-webkit-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-basic_container--bordered:focus-within::-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-basic_container--bordered:focus-within:-ms-input-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-basic_container--bordered:focus-within:-moz-placeholder {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
}

.c-basic_container--disabled {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  opacity: 0.6;
  pointer-events: none;
}

/*!
 * Quill Editor v1.2.6
 * https://quilljs.com/
 * Copyright (c) 2014, Jason Chen
 * Copyright (c) 2013, salesforce.com
 */

.ql-container {
  box-sizing: border-box;
  height: auto;
  margin: 0;
  font-family: Helvetica, Arial, sans-serif;
  font-size: 13px;
  position: relative;
}

.ql-container.ql-disabled .ql-tooltip {
  visibility: hidden;
}

.ql-clipboard {
  height: 1px;
  position: absolute;
  top: 50%;
  left: -100000px;
  overflow-y: hidden;
}

.ql-clipboard p {
  margin: 0;
  padding: 0;
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

.ql-editor p,
.ql-editor h1,
.ql-editor h2,
.ql-editor h3,
.ql-editor h4,
.ql-editor h5,
.ql-editor h6 {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
  margin: 0;
  padding: 0;
}

.ql-editor .ql-size-small {
  font-size: 0.75em;
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

[lang="ja-JP"] .c-texty_input {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] .c-texty_input {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-CN"] .c-texty_input {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-TW"] .c-texty_input {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.c-texty_input.c-texty_input--double_decker {
  padding-bottom: 48px !important;
}

.c-texty_input.c-texty_input--double_decker .ql-editor {
  width: auto !important;
  padding-right: 9px !important;
}

.c-texty_input .ql-editor,
.c-texty_input .ql-placeholder {
  padding: 0;
}

[lang] .c-texty_input .ql-editor,
[lang] .c-texty_input .ql-placeholder {
  font-size: 15px;
}

[lang="ja-JP"] .c-texty_input .ql-editor,
[lang="ja-JP"] .c-texty_input .ql-placeholder {
  font-size: 14px;
}

[lang] .c-texty_input .ql-editor,
[lang] .c-texty_input .ql-placeholder {
  line-height: 1.46668;
}

[lang="ja-JP"] .c-texty_input .ql-editor,
[lang="ja-JP"] .c-texty_input .ql-placeholder {
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

.c-texty_input .ql-editor p,
.c-texty_input .ql-editor h1,
.c-texty_input .ql-editor h2,
.c-texty_input .ql-editor h3,
.c-texty_input .ql-editor h4,
.c-texty_input .ql-editor h5,
.c-texty_input .ql-editor h6 {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
}

.c-texty_input .ql-placeholder {
  text-overflow: ellipsis;
  white-space: nowrap;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  filter: grayscale();
  -ms-filter: grayscale(100%);
  opacity: 0.5;
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

.c-texty_input .ql-blank ~ .ql-placeholder {
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

.c-texty_input__placeholder_icon--public {
  margin-left: -4px;
  margin-right: -4px;
}

.c-texty_input__button {
  border-radius: 2px;
  transition: opacity 0.2s, background-color 0.2s, color 0.2s;
  position: absolute;
  top: 0;
  right: 0;
}

.c-texty_input__button .c-icon:before {
  font-size: 16px;
}

.c-texty_input__button ~ .c-texty_input__button {
  right: 33px;
}

.c-texty_input__button ~ .c-texty_input__button ~ .c-texty_input__button {
  right: 66px;
}

.c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button {
  right: 99px;
}

.c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button {
  right: 131px;
}

.c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button
  ~ .c-texty_input__button {
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

.c-texty_input_unstyled__container .ql-editor,
.c-texty_input_unstyled__container .ql-placeholder {
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

.c-texty_input_unstyled__container .ql-editor p,
.c-texty_input_unstyled__container .ql-editor h1,
.c-texty_input_unstyled__container .ql-editor h2,
.c-texty_input_unstyled__container .ql-editor h3,
.c-texty_input_unstyled__container .ql-editor h4,
.c-texty_input_unstyled__container .ql-editor h5,
.c-texty_input_unstyled__container .ql-editor h6 {
  counter-reset: list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
}

.c-texty_input_unstyled__container .ql-placeholder {
  filter: grayscale();
  -ms-filter: grayscale(100%);
  text-overflow: ellipsis;
  white-space: nowrap;
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  opacity: 0.5;
  pointer-events: none;
  font-style: normal;
  display: none;
  position: absolute;
  overflow: hidden;
}

.c-texty_input_unstyled__container .ql-placeholder ::selection {
  background: 0 0;
}

.c-texty_input_unstyled__container .ql-blank ~ .ql-placeholder {
  display: block;
}

[lang] .c-texty_input_unstyled__container--size_medium .ql-editor,
[lang] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  font-size: 15px;
}

[lang="ja-JP"] .c-texty_input_unstyled__container--size_medium .ql-editor,
[lang="ja-JP"] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  font-size: 14px;
}

[lang] .c-texty_input_unstyled__container--size_medium .ql-editor,
[lang] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  line-height: 1.46668;
}

[lang="ja-JP"] .c-texty_input_unstyled__container--size_medium .ql-editor,
[lang="ja-JP"] .c-texty_input_unstyled__container--size_medium .ql-placeholder {
  line-height: 1.6337;
}

.c-texty_input_unstyled {
  flex-grow: 1;
  min-width: 0;
  display: flex;
}

[lang] .c-texty_input_unstyled {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ja-JP"] .c-texty_input_unstyled {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] .c-texty_input_unstyled {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-CN"] .c-texty_input_unstyled {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-TW"] .c-texty_input_unstyled {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.c-texty_input_unstyled .emoji {
  vertical-align: bottom;
  background-position: 50%;
  background-repeat: no-repeat;
  background-size: contain;
  width: 22px;
  height: 22px;
}

.c-texty_input_unstyled .emoji[data-has-skin-tone] {
  cursor: pointer;
}

.p-context_bar_v2 {
  background: rgba(var(--sk_foreground_soft_solid, 243, 243, 243), 1);
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
  padding: 12px;
  display: flex;
  position: relative;
}

.p-context_bar_v2__icon {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  flex-shrink: 0;
  justify-content: center;
  align-self: flex-start;
  align-items: center;
  min-width: 16px;
  height: 16px;
  margin-top: 1px;
  margin-right: 12px;
  font-size: 16px;
  display: flex;
}

.p-composer__body {
  display: flex;
}

.p-composer__body:focus {
  outline: none;
}

.p-composer__button:not(:last-child) {
  margin-right: 1px;
}

.p-composer__button[disabled] {
  cursor: default;
}

.p-composer__button .c-icon:before {
  font-size: 16px;
}

.p-composer__separator {
  background: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  flex-shrink: 0;
  align-self: center;
  width: 1px;
  height: 20px;
  margin: 2px 4px;
}

.p-composer__selection_button {
  position: relative;
}

.p-composer__body--unstyled {
  width: 100%;
}

.p-composer__body--overflow {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #00000014;
  z-index: 1053;
  border-radius: 4px;
  padding: 4px;
  position: absolute;
  top: -45px;
}

.p-composer__button--no_pointer_events.c-icon_button {
  pointer-events: none;
}

.p-composer__button--sticky.c-icon_button {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
  background: 0 0;
  border-radius: 2px;
  flex: 0 0 32px;
}

.p-composer__button--sticky.c-icon_button[disabled],
.p-composer__button--sticky.c-icon_button[disabled]:hover {
  color: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  background-color: #0000;
}

.p-composer__button--sticky.c-icon_button[aria-pressed="true"] {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
}

.p-composer__button--sticky.c-icon_button[aria-pressed="true"]:hover,
.p-composer__button--sticky.c-icon_button[aria-pressed="true"]:focus {
  background-color: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.2);
}

.p-composer__button--sticky.c-icon_button[aria-pressed="true"]:focus:not(
    :active,
    .p-composer__button--composer_ia
  ) {
  box-shadow: inset 0 0 1px #000;
}

.p-texty_sticky_formatting_bar {
  flex-grow: 1;
  position: relative;
}

.p-hidden_file_input {
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

.c-wysiwyg_container {
  border-style: solid;
  border-width: 1px;
  border-radius: 4px;
  position: relative;
}

.c-wysiwyg_container .c-basic_container__body {
  grid-template: "context context context" "formatting formatting formatting" "input input input" minmax(
      0,
      100%
    ) "attachments attachments attachments" "broadcast_controls broadcast_controls broadcast_controls" "prefix toolbar_buttons suffix" / auto minmax(
      0,
      1fr
    ) auto;
  display: grid;
}

.c-wysiwyg_container
  .c-basic_container__body
  .c-texty_input_unstyled__container {
  z-index: 1;
  grid-area: input;
  position: relative;
}

.c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__prefix {
  grid-area: prefix;
}

.c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__suffix {
  grid-area: suffix;
}

.c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__context {
  grid-area: context;
}

.c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__formatting {
  grid-area: formatting;
}

.c-wysiwyg_container
  .c-basic_container__body
  .c-wysiwyg_container__toolbar_buttons {
  grid-area: toolbar_buttons;
}

.c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__footer {
  grid-column: 1/-1;
  grid-row-start: -1;
}

.c-wysiwyg_container
  .c-basic_container__body
  .c-texty_input_unstyled__container--multi_line {
  transition: box-shadow 80ms linear;
}

.c-wysiwyg_container
  .c-basic_container__body
  .c-texty_buttons__overflow_container {
  position: relative;
}

.c-wysiwyg_container:not(
    .c-wysiwyg_container--double_decker,
    .c-wysiwyg_container--with_footer
  )
  .c-basic_container__body
  .c-texty_input_unstyled__container {
  grid-area: 1/2/-1/2;
}

.c-wysiwyg_container:not(
    .c-wysiwyg_container--double_decker,
    .c-wysiwyg_container--with_footer
  )
  .c-basic_container__body
  .c-wysiwyg_container__context
  + .c-texty_input_unstyled__container {
  grid-area: single_decker_input;
}

.c-wysiwyg_container.p-message_input__input_container_unstyled {
  border-radius: 8px;
}

.c-wysiwyg_container.p-message_input__input_container_unstyled:focus-within {
  box-shadow: 0 1px 3px #00000014;
}

.c-wysiwyg_container.p-message_input__input_container_unstyled
  .c-wysiwyg_container__footer {
  border-bottom-right-radius: 8px;
  border-bottom-left-radius: 8px;
}

.c-wysiwyg_container__footer {
  border-top: 1px solid #0000;
  border-bottom-right-radius: 4px;
  border-bottom-left-radius: 4px;
  justify-content: space-between;
  align-items: center;
  transition: background 80ms, border-color 80ms;
  display: flex;
}

.c-wysiwyg_container:focus-within .c-wysiwyg_container__footer {
  border-color: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
}

.c-wysiwyg_container
  .c-wysiwyg_container__formatting
  + .c-texty_input_unstyled__container--multiline_overflow--top {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  box-shadow: inset 0 1px 0 var(--saf-0);
}

.c-wysiwyg_container .c-wysiwyg_container__footer {
  border-top: unset;
  cursor: text;
  background-color: #0000;
  padding: 0 4px 0 6px;
}

.c-wysiwyg_container
  .c-wysiwyg_container__footer
  .c-wysiwyg_container__prefix
  + .c-wysiwyg_container__toolbar_buttons
  .c-wysiwyg_container__button {
  margin-left: 2px;
}

.c-wysiwyg_container:focus-within .c-wysiwyg_container__footer {
  background-color: #0000;
}

.c-wysiwyg_container__formatting {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  cursor: text;
  border-top-left-radius: 8px;
  border-top-right-radius: 8px;
  width: 100%;
  display: flex;
}

.c-wysiwyg_container__prefix,
.c-wysiwyg_container__suffix,
.c-wysiwyg_container__formatting,
.c-wysiwyg_container__toolbar_buttons {
  padding: 4px;
}

.c-wysiwyg_container__suffix {
  flex-shrink: 0;
  align-items: flex-end;
  padding-right: 2px;
  display: flex;
}

.c-wysiwyg_container:focus-within .c-wysiwyg_container__suffix {
  opacity: 1;
}

.c-wysiwyg_container__prefix {
  flex-shrink: 0;
  align-items: center;
  padding-left: 0;
  padding-right: 0;
  display: flex;
}

.c-wysiwyg_container__toolbar_buttons {
  flex: 1;
  padding-left: 0;
  padding-right: 0;
}

.c-wysiwyg_container__button {
  transition: background 80ms, border-color 80ms, color 80ms;
}

.c-wysiwyg_container .c-wysiwyg_container__button,
.c-wysiwyg_container .p-composer__button--sticky.c-icon_button {
  border-radius: 4px;
  width: 28px;
  height: 28px;
  margin: 2px;
  padding: 2px;
}

.c-wysiwyg_container .c-wysiwyg_container__button.p-composer__menu-trigger,
.c-wysiwyg_container
  .p-composer__button--sticky.c-icon_button.p-composer__menu-trigger {
  width: auto;
  padding: 0;
}

.c-wysiwyg_container
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send,
.c-wysiwyg_container
  .p-composer__button--sticky.c-icon_button.c-wysiwyg_container__button--send,
.c-wysiwyg_container
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send_options,
.c-wysiwyg_container
  .p-composer__button--sticky.c-icon_button.c-wysiwyg_container__button--send_options {
  margin: 0;
}

.c-wysiwyg_container .p-composer__button--sticky.c-icon_button {
  opacity: 0.3;
  flex: 0 0 28px;
  margin-bottom: 0;
}

.c-wysiwyg_container .c-wysiwyg_container__formatting .c-icon_button {
  opacity: 0.3;
}

.c-wysiwyg_container .c-wysiwyg_container__formatting .c-icon_button:hover,
.c-wysiwyg_container:focus-within
  .c-wysiwyg_container__formatting
  .c-icon_button:not(.c-button--disabled) {
  opacity: 1;
}

.c-wysiwyg_container__button--emoji {
  z-index: 1;
  position: relative;
}

.c-wysiwyg_container__button--emoji:after {
  content: "";
  background: rgba(var(--sk_secondary_highlight, 242, 199, 68), 1);
  z-index: -1;
  opacity: 0;
  border-radius: 9999px;
  width: 1em;
  height: 1em;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.c-wysiwyg_container__button--emoji.skin-tone-2:after {
  background: #ffdbbe;
}

.c-wysiwyg_container__button--emoji.skin-tone-3:after {
  background: #e6b892;
}

.c-wysiwyg_container__button--emoji.skin-tone-4:after {
  background: #d4a37c;
}

.c-wysiwyg_container__button--emoji.skin-tone-5:after {
  background: #c18e65;
}

.c-wysiwyg_container__button--emoji.skin-tone-6:after {
  background: #b47f55;
}

.c-wysiwyg_container__button--emoji .is-second {
  display: none;
}

.c-wysiwyg_container__button--emoji:hover:after,
.c-wysiwyg_container__button--emoji:focus:after {
  opacity: 1;
}

.c-wysiwyg_container__button--emoji:hover .is-first,
.c-wysiwyg_container__button--emoji:focus .is-first {
  display: none;
}

.c-wysiwyg_container__button--emoji:hover .is-second,
.c-wysiwyg_container__button--emoji:focus .is-second {
  display: block;
  transform: scale(1.05) rotate(15deg);
}

.c-wysiwyg_container__button.c-wysiwyg_container__button--send,
.c-wysiwyg_container__button.c-wysiwyg_container__button--send_options {
  color: #fff;
  background: #007a5a;
}

.c-wysiwyg_container__button.c-wysiwyg_container__button--send:hover,
.c-wysiwyg_container__button.c-wysiwyg_container__button--send_options:hover {
  color: #fff;
  background: #148567;
}

.c-wysiwyg_container__button.c-wysiwyg_container__button--send.c-wysiwyg_container__button--disabled,
.c-wysiwyg_container__button.c-wysiwyg_container__button--send_options.c-wysiwyg_container__button--disabled {
  background: unset;
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
  pointer-events: none;
  opacity: 0.3;
}

.c-wysiwyg_container__send_button--with_options {
  border-radius: 4px;
  margin-left: 0;
  display: inline-flex;
}

.c-wysiwyg_container__send_button--with_options:hover {
  box-shadow: 0 1px 3px #00000014;
}

.c-wysiwyg_container__send_button--with_options.c-wysiwyg_container__send_button--with_options_disabled:hover {
  box-shadow: none;
}

.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button--send {
  margin-right: 0;
  padding-right: 0;
}

.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send.c-wysiwyg_container__button--disabled,
.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send_options.c-wysiwyg_container__button--disabled {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  background-color: #0000;
}

.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send {
  border-radius: 4px 0 0 4px;
  width: auto;
  padding-left: 8px;
  padding-right: 8px;
  position: relative;
}

.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send:after {
  content: "";
  background: #fff6;
  width: 1px;
  height: calc(100% - 8px);
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
}

.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send.c-wysiwyg_container__button--disabled:after {
  background: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.3);
}

.c-wysiwyg_container__send_button--with_options
  .c-wysiwyg_container__button.c-wysiwyg_container__button--send_options {
  border-radius: 0 4px 4px 0;
  width: auto;
  padding-left: 4px;
  padding-right: 4px;
}

.c-texty_buttons {
  align-items: center;
  display: flex;
  position: relative;
}

.c-texty_buttons--overflow {
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  z-index: 1001;
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
  border-radius: 4px;
  padding: 4px;
  display: flex;
  position: absolute;
  top: -40px;
  right: -36px;
}

.c-wysiwyg_container__button--composer:after {
  content: "";
  opacity: 0;
  background: currentColor;
  border-radius: 9999px;
  width: 75%;
  height: 1.5px;
  transition: opacity 80ms, transform 80ms;
  position: absolute;
  bottom: 4px;
  left: 50%;
  transform: translate(-50%, 2px);
}

.c-wysiwyg_container__button--composer_active:after {
  opacity: 1;
  transform: translate(-50%);
}

.c-wysiwyg_container__button--active {
  background-color: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
}

.c-wysiwyg_container--theme_light {
  transition: border-color 0.16s, box-shadow 0.16s;
}

.c-wysiwyg_container--theme_light:focus-within
  .c-wysiwyg_container__footer--with_formatting {
  background-color: #0000;
}

.c-wysiwyg_container--theme_light_bordered {
  border-color: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
}

.c-wysiwyg_container--theme_light_bordered:focus-within {
  border-color: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.3);
}

.c-wysiwyg_container--disabled .c-wysiwyg_container__footer {
  opacity: 0.3;
}

.c-wysiwyg_container--disabled .c-wysiwyg_container__button--active {
  background-color: unset;
}

.c-message_kit__actions .c-message__actions.c-message_actions__container {
  display: inline-flex;
}

.c-message_actions__group {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border: unset;
  box-shadow: unset;
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
  border-radius: 0.375em;
  margin-left: 8px;
  padding: 2px;
  line-height: 1;
  display: flex;
}

.c-message_actions__button {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  border-radius: 4px;
  height: 32px;
  font-size: 18px;
}

.c-message_actions__button:active,
.c-message_actions__button:focus {
  z-index: 1;
  position: relative;
}

.c-message_actions__button:hover {
  background: rgba(var(--sk_foreground_min, 29, 28, 29), 0.04);
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
}

.c-message_actions__button:disabled {
  color: rgba(var(--sk_foreground_mid, 29, 28, 29), 0.3);
}

.c-message_actions__button:disabled:hover {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  cursor: initial;
  background: 0 0;
}

.c-message_actions__emoji_button {
  -webkit-user-select: none;
  user-select: none;
  padding: 3px 7px;
}

.c-message {
  -webkit-user-select: text;
  user-select: text;
  min-width: 1px;
  padding-right: 26px;
  position: relative;
}

[lang] .c-message {
  font-size: 15px;
}

[lang="ja-JP"] .c-message {
  font-size: 14px;
}

[lang] .c-message {
  line-height: 16px;
}

[lang="ja-JP"] .c-message {
  line-height: 17.6px;
}

.c-message__body {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  word-wrap: break-word;
  width: 100%;
  display: inline-block;
}

[lang] .c-message__body {
  line-height: 1.46668;
}

[lang="ja-JP"] .c-message__body {
  line-height: 1.56668;
}

.c-message__actions {
  z-index: 1;
  display: none;
  position: absolute;
  top: -16px;
  right: 17px;
}

.c-message:hover .c-message__actions {
  display: block;
}

.c-message--light {
  padding: 6px 0;
}

.c-message__label {
  -webkit-user-select: none;
  user-select: none;
  padding: 1px 0;
  font-size: 13px;
}

.c-message__label:before,
.c-message__label:after {
  content: "";
  line-height: 0;
  display: table;
}

.c-message__label:after {
  clear: both;
}

a.c-message__label_link {
  color: inherit;
  background: 0 0;
  padding-left: 0;
}

a.c-message__label_link:hover {
  color: inherit;
  background: 0 0;
  text-decoration: underline;
}

.c-message__label_button {
  color: inherit;
  font: inherit;
  vertical-align: baseline;
  background: 0 0;
  border: 0;
  padding: 0;
  line-height: normal;
  overflow: visible;
}

.c-message__label_button:hover,
.c-message__label_button:focus,
.c-message__label_button:active {
  outline: none;
}

.c-message__label_button:hover {
  text-decoration: underline;
}

.c-message__editor__emoji_menu {
  color: inherit;
  font: inherit;
  background: 0 0;
  border: 0;
  width: 40px;
  height: 40px;
  padding: 0;
  line-height: normal;
  transition: all 50ms ease-out;
  position: absolute;
  top: 0;
  right: 0;
  overflow: visible;
}

[lang] .c-message__editor__emoji_menu {
  line-height: 1;
}

[lang="ja-JP"] .c-message__editor__emoji_menu {
  line-height: 1.1;
}

.c-message__editor__emoji_menu:hover,
.c-message__editor__emoji_menu:focus,
.c-message__editor__emoji_menu:active {
  outline: none;
}

.c-message__editor__emoji_menu:hover {
  transform: scale(1.25);
}

.c-message__editor__input_container {
  position: relative;
}

.c-message__editor__footer__meta {
  margin-top: 4px;
  font-size: 12px;
}

.c-message__editor__footer {
  flex-wrap: wrap;
  align-items: center;
  display: flex;
}

.c-message__editor__footer > * {
  margin-top: 8px;
}

.c-message__theme_button_container {
  margin-top: 8px;
}

.c-message__file {
  display: inline;
}

.c-message__file_link {
  white-space: normal;
  word-break: break-word;
  font-weight: 700;
}

.c-message__file_meta {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  line-height: 1.4;
  display: block;
}

.c-message__file_meta_title {
  white-space: nowrap;
}

.c-message__file .p-message_file {
  margin-top: 8px;
}

.c-message__body {
  text-align: left;
  margin: 8px 0 -4px;
}

.c-message__body:empty {
  display: none;
}

.c-message__file .c-file_container {
  margin: 8px 0 0;
}

.c-message__editor {
  margin: 8px 0 0;
}

.c-message__file_meta {
  margin: 8px 0 -5px;
}

input[type="checkbox"]:disabled {
  cursor: auto;
}

.p-file_link_button--link {
  width: 100%;
  display: block;
}

.p-file_link_button--link,
.p-file_link_button--link.c-link--button,
.p-file_link_button--link:hover,
.p-file_link_button--link:focus {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
  text-decoration: none;
}

.c-file_container {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border: 1px solid #0000001a;
  border-radius: 4px;
  min-width: 230px;
  max-width: 600px;
  padding: 15px;
  position: relative;
}

.c-file_container .c-file__actions {
  position: absolute;
  top: 19px;
  right: 15px;
}

.c-file_container:hover {
  border-color: #00000026;
  box-shadow: 0 1px 1px #0000000f;
}

.c-file_container:hover .c-file__actions,
.c-file_container:focus-within .c-file__actions {
  opacity: 1;
}

.c-file__actions {
  opacity: 0;
  transition: opacity 0.1s;
}

.c-file__actions--overflow {
  white-space: nowrap;
  background: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 0.9);
  border: 1px solid #0000001a;
  border-radius: 6px;
  padding: 6px 6px 6px 0;
  left: 10px;
  right: auto;
}

.c-file__svg_icon svg {
  position: relative;
  bottom: 2px;
}

.c-message_kit__file {
  margin-bottom: 8px;
  margin-left: -20px;
  padding-left: 20px;
  position: relative;
}

.c-message_kit__file__meta {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
  align-items: center;
  margin-bottom: 4px;
  display: flex;
}

.c-message_kit__file__meta__text {
  font-size: 13px;
}

.c-message_kit__file__meta__separator {
  color: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.33);
}

.c-message_kit__text:after {
  content: "";
  height: 4px;
  display: block;
}

.c-message_kit__hidden__message__link {
  margin-bottom: 8px;
}

.c-message_kit__inline_channel_context {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
}

.c-message_kit__footer {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  font-size: 13px;
  line-height: 1.38463;
  font-weight: initial;
  align-items: center;
  display: flex;
}

.c-message_kit__footer_channel {
  text-overflow: ellipsis;
  white-space: nowrap;
  display: block;
  overflow: hidden;
}

.p-multi_file_upload__container {
  min-width: 100%;
}

.p-multi_file_upload__file_container {
  line-height: 0;
  position: relative;
}

.p-multi_file_upload__file_container:not(:last-child) {
  margin-right: 12px;
}

.p-multi_file_upload__container--small
  .p-multi_file_upload__file_container:not(:last-child) {
  margin-right: 8px;
}

.c-message_kit__actions .c-message__actions {
  display: block;
}

.c-message_kit__message {
  -webkit-user-select: text;
  user-select: text;
  word-wrap: break-word;
}

[lang] .c-message_kit__message {
  font-size: 15px;
}

[lang="ja-JP"] .c-message_kit__message {
  font-size: 14px;
}

[lang] .c-message_kit__message {
  line-height: 1.46668;
}

[lang="ja-JP"] .c-message_kit__message {
  line-height: 1.56668;
}

.p-notification_bar {
  align-items: center;
  height: 24px;
  padding-left: 12px;
  padding-right: 8px;
  display: flex;
}

.p-notification_bar--double_decker {
  padding-left: 12px;
}

.p-notification_bar__section {
  color: rgba(var(--sk_foreground_max_solid, 97, 96, 97), 1);
  white-space: nowrap;
  height: 1rem;
  font-size: 0.7em;
  line-height: 1rem;
}

.p-notification_bar__section--left {
  text-overflow: ellipsis;
  white-space: nowrap;
  flex: auto;
  display: block;
  overflow: hidden;
}

.p-notification_bar__section--right {
  text-align: right;
  opacity: 0;
  pointer-events: none;
  flex: none;
  margin-left: 4px;
  transition: opacity 0.2s ease-in-out;
}

.p-notification_bar__section--is-visible {
  pointer-events: auto;
  opacity: 1;
}

.p-notification_bar__formatting b,
.p-notification_bar__formatting i,
.p-notification_bar__formatting span {
  margin-right: 4px;
}

.p-notification_bar__formatting .p-notification_bar__return {
  margin-right: 0;
}

.p-notification_bar__formatting .p-notification_bar__send {
  margin-right: 16px;
}

.p-message_pane_input__disabled {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
  text-align: center;
  justify-content: center;
  align-items: center;
  min-height: 66px;
  max-height: 70px;
  padding: 0 30px;
  font-size: 1rem;
  display: flex;
  overflow-y: auto;
}

[lang] .p-message_pane_input__disabled {
  font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ja-JP"] .p-message_pane_input__disabled {
  font-family: NotoSansJP, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="ko-KR"] .p-message_pane_input__disabled {
  font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-CN"] .p-message_pane_input__disabled {
  font-family: NotoSansSC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

[lang="zh-TW"] .p-message_pane_input__disabled {
  font-family: NotoSansTC, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
}

.p-message_pane_input__disabled_button {
  flex: none;
  margin-left: 20px;
}

.p-message_pane_input__disabled_text {
  max-height: inherit;
  padding-top: 12px;
  padding-bottom: 12px;
}

.p-message_pane_input__button-wrapper {
  flex-wrap: wrap;
  justify-content: center;
  margin-top: -12px;
  margin-left: -12px;
  display: flex;
}

.p-message_pane_input__button-wrapper > * {
  margin-top: 12px;
  margin-left: 12px;
}

.p-message_pane_input {
  flex: 1;
  padding: 0 20px;
  display: flex;
}

.p-message_pane_input_inner {
  flex: 1;
}

.p-message_pane_input_inner_top {
  position: relative;
}

.c-actions_menu__actions {
  opacity: 0;
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border: unset;
  box-shadow: unset;
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 1px 3px 0 #00000014;
  border-radius: 0.375em;
  margin-left: 8px;
  margin-right: 4px;
  padding: 2px;
  line-height: 1;
  transition: opacity 0.1s;
  display: flex;
  position: absolute;
  top: 50%;
  right: 0;
  transform: translateY(-50%);
}

.c-actions_menu__actions:hover,
.c-actions_menu__actions:focus {
  opacity: 1;
}

.c-message_group {
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  border: 1px solid var(--saf-0);
  background-color: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  border-radius: 8px;
  padding: 7px 12px 12px;
}

.c-message_group-first {
  border-bottom: 0;
  border-radius: 8px 8px 0 0;
}

.c-message_group--ia4 {
  border-color: var(--dt_color-otl-ter);
  background-color: var(--dt_color-theme-surf-pry);
  cursor: pointer;
  border-radius: 12px;
  padding: 12px 16px 16px;
}

.c-message_group--ia4:hover {
  background-blend-mode: var(--dt_blend-mode-interaction);
  background-image: linear-gradient(
    var(--dt_color-theme-surf-pry-hover),
    var(--dt_color-theme-surf-pry-hover)
  );
}

.c-message_group:hover {
  border-color: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.15);
  box-shadow: 0 1px 1px #0000000f;
}

:root {
  --dsg-selection-border-radius: 4px;
  --dsg-selection-border-width: 1px;
  --dsg-selection-background-color: #4580e60a;
  --dsg-selection-disabled-border-color: #9da6ab;
  --dsg-selection-disabled-background-color: #0000000a;
  --dsg-corner-indicator-width: 10px;
}

.c-channel-section {
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  --saf-0: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  border: solid 1px var(--saf-0);
  border-radius: 8px;
  margin-bottom: 24px;
}

.p-shortcuts_menu_v2 {
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  box-sizing: content-box;
  --saf-0: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  box-shadow: 0 0 0 1px var(--saf-0), 0 4px 12px 0 #0000001f;
  border-radius: 6px;
  flex-direction: column;
  align-items: center;
  max-width: calc(100vw - 30px);
  max-height: calc(100vh - 30px);
  margin: 0;
  display: flex;
  overflow: hidden;
}

.p-shortcuts_menu_trigger_button_container {
  z-index: 200;
  border-right: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  align-self: flex-end;
  height: 24px;
  margin: 8px 0 8px 4px;
  transition: border-color 80ms linear;
  display: flex;
}

.p-shortcuts_menu_trigger_button_container--disabled {
  pointer-events: none;
}

.p-shortcuts_menu_trigger_button_container:hover {
  border-color: #0000;
}

.p-shortcuts_menu_trigger_button {
  z-index: 200;
  border-radius: 2px;
  width: 32px;
  height: 32px;
  margin: -4px 0;
  transition: background 80ms linear, color 80ms linear;
}

.p-shortcuts_menu_trigger_button .c-icon:before {
  font-size: 16px;
}

.p-shortcuts_menu_trigger_button--composer_ia .c-icon:before {
  font-size: 18px;
}

.p-shortcuts_menu_trigger_button_container--composer_ia_icon_button {
  position: relative;
}

.p-shortcuts_menu_trigger_button--composer_ia.c-icon_button,
.p-shortcuts_menu_trigger_button--composer_ia.c-wysiwyg_container__button {
  background: rgba(var(--sk_foreground_soft, 29, 28, 29), 0.06);
  transform-origin: 50%;
  width: 24px;
  height: 24px;
  transition: background 80ms, transform 0.32s cubic-bezier(0.34, 1.56, 0.64, 1);
  position: relative;
  transform: rotate(-270deg);
  border-radius: 50% !important;
}

.p-shortcuts_menu_trigger_button--composer_ia.c-icon_button:before,
.p-shortcuts_menu_trigger_button--composer_ia.c-wysiwyg_container__button:before {
  content: "";
  position: absolute;
  top: -2px;
  bottom: -2px;
  left: -2px;
  right: -2px;
}

.p-shortcuts_menu_trigger_button--composer_ia.c-icon_button:hover,
.p-shortcuts_menu_trigger_button--composer_ia.c-wysiwyg_container__button:hover {
  background: rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
}

.p-shortcuts_menu_trigger_button--composer_ia.c-icon_button:active,
.p-shortcuts_menu_trigger_button--composer_ia.c-wysiwyg_container__button:active {
  background: rgba(var(--sk_foreground_mid, 29, 28, 29), 0.3);
}

.p-list_footer {
  color: rgba(var(--sk_foreground_max, 29, 28, 29), 0.7);
  background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
  background-color: rgba(var(--sk_foreground_min_solid, 248, 248, 248), 1);
  align-items: center;
  height: 48px;
  display: flex;
}

.p-list_view {
  border-top: 1px solid rgba(var(--sk_foreground_low, 29, 28, 29), 0.13);
  background: rgba(var(--sk_foreground_min, 29, 28, 29), 0.04);
  width: 100%;
  height: 100%;
  position: relative;
}

.p-list_view .p-list_footer {
  width: 100%;
  position: absolute;
  bottom: 0;
}

.p-workspace {
  grid-template-rows: min-content 60px auto;
  display: grid;
}

.p-workspace__primary_view {
  grid-template: "p-workspace__primary_view_header" 36px "p-workspace__primary_view_contents" / auto;
  grid-area: p-workspace__primary_view;
  max-height: calc(100vh - 44px);
  display: grid;
}

.p-workspace__primary_view_body {
  --saf-0: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  box-shadow: 1px 0 var(--saf-0) inset;
  flex: 1;
  min-height: 0;
  position: relative;
}

.p-workspace__primary_view_body--hidden {
  display: none;
}

.p-workspace__primary_view_footer {
  --saf-0: rgba(var(--sk_foreground_low_solid, 221, 221, 221), 1);
  box-shadow: 1px 0 var(--saf-0) inset;
  flex-direction: column;
  justify-content: flex-end;
  display: flex;
}

.p-workspace__primary_view_footer--float {
  z-index: 200;
  background: linear-gradient(
    to bottom,
    rgba(var(--sk_primary_background, 255, 255, 255), 0),
    rgba(var(--sk_primary_background, 255, 255, 255), 1) 8px
  );
  margin-top: -8px;
  position: relative;
}

.p-workspace__input.p-message_input {
  display: flex;
  position: relative;
}

.p-workspace__input.p-message_input.p-message_input--disabled
  .c-texty_input__button,
.p-workspace__input.p-message_input.p-message_input--disabled
  .p-shortcuts_menu_trigger_button {
  opacity: 0.6;
  pointer-events: none;
}

.p-workspace__input .ql-editor {
  max-height: calc(60vh - 80px);
}

.p-workspace,
.p-workspace__primary_view {
  min-width: 0;
  min-height: 0;
  position: relative;
}

.p-workspace__primary_view_footer_inner {
  transition: height 0.16s cubic-bezier(0.36, 0.19, 0.29, 1);
}
</style>
