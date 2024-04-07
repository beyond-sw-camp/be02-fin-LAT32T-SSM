<template>
    <div class="container1">

        <div class="panel panel-default">
            <div class="panel-body">
                <div class="col-lg-6">
                    <label for="calendar_view">채팅방List</label>
                    <div class="input-group filter" @click="chatRoomStore.getRoomList()">
                        <select v-if="chatRoomStore.roomList.length > 0" class="filter" id="type_filter" v-model="mainStore.selectedChatRoom"
                            @change="mainStore.onChatRoomChange(); chatRoomChange()">
                            <option value="일반일정">일반일정</option>
                            <option v-for="(chatRoom, index) in chatRoomStore.roomList" :key="index"
                                :value="chatRoom"> {{ chatRoom.chatRoomName }}</option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-6">
                    <label for="calendar_view">등록자별</label>
                    <button @click="mainStore.openComponent"><i class="fa fa-plus"></i></button>
                    <MemberSearchComponent></MemberSearchComponent>
                    <div class="input-group filter">
                        <label v-for="(member, index) in mainStore.filteredMemberNames" :key="index" :value="member"
                            class="filter checkbox-inline">
                            <input class='filter' type="checkbox" :value="member" :checked="index === 0">
                            {{ member }}</label>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.filter panel -->
    </div>
</template>

<script>
import { mapStores } from "pinia";
import { useMainStore } from "@/stores/useMainStore";
import { useChatRoomStore } from "@/stores/useChatRoomStore";
import MemberSearchComponent from "./MemberSearchComponent.vue";

export default {
    data() {
        return {
          
        }
    },
    components: {
        MemberSearchComponent
    },
    computed: {
        ...mapStores(useMainStore, useChatRoomStore)
    },
    mounted() {
        const script = document.createElement('script');
        script.src = "/js/main.js";
        document.body.appendChild(script);

        const script2 = document.createElement('script');
        script2.src = "/js/addEvent.js";
        document.body.appendChild(script2);

        const script3 = document.createElement('script');
        script3.src = "/js/editEvent.js";
        document.body.appendChild(script3);

        const script4 = document.createElement('script');
        script4.src = "/js/etcSetting.js";
        document.body.appendChild(script4);
    },
    methods: {
        chatRoomChange() {
      // 선택된 채팅방의 이름을 외부 함수로 전달합니다.
      // 여기서는 예시로 updateChatRoomName이라는 외부 함수를 호출합니다.
      // 실제로는 이 함수를 외부 JavaScript에서 정의해야 합니다.
      if (this.mainStore.selectedChatRoom && typeof updateChatRoomName === "function") {
        updateChatRoomName(this.mainStore.selectedChatRoom.chatRoomName);
      }
    }
    },
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