<template>
  <div class="video">
    <van-sticky>
      <VideoPlayer :options="options" />
    </van-sticky>
    <van-tabs animated>
      <van-tab title="推荐">
        <keep-alive>
          <videoCardList :lists="list" />
        </keep-alive>
      </van-tab>
      <van-tab title="评论">
       <keep-alive>
         <videoCardList :lists="list" />
       </keep-alive>
      </van-tab>
    </van-tabs>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import videoCardList from '@/components/videoCardList.vue'
import VideoPlayer from '@/views/video/components/videoPlayer.vue'
import obj from '@/utils/testData'
const options = ref({
  controls: true,
  autoplay: false,
  fluid: true,
  poster: 'https://img.yzcdn.cn/vant/apple-1.jpg',
  src: 'http://localhost:8080/video/780667066-1-208.mp4'
})
const list = ref(obj.videoList)
</script>

<style lang="less" scoped>
</style>
