<template>
  <div id="app">
    <van-config-provider>
      <router-view />
    </van-config-provider>
  </div>
</template>

<script setup lang="ts"></script>

<style lang="less" scoped>
.van-theme-dark body {
  background-color: black;
}
</style>
