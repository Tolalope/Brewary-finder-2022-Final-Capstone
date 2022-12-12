<template>

 <div>
      <h2>List of Breweries</h2>
      <div id = "brewery-list">
      <p v-on:click="goToBrewery(brewery)" v-for="brewery in breweries" v-bind:key="brewery.id">{{brewery.name}}</p>
      </div>
<div>
                <h2>Search for Breweries</h2>
                  <label for="breweryName" class="sr-only">Brewery Name</label>
                  <input
                    id="breweryName"
                    name="breweryName"

                    type="text"
                    className="form-control"
                    required
                    autofocus
                    v-model="name"
                  />
                  <button id="breweryName" v-on:click="getBreweries">Submit</button>
                
                </div>

                <div>
                
                  <label for="breweryCity" class="sr-only">City</label>
                  <input
                    id="breweryCity"
                    name="breweryCity"
                    type="text"
                    className="form-control"
                    required
                    autofocus
                    v-model="city"
                  />
                  <button id="breweryCity" v-on:click="getBreweries">Submit</button>
                
                </div>

                <div>
                
                  <label for="breweryState" class="sr-only">State</label>
                  <input
                    id="breweryState"
                    name="breweryState"
                     type="text"
                    className="form-control"
                    required
                    autofocus
                    v-model="state"
                  />
                <button id="breweryState" v-on:click="getBreweries">Submit</button>
                </div>

                <div>
                
                  <label for="breweryZip" class="sr-only">Zip Code</label>
                  <input
                    id="breweryZip"
                    name="breweryZip"
                    type="text"
                    className="form-control"
                    required
                    autofocus
                    v-model="zip"
                  />
                  <button id="breweryZip" v-on:click="getBreweries">Submit</button>
                
                </div>

      
  </div>

</template>
  


<script>
import BreweryService from '@/services/BreweryService.js'

export default {
    name: "view-breweries",
    data(){
        return {
            breweries: [],
            zip: "",
            name: "",
            city: "",
            state: ""
        }

        
    },
    methods: {
        viewBreweries() {
            BreweryService.viewBreweries().then(
            (response) => {

                this.breweries = response.data
            } 
        )  
        },

        getBreweries() {
            BreweryService.getBreweries(this.zip, this.name, this.city, this.state).then(
            (response) => {

                this.breweries = response.data
            } 
        )  
        },

        goToBrewery(brewery) {
            BreweryService.saveBrewery(brewery).then(
              (response) => {

                this.$router.push({name: 'brewery-details', params: {id : response.data.id}})
            }   
            )

        }



    },
    created(){
        this.viewBreweries()  
    }


}
</script>

<style>

</style>