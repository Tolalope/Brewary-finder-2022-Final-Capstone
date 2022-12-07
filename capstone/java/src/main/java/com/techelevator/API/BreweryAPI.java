package com.techelevator.API;

import com.techelevator.model.Brewery;
import org.jboss.logging.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class BreweryAPI {

    private static final String API_BASE_URL = "http://localhost:9000/";
    private final RestTemplate restTemplate = new RestTemplate();


    public Brewery[] getBreweries() {
        Brewery[] Breweries = null;
        try {
            Breweries = restTemplate.getForObject(API_BASE_URL + "breweries", Brewery[].class);
        } catch (RestClientResponseException | ResourceAccessException e) {

        }
        return Breweries;
    }
}