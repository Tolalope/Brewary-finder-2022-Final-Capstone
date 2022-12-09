import axios from 'axios';

export default {

  viewBreweries(){
    return axios.get('/searchBreweries')
  },
  getBreweries(zip, name, city, state) {
    if(zip.length > 0) {
    return axios.get('/searchBreweries?zip=' + zip)
    }
    if(name.length > 0) {
    return axios.get('/searchBreweries?name=' + name)
    }
    if(city.length > 0) {
    return axios.get('/searchBreweries?city=' + city)
    }
    if(state.length >0) {
    return axios.get('/searchBreweries?state=' + state)
    }
  },
  
}
