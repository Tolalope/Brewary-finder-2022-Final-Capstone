<template>

 <div>
      

      <h2>View Breweries</h2>
      <p v-for="brewery in breweries" v-bind:key="brewery.id">{{brewery.name}}</p>


<div>
                
                  <Label for="breweryName" class="sr-only">Brewery Name</Label>
                  <input
                    id="breweryName"
                    name="breweryName"

                    type="text"
                    className="form-control"
                    required
                    autofocus
                  />
                  <button id="breweryName" type="submit">Submit</button>
                
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
                  />
                <button id="breweryState" type="submit">Submit</button>
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
                  />
                  <button id="breweryCity" type="submit">Submit</button>
                
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
            zip: ""
        }

        
    },
    methods: {
        getBreweries() {
            BreweryService.getBreweries(this.zip).then(
            (response) => {

                this.breweries = response.data
            } 
        )  
        }



    },
    created(){

        this.getBreweries() 
        
    }


}
</script>

<style>

</style>