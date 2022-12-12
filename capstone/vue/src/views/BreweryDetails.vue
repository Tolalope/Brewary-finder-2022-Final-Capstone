<template>
<div>
<p>{{brewery.name}}</p>
<p v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerName}}</p>
  <div v-if="brewery.id">
  <brewery-details v-bind:brewery="brewery" />
  </div>
  </div>
</template>

<script>
import BreweryDetails from '@/components/BreweryDetails.vue'
import BreweryService from '@/services/BreweryService.js'

export default {
  components: { 
      BreweryDetails 
      },
      data() {
        return {
          brewery: {},
          beers: {}
        }
      },
      created(){
        const breweryId = this.$route.params.id;
        BreweryService.getBreweryById(breweryId).then (
          (response) => {
            this.brewery = response.data;
           
          }
        )
        BreweryService.getBeers(breweryId).then (
          (response) => {
            this.beers = response.data;
          }
        )
      }
}
</script>

<style>

</style>