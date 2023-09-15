<script setup>
import MainButton from '../components/MainButton.vue';
import MainCourse from '../components/MainCourse.vue';
import MainNavbar from '../components/MainNavbar.vue';
import VideoContainer from '../components/VideoContainer.vue';
import { ref, onBeforeMount } from 'vue'
import ApiConnection from '../services/ApiConnection';

const courses = ref([])
const courseId = ref()
const courseTitle = ref()
const courseDescription = ref()
const courseRating = ref()

const getCourses = async () => {
  let response = await ApiConnection.getAllCourses()
  courses.value = response.data
  courseTitle.value = courses.value[0].title
  courseId.value = courses.value[0].id
  courseDescription.value = courses.value[0].description
  courseRating.value = courses.value[0].rating
}

onBeforeMount(() => {
  getCourses()
})
</script>

<template>
  <header>
    <MainNavbar />
  </header>

  <main>
    <div class="videoContainer flex flex-col items-center">
      <VideoContainer class="w-5/12 h-4/12 mb-10"/>
      <p class="flex justify-center w-6/12 text-justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis aliquid voluptate dicta quaerat ullam soluta adipisci inventore ducimus rerum, a assumenda perspiciatis nobis laborum, autem eaque amet reprehenderit illum eos?</p>
    </div>
    <div class="buttonContainer flex justify-end mr-20 pt-5">
        <MainButton button-title="Añadir Curso" href="/add"/>
    </div>
    <section class="flex flex-row justify-center items-center">
      <div class="coursesContainer bg-blue-950 h-auto w-11/12 mt-10 rounded-md">
        <MainCourse v-for="(courses, index) in courses" :key="index" video-class="w-4/12 h-auto" class="m-10"/>
      </div>
    </section>
    

  </main>
</template>

<style scoped>
</style>
