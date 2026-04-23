import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import SignupView from '../views/UserProfileView.vue'

const routes = [
  { path: '/', component: LoginView },
  { path: '/signup', component: SignupView }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router