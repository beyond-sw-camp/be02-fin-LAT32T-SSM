<template>
  <div>
    유저이름:
    <input v-model="sender" type="text">
    내용: <input v-model="message" type="text" @keyup="sendMessage">
    <div v-for="(item, idx) in recvList" :key="idx">
      <h3>유저이름: {{ item.userName }}</h3>
      <h3>내용: {{ item.message }}</h3>
    </div>
  </div><br><br>
  <div>
    유저이름:
    <input v-model="username" type="text">
    채팅방 이름: <input v-model="roomName" type="text">
    <button @click="createRoom">채팅방 생성하기</button>
    <div v-for="(item, idx) in roomList" :key="idx">
      <br>
      <button @click="enterRoom(item.chatRoomId)">
        <span>{{ item.chatRoomName }}</span>
      </button>
    </div>
  </div>
</template>

<script>
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'
import axios from "axios";

export default {
  name: 'ChatPage',
  data() {
    return {
      sender: "",
      message: "",
      recvList: [],
      roomName: "",
      roomList: [],
      username: ""
    }
  },
  created() {
    this.connect()
  },
  methods: {
    connect() {
      const server = "http://localhost:8080:8080/chat"
      let socket = new SockJS(server);
      this.stompClient = Stomp.over(socket);
      console.log(`소켓 연결을 시도 중 서버 주소: ${server}`)
      this.stompClient.connect(
        {},
        frame => {
          this.connected = true;
          console.log('소켓 연결 성공', frame);
          this.stompClient.subscribe("/sub/message", res => {
            console.log(res);
            console.log("구독으로 받은 메시지입니다.", res.body);
            this.recvList.push(JSON.parse(res.body))
          });
        },
        error => {
          console.log('소켓 연결 실패', error);
          this.connected = false;
        }
      )
    },
    async createRoom(e) {
      console.log(e);
      const postCreateRoom = {
        username: this.username,
        roomName: this.roomName
      }
      console.log(postCreateRoom);
      let response = await axios.post("http://localhost:8080:8080/chat/room/create", postCreateRoom);

      console.log(response.data);
    },
    async getRoomList() {
      let response = await axios.get("http://localhost:8080:8080/chat/rooms");
      console.log(response.data)
      this.roomList = response.data;

    },
    sendMessage(e) {
      console.log(e);
      if (e.keyCode === 13 && this.userName !== '' && this.message !== '') {
        this.send()
        this.message = ''
      }
    },
    enterRoom(roomId) {
      console.log(roomId)
      const server = "http://localhost:8080:8080/chat"
      let socket = new SockJS(server);
      this.stompClient = Stomp.over(socket);
      console.log(`소켓 연결을 시도 중 서버 주소: ${server}`)
      this.stompClient.connect(
        {},
        frame => {
          this.connected = true;
          console.log('소켓 연결 성공', frame);
          this.stompClient.subscribe("/sub/room/" + roomId + "/entered", res => {
            console.log(res);
            console.log("구독으로 받은 메시지입니다.", res.body);
            this.recvList.push(JSON.parse(res.body))
          });
        },
        error => {
          console.log('소켓 연결 실패', error);
          this.connected = false;
        }
      )
      this.sendRoomMessage(roomId);
    },
    sendRoomMessage(roomId) {
      console.log('Send Message:' + this.message);
      if (this.stompClient && this.stompClient.connected) {
        const msg = {
          userName: this.sender,
          message: this.message
        };
        console.log(msg);
        this.stompClient.send("/send/room/" + roomId, JSON.stringify(msg), {});
      }
    },
    send() {
      console.log('Send Message:' + this.message);
      if (this.stompClient && this.stompClient.connected) {
        const msg = {

          userName: this.sender,
          message: this.message
        };
        console.log(msg);
        this.stompClient.send("/send/room/" + roomId, JSON.stringify(msg), {});
      }
    }
  },
  mounted() {
    this.getRoomList();
  }
}
</script>

<style></style>