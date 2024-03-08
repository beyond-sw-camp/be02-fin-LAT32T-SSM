<template>
  <ChatInputComponent></ChatInputComponent>
  <router-view></router-view>
</template>

<script>
import ChatInputComponent from './components/ChatInputComponent.vue';

export default {
  name: 'App',
  components:{
    ChatInputComponent
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
