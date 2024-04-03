<template>
  <div class="wrapper">
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
.wrapper {
  overflow-y: auto;
  max-height: 100vh;
  padding-right: 17px;
}
</style>
