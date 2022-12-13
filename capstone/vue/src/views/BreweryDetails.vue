<template>
<div>
<p >{{brewery.name}}</p>
<p class="brewaryName" v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerName}}</p>
  <div v-if="brewery.id">
  <brewery-details v-bind:brewery="brewery" />
  <div>
<add-review/>

    </div>
  </div>
  </div>
</template>

<script>
import BreweryDetails from '@/components/BreweryDetails.vue'
import AddReview from '@/components/AddReview.vue'
import BreweryService from '@/services/BreweryService.js'


export default {
  components: { 
      BreweryDetails, AddReview
   
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
.brewaryName{
  color:whitesmoke;
}

</style>