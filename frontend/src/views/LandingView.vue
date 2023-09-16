<script setup>
import MainCourse from '../components/MainCourse.vue';
import MainNavbar from '../components/MainNavbar.vue';
import VideoContainer from '../components/VideoContainer.vue';
import { ref, onBeforeMount } from 'vue'
import ApiConnection from '../services/ApiConnection';
import AddCourseButton from '../components/AddCourseButton.vue';
import AddCourseModal from '../components/AddCourseModal.vue';

const props = defineProps({
  showModal: {
    type: Boolean,
    default: false
  }
})

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

  <main id="main">
    <div class="videoContainer flex flex-col items-center">
      <VideoContainer class="w-5/12 h-4/12 mb-10"/>
      <p class="flex text-white justify-center w-6/12 text-justify">Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis aliquid voluptate dicta quaerat ullam soluta adipisci inventore ducimus rerum, a assumenda perspiciatis nobis laborum, autem eaque amet reprehenderit illum eos?</p>
    </div>
    <div class="buttonContainer flex justify-end mr-20 pt-5">
        <AddCourseButton button-title="Añadir Curso" @click="showModal = true"/>
        <!-- <AddCourseModal v-if="showModal"/> -->
        <div v-if="showModal" class="fixed inset-0 flex items-center justify-center z-50">
      <div v-if="showModal" class="modal-overlay absolute inset-0 bg-gray-500 opacity-75"></div>

      <div class="modal-container bg-white w-11/12 md:max-w-md mx-auto rounded shadow-lg z-50 overflow-y-auto">
        <div class="modal-content py-4 text-left px-6">
          <!-- Título del modal -->
          <h3 class="text-2xl font-semibold">Agregar Curso</h3>

          <!-- Contenido del modal -->
          <!-- Aquí puedes agregar tus campos de entrada para la información del curso -->
          <!-- Por ejemplo: -->
          <div class="mt-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="cursoNombre">Nombre del Curso</label>
            <input v-model="nombreCurso" type="text" id="cursoNombre" class="w-full border rounded-lg px-3 py-2" />
          </div>

          <!-- Botones del modal -->
          <div class="mt-6 text-right">
            <button @click="showModal = false" class="text-gray-600 hover:text-gray-900 mr-2">
              Cancelar
            </button>
            <button @click="agregarCurso" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
              Guardar
            </button>
          </div>
        </div>
      </div>
    </div>
    </div>
    <section class="flex flex-row justify-center items-center">
      <div class="coursesContainer bg-blue-950 h-auto w-11/12 mt-10 rounded-md">
        <MainCourse v-for="(courses, index) in courses" :key="index" video-class="w-4/12 h-auto" class="m-10"/>
      </div>
    </section>
    

  </main>
</template>

<style scoped>
  #main{ 
    background-image: url("../assets/bg.jpg");
    background-size: cover;
    background-repeat: no-repeat; 
  }
</style>
