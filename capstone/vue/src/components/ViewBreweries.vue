<template>
  <div>
      <h2>View Breweries</h2>
      <p v-for="brewery in breweries" v-bind:key="brewery.id">{{brewery.name}}</p>
  </div>
</template>

<script>
import BreweryService from '@/services/BreweryService.js'

export default {
    name: "view-breweries",
    data(){
        return {
            breweries: []
        }
    },
    created(){

        BreweryService.getBreweries("14202").then(
            (response) => {

                this.breweries = response.data
            } 
        )

    }
}
</script>

<style>

</style>