package com.techelevator.API;

import com.techelevator.model.Brewery;
import org.jboss.logging.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class BreweryAPI {

    private static final String API_BASE_URL = "https://api.openbrewerydb.org/";
    private final RestTemplate restTemplate = new RestTemplate();


    public Brewery[] getBreweries(String zip) {
        Brewery[] Breweries = null;
        try {
            String url = API_BASE_URL + "breweries?";
            if (zip.length() > 0) {
                url += "by_postal=" + zip;
            }
            Breweries = restTemplate.getForObject(url, Brewery[].class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
        return Breweries;
    }
}