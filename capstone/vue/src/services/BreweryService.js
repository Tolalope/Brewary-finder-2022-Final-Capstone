import axios from 'axios';

export default {

  viewBreweries(){
    return axios.get('/search-breweries')
  },
  getBreweries(zip, name, city, state) {
    if(zip.length > 0) {
    return axios.get('/search-breweries?zip=' + zip)
    }
    if(name.length > 0) {
    return axios.get('/search-breweries?name=' + name)
    }
    if(city.length > 0) {
    return axios.get('/search-breweries?city=' + city)
    }
    if(state.length >0) {
    return axios.get('/search-breweries?state=' + state)
    }
  },
  saveBrewery(brewery) {
    return axios.post('/add-brewery', brewery)
  },
  getBreweryById(id) {
    return axios.get('/breweries/' + id)
  },
  getBeers(id) {
    return axios.get('breweries/' + id + '/beers')
  },
  createReview(newReview) {
    return axios.post("/reviews", newReview)
  },
  getReviewsByBreweryId(breweryId) {
    return axios.get("/brewery/reviews/" + breweryId)
  }
  
}
