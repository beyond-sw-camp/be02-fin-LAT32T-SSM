<template>
  <div style="display: contents">
    <div class="p-view_contents p-view_contents--secondary p-view_contents--channel-list-pry" role="group">
      <div style="display: contents">
        <div id="channel-canvas-main-C06DP0W22ES" aria-label="제목 없음, 채널 캔버스" data-qa="quip_flexpane" class="p-flexpane p-flexpane--iap1 p-flexpane--ia_details_popover p-quip_flexpane p-quip_flexpane--quip_canvas_sideview">
          <div role="presentation" style="display: contents">
            <div class="p-flexpane__body p-flexpane__body--dark">
              <div class="p-quip_flexpane--quip_canvas_sideview__body">
                <div role="none" class="active-managed-focus-container" style="display: contents">
                  <div class="p-autoclog__hook">
                    <div class="p-canvas_template_options p-canvas_template_options--absolute template_size" role="group" aria-label="calendar"></div>
                    <div class="p-canvas_template_options p-canvas_template_options--absolute template_size" role="group" aria-label="eventlist"></div>
                    <div class="p-canvas_template_options p-canvas_template_options--absolute template_size" role="group" aria-label="mettingroom"></div>
                  </div>
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

export default {
  name: 'SideTabComponent',
}
</script>

<style>
.p-quip_flexpane--quip_canvas_sideview {
  /*background-color: rgba(var(--sk_primary_background,255,255,255),1);*/
  background-color: rgb(255, 255, 255);
  width: 100%;
  height: 100%;
  position: relative;
}

.p-flexpane {
  flex-direction: column;
  flex-grow: 1;
  height: 100%;
  display: flex;
}

.p-flexpane--ia_details_popover .p-flexpane_header {
  /*--saf-0: rgba(var(--sk_foreground_low,29,28,29),.13);*/
  --saf-0: rgba(29, 28, 29);
  box-shadow: 0 1px 0 0 var(--saf-0);
  z-index: 1;
  border-bottom: none;
}

.p-flexpane--ia_details_popover .p-flexpane_header__primary {
  height: 49px;
}

.p-flexpane--iap1 .p-flexpane_header__primary {
  flex: 1;
  align-items: center;
  min-width: 0;
  height: 63px;
  font-size: 15px;
  line-height: 1.46668;
  display: flex;
}

.c-icon_button--default,.c-icon_button--default:link,.c-icon_button--default.c-button-unstyled {
  /*color: rgba(var(--sk_foreground_max,29,28,29),.7);*/
  color: rgba(29, 28, 29);
}

.p-flexpane_header__control--back {
  margin-left: 0;
  margin-right: 8px;
}

.p-flexpane_header__control {
  /*color: rgba(var(--sk_foreground_max_solid,97,96,97),1);*/
  color: rgba(97, 96, 97);
  cursor: pointer;
}

.c-icon_button--default,.c-icon_button--default:link,.c-icon_button--default.c-button-unstyled {
  /*color: rgba(var(--sk_foreground_max,29,28,29),.7);*/
  color: rgba(29, 28, 29);
}

.p-flexpane_header__primary {
  align-items: center;
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
  display: flex;
}

.p-quip_flexpane .p-flexpane__title_container {
  width: 100%;
}

.p-flexpane--ia_details_popover .p-flexpane__title_container {
  align-items: baseline;
  font-size: 18px;
  font-weight: 900;
  line-height: 1.33334;
  display: flex;
}

.p-flexpane__title_container {
  min-width: 0;
}

.p-flexpane__subtitle {
  font-size: 13px;
  font-weight: 400;
}

.p-flexpane--ia_details_popover .p-flexpane__subtitle {
  margin: 0 8px;
}

.p-quip_flexpane__action_items.p-quip_flexpane__action_items--max-width {
  max-width: 70%;
}

.p-quip_flexpane__action_items {
  align-items: center;
  display: flex;
}

.p-quip_flexpane__action_items .p-quip_flexpane__menu_trigger {
  width: 28px;
  height: 28px;
}

.c-icon_button--default,.c-icon_button--default:link,.c-icon_button--default.c-button-unstyled {
  /*color: rgba(var(--sk_foreground_max,29,28,29),.7);*/
  color: rgba(29, 28, 29);
}

.c-icon_button {
  border-radius: 4px;
  justify-content: center;
  align-items: center;
  display: inline-flex;
  position: relative;
}

.c-icon {
  justify-content: center;
  align-items: center;
  width: 20px;
  height: 20px;
  display: inline-flex;
  position: relative;
}

.p-flexpane__body {
  flex: 1;
  min-height: 0;
  position: relative;
}

.p-quip_flexpane--quip_canvas_sideview .p-quip_flexpane--quip_canvas_sideview__body {
  /*background-color: rgba(var(--sk_primary_background,255,255,255),1);*/
  background-color: rgba(255, 255, 255);
  height: 100%;
  position: relative;
  container: quip-flexpane / size;
}

.p-autoclog__hook {
  display: contents;
}

.p-canvas_template_options--absolute {
  z-index: 1;
  width: calc(100% - 176px);
  margin: 88px;
  padding: 0;
  display: none;
  position: relative;
  top: 60px;
}

.p-canvas_template_options {
  max-width: 800px;
  margin: auto;
  padding: 88px;
}

.p-canvas_template_options__header {
  /*color: var(--dt_color-content-ter);*/
  margin-bottom: 12px;
  font-size: 15px;
  font-weight: 700;
}

.p-canvas_template_options__buttons {
  /*color: var(--dt_color-content-ter);*/
  flex-direction: column;
  margin-left: -8px;
  font-size: 15px;
  display: flex;
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

.c-virtual_list--scrollbar {
  overflow: hidden;
}

.c-virtual_list {
  position: relative;
  overflow-x: hidden;
  overflow-y: scroll;
}

.c-scrollbar {
  position: relative;
  overflow: hidden;
}

.p-canvas_template_options--absolute .p-canvas_template_options__buttons--ia4 .c-virtual_list__item {
  border-radius: 4px;
}

.c-virtual_list__item {
  width: 100%;
  position: absolute;
}

.p-canvas_template_options--absolute .p-canvas_template_options__buttons--ia4 .p-canvas_template_options__buttons__button {
  text-decoration: none;
}

.p-canvas_template_options--absolute .p-canvas_template_options__buttons__button {
  margin-top: 4px;
  margin-bottom: 4px;
}

.p-canvas_template_options__buttons__button {
  align-items: center;
  margin-top: 8px;
  margin-bottom: 8px;
  margin-left: 8px;
  display: flex;
}

.template_size {
  display: block;
  margin-left: 0px;
  margin-top: 20px;
  left: 20px;
  top: 50px;
}

</style>