<template>
  <div id ="details">
        <div class="heading">
          <h1 class="brewery-name" v-bind:key="brewery.id">{{brewery.name}}</h1>
        </div>

        <div class="address">
          <h2 class="brewery-address" v-bind:key="brewery.id">{{brewery.street}} {{brewery.city}}, {{brewery.state}}</h2>
        </div>

        <div class="website">
            <a v-bind:href="brewery.url" target="_blank"><h3>{{brewery.url}}</h3></a>
        </div>

  </div>
</template>

<script>

export default {
    name: "brewery-details",
    data(){
        return {
            breweries: [],
            name: "",
            phone: "",
            url: "",
            street: "",
            city: "",
            state:""
        }
    },
    props: ["brewery"]
}
</script>

<style>

</style>