import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import store from '@/store'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home',
    component: () => import('@/layouts/basicLayout.vue'),
    children: [
      {
        path: '/home',
        component: () => import('@/views/home/index.vue')
      },
      {
        path: '/search',
        component: () => import('@/views/search/index.vue')
      },
      {
        path: '/account',
        component: () => import('@/views/account/index.vue')
      }
    ]
  },
  {
    path: '/video',
    component: () => import('@/layouts/videoPlayLayout.vue'),
    children: [
      {
        path: '/video/:id',
        component: () => import('@/views/video/index.vue')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/layouts/userLayout.vue'),
    children: [
      {
        path: '/login',
        name: 'login',
        component: () => import('@/views/user/login.vue')
      },
      {
        path: '/register',
        name: 'register',
        component: () => import('@/views/user/register.vue')
      }
    ]
  },
  {
    path: '/404',
    component: () => import('@/views/exception/404.vue')
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return { top: 0 }
    }
  }
})

// before change route
router.beforeEach((to, from, next) => {
  // 判断是否非法路由
  if (to.matched.length === 0) {
    next('/404')
  } else {
    next()
  }
})

export default router
