import { createApp } from 'vue'
import App from './App.vue'
import '@/index.less'

import router from './router'
import store from './store'

import request from '@/utils/request'

import VueVideoPlayer from '@videojs-player/vue'
import 'video.js/dist/video-js.css'

import {
  TextEllipsis,
  Lazyload,
  Tabs,
  Tab,
  Image,
  Loading,
  List,
  PullRefresh,
  NavBar,
  Tag,
  Icon,
  Tabbar,
  TabbarItem,
  Search,
  Empty,
  Sticky,
  Cell,
  CellGroup,
  ConfigProvider,
  Field,
  Form,
  Button
} from 'vant'
import 'vant/lib/index.css'

const app = createApp(App)

app.config.globalProperties.request = request
app.config.globalProperties.router = router

app.use(store)
app.use(router)

app.use(VueVideoPlayer)

// vant
app
  .use(Tabs)
  .use(Lazyload)
  .use(Tab)
  .use(List)
  .use(Image)
  .use(NavBar)
  .use(Loading)
  .use(PullRefresh)
  .use(Tag)
  .use(TextEllipsis)
  .use(Icon)
  .use(Tabbar)
  .use(TabbarItem)
  .use(Search)
  .use(Empty)
  .use(Sticky)
  .use(Cell)
  .use(CellGroup)
  .use(ConfigProvider)
  .use(Field)
  .use(Form)
  .use(Button)
app.mount('#app')
