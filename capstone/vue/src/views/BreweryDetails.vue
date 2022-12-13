<template>
<div>
<div class="breweryInfo" v-if="brewery.id">
<brewery-details v-bind:brewery="brewery" />
</div>

<h2>Beer's List</h2>
<p class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerName}}</p>
  
<div>
  <add-review/>
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
.beers-list{
  color: white;
  font-family: Ink Free;
}

</style>