package com.techelevator.API;

import com.techelevator.model.Brewery;
import org.jboss.logging.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class BreweryAPI {

    private static final String API_BASE_URL = "https://api.openbrewerydb.org/";
    private final RestTemplate restTemplate = new RestTemplate();


    public Brewery[] listBreweries() {
        Brewery[] Breweries = null;
        try {
            Breweries = restTemplate.getForObject(API_BASE_URL + "Breweries", Brewery[].class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
        return Breweries;
    }
}