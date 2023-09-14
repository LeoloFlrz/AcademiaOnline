<script setup>
import ApiConnection from '../services/ApiConnection.js'
import { onMounted, ref } from 'vue';
// eslint-disable-next-line no-unused-vars
const props = defineProps({
  courseClass: {
    type: String,
    default: ''
  },
  videoClass: {
    type: String,
    default: ''
  }
  
})

const userName = ref()
const userId = ref()
const users = ref([])
const courses = ref([])
const courseId = ref()
const courseTitle = ref()
const courseDescription = ref()
const courseRating = ref()

const getUsers = async () => {
  let response = await ApiConnection.getAllUsers()
  users.value = response.data
  userId.value = users.value[0].id
  userName.value = users.value[0].username
}


  const getCourses = async () => {
    let response = await ApiConnection.getAllCourses();
    courses.value = response.data
    courseTitle.value = courses.value[0].title
    courseId.value = courses.value[0].id
    courseDescription.value = courses.value[0].description
    courseRating.value = courses.value[0].rating
  }
  
  onMounted(async () => {
  getCourses()
  getUsers()
})
</script>

<template>
  <div class="flex justify-between" :class="courseClass">
    <div :class="videoClass">
      <video src="../assets/RaicesConSonido.mkv"></video>
    </div>

    <div class="courseTitle">{{ courseTitle }}</div>

    <div class="courseDescription">{{ courseDescription }}</div>

    <div class="inscribeButton"></div>

    <div class="courseRating">Rating: {{ courseRating }}</div>
  </div>
</template>

<style scoped>
</style>
