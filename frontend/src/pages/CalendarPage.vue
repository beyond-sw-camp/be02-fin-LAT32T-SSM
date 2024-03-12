<template>
  <CalendarComponent />
  <div class="container">

    <!-- 일자 클릭시 메뉴오픈 -->
    <div id="contextMenu" class="dropdown clearfix contextOpened" style="display: none; left: 802px; top: 448px;">
      <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
          style="display:block;position:static;margin-bottom:5px;">
        <li><a tabindex="-1" href="#">카테고리1</a></li>
        <li><a tabindex="-1" href="#">카테고리2</a></li>
        <li><a tabindex="-1" href="#">카테고리3</a></li>
        <li><a tabindex="-1" href="#">카테고리4</a></li>
        <li class="divider"></li>
        <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
      </ul>
    </div>

    <div id="wrapper">
      <div id="loading"></div>
      <div id="calendar" class="fc fc-unthemed fc-ltr"></div>
    </div>


    <!-- 일정 추가 Component -->
    <div class="modal fade" tabindex="-1" role="dialog" id="eventModal" style="display: none;">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">×</span></button>
            <h4 class="modal-title">새로운 일정</h4>
          </div>
          <div class="modal-body">

            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-allDay">하루종일</label>
                <input class="allDayNewEvent" id="edit-allDay" type="checkbox">
              </div>
            </div>

            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-title">일정명</label>
                <input class="inputModal" type="text" name="edit-title" id="edit-title"
                       required="required">
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-start">시작</label>
                <input class="inputModal" type="text" name="edit-start" id="edit-start">
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-end">끝</label>
                <input class="inputModal" type="text" name="edit-end" id="edit-end">
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-type">구분</label>
                <select class="inputModal" type="text" name="edit-type" id="edit-type">
                  <option value="카테고리1">카테고리1</option>
                  <option value="카테고리2">카테고리2</option>
                  <option value="카테고리3">카테고리3</option>
                  <option value="카테고리4">카테고리4</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-color">색상</label>
                <select class="inputModal" name="color" id="edit-color">
                  <option value="#D25565" style="color:#D25565;">빨간색</option>
                  <option value="#9775fa" style="color:#9775fa;">보라색</option>
                  <option value="#ffa94d" style="color:#ffa94d;">주황색</option>
                  <option value="#74c0fc" style="color:#74c0fc;">파란색</option>
                  <option value="#f06595" style="color:#f06595;">핑크색</option>
                  <option value="#63e6be" style="color:#63e6be;">연두색</option>
                  <option value="#a9e34b" style="color:#a9e34b;">초록색</option>
                  <option value="#4d638c" style="color:#4d638c;">남색</option>
                  <option value="#495057" style="color:#495057;">검정색</option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-desc">설명</label>
                <textarea rows="4" cols="50" class="inputModal" name="edit-desc"
                          id="edit-desc"></textarea>
              </div>
            </div>
          </div>
          <div class="modal-footer modalBtnContainer-addEvent">
            <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
            <button type="button" class="btn btn-primary" id="save-event">저장</button>
          </div>
          <div class="modal-footer modalBtnContainer-modifyEvent" style="display: none;">
            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
            <button type="button" class="btn btn-primary" id="updateEvent">저장</button>
          </div>
        </div><!-- /.component-content -->
      </div><!-- /.component-dialog -->
    </div><!-- /.component -->

    <!-- 필터 Component -->
    <div class="panel panel-default">

      <div class="panel-heading">
        <h3 class="panel-title">필터</h3>
      </div>

      <div class="panel-body">

        <div class="col-lg-6">
          <label for="calendar_view">구분별</label>
          <div class="input-group">
            <select class="filter select2-hidden-accessible" id="type_filter" multiple=""
                    data-select2-id="type_filter" tabindex="-1" aria-hidden="true">
              <option value="카테고리1">카테고리1</option>
              <option value="카테고리2">카테고리2</option>
              <option value="카테고리3">카테고리3</option>
              <option value="카테고리4">카테고리4</option>
            </select><span class="select2 select2-container select2-container--default" dir="ltr"
                           data-select2-id="1" style="width: 500px;"><span class="selection"><span
              class="select2-selection select2-selection--multiple" role="combobox"
              aria-haspopup="true" aria-expanded="false" tabindex="-1">
                                    <ul class="select2-selection__rendered">
                                        <li class="select2-search select2-search--inline"><input
                                            class="select2-search__field" type="search" tabindex="0"
                                            autocomplete="off" autocorrect="off" autocapitalize="none"
                                            spellcheck="false" role="textbox" aria-autocomplete="list"
                                            placeholder="선택.." style="width: 498px;"></li>
                                    </ul>
                                </span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
          </div>
        </div>

        <div class="col-lg-6">
          <label for="calendar_view">등록자별</label>
          <div class="input-group">
            <label class="checkbox-inline"><input class="filter" type="checkbox" value="정연"
                                                  checked="">정연</label>
            <label class="checkbox-inline"><input class="filter" type="checkbox" value="다현"
                                                  checked="">다현</label>
            <label class="checkbox-inline"><input class="filter" type="checkbox" value="사나"
                                                  checked="">사나</label>
            <label class="checkbox-inline"><input class="filter" type="checkbox" value="나연"
                                                  checked="">나연</label>
            <label class="checkbox-inline"><input class="filter" type="checkbox" value="지효"
                                                  checked="">지효</label>
          </div>
        </div>

      </div>
    </div>
    <!-- 필터 Component -->
    /.filter panel
  </div>
</template>

<script>
import CalendarComponent from "@/components/CalendarComponent.vue";
//import CalendarComponent from "@/App.vue";

export default {
  components: {
    CalendarComponent,
  },
  data() {
    return {
      
    }
  },
  created() {
    const script = document.createElement('script');
    script.src = "/js/main.js";
    script.async = true;
    document.body.appendChild(script);

    const script2 = document.createElement('script');
    script2.src = "/js/addEvent.js";
    script2.async = true;
    document.body.appendChild(script2);

    const script3 = document.createElement('script');
    script3.src = "/js/editEvent.js";
    script3.async = true;
    document.body.appendChild(script3);

    const script4 = document.createElement('script');
    script4.src = "/js/etcSetting.js";
    script4.async = true;
    document.body.appendChild(script4);
  },


}

</script>

<style>

</style>