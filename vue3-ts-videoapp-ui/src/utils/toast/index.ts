import { closeToast, showLoadingToast, showToast } from 'vant'
const toast = {
  text: (msg: string) => {
    return showToast(msg)
  },
  loading: (msg: string) => {
    return showLoadingToast({
      message: msg,
      forbidClick: true,
      duration: 0
    })
  },
  close: () => {
    return closeToast()
  }
}
export default toast
