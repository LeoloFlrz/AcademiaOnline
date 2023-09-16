import { createRouter, createWebHistory } from 'vue-router'
import LandingView from "../views/LandingView.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'LandingView',
      component: LandingView
    },
    {
      path: '/add',
      name: 'AddCourse',
      component: () => import('../views/AddCourseView.vue')
    }
  ]
})

export default router
