<template>
  <div id ="details">
        <div class="heading">
          <h1 class="brewery-name" v-bind:key="brewery.id">{{brewery.name}}</h1>
        </div>

        <div class="address">
          <h2 class="brewery-address" v-bind:key="brewery.id">{{brewery.street}} {{brewery.city}}, {{brewery.state}}</h2>
        </div>

        <div class="phone">
            <h3 class="brewery-phone" v-bind:key="brewery.phone">Phone: {{brewery.phone}}</h3>
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
.details {
  color: darkgoldenrod;
}
.brewery-name {
    font-family: Ink Free;
    font-weight:900;
    color: darkgoldenrod;
    letter-spacing: 5px;
}
.brewery-address {
    font-family: Ink Free;
    color: darkgoldenrod;
}
.brewery-phone {
    font-family: Ink Free;
    color: darkgoldenrod;
}

</style>