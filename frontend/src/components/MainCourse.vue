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

const courses = ref()

onMounted(async () => {
  courses.value = await ApiConnection.getAllCourses()
  console.log(courses.value);
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
