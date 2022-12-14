<template>
<div class="review-container">
    <form id ="review-form" v-on:submit.prevent="addNewReview">
        <h2 id="rating">RATE OUR BREWERY!</h2>
        <div class="form-description">
            <label id="leave-review" for="description">Leave a review:</label>
            <textarea id="description" v-model="newReview.description" placeholder="Write your review..."></textarea>
        </div>
        
        <div class="form-rating">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
            <option value="1">1 Stars</option>
            <option value="2">2 Stars</option>
            <option value="3">3 Stars</option>
            <option value="4">4 Stars</option>
            <option value="5">5 Stars</option>
        </select>
        </div>

        <button id="submit-button" type="submit">Submit</button>
        </form>
        <h1>Reviews</h1>
    <div
      class="review"
      v-for="review in reviews"
      v-bind:key="review.id"
    >
    {{review.rating}}-{{review.description}}
    </div>
</div>
</template>

<script>

import breweryService from "@/services/BreweryService.js";
export default {
    name: "Add-review",
    data() {
        return {
            errorMsg: "",
            newReview: {
                userId: "",
                beerId: "",
                beerName: "",
                breweryName: "",
                description: "",
                rating: 0
            },
            reviews: [

            ]
                
            
        }
        
    },
    methods: {
       /* getBeerIdFromBeerName(name) {
            return beerService.getBeerIdFromBeerName(name).then((response) => {
                const beerId = response.data;
                return beerId;
            });
        },
        getBreweryNameByBeerId(id) {
            return breweryService.getBreweryNameByBeerId(id).then((response) => {
                const breweryName = response.data;
                return breweryName;
            });
        },
        */
        addNewReview() {
            const userId = this.$store.state.user.id;
           // const beerId = this.$store.state.beer.beerId;
            const breweryId = this.$route.params.id;
           // const beerName = this.$store.state.beer.beerName;
            this.newReview.userId = userId;
          //  this.newReview.beerId = beerId;
            this.newReview.breweryId = breweryId;
           // this.newReview.beerName = beerName;
           // this.$store.commit("ADD_REVIEW", this.newReview);
            breweryService.createReview(this.newReview).then(() => {
                this.getReviews()
            }).catch(error => {
                if(error.response) {
                    this.errorMsg = error.response.statusText;
                } else if(error.request) {
                    this.errorMsg = "Unable to find the server";
                } else {
                    this.errorMsg = "Couldn't create the request";
                }
            });
            this.newReview = {};
        },
        getReviews() {
            breweryService.getReviewsByBreweryId(this.$route.params.id).then(
                (response) => {
                    this.reviews = response.data
                }
            )
        }
    }
}
</script>

<style>
.form-rating {
    display:inline;
    width: 200px;
    margin-left: auto;
    margin-right: auto;
    color: white;
}
.form-description {
    color: white;
    padding-bottom: 10px;
}
#description {
    height: 50px;
    width: 200px;
    margin-left: auto;
    margin-right: auto;
    border-radius: 5px;
    
}
#submit-button {
    width: 200px;
    height: 20px;
    justify-content: center;
}
.review-container {
  border-radius: 2px;
  padding: 20px;
  font-family: Ink Free;
}
#rating {
    height: 24px;
}

#submit-button{
  position:relative;
  background-color: darkgoldenrod;
  border: none;
  font-size: 15px;
  font-family: Ink Free;
  color: #FFFFFF;
  width: 75px;
  height: 24px;
  text-align: center;
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

#submit-button:after {
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

#submit-button:active:after {
  padding: 0;
  margin: 0;
  opacity: 5;
  transition: 0s
}
</style>