package com.techelevator.dao;

import com.techelevator.model.Beers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcBeersDao implements BeersDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcBeersDao(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Beers> getAllBeers() {
        List<Beers> allBeers = new ArrayList<>();
        String sqlSelectAllBeers = "SELECT beer_id, beer_name, beer_description, image, abv, beer_type " +
                "FROM beers";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllBeers);

        while(results.next()) {
            allBeers.add(mapRowToBeers(results));
        }
        return allBeers;
    }

    @Override
    public Beers getBeersByName(String name) {
        Beers beer = new Beers();
        String sqlSelectBeerByName = "SELECT beer_id, beer_name, beer_description, image, abv, beer_type " +
                "FROM beers " +
                "WHERE beer_name = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectBeerByName, name);

        if(result.next()) {
            beer = mapRowToBeers(result);
        }
        return beer;
    }

    @Override
    public Beers getBeersById(int beerId) {
        Beers beer = new Beers();

        String sqlGetBeersById = "SELECT beer_id, beer_name, beer_description, image, abv, beer_type " +
                "FROM beers " +
                "WHERE beer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetBeersById, beerId);
        if(results.next()) {
            beer = mapRowToBeers(results);
        }
        return beer;
    }

    @Override
    public boolean searchForBeersByName(String name) {
        String sqlSearchForBeer = "SELECT beer_id, beer_name, beer_description, image, abv, beer_type " +
                "FROM beers " +
                "WHERE UPPER(beer_name) = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForBeer, name.toUpperCase());
        if(results.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void insertBeers(Beers newBeers) {
        String sqlAddBeer = "INSERT INTO beers(beer_name, beer_description, image, abv, beer_type) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sqlAddBeer, newBeers.getBeerName(), newBeers.getBeerDescription(), newBeers.getImage(), newBeers.getAbv(), newBeers.getBeerType());
    }

    @Override
    public List<Beers> getAllBeersByBrewery(int breweryId) {
        List<Beers> breweryBeerList = new ArrayList<>();
        String sqlSelectBeerByBrewery = "SELECT beer_id, beer_name, beer_description, image, abv, beer_type " +
                "FROM beers " +
                "JOIN breweries_beers ON breweries_beers.beer_id = beers.beer_id " +
                "WHERE brewery_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectBeerByBrewery, breweryId);

        while(results.next()) {
            breweryBeerList.add(mapRowToBeers(results));
        }
        return breweryBeerList;
    }

    @Override
    public void deleteBeers(int beerId) {
        String sqlDeleteBeer = "DELETE FROM beers " +
                "WHERE beer_id = ?";

        jdbcTemplate.update(sqlDeleteBeer, beerId);
    }

    private Beers mapRowToBeers(SqlRowSet row) {
        Beers newBeer = new Beers();

        newBeer.setBeerId(row.getInt("beer_id"));
        newBeer.setBeerName(row.getString("beer_name").toUpperCase());
        newBeer.setBeerDescription(row.getString("beer_description"));
        newBeer.setImage(row.getString("image"));
        newBeer.setAbv(row.getDouble("abv"));
        newBeer.setBeerType(row.getString("beer_type"));

        return newBeer;
    }
}
