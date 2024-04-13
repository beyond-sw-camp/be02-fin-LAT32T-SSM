<template>
    <div v-if="chatRoomStore.visible" class="modal-overlay">
        <div class="modal-container">
            <div class="modal-header">
                <h3>새 채팅방 생성</h3>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="chatRoomName">채팅방 이름:</label>
                    <input v-model="chatRoomStore.chatRoomName" type="text" id="chatRoomName" placeholder="채팅방 이름 입력">
                </div>
                <div class="form-group">
                    <label for="memberId">멤버</label>
                    <input v-model="chatRoomStore.memberId" type="text" id="memberId" placeholder="추가할 멤버 이름">
                </div>
                <span v-for="(memberId, index) in chatRoomStore.memberIds" :key="index"> {{ memberId }}</span>
            </div>
            <div class="modal-footer">
                <button @click="chatRoomStore.memberPush()">추가</button>
                <button @click="chatRoomStore.makeChatRoom(this.$router)">생성하기</button>
                <button @click="chatRoomStore.closeModal()">취소하기</button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapStores } from "pinia";
import { useChatRoomStore } from "@/stores/useChatRoomStore";
import { useMainStore } from "@/stores/useMainStore";

export default {
    name: 'CreateChatRoomComponent',
    data() {
        return {
            chatRoomName: '',
            memberSearch: '',
            searchResults: [],
            selectedMembers: [],
        };
    },
    components:{
        
    },
    computed: {
        ...mapStores(useChatRoomStore, useMainStore)
    },
}
</script>


<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-container {
  background: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 500px;
  max-width: 90%;
}

.modal-header {
  margin-bottom: 20px;
  padding-bottom: 10px;
  border-bottom: 1px solid #eaeaea;
}

.modal-header h3 {
  margin: 0;
  color: #333;
  font-size: 1.5em;
}

.modal-body {
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 1em;
}

.form-group label {
  display: block;
  margin-bottom: .5em;
  color: #666;
}

.form-group input[type="text"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  color: #333;
}

.modal-footer {
  text-align: right;
}

.modal-footer button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  margin-left: 10px;
}

.modal-footer button:first-child {
  background-color: #007bff;
  color: #ffffff;
}

.modal-footer button:nth-child(2) {
  background-color: #f44336;
  color: #ffffff;
}

.modal-footer button:last-child {
  background-color: #4caf50;
  color: #ffffff;
}

span {
  color: #4caf50;
  cursor: pointer;
  display: inline-block;
  margin-top: 20px;
}
</style>

