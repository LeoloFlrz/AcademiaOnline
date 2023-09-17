<script setup>
import MainNavbar from '../components/MainNavbar.vue';
import ApiConnection from '../services/ApiConnection';
import { ref } from 'vue'

const props = defineProps({
    showModal: {
        type: Boolean,
        default: true
    }
})

const course = ref({
  title: '',
  description: '',
  rating: ''
})

const addCourse = async () => {
  const newCourse = {
    ...course.value,
    user: {
      id: 1
    }
  }
}

</script>

<template>

    <div v-if="showModal" class="fixed inset-0 flex items-center justify-center z-50">
      <div class="modal-overlay absolute inset-0 bg-gray-500 opacity-75"></div>

      <div class="modal-container bg-white w-11/12 md:max-w-md mx-auto rounded shadow-lg z-50 overflow-y-auto">
        <div class="modal-content py-4 text-left px-6">
          <h3 class="text-2xl font-semibold">Agregar Curso</h3>
          <div class="mt-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="cursoNombre">Nombre del Curso</label>
            <input v-model="course.title" type="text" id="cursoNombre" class="w-full border rounded-lg px-3 py-2" />
          </div>

          <!-- Botones del modal -->
          <div class="mt-6 text-right">
            <button @click="showModal = false" class="text-gray-600 hover:text-gray-900 mr-2">
              Cancelar
            </button>
            <button @click="agregarCurso(newCourse)" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
              Guardar
            </button>
          </div>
        </div>
      </div>
    </div>
</template>

<style scoped>
</style>