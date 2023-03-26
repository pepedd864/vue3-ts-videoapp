<template>
  <div>
    <!-- 登录表单 -->
    <van-form @submit="onSubmit" ref="loginForm">
      <van-cell-group inset>
        <van-field
          v-model="loginInfoForm.username"
          name="用户名"
          label="用户名"
          placeholder="用户名"
          :rules="loginInfoFormRules.username"
        />
        <van-field
          v-model="loginInfoForm.password"
          type="password"
          name="密码"
          label="密码"
          placeholder="密码"
          :rules="loginInfoFormRules.password"
        />
        <div class="line">
          <van-field
          v-model="loginInfoForm.checkCode"
          name="验证码"
          label="验证码"
          placeholder="验证码"
          :rules="loginInfoFormRules.checkCode"
          />
          <van-image fit="contain" :src="checkCodeImage" @click="getCheckCodeImage">
            <template v-slot:loading>
              <van-loading type="spinner" size="20" />
            </template>
          </van-image>
        </div>
      </van-cell-group>
      <div style="margin: 16px">
        <van-button round block type="primary" native-type="submit"> 提交 </van-button>
      </div>
    </van-form>
  </div>
</template>

<script setup lang="ts">
// 导入依赖
import { ref, onMounted, getCurrentInstance } from 'vue'
const { proxy } = getCurrentInstance() as any
const loginForm = ref()
// 验证码图片
const checkCodeImage = ref('')
// 登录表单数据
const loginInfoForm = ref({
  username: '',
  password: '',
  checkCode: ''
})
// 正则
const reg = ref({
  username: /^[a-zA-Z0-9_-]{4,16}$/,
  password: /^[a-zA-Z0-9_-]{6,18}$/,
  checkCode: /^[a-zA-Z0-9]{4}$/
})
// 登录表单规则
const loginInfoFormRules = ref({
  username: [{ pattern: reg.value.username, message: '请填写正确的用户名' }],
  password: [{ pattern: reg.value.password, message: '请填写正确的密码' }],
  checkCode: [{ pattern: reg.value.checkCode, message: '请填写正确的验证码' }]
})
// 提交表单
const onSubmit = async () => {
  // 参数
  const params = {
    username: loginInfoForm.value.username,
    password: loginInfoForm.value.password,
    checkCode: loginInfoForm.value.checkCode
  }
  // 表单验证并提交
  if (loginForm.value.validate()) {
    const res = await proxy.request({
      url: '/system/login',
      method: 'post',
      dataType: 'json', // 放在payload上
      params: params,
      showLoading: true
    })
    if (res === null) {
      getCheckCodeImage()
      return
    }
    if (res.code === 20041) {
      proxy.$router.push('/home')
    } else if (res.code === 20042) {
      getCheckCodeImage()
    }
  }
}
// 获取验证码图片, 时间戳防止缓存
const getCheckCodeImage = () => {
  // 防止重复请求
  setTimeout(() => {
    checkCodeImage.value = 'http://localhost:8080/api/system/checkCodeImage?t=' + new Date().getTime()
  }, 500)
  return checkCodeImage.value
}
// 页面加载时执行
onMounted(() => {
  getCheckCodeImage()
})
</script>

<style lang="less" scoped>
.van-form {
  .van-cell-group {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    height: 160px;
    .van-field {
      height: 55px;
      border-bottom: 1px solid #e5e5e5;
    }
    .line{
      display: flex;
    }
  }
}
</style>
