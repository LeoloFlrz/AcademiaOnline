<script setup>
import MainCourse from "../components/MainCourse.vue";
import MainNavbar from "../components/MainNavbar.vue";
import VideoContainer from "../components/VideoContainer.vue";
import { ref, onBeforeMount } from "vue";
import ApiConnection from "../services/ApiConnection";
import AddCourseButton from "../components/AddCourseButton.vue";
import MainFooter from "../components/MainFooter.vue";

const props = defineProps({
  showModal: {
    type: Boolean,
    default: false,
  },
});

const courses = ref([]);
const courseId = ref();
const courseTitle = ref();
const courseDescription = ref();
const courseRating = ref();

const newCourse = ref({
  "user": {
    "id": 6,
    "username": "leolo",
    "password": "admin",
    "email": "leolo@leolo.com",
  },
  "title": "",
  "description": "",
  "rating": 1,
});

const getCourses = async () => {
  let response = await ApiConnection.getAllCourses();
  courses.value = response.data;
  console.log(courses.value);
  courseTitle.value = courses.value[0].title;
  courseId.value = courses.value[0].id;
  courseDescription.value = courses.value[0].description;
  courseRating.value = courses.value[0].rating;
};

const addCourse = async () => {
  try {
    const response = await ApiConnection.addCourse(newCourse);
    if (response.status === 201) {
      alert("Curso añadido correctamente");
      showModal.value = false;
      console.log(newCourse);
    } else {
      alert("Error al añadir el curso");
      console.log(newCourse);
    }
  } catch (error) {
    return alert("No se añadió el curso: " + error.message);
  }
};

onBeforeMount(() => {
  getCourses();
});
</script>

<template>
  <body>
    <header>
    <MainNavbar />
  </header>

  <main id="main">
    <div class="videoContainer flex flex-col items-center">
      <VideoContainer class="w-5/12 h-4/12 mb-10" />
      <p class="flex text-white justify-center w-6/12 text-justify">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis
        aliquid voluptate dicta quaerat ullam soluta adipisci inventore ducimus
        rerum, a assumenda perspiciatis nobis laborum, autem eaque amet
        reprehenderit illum eos?
      </p>
    </div>
    <div class="buttonContainer flex justify-end mr-20 pt-5">
      <AddCourseButton button-title="Añadir Curso" @click="showModal = true" />
      <!-- <AddCourseModal v-if="showModal"/> -->
      <div
        v-if="showModal"
        class="fixed inset-0 flex items-center justify-center z-50"
      >
        <div
          v-if="showModal"
          class="modal-overlay absolute inset-0 bg-gray-500 opacity-75"
        ></div>

        <div
          class="modal-container bg-white w-11/12 md:max-w-md mx-auto rounded shadow-lg z-50 overflow-y-auto"
        >
          <div class="modal-content py-4 text-left px-6">
            <h3 class="text-2xl font-semibold">Agregar Curso</h3>
            <div class="mt-4">
              <label
                class="block text-gray-700 text-sm font-bold mb-2"
                for="cursoNombre"
                >Nombre del Curso</label
              >
              <input
                v-model="newCourse.title"
                type="text"
                id="cursoNombre"
                class="w-full border rounded-lg px-3 py-2"
              />
            </div>
            <div class="mt-4">
              <label
                class="block text-gray-700 text-sm font-bold mb-2"
                for="cursoNombre"
                >Descripción</label
              >
              <input
                v-model="newCourse.description"
                type="text"
                id="cursoNombre"
                class="w-full border rounded-lg px-3 py-2"
              />
            </div>
            <div class="mt-4">
              <label
                class="block text-gray-700 text-sm font-bold mb-2"
                for="cursoNombre"
                >Puntuación</label
              >
              <input
                v-model="newCourse.rating"
                type="number"
                id="cursoNombre"
                class="w-full border rounded-lg px-3 py-2"
              />
            </div>
            <div class="mt-6 text-right">
              <button
                @click="showModal = false"
                class="text-gray-600 hover:text-gray-900 mr-2"
              >
                Cancelar
              </button>
              <button
                @click="addCourse()"
                class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
              >
                Guardar
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <section class="flex flex-row justify-center items-center">
      <div class="coursesContainer bg-blue-950 h-auto w-11/12 mt-10 rounded-md">
        <MainCourse
          delete-button="hidden"
          :title="course.title"
          :description="course.description"
          :rating="course.rating"
          v-for="course in courses"
          :key="course.id"
          video-class="w-4/12 h-auto"
          class="m-10"
        />
      </div>
    </section>
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
