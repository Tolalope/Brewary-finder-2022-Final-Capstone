<template>
  <div class="home">
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