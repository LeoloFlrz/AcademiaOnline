<script setup>
import MainCourse from '../components/MainCourse.vue';
import MainNavbar from '../components/MainNavbar.vue';
import ApiConnection from '../services/ApiConnection.js';
import { ref, onBeforeMount } from 'vue'
 
const courses = ref([])

// const getCourses = async () => {
//   let response = await ApiConnection.getAllCourses()
//   courses.value = response.data
//   courseTitle.value = courses.value[1].title
//   courseId.value = courses.value[1].id
//   courseDescription.value = courses.value[1].description
//   courseRating.value = courses.value[1].rating
//   return response
// }

const getCourses = async () => {
  let response = await ApiConnection.getAllCourses()
  console.log(response.data);
  courses.value = response.data
  console.log(courses.value);
}



onBeforeMount(() => {
    getCourses()
})
</script>

<template  >
    <body id="main">
        <header>
        <MainNavbar />
    </header>

    <div >
        <div v-for="course in courses" :key="course.id">       
            <MainCourse :title="course.title" :description="course.description" :rating="course.rating" video-class="w-4/12 h-auto" class="m-10 bg-blue-950 mt-10"/>
        </div>
    </div>
    </body>
    
</template>

<style scoped>
#main {
    background-image: url('../assets/bg.jpg');
    background-size: cover;
    background-repeat: no-repeat;
}

</style>