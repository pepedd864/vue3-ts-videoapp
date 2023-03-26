import axios from 'axios'
import { errcode, sererr, serok } from './errcode/code'
import toast from '../toast'
import router from '@/router'
// 携带cookie 使session生效
axios.defaults.withCredentials = true
// 前端域名应该和后端一样，否则session id不一致

// 请求头格式
const contentTypeForm = 'application/x-www-form-urlencoded;charset=UTF-8'
const contentTypeJson = 'application/json'
const contnetTypeFile = 'multipart/form-data'

interface Config {
  url: string
  params: any
  method: string
  dataType: string
  showLoading: boolean
  successCallback: () => void
  errorCallback: () => void
}
const request = function (config: Config): Promise<any> {
  // 初始化参数
  let { url, params, dataType, showLoading, method } = config
  dataType = dataType || 'form'
  showLoading = showLoading ? true : showLoading

  // 赋值参数
  let contentType = contentTypeForm
  if (dataType === 'json') {
    contentType = contentTypeJson
  } else if (dataType === 'file') {
    contentType = contnetTypeFile

    const param = new FormData()
    for (const key in params) {
      param.append(key, params[key])
      console.log(key, params[key])
    }
    params = param
  }

  // axios创建请求头
  const headers = {
    'Content-Type': contentType,
    'X-Requested-With': 'XMLHttpRequest'
  }
  const instantce = axios.create({
    baseURL: '/api',
    timeout: 10 * 1000,
    headers: headers,
    method: method
  })

  // 请求前拦截
  let loading: any = null
  instantce.interceptors.request.use(
    (config) => {
      if (showLoading) {
        loading = toast.loading('加载中...')
      }
      return config
    },
    (error) => {
      if (showLoading && loading) {
        toast.close()
      }
      return error
    }
  )
  // 请求后拦截
  instantce.interceptors.response.use(
    (response) => {
      let responseData = response.data
      // 请求为空
      if (responseData === null) {
        loading = toast.loading('服务器错误')
        return responseData
      }
      // 根据响应数据的状态码进行处理
      // 请求成功
      serok.forEach((item) => {
        if (item.code === responseData.code) {
          loading = toast.loading(responseData.msg)
        }
      })
      // 请求失败
      sererr.forEach((item) => {
        if (item.code === responseData.code) {
          console.log(item)
          loading = toast.loading(responseData.msg)
          // 系统错误
          if (item.code === 50000) responseData = null
        }
      })
      return responseData
    },
    (error) => {
      // 请求错误
      errcode.forEach((item) => {
        if (item.code === error.response.status) {
          loading = toast.loading(item.message)
        }
      })
      return null
    }
  )
  return instantce({
    url,
    data: dataType === 'form' ? null : params,
    params: dataType === 'form' ? params : null
  }).then((res) => {
    if (showLoading && loading && res) {
      setTimeout(() => loading.close(), 1000) // 延时关闭
    }
    return res ? res.data : null // 根据错误类型返回数据
  })
}
/**
 * 正常返回数据，错误返回修改后的错误数据
 */
export default request
