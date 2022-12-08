import axios from 'axios';

export default {

  getBreweries(zip) {
    return axios.get('/searchBreweries?zip=' + zip)
  },

  

}
