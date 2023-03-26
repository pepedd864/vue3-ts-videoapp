<template>
  <video-player
    class="video-player vjs-big-play-centered"
    preload="metadata"
    :options="options.options"
    :loop="false"
    :volume="0.6"
  />
</template>

<script setup lang="ts">
import { defineProps, PropType } from 'vue'
import { VideoPlayer } from '@videojs-player/vue'
import 'video.js/dist/video-js.css'

interface Props {
  controls?: boolean
  autoplay?: boolean
  fluid?: boolean
  poster?: string
  src?: string
}
const options = defineProps({
  options: {
    type: Object as PropType<Props>,
    required: true
  }
})
</script>

<style lang="less" scoped>
.video-player {
  height: 30vh;
  width: 100%;
  .vjs-paused .vjs-big-play-button,
  .vjs-paused.vjs-has-started .vjs-big-play-button {
    display: block;
  }
}
</style>
