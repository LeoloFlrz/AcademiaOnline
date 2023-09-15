<script setup>
import ApiConnection from '../services/ApiConnection.js'
import { onMounted, ref } from 'vue'
import MainButton from './MainButton.vue'
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
  let response = await ApiConnection.getAllCourses()
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
  <div class="flex justify-around bg-indigo-300 rounded p-4 items-center" :class="courseClass">
    <div :class="videoClass">
      <video class="rounded" src="../assets/RaicesConSonido.mkv" controls></video>
    </div>

    <div class="titleDescriptionContainer flex flex-col items-center">
      <div class="courseTitle rounded bg-gray-300 w-16 h-auto text-center font-semibold ">
        {{ courseTitle }}
      </div>

      <div class="courseDescription rounded bg-gray-300 w-auto h-auto text-center mt-8 p-2">{{ courseDescription }}</div>
    </div>

    <div class="flex flex-col">
      <div class="inscribeButton">
        <MainButton button-title="Inscríbete" class="mb-5"/>
      </div>
      
      <div class="ratingContainer">
        <div class="courseRating">Rating: {{ courseRating }}</div>

        <div class="flex items-center space-x-1">
          <svg
            class="w-4 h-4 text-yellow-300"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 22 20"
          >
            <path
              d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"
            />
          </svg>
          <svg
            class="w-4 h-4 text-yellow-300"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 22 20"
          >
            <path
              d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"
            />
          </svg>
          <svg
            class="w-4 h-4 text-yellow-300"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 22 20"
          >
            <path
              d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"
            />
          </svg>
          <svg
            class="w-4 h-4 text-yellow-300"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 22 20"
          >
            <path
              d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"
            />
          </svg>
          <svg
            class="w-4 h-4 text-gray-300 dark:text-gray-500"
            aria-hidden="true"
            xmlns="http://www.w3.org/2000/svg"
            fill="currentColor"
            viewBox="0 0 22 20"
          >
            <path
              d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"
            />
          </svg>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
