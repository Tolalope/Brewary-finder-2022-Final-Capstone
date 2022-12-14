<template>
<div>
<div class="breweryInfo" v-if="brewery.id">
<brewery-details v-bind:brewery="brewery" />
</div>

<h2 id="beer-list-title">BEERS LIST</h2>

<table>

<tr>
  <td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId">{{beer.beerName}}</td>
</tr>

<tr>
  <td class="beers-list" v-for="beer in beers" v-bind:key="beer.beerId"><img src="beer.image"></td>
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
  color: ghostwhite;
  font-family: Ink Free;
}

table, th, td {
  border: 1px solid;
  text-shadow: 2px 2px black;
  text-align:center;
}
table:hover {
  background-color: rgb(116, 59, 6);
}
#beer-list-title {
  text-align: center;
}


</style>