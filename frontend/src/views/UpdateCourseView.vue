<script setup>
import MainFooter from '../components/MainFooter.vue';
import MainNavbar from '../components/MainNavbar.vue'
import ApiConnection from '../services/ApiConnection';
import { ref, onMounted } from 'vue'

const course = ref({})

onMounted( async () => {
    await getCourses()
})


const getCourses = async (id) => {
    let response = await ApiConnection.getCourseById(id)
    console.log(response);
    course.value = response.data
}

</script>

<template>
    <body>
        <header>
            <MainNavbar /> 
        </header>
        <main>
            <form class="w-full max-w-lg">
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
        Nickname
      </label>
      <input  class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="nick" type="text">
      
    </div>
  </div>
  <div class="flex flex-wrap -mx-3 mb-6">
    <div class="w-full px-3">
      <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-password">
        E-mail
      </label>
      <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="email" type="email">
      
    </div>
  </div>
  
  <div class="md:flex md:items-center">
    <div class="md:w-1/3">
      <button class="shadow bg-teal-400 hover:bg-teal-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded" type="button">
        Send
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