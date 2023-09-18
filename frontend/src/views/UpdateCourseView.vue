<script setup>
import { useRoute, useRouter } from 'vue-router';
import MainFooter from '../components/MainFooter.vue';
import MainNavbar from '../components/MainNavbar.vue'
import ApiConnection from '../services/ApiConnection';
import { ref, onMounted } from 'vue'

const course = ref({})
const route = useRoute()
const router = useRouter()


onMounted( async () => {
    console.log(route.params.id);
    await getCourses(route.params.id)
})


const getCourses = async (id) => {
    let response = await ApiConnection.getCourseById(id)
    course.value = response.data
}

const updateCourse = async () => {
    const updatedCourse = {
        ...course.value
    }
    try {
        const response = await ApiConnection.updateCourse(course.value.id, updatedCourse)
        if(response.status === 200) {
            alert('Course successfully updated!')
            router.push('/courses')
        } else {
            alert('Cannot update the course')
        }
    } catch (error) {
        return error.message
    }
}

</script>

<template>
    <body>
        <header>
            <MainNavbar /> 
        </header>
        <main class="flex justify-center m-20">
            <form class="w-full max-w-lg">
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <label class="block uppercase tracking-wide text-white text-xs font-bold mb-2" for="grid-password">
        Título
      </label>
      <input v-model="course.title" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="title" type="text">
      
    </div>
  </div>
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <label class="block uppercase tracking-wide text-white text-xs font-bold mb-2" for="grid-password">
        Descripción
      </label>
      <input v-model="course.description" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="description" type="text">
    </div>
  </div>
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <label class="block uppercase tracking-wide text-white text-xs font-bold mb-2" for="grid-password">
        Puntuación
      </label>
      <input v-model="course.rating" class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="rating" type="number">
    </div>
  </div>
  
  <div class="md:flex md:items-center">
    <div class="md:w-1/3">
      <button @click="updateCourse()" class="shadow bg-teal-400 hover:bg-teal-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded" type="button">
        Actualizar
      </button>
    </div>
    <div class="md:w-2/3"></div>
  </div>
</form>
        </main>
        <footer>
            <MainFooter />
        </footer>
    </body>
</template>

<style scoped>
body {
  min-width: 100vh;
  background-image: url("../assets/bg.jpg");
  background-size: cover;
  background-repeat: no-repeat;
}
</style>