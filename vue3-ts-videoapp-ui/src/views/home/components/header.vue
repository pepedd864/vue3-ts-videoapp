<template>
  <div class="app-header">
    <div class="title">{{ store.state.title }}</div>
  </div>
</template>

<script setup lang="ts">
import { useStore } from 'vuex'
const store = useStore()
</script>

<style lang="less" scoped>
.app-header {
  .title {
    font-size: 22px;
    padding: 10px;
    text-align: center;
    font-weight: bold;
    color: #fff;
    background: var(--theme-color);
  }
}
</style>
