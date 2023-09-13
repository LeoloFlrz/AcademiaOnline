<script setup>
import MainNavbar from '../components/MainNavbar.vue';
import VideoContainer from '../components/VideoContainer.vue';

</script>

<template>
  <header>
    <MainNavbar />
  </header>

  <main>
    <div class="videoContainer">
      <VideoContainer/>
      <p class="flex justify-center w-25">Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis aliquid voluptate dicta quaerat ullam soluta adipisci inventore ducimus rerum, a assumenda perspiciatis nobis laborum, autem eaque amet reprehenderit illum eos?</p>
    </div>

    <section class="flex justify-center">
      <div class="coursesContainer bg-zinc-400 h-96 w-8/12 rounded-md">
        
      </div>
    </section>
    

  </main>
</template>

<style scoped>
</style>
