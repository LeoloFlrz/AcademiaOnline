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

const getUsers = async () => {
  let response = await ApiConnection.getAllUsers()
  users.value = response.data
  console.log(users.value);
  userId.value = users.value[0].id
  console.log(userId.value);
  userName.value = users.value[0].username
  console.log(userName.value);
}


  const getCourses = async () => {
    let response = await ApiConnection.getAllCourses();
    courses.value = response.data
    courseTitle.value = courses.value[0].title
    courseId.value = courses.value[0].id
    courseDescription.value = courses.value[0].description
  }
  
  onMounted(async () => {
  // const response = await ApiConnection.getAllUsers()
  // await getCourseById(1)
  // courseTitle.value = response.data[0].title
  // console.log(courseTitle.value);
  getCourses()
  getUsers()
})
</script>

<template>
  <div :class="courseClass">
    <div :class="videoClass">
      <video src="../assets/RaicesConSonido.mkv"></video>
    </div>

    <div class="courseTitle">{{  }}</div>

    <div class="courseDescription"></div>

    <div class="inscribeButton"></div>

    <div class="courseRating"></div>
  </div>
</template>

<style scoped>
</style>
