<template>
  <div class="beer-list">
    <h1> </h1>
    <table>
      <tbody>
        <tr v-for="review in sortedReviews" :key="review.id">
          <td class="id"></td>
          <td></td>
          <div id="beerimage">
          <td ><img :src="beer.image" /></td></div>
          <td id="beername">{{ beer.beerName }}</td>
          <td id="description">{{ beer.beerDescription }}</td>
          <td id="abv">{{ beer.abv }}% abv</td>
          <td>
            <button v-on:click.prevent="favoriteBeer(beer)" v-if="$store.state.user.role == 'ROLE_USER'">
              Add to Favorites
            </button>
            <button v-on:click.prevent="addReview(beer.beerId)" v-if="$store.state.user.role == 'ROLE_USER'">
              Add Review
            </button>
            <button v-on:click.prevent="deleteABeer(beer.beerId)" v-if="$store.state.user.role == 'ROLE_BREWER'">Remove Beer</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import applicationService from "../services/ApplicationService";
export default {
  data() {
    return {
      breweries: [],
      beers: [],
      beer: {
        beerId: "",
        breweryId: "",
          beerName: "",
          beerDescription: "",
          image: "",
          beerType: "",
          abv: "",
          
      },
      
    };
  },
  name: "breweries-list",
  methods: {
    viewBrewery(id) {
      this.$router.push(`/breweries/${id}`);
    },
    deleteABeer(id) {
      if (
        confirm(
          "Are you sure you want to delete this brewery and all associated information? This action cannot be undone."
        )
      ) {
        applicationService
          .deleteBeer(id)
          .then((response) => {
            if (response.status === 200) {
              alert("Beer successfully deleted");
              this.getBeers();
               this.$store.commit("DELETE_BEER", id);
            }
          })
          .catch((error) => {
            if (error.response.status === 404) {
              this.$router.push("/404");
            } else {
              console.error(error);
            }
          });
      }
    },
    getBeers() {
      applicationService
        .getBeer()
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_BEERS", response.data);
            this.beers = response.data;
          }
        })
        .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
    },
    getBeersByBreweryId() {
      applicationService
        .getBeerByBreweryId(this.$store.state.activeBrewery.id)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_BEERS", response.data);
            this.beers = response.data;
          }
        })
        .catch((error) => {
          if (error.response.status === 404) {
            this.$router.push("/404");
          } else {
            console.error(error);
          }
        });
    },
    addReview(id){
      applicationService.getBeerById(id)
      .then((response) => {
        if (response.status == 200) {
            this.$store.commit("SET_ACTIVE_BEER", response.data);
            this.beer = response.data;
            this.$router.push({name: "reviewform"});
      }
      });
    },
    favoriteBeer(name){
      this.$store.commit("SET_FAVORITES", name);
    }
  },
  created() {
    this.getBeersByBreweryId();
  },
  computed: {
    sortedBeers() {
      return this.$store.state.beers;
    },
  },
};
</script>

<style scoped>
#beer-list {
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