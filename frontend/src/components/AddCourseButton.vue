<script setup>
import { defineProps } from 'vue'

const props = defineProps({
  buttonTitle: {
    type: String,
    Default: 'Inscríbete'
  },
  route: {
    type: String
  }
})
</script>

<template>
  <div>

      <button 
        
      class="font-semibold rounded-full bg-green-300 w-32 h-auto pt-1 pb-1 border-1 border-solid border-green-400 hover:bg-green-250 hover:border-none hover:scale-110 hover:transition-transform"
    >
      {{ props.buttonTitle }}
    </button>
    
    <!-- <router-link to="/add" type="button" class="font-semibold rounded-full bg-green-300 w-auto h-auto text-center pl-3 pr-3 pb-1 pt-1 border-1 border-solid border-green-400 hover:bg-green-250 hover:border-none hover:scale-110 hover:transition-transform" >{{ props.buttonTitle }}</router-link> -->
  </div>
</template>

<style scoped></style>
