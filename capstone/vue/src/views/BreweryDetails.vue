<template>
<div>
<div class="breweryInfo" v-if="brewery.id">
<brewery-details v-bind:brewery="brewery" />
</div>

<brewery-gallery />

<h2 id="beer-list-title">BEERS LIST</h2>

<table>

<tr>
  <td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerName}}</td>
</tr>

<tr>
  <td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId"><img class="beer-image" v-bind:src="beer.image"></td>
</tr>

<tr>
  <td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerType}}</td>
</tr>

<tr>
<td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId">ABV: {{beer.abv}}%</td>
</tr>

<tr>
  <td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerDescription}}</td>
</tr>

</table>



<div>
  <add-review/>
</div>


  </div>
</template>

<script>
import BreweryDetails from '@/components/BreweryDetails.vue'
import AddReview from '@/components/AddReview.vue'
import BreweryService from '@/services/BreweryService.js'
import BreweryGallery from '@/components/BreweryGallery.vue'


export default {
  components: { 
      BreweryDetails, 
      AddReview,
      BreweryGallery
   
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
  color: ghostwhite;
  font-family: Ink Free;
}

table, th, td {
  border: 1px solid;
  text-shadow: 2px 2px black;
  text-align:center;
}
table {
  background-color: rgb(116, 59, 6);
}
#beer-list-title {
  text-align: center;
  font-family: Ink Free;
  color: black;
  text-shadow: 0 0 3px red, 0 0 5px darkgoldenrod;
}

.beer-image{
  width: 100px;
}

</style>