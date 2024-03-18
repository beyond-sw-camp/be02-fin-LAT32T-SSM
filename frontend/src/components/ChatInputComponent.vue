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


    html {
        height: 100%;
    }

    .c-basic_container {
        background: rgba(var(--sk_primary_background, 255, 255, 255), 1);
    }

    [lang] .c-basic_container {
        font-family: Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
    }


    [lang="ko-KR"] .c-basic_container {
        font-family: NotoSansKR, Slack-Lato, Slack-Fractions, appleLogo, sans-serif;
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

    .ql-container {
        box-sizing: border-box;
        height: auto;
        margin: 0;
        font-family: Helvetica, Arial, sans-serif;
        font-size: 13px;
        position: relative;
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


    .ql-editor.ql-blank:before {
        color: #0009;
        content: attr(data-placeholder);
        pointer-events: none;
        font-style: italic;
        position: absolute;
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
        grid-template: "context context context" "formatting formatting formatting" "input input input" minmax(0,
        100%
            ) "attachments attachments attachments" "broadcast_controls broadcast_controls broadcast_controls" "prefix toolbar_buttons suffix" / auto minmax(0,
                1fr
            ) auto;
        display: grid;
    }

    .c-wysiwyg_container .c-basic_container__body .c-texty_input_unstyled__container {
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

    .c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__formatting {
        grid-area: formatting;
    }

    .c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__toolbar_buttons {
        grid-area: toolbar_buttons;
    }

    .c-wysiwyg_container .c-basic_container__body .c-wysiwyg_container__footer {
        grid-column: 1/-1;
        grid-row-start: -1;
    }

    .c-wysiwyg_container .c-basic_container__body .c-texty_input_unstyled__container--multi_line {
        transition: box-shadow 80ms linear;
    }

    .c-wysiwyg_container .c-basic_container__body .c-texty_buttons__overflow_container {
        position: relative;
    }

    .c-wysiwyg_container.p-message_input__input_container_unstyled {
        border-radius: 8px;
    }

    .c-wysiwyg_container.p-message_input__input_container_unstyled:focus-within {
        box-shadow: 0 1px 3px #00000014;
    }

    .c-wysiwyg_container.p-message_input__input_container_unstyled .c-wysiwyg_container__footer {
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


    .c-wysiwyg_container .c-wysiwyg_container__footer {
        border-top: unset;
        cursor: text;
        background-color: #0000;
        padding: 0 4px 0 6px;
    }

    .c-wysiwyg_container .c-wysiwyg_container__footer .c-wysiwyg_container__prefix + .c-wysiwyg_container__toolbar_buttons .c-wysiwyg_container__button {
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

    .c-wysiwyg_container .c-wysiwyg_container__button.c-wysiwyg_container__button--send,
    .c-wysiwyg_container .p-composer__button--sticky.c-icon_button.c-wysiwyg_container__button--send,
    .c-wysiwyg_container .c-wysiwyg_container__button.c-wysiwyg_container__button--send_options,
    .c-wysiwyg_container .p-composer__button--sticky.c-icon_button.c-wysiwyg_container__button--send_options {
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
    .c-wysiwyg_container:focus-within .c-wysiwyg_container__formatting .c-icon_button:not(.c-button--disabled) {
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

    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button--send {
        margin-right: 0;
        padding-right: 0;
    }

    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button.c-wysiwyg_container__button--send.c-wysiwyg_container__button--disabled,
    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button.c-wysiwyg_container__button--send_options.c-wysiwyg_container__button--disabled {
        color: rgba(var(--sk_primary_foreground, 29, 28, 29), 1);
        background-color: #0000;
    }

    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button.c-wysiwyg_container__button--send {
        border-radius: 4px 0 0 4px;
        width: auto;
        padding-left: 8px;
        padding-right: 8px;
        position: relative;
    }

    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button.c-wysiwyg_container__button--send:after {
        content: "";
        background: #fff6;
        width: 1px;
        height: calc(100% - 8px);
        position: absolute;
        top: 50%;
        right: 0;
        transform: translateY(-50%);
    }

    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button.c-wysiwyg_container__button--send.c-wysiwyg_container__button--disabled:after {
        background: rgba(var(--sk_primary_foreground, 29, 28, 29), 0.3);
    }

    .c-wysiwyg_container__send_button--with_options .c-wysiwyg_container__button.c-wysiwyg_container__button--send_options {
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


    .c-wysiwyg_container--theme_light {
        transition: border-color 0.16s, box-shadow 0.16s;
    }

    .c-wysiwyg_container--theme_light:focus-within .c-wysiwyg_container__footer--with_formatting {
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


    .c-message__editor__footer > * {
        margin-top: 8px;
    }


    input[type="checkbox"]:disabled {
        cursor: auto;
    }


    .c-file__svg_icon svg {
        position: relative;
        bottom: 2px;
    }

    .p-notification_bar__formatting b,
    .p-notification_bar__formatting i,
    .p-notification_bar__formatting span {
        margin-right: 4px;
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


    :root {
        --dsg-selection-border-radius: 4px;
        --dsg-selection-border-width: 1px;
        --dsg-selection-background-color: #4580e60a;
        --dsg-selection-disabled-border-color: #9da6ab;
        --dsg-selection-disabled-background-color: #0000000a;
        --dsg-corner-indicator-width: 10px;
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


    .p-workspace__primary_view_footer--float {
        z-index: 200;
        background: linear-gradient(to bottom,
        rgba(var(--sk_primary_background, 255, 255, 255), 0),
        rgba(var(--sk_primary_background, 255, 255, 255), 1) 8px);
        margin-top: -8px;
        position: relative;
    }


    .p-workspace__input .ql-editor {
        max-height: calc(60vh - 80px);
    }
</style>
