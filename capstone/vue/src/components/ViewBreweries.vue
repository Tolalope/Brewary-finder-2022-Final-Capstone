<template>

 <div>
      

      <h2>List of Breweries</h2>
      <div id = "brewery-list">
      <p v-for="brewery in breweries" v-bind:key="brewery.id">{{brewery.name}}</p>
      </div>


<div>
                <h2>Search for Breweries</h2>
                  <Label for="breweryName" class="sr-only">Brewery Name</Label>
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
                
                  <Label for="breweryZip" class="sr-only">Zip Code</Label>
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

                <div>
                
                  <Label for="breweryState" class="sr-only">State</Label>
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
                
                  <Label for="breweryCity" class="sr-only">City</Label>
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
        }



    },
    created(){
        this.viewBreweries(),
        this.getBreweries() 
        
    }


}
</script>

<style>

</style>