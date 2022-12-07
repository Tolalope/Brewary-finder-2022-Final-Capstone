package com.techelevator.dao;

import com.techelevator.model.Beers;

import java.util.List;

public interface BeersDao {
    public List<Beers> getAllBeers();
    public Beers getBeersByName(String name);
    public List<Beers> getBeersByBrewery(int breweryId);
    public Beers getBeersById(int beerId);
    public boolean searchForBeersByName(String name);
    public void saveBeers(Beers newBeers);
    public List<Beers> getAllBeersByBrewery(int breweryId);
    public void removeBeers(int beerId);
}