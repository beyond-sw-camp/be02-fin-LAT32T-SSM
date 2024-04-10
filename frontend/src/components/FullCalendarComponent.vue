<template>
  <div class="container1">

    <!-- 일자 클릭시 메뉴오픈 -->
    <div id="contextMenu" class="dropdown clearfix">
      <ul class="dropdown-menu dropNewEvent" role="menu" aria-labelledby="dropdownMenu"
          style="display:block;position:static;margin-bottom:5px;">
        <li><a tabindex="-1" href="#">일반일정</a></li>
        <li class="divider"></li>
        <div>그룹일정</div>
        <li v-for="(chatRoom, index) in chatRoomStore.roomList" :key="index" :value="chatRoom.chatRoomName">
          <a tabindex="-1" href="#">{{ chatRoom.chatRoomName }}</a>
        </li>
        <li class="divider"></li>
        <li><a tabindex="-1" href="#" data-role="close">Close</a></li>
      </ul>
    </div>

    <div id="wrapper">
      <div id="loading"></div>
      <div id="calendar"></div>
    </div>


    <!-- 일정 추가 MODAL -->
    <div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title"></h4>
          </div>
          <div class="modal-body">

            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-allDay">하루종일</label>
                <input class='allDayNewEvent' id="edit-allDay" type="checkbox">
              </div>
            </div>

            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-title">일정명</label>
                <input class="inputModal" type="text" name="edit-title" id="edit-title"
                       required="required"/>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-start">시작</label>
                <input class="inputModal" type="text" name="edit-start" id="edit-start"/>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-end">끝</label>
                <input class="inputModal" type="text" name="edit-end" id="edit-end"/>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-type">구분</label>
                <select class="inputModal" type="text" name="edit-type" id="edit-type">
                  <option value="일반일정">일반일정</option>
                  <option v-for="(chatRoom, index) in chatRoomStore.roomList"
                          :key="index" :value="chatRoom.chatRoomName"> {{ chatRoom.chatRoomName }}
                  </option>
                </select>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-member">인물</label>
                <button @click="mainStore.openComponent"><i class="fa fa-plus"></i></button>
                <MemberSearchComponent></MemberSearchComponent>
                <select class="inputModal" type="text" name="edit-member" id="edit-member"
                        multiple="multiple" required="required">
                  <option @click="temp" v-for="(member, index) in mainStore.members" :key="index"
                          :value="member.memberId">
                    {{ member.memberId }} /
                    {{ member.memberName }} /
                    {{ member.department }} /
                    {{ member.position }}
                  </option>
                </select>
              </div>
            </div>


            <div class="row">
              <div class="col-xs-12">
                <label class="col-xs-4" for="edit-member">회의실</label>
                <select class="inputModal" type="text" name="edit-room" id="edit-room">
                  <option :value="null">없음</option>
                  <option @click="temp" v-for="(room, index) in mainStore.meetingRooms" :key="index"
                          :value="room.meetingRoomIdx">
                    {{ room.meetingRoomName }}
                  </option>
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
          <div class="modal-footer modalBtnContainer-modifyEvent">
            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
            <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
            <button type="button" class="btn btn-primary" id="updateEvent">저장</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
  </div>
</template>

<script>
import {mapStores} from "pinia";
import {useMainStore} from "@/stores/useMainStore";
import {useChatRoomStore} from "@/stores/useChatRoomStore";
import MemberSearchComponent from "./MemberSearchComponent.vue";

export default {
  data() {
    return {
      selectedMembers: [],
    }
  },
  components: {
    MemberSearchComponent
  },
  computed: {
    ...mapStores(useMainStore, useChatRoomStore)
  },
  created() {

  },
  mounted() {
    // const script = document.createElement('script');
    // script.src = "/js/main.js";
    // document.body.appendChild(script);
    //
    // const script2 = document.createElement('script');
    // script2.src = "/js/addEvent.js";
    // document.body.appendChild(script2);
    //
    // const script3 = document.createElement('script');
    // script3.src = "/js/editEvent.js";
    // document.body.appendChild(script3);
    //
    // const script4 = document.createElement('script');
    // script4.src = "/js/etcSetting.js";
    // document.body.appendChild(script4);


  },
  methods: {},
}
</script>

<style scoped>
.container {
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 2.375rem 1fr;
}

.col-lg-6 {
  margin-top: 0.5rem;
  width: 100%;
}
</style>