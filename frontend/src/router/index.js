import { createRouter, createWebHistory } from "vue-router";
import AddCourseView from '../views/AddCourseView';
import LandingView from '../views/LandingView'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
        path:"/",
        name: "LandingPage",
        component: LandingView
    },
    {
      path: "/add",
      name: "AddCourse",
      component: AddCourseView
    }
    
  ],
});

export default router;
