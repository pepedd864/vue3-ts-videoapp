import { createStore } from 'vuex'

export default createStore({
  state: {
    title: 'vue3-ts-videoapp',
    videoTitle: '视频',
    view: 'video',
    user: {
      id: 0,
      name: '游客',
      avatar: 'https://img.yzcdn.cn/vant/cat.jpeg'
    },
    channel: [],
    tabbar: [
      {
        id: 0,
        name: '首页',
        path: '/home',
        icon: 'home-o',
        active: true
      },
      {
        id: 1,
        name: '搜索',
        path: '/search',
        icon: 'search',
        active: false
      },
      {
        id: 2,
        name: '用户',
        path: '/account',
        icon: 'user-o',
        active: false
      }
    ]
  },
  getters: {},
  mutations: {
    setView (state, view) {
      state.view = view
    },
    setChannel (state, channel) {
      state.channel = channel
    },
    setTabbar (state, tabbar) {
      state.tabbar = tabbar
    }
  },
  actions: {
    setChannel ({ commit }, setChannel) {
      commit('setChannel', setChannel)
    },
    setTabbar ({ commit }, setTabbar) {
      commit('setTabbar', setTabbar)
    }
  },
  modules: {}
})
