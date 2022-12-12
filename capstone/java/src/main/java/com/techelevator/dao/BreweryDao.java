package com.techelevator.dao;

import com.techelevator.model.Brewery;

import java.util.List;

public interface BreweryDao {
    public List<Brewery> getAllBreweries();

    public void insertBrewery(Brewery brewery);

    public void updateBrewery(Brewery brewery);

    public boolean searchForBrewery(String name);

    public Brewery getBreweryById(int id);

    public Brewery getBreweryByName(String name);


}
