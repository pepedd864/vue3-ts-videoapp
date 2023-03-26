<template>
  <div class="search">
    <van-search
      v-model="value"
      placeholder="请输入搜索内容"
      show-action
      @search="onSearch"
      @cancel="onCancel"
    />
    <van-empty image="search" description="无搜索内容" />
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import router from '@/router'
const value = ref('')
const onSearch = () => {
  console.log(value)
}
const onCancel = () => {
  // 返回
  router.go(-1)
}
</script>

<style lang="less" scoped>
.search {
  .van-empty {
    background: #fff;
  }
}
</style>
