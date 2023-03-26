<template>
  <div class="card-list">
    <videoCard v-for="item in lists" :key="item.id" :video="item" />
  </div>
</template>

<script setup lang="ts">
import { defineProps, PropType } from 'vue'
import videoCard from '@/components/videoCard.vue'

interface Video {
  id?: number
  img?: string
  desc?: string
  date?: string
}

defineProps({
  lists: {
    type: Object as PropType<Video[]>,
    required: true
  }
})

</script>

<style lang="less" scoped>
.card-list {
  margin: 0 auto;
  max-width: 620px;
  height: auto;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 0 1vw;
}
</style>
