<template>
  <div class="home">
    <h1>Home</h1>
    <view-breweries/>
  </div>
</template>

<script>
import ViewBreweries from '@/components/ViewBreweries.vue'


export default {
  name: "home",
  components: {
    ViewBreweries
  }
};
</script>

<style>
.home {
  color: whitesmoke;
}

</style>