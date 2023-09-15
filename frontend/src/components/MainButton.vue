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
        :href="route"
      class="font-semibold rounded-full bg-green-300 w-32 h-auto pt-1 pb-1 border-1 border-solid border-green-400 hover:bg-green-250 hover:border-none hover:scale-110 hover:transition-transform"
    >
      {{ props.buttonTitle }}
    </button>
  </div>
</template>

<style scoped></style>
