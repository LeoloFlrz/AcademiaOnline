<script setup>
import MainCourse from "../components/MainCourse.vue";
import MainNavbar from "../components/MainNavbar.vue";
import MainFooter from "../components/MainFooter.vue";
import ApiConnection from "../services/ApiConnection.js";
import { ref, onBeforeMount } from "vue";
import DeleteButton from "../components/DeleteButton.vue";

const courses = ref([]);

const getCourses = async () => {
  let response = await ApiConnection.getAllCourses();
  courses.value = response.data;
};

const deleteCourseById = async (id) => {
    let response = await ApiConnection.deleteCourseById(id)
    if(response.status === 200) {
        alert("Course successfully deleted")
        location.reload()
    } else {
        alert("Cannot delete the course")
    }
}

onBeforeMount(() => {
  getCourses();
});
</script>

<template>
  <body id="main" class="min-h-screen flex flex-col">
    <header>
      <MainNavbar />
    </header>
    <main class="flex-grow">
      <table
        class="w-11/12 text-md bg-white shadow-md rounded mb-4 ml-10 mt-20"
      >
        <tbody>
          <tr class="border-b">
            <th class="text-left p-3 px-5">Título</th>
            <th class="text-left p-3 px-5">Descripcion</th>
            <th class="text-left p-3 px-5">Puntuación</th>
            <th></th>
          </tr>
          <!-- <tr class="border-b hover:bg-orange-100 bg-gray-100"> -->
          <tr v-for="course in courses" :key="course.id">
            <td class="p-3 px-5">{{ course.title }}</td>
            <td class="p-3 px-5">{{ course.description }}</td>
            <td class="p-3 px-5">{{ course.rating }}</td>
            <td class="p-3 px-5 flex justify-end">
              <div class="buttonsContainer">
                <button
                  class="mr-3 text-sm bg-blue-500 hover:bg-blue-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline"
                >
                  Editar
                </button>
                <button
                    
                  @click="deleteCourseById(course.id)"
                  class="text-sm bg-red-500 hover:bg-red-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline"
                >
                  Borrar
            </button>
              </div>
            </td>
            <!-- <button type="button" class="mr-3 text-sm bg-blue-500 hover:bg-blue-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline">Save</button><button type="button" class="text-sm bg-red-500 hover:bg-red-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline">Delete</button> -->
          </tr>
        </tbody>
      </table>

      <!-- <table class="table table-fixed rounded table-hover m-10 bg-blue-950 mt-10 text-white w-11/12 ">
        <div id="tableContent" class="m-5 flex flex flex-col">
          <thead>
            <tr class="">
              <th scope="col">Título</th>
              <th scope="col">Descripción</th>
              <th scope="col">Puntuación</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody class="divide-y divide-gray-200">
            <tr v-for="course in courses" :key="course.id">
              <th scope="row">{{ course.title }}</th>
              <td>{{ course.description }}</td>
              <td>{{ course.rating }}</td>
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
        </div>
      </table> -->
    </main>

    <footer class="mt-auto">
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
