<template>
  <div class="review-list">
    <h1>Reviews</h1>
    <div
      class="review"
      v-for="review in $store.state.reviews"
      v-bind:key="review.id"
    >
    </div>
  <h4>{{ review.reviewer }}</h4>
      <div class="rating">
       {{review.rating}}
        
      </div>
      <h3>{{ review.description }}</h3>

  </div>
</template>

<script>
export default {
  name: 'reviews',
  data() {
      
    }
  };

</script>

<style scoped>
#review-list {
  display: flex;
  justify-content: space-evenly;
}
html {
  background-color: darkgoldenrod;
}
table {
  display: flex;
  justify-content: space-evenly;
}
thead {
  font-size: 20px;
  word-spacing: 50%;
  text-align: left;
}
#beername {
  font-size: 30px;
  color: #000;
  font-weight: 700;
  font-style: italic;
  text-decoration: underline;
}
#description {
  font-size: 20px;
  color: black;
  font-weight: 700;
  text-align: left;
  padding-left: 5%;
  padding-right: 5%;
  font-style: italic;
  max-width: 57vw;
}
#abv {
  font-size: 25px;
  color: black;
  font-weight: 700;
  text-decoration: underline;
  text-align: left;
  transform: translate(-1vw);
  
}
h1 {
  color: black;
  margin-left: 130px;
  padding-top: 2%;
}
img {
  max-height: 50vh;
  max-width: 15vw;
  height: 100%;
}
button {
  border: 7px solid rgba(255, 255, 255, 0.1);
  box-shadow: 0px 0px 20px rgba(8, 7, 16, 0.6);
  color: darkgoldenrod;
  font-size: 110%;
  background-color: black;
  cursor: pointer;
  margin-top: -4.5vh;
}
</style>