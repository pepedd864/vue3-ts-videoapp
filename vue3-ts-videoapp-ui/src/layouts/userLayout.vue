<template>
  <div class="title">
    <h1>{{ title }}</h1>
  </div>
  <van-tabs>
    <van-tab v-for="item in arr" :key="item.id" :title="item.name" :to="item.path"> </van-tab>
    <router-view v-slot="{ Component, route }">
      <Transition name="fade-transform">
        <keep-alive>
          <component :is="Component" :key="route.path" />
        </keep-alive>
      </Transition>
    </router-view>
  </van-tabs>
</template>

<script setup lang="ts">
import { ref } from 'vue'
const title = ref('登录  注册')
const arr = ref([
  {
    id: 0,
    path: '/login',
    name: '登录'
  },
  {
    id: 1,
    path: '/register',
    name: '注册'
  }
])
</script>

<style lang="less" scoped>
.title {
  margin: 10px auto;
  text-align: center;
}
.van-tabs {
  height: 300px;
  margin: 10px;
  padding: 10px;
  border-radius: 10px;
  box-shadow: 0 5px 7px rgba(0, 0, 0, 0.3);
  overflow: hidden;
}
</style>
