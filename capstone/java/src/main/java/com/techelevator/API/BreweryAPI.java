package com.techelevator.API;

import com.techelevator.model.Brewery;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class BreweryAPI {

    private static final String API_BASE_URL = "https://api.openbrewerydb.org/";
    private final RestTemplate restTemplate = new RestTemplate();


    public Brewery[] getBreweries(String zip, String name, String city, String state) {
        Brewery[] Breweries = null;
        try {
            String url = API_BASE_URL + "breweries?";
            if (zip.length() > 0) {
                url += "by_postal=" + zip;
            }
            if (name.length() > 0) {
                url += "by_name=" + name;
            }
            if (city.length() > 0) {
                url += "by_city=" + city;
            }
            if (state.length() > 0) {
                url += "by_state=" + state;
            }
            Breweries = restTemplate.getForObject(url, Brewery[].class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
        return Breweries;
    }
}