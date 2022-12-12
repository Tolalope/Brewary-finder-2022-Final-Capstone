package com.techelevator.dao;

import com.techelevator.model.Beers;
import com.techelevator.model.Brewery;

import java.util.List;

public interface BeersDao {
    public List<Beers> getAllBeers();
    public Beers getBeersByName(String name);
    public Beers getBeersById(int beerId);
    public boolean searchForBeersByName(String name);
    public void insertBeers(Beers newBeers);
    public void insertBeersToBrewery(int breweryId, int beerId);
    public List<Beers> getAllBeersByBrewery(int breweryId);
    public void deleteBeers(int beerId);
}