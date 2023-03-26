<template>
  <div class="avatar">
    <van-image round fit="cover" width="5rem" height="5rem" :src="props.props.avatar" />
    <div class="account-name">{{ props.props.name }}</div>
  </div>
</template>

<script setup lang="ts">
import { defineProps, PropType } from 'vue'
interface Props {
  id: number
  name: string
  avatar: string
}
const props = defineProps({
  props: {
    type: Object as PropType<Props>,
    required: true
  }
})
</script>

<style lang="less" scoped>
.avatar {
  display: flex;
  align-items: center;
  padding: 10px 50px;
  width: 60vw;
  margin: 15px auto;
  background: #fff;
  box-shadow: 0 3px 10px rgba(0,0,0,0.3);
  border-radius: 10px;
  .account-name {
    margin-left: 25px;
    font-family: '思源黑体';
    font-size: 30px;
  }
}
</style>
