<script setup>
import MainCourse from "../components/MainCourse.vue";
import MainNavbar from "../components/MainNavbar.vue";
import MainFooter from '../components/MainFooter.vue'
import ApiConnection from "../services/ApiConnection.js";
import { ref, onBeforeMount } from "vue";

const courses = ref([]);

const getCourses = async () => {
  let response = await ApiConnection.getAllCourses();
  console.log(response.data);
  courses.value = response.data;
  console.log(courses.value);
};

onBeforeMount(() => {
  getCourses();
});
</script>

<template>
  <body id="main" class="min-h-screen flex flex-col">
    <header>
      <MainNavbar />
    </header>

    <!-- <div >
        <div v-for="course in courses" :key="course.id">       
            <MainCourse :title="course.title" :description="course.description" :rating="course.rating" video-class="w-4/12 h-auto" class="m-10 bg-blue-950 mt-10"/>
        </div>
    </div> -->
    <main class="flex-grow">
      <table class="table table-hover m-10 bg-blue-950 mt-10">
        <thead>
          <tr>
            <th scope="col">Título</th>
            <th scope="col">Descripción</th>
            <th scope="col">Puntuación</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="course in courses" :key="course.id">
            <!-- <MainCourse /> -->
            <th scope="row">{{ course.title }}</th>
            <td>{{ course.description }}</td>
            <td>{{ course.dueDate }}</td>
            <td>
              <div class="button-group">
                <a class="btn btn-primary" :href="`/update/${course.id}`"
                  >Edit</a
                >
                <button
                  class="btn btn-danger mx-2"
                  @click="deleteTask(course.id)"
                >
                  Delete
                </button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </main>

    <footer  class="mt-auto">
        <MainFooter />
    </footer>
</body>
</template>

<style scoped>

body {
    min-height: 100vh;
  background-image: url("../assets/bg.jpg");
  background-size: cover;
  background-repeat: no-repeat;
}
</style>
