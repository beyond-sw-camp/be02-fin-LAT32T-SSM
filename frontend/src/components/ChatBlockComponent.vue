<template>
  <section class="feeds">
    <article class="feed">
      <section class="feeds-user-avatar">
        <button class="c-button-unstyled c-message_kit__avatar c-avatar c-avatar--interactive" aria-hidden="true" aria-label="프로필 보기" tabindex="-1" type="button" style="height: 36px; width: 36px">
            <span class="c-base_icon__width_only_container" style="height: 36px; width: 36px">
              <img src="" class="c-base_icon c-base_icon--image" aria-hidden="true" role="img" alt="" style="width: 36px"/>
            </span>
        </button>
      </section>
      <section class="feed-content">
        <div class="divtest">
          <div role="presentation" class="c-message_kit__gutter__right" data-qa="message_content">
            <button data-message-sender="U06569E3D7H" data-qa="message_sender_name" class="c-link--button c-message__sender_button" type="button" tabindex="0">
              {{ item.userName }}
            </button>
            <span class="c-message__sender c-message_kit__sender" data-qa="message_sender" data-stringify-type="replace" data-stringify-text="test">
              <span class="p-member_profile_hover_card" role="presentation">
                <a aria-label="오늘, 오후 12:43:59" data-stringify-type="replace" data-stringify-text="[오후 12:43]" data-stringify-requires-siblings="true" data-ts="1709869439.969209" delay="300" data-sk="tooltip_parent" class="c-link c-timestamp">
                  <span class="c-timestamp__label" data-qa="timestamp_label">{{ item.createdAt }}</span>
                </a>
              </span>
            </span>
            &nbsp;&nbsp;
          </div>
          <br />
          <div class="c-message_kit__blocks c-message_kit__blocks--rich_text">
            <div class="c-message__message_blocks c-message__message_blocks--rich_text" data-qa="message-text">
              <div class="p-block_kit_renderer" data-qa="block-kit-renderer">
                <div class="p-block_kit_renderer__block_wrapper p-block_kit_renderer__block_wrapper--first">
                  <div class="p-rich_text_block" dir="auto">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section>
        <div class="p-rich_text_section">
          {{ item.message }}
        </div>
      </section>
    </article>
  </section>
</template>

<script>
export default {
  name: 'ChatBlockComponent',
  props: [
      "item"
  ]
}
</script>

<style>
*,:before,:after {
  box-sizing: inherit;
}

div {
  display: block;
}

.p-member_profile_hover_card {
  width: -moz-fit-content;
  width: fit-content;
  height: -moz-fit-content;
  height: fit-content;
  display: inline-flex;
}

.c-message_kit__avatar {
  flex-shrink: 0;
}

.c-avatar--interactive {
  cursor: pointer;
}

.c-avatar {
  --sk_avatar-border-radius: 3px;
  cursor: default;
  outline: none;
  display: inline-block;
  position: relative;
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

button {
  font-family: inherit;
}

button {
  cursor: pointer;
  background-color: #0000;
  border-width: 0;
  padding: 0;
}

.c-base_icon__width_only_container {
  --sk_base_icon-border-radius: 4px;
  background-color: rgba(var(--sk_foreground_low,29,28,29),.13);
  border-radius: var(--sk_base_icon-border-radius);
  color: rgba(var(--sk_primary_foreground,29,28,29),1);
  flex-shrink: 0;
  display: block;
  position: relative;
  overflow: hidden;
}

.c-base_icon--image {
  background-repeat: no-repeat;
  background-size: 100%;
  display: inline-block;
}

.c-base_icon {
  --sk_base_icon-border-radius: 4px;
  background-color: rgba(var(--sk_foreground_low,29,28,29),.13);
  border-radius: var(--sk_base_icon-border-radius);
  color: rgba(var(--sk_primary_foreground,29,28,29),1);
  flex-shrink: 0;
  position: relative;
}

.c-message_kit__gutter__right {
  flex: 1 1 0;
  min-width: 0;
  margin: -12px -8px -16px -16px;
  padding: 8px 8px 8px 16px;
  display:flex;
  flex-direction:row;
  align-items: flex-start;
}
.divtest{
  display:flex;
}

.c-message_kit__sender {
  font-weight: 900;
}

.c-message__sender {
  color: rgba(var(--sk_primary_foreground,29,28,29),1);
  word-break: break-word;
  font-weight: 900;
}

.p-member_profile_hover_card {
  width: -moz-fit-content;
  width: fit-content;
  height: -moz-fit-content;
  height: fit-content;
  display: inline-flex;
}

.c-message__sender .c-message__sender_button {
  color: rgba(var(--sk_primary_foreground,29,28,29),1);
}

.c-message__sender_button {
  display: inline-block;
}

.c-link--button {
  color: rgba(var(--sk_highlight,18,100,163),1);
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

.c-timestamp,.c-timestamp:link,.c-timestamp:hover {
  color: rgba(var(--sk_foreground_max_solid,97,96,97),1);
}

.c-timestamp {
  font-size: 12px;
}

a {
  color: rgba(var(--sk_highlight,18,100,163),1);
  text-decoration: none;
}

a:-webkit-any-link {
  color: -webkit-link;
  cursor: pointer;
  text-decoration: underline;
}

.c-timestamp__label {
  color: rgba(var(--sk_foreground_max_solid,97,96,97),1);
  margin-left:10px;
}

.c-message_kit__blocks--rich_text {
  max-width: none;
  margin-bottom: 4px;
}

.c-message_kit__blocks {
  max-width: 600px;
}

.c-message__message_blocks--rich_text {
  word-wrap: break-word;
  max-width: none;
}

.c-message__message_blocks {
  max-width: 600px;
}

.p-block_kit_renderer {
  width: 100%;
}

.p-block_kit_renderer__block_wrapper {
  display: flex;
}

[lang] .p-rich_text_block {
  line-height: 1.46668;
}

[lang] .p-rich_text_block {
  font-size: 15px;
}

.p-rich_text_block {
  -webkit-user-select: text;
  user-select: text;
  text-align: left;
  width: 100%;
  overflow-y: hidden;
}

.p-rich_text_block,.p-rich_text_section {
  counter-reset: list-0 list-1 list-2 list-3 list-4 list-5 list-6 list-7 list-8 list-9;
}

.c-virtual_list__item {
  width: 100%;
  position: absolute;
}

.c-message_kit__message {
  -webkit-user-select: text;
  user-select: text;
  word-wrap: break-word;
}

.c-message_kit__background {
  background: rgba(var(--sk_primary_background,255,255,255),1);
}

.feeds {
  grid-area: main;
  overflow: auto;
  padding: 0.9375rem 0.3125rem 0.625rem 0.3125rem;
}

.feed {
  display: flex;
  padding: 0.5rem;
  margin-left: 1rem;
  margin-right: 2rem;
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

</style>