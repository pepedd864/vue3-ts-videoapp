<template>
  <div class="video-card van-haptics-feedback" @click="CardOnClick">
    <div class="card-img">
      <div class="video-img-mask">
        <van-icon name="play-circle-o" />
        <van-text-ellipsis :content="`title`"> </van-text-ellipsis>
      </div>
      <van-image fit="cover" lazy-load :src="video.img" :alt="video.desc">
        <template v-slot:loading>
          <van-loading type="spinner" size="20" />
        </template>
        <template v-slot:error>加载失败</template>
      </van-image>
    </div>
    <div class="card-bottom">
      <van-text-ellipsis class="video-title" :content="video.desc" :rows="`2`" />
      <div class="text-line">
        <van-tag type="primary">已发布</van-tag>
        <van-text-ellipsis class="video-lang" :content="video.date" />
        <van-text-ellipsis class="video-date" :content="video.date" />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { defineProps, PropType } from 'vue'
import router from '@/router'
interface Video {
  id?: number
  img?: string
  desc?: string
  date?: string
}
const props = defineProps({
  video: {
    type: Object as PropType<Video>,
    required: true
  }
})
const CardOnClick = () => {
  router.push(`/video/${props.video.id}`)
}
</script>

<style lang="less" scoped>
.video-card {
  display: flex;
  flex-direction: column;
  width: 45vw;
  max-width: 255px;
  height: 23vh;
  max-height: 230px;
  min-height: 170px;
  margin: 0.5vh 0;
  background: #fff;
  box-shadow: 1px 1px 1px 1px rgba(0, 0, 0, 0.1);
  border-radius: 5px;
  transition: 0.3s all;
  .card-img {
    position: relative;
    width: 100%;
    height: 55%;
    min-height: 90px;
    max-height: 120px;
    .video-img-mask {
      position: absolute;
      display: flex;
      align-items: flex-end;
      bottom: 0;
      width: 100%;
      height: 20%;
      min-height: 30px;
      color: #fff;
      background: linear-gradient(0deg, rgba(0, 0, 0, 0.6) 0%, rgba(0, 0, 0, 0) 100%);
      z-index: 1;
      .van-icon {
        padding: 3px;
        font-size: 18px;
      }
      .van-text-ellipsis {
        padding: 5px;
        height: 16px;
        font-size: 14px;
      }
    }
    .van-image {
      height: 100%;
      width: 100%;
    }
  }
  .card-bottom {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding: 5px;
    .video-title {
      font-size: 14px;
      font-family: 思源黑体;
      width: 100%;
      height: 6.5vh;
      max-height: 60px;
      min-height: 45px;
    }
    .text-line {
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      .van-tag {
        max-width: 50px;
        min-width: 40px;
        max-height: 30px;
        font-size: 0.2vh;
      }
      .video-lang {
        width: 10vw;
        font-size: 12px;
        color: #888;
      }
      .video-date {
        width: 20vw;
        max-width: 75px;
        font-size: 12px;
        color: #888;
      }
    }
  }
}
</style>
