<script setup>
import MainCourse from '../components/MainCourse.vue';
import MainNavbar from '../components/MainNavbar.vue';
import ApiConnection from '../services/ApiConnection.js';
import { ref, onBeforeMount } from 'vue'
 
const courses = ref([])
const courseId = ref()
const courseTitle = ref()
const courseDescription = ref()
const courseRating = ref()

const getCourses = async () => {
  let response = await ApiConnection.getAllCourses()
  courses.value = response.data
  courseTitle.value = courses.value[1].title
  courseId.value = courses.value[1].id
  courseDescription.value = courses.value[1].description
  courseRating.value = courses.value[1].rating
  return response
}

// const getCourses = async () => {
//   let response = await ApiConnection.getAllCourses()
//   for( const i = 0 ; index<8; i++ ){
//     courseId.value = i
//     return i, console.log(i);
//   }
//   courses.value = response.data
//   courseTitle.value = courses.value[i].title
//   courseId.value = courses.value[1].id
//   courseDescription.value = courses.value[i].description
//   courseRating.value = courses.value[i].rating
// }

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
        <div>       
            <MainCourse v-for="(courses, index) in courses" :key="index" video-class="w-4/12 h-auto" class="m-10 bg-blue-950 mt-10"/>
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