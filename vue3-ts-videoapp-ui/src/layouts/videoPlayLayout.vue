<template>
  <div class="video-layout">
    <van-nav-bar
      :title="store.state.videoTitle"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
    />
    <router-view v-slot="{ Component, route }">
      <Transition name="fade-transform">
        <component :is="Component" :key="route.path" />
      </Transition>
    </router-view>
  </div>
</template>

<script setup lang="ts">
import { useStore } from 'vuex'
const store = useStore()
const onClickLeft = () => {
  history.back()
}
</script>

<style lang="less" scoped></style>
