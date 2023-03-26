<template>
  <div class="account">
    <avatar :props="store.state.user" />
    <van-cell-group inset>
      <van-cell title="单元格" value="内容" is-link />
      <van-cell title="单元格" value="内容" label="描述信息" />
    </van-cell-group>
    <van-cell-group style="margin-top: 10px" inset>
      <van-cell title="单元格" value="内容" />
      <van-cell title="单元格" value="内容" label="描述信息" />
    </van-cell-group>
    <van-cell-group style="margin-top: 10px" inset>
      <van-cell title="退出登录" @click="loginoff" is-link />
    </van-cell-group>
  </div>
</template>

<script setup lang="ts">
import { getCurrentInstance } from 'vue'
import { useStore } from 'vuex'
import avatar from './components/avatar.vue'
const { proxy } = getCurrentInstance() as any
const store = useStore()
const loginoff = () => {
  proxy.$router.push('/login')
}
</script>

<style lang="less" scoped>
.account {
  padding: 10px 0;
  //background: #fff;
  height: 100vh;
  .basic-layout {
    background: #fff;
    .van-cell-group {
      .van-cell {
        background: #f2f9ff;
        transition: 0.3s all;
        // 点击效果
        &:active {
          background: #eaf3fc;
        }
      }
    }
  }
}
</style>
