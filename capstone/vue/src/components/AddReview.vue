<template>
    <form id ="review-form" v-on:submit.prevent="addNewReview">
        <div class="form-rating">
        <label for="rating">Rating</label>
        <select id="rating" v-model.number="newReview.rating">
            <option value="1">1 Stars</option>
            <option value="2">2 Stars</option>
            <option value="3">3 Stars</option>
            <option value="4">4 Stars</option>
            <option value="5">5 Stars</option>
        </select>
        </div>

        <div class="form-description">
            <label for="beer-description">How's the Beer ?</label>
            <textarea id ="beer-description" v-model="newReview.description"></textarea>
        </div>

        <button id="submit-button" type="submit">Submit</button>
        </form>
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
            }
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
            const userId = this.$store.state.user.userId;
            const beerId = this.$store.state.beer.beerId;
            const breweryName = this.$store.state.brewery.name;
            const beerName = this.$store.state.beer.beerName;
            this.newReview.userId = userId;
            this.newReview.beerId = beerId;
            this.newReview.breweryName = breweryName;
            this.newReview.beerName = beerName;
            this.$store.commit("ADD_REVIEW", this.newReview);
            breweryService.createReview(this.newReview).then(() => {
                alert("Review Created")
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
        }
    }
}
</script>

<style>
.form-rating {
    display:flex;
    width: 200px;
    margin-left: auto;
    margin-right: auto;
    color: white;
}
.form-description {
    color: white;
}
#beer-description {
    height: 150px;
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
</style>