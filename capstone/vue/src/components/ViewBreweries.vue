<template>

<div>
      <h2 id ="list">List of Breweries</h2>
      <div id = "brewery-list">
      <p v-on:click="goToBrewery(brewery)" v-for="brewery in breweries" v-bind:key="brewery.id">{{brewery.name}}</p>
</div>

<h2>Search for Breweries</h2>

<div class="searchDiv">
<div class="searchForm">
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
                  <button class="brewerySearch" v-on:click="getBreweries">Submit</button>
                
</div>

<div class="searchForm">
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
                  <button class="brewerySearch" v-on:click="getBreweries">Submit</button>
                
</div>

<div class="searchForm">
    <label for="brewerySearch" class="sr-only">State</label>
        <input
            id="breweryState"
            name="breweryState"
            type="text"
            className="form-control"
            required
            autofocus
            v-model="state"
                />
                    <button class="brewerySearch" v-on:click="getBreweries">Submit</button>
</div>

<div class="searchForm">
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
                  <button class="brewerySearch" v-on:click="getBreweries">Submit</button>
                
</div>
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
.brewerySearch {
  position:relative;
  background-color: darkgoldenrod;
  border: none;
  font-size: 20px;
  font-family: Ink Free;
  color: #FFFFFF;
  width: 75px;
  height: 25px;
  text-align: center;
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

.brewerySearch:after {
  content: "";
  background: black;
  display: block;
  position: absolute;
  padding-top: 300%;
  padding-left: 350%;
  margin-left: -20px!important;
  margin-top: -120%;
  opacity: 0;
  transition: all 1.8s
}

.brewerySearch:active:after {
  padding: 0;
  margin: 0;
  opacity: 5;
  transition: 0s
}
#breweryName {
    font-size: 18px;
    border: 2px solid grey;
    width: 15%;
    background: #f1f1f1;
}
#breweryCity {
    font-size: 18px;
    border: 2px solid grey;
    width: 15%;
    background: #f1f1f1;
}
#breweryState {
    font-size: 18px;
    border: 2px solid grey;
    width: 15%;
    background: #f1f1f1;
}
#breweryZip{
    font-size: 18px;
    border: 2px solid grey;
    width: 15%;
    background: #f1f1f1;
}
#brewery-list {
    font-size: 20px;
    font-family: Ink Free;
    font-weight: bold;
}
.sr-only {
    font-size: 20px;
    font-family: Ink Free;
    color: darkgoldenrod;
    font-weight:900;
    padding-top: 20px;
    padding-right: 10px;
    padding-bottom: 20px;
    padding-left: 10px; 
}

#list {
    color:white;
    text-decoration-line: underline;
    text-shadow: 0 0 3px darkgoldenrod, 0 0 5px darkgoldenrod;
}
</style>