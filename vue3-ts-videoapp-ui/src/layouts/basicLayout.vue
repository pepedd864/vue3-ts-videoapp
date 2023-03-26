<template>
  <div class="basic-layout">
    <router-view v-slot="{ Component }">
      <keep-alive>
        <component :is="Component" />
      </keep-alive>
    </router-view>
    <van-tabbar v-model="active" animated>
      <van-tabbar-item
        v-for="item in store.state.tabbar"
        :key="item.id"
        :icon="item.icon"
        :to="item.path"
        >{{ item.name }}</van-tabbar-item
      >
    </van-tabbar>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { useStore } from 'vuex'
const store = useStore()
const active = ref(0)
active.value = store.state.tabbar.findIndex((item: any) => item.path === location.pathname)
</script>

<style lang="less" scoped>
.basic-layout {
  background: #eee;
  .van-tabbar {
    backdrop-filter: blur(10px);
    background: rgba(255, 255, 255, 0.8);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    .van-tabbar-item {
      background: transparent;
      transition: 0.3s all;
    }
  }
}
</style>
