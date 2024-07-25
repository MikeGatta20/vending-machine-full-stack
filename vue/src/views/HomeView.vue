<template>
  <div class="home">
    <h1>Home</h1>
    <!-- <p>You must be authenticated to see this</p> -->
    <VendingMachine/> 
  </div>
</template>

<script>
import VendingMachine from '../components/VendingMachine.vue';

export default {
  components : {
    VendingMachine 
  }

};
</script>
