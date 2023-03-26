<template>
  <div class="home">
    <Header />
    <van-tabs v-model:active="active" swipeable animated>
      <van-tab
        v-for="item in store.state.channel"
        :key="item.id"
        :title="item.name"
        :to="item.path"
      >
        <keep-alive>
          <van-pull-refresh v-model="refreshing" @refresh="onLoad">
            <van-list :finished="true" finished-text="没有更多了">
              <videoCardList :lists="list" />
            </van-list>
          </van-pull-refresh>
        </keep-alive>
      </van-tab>
    </van-tabs>

  </div>
</template>

<script setup lang="ts">
import { ref, getCurrentInstance } from 'vue'
import { useStore } from 'vuex'
import Header from './components/header.vue'
import videoCardList from '@/components/videoCardList.vue'
import toast from '@/utils/toast'
import obj from '@/utils/testData'
const store = useStore()
const active = ref(0)
const { proxy } = getCurrentInstance() as any
const list = ref(obj.videoList)
// const loading = ref(false)
// const finished = ref(false)
const refreshing = ref(false)
const onLoad = () => {
  setTimeout(() => {
    toast.text('刷新成功')
    refreshing.value = false
  }, 1000)
}
const getChannel = async () => {
  // 判断store中是否有数据，有数据就不再请求
  if (store.state.channel.length === 0) {
    const res = await proxy.request({
      url: '/channel',
      showLoading: true,
      method: 'get'
    })
    if (res.code === 20041) {
      store.commit('setChannel', res.data)
    }
  }
}
getChannel()
</script>

<style lang="less" scoped>
.home {
  .van-pull-refresh{
    margin-bottom: 40px;
  }
}
</style>
