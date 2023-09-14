<script setup>
import MainButton from '../components/MainButton.vue';
import MainCourse from '../components/MainCourse.vue';
import MainNavbar from '../components/MainNavbar.vue';
import VideoContainer from '../components/VideoContainer.vue';

</script>

<template>
  <header>
    <MainNavbar />
  </header>

  <main>
    <div class="videoContainer flex flex-row">
      <VideoContainer class="w-10/12 h-auto"/>
      <p class="flex justify-center w-25">Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis aliquid voluptate dicta quaerat ullam soluta adipisci inventore ducimus rerum, a assumenda perspiciatis nobis laborum, autem eaque amet reprehenderit illum eos?</p>
    </div>

    <section class="flex flex-row justify-center items-center">
      <div class="buttonContainer flex flex-end">
        <MainButton button-title="Inscríbete"/>
      </div>
      
      <div class="coursesContainer bg-zinc-400 h-auto w-11/12 mt-10 rounded-md">
        <MainCourse video-class="w-96 h-auto" class=" m-10"/>
      </div>
    </section>
    

  </main>
</template>

<style scoped>
</style>
