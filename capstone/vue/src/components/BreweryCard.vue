<template>
<router-link v-bind:to="{ name: 'brewery-details', params: {id : this.brewery.brewery.id} }">
  <div id ="brewery-card">
      <brewery-details>
  </div>
</template>

<script>
export default {
  name: 'brewery-card',

}
</script>

<style>

</style>