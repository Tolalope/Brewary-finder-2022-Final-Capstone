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
        String sqlSelectAllBeers = "SELECT * FROM beers LEFT JOIN (SELECT beer_id, AVG(rating)AS avg_rating FROM reviews GROUP BY beer_id) AS rating " +
                "ON rating.beer_id = beers.beer_id WHERE name =? GROUP BY beers.beer_id, avg_rating ORDER BY name ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllBeers, true);

        while(results.next()) {
            allBeers.add(mapRowToBeers(results));
        }
        return allBeers;
    }

    @Override
    public Beers getBeersByName(String name) {
        Beers newBeers = new Beers();
        String sqlSelectBeerByName = "SELECT * FROM beers LEFT JOIN (SELECT beer_id, AVG(rating)AS avg_rating FROM reviews GROUP BY beer_id)AS rating " +
                "ON rating.beer_id = beers.beer_id WHERE name =? GROUP BY beers.beer_id, rating.beer_id, avg_rating ORDER BY name";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectBeerByName, name, true);

        if(result.next()) {
            newBeers = mapRowToBeers(result);
        }
        return newBeers;    }

    @Override
    public List<Beers> getBeersByBrewery(int breweryId) {
        List<Beers> breweryBeerList = new ArrayList<>();
        String sqlSelectBeerByBrewery = "SELECT * FROM beers LEFT JOIN (SELECT beer_id, AVG(rating)AS avg_rating FROM reviews GROUP BY beer_id)AS rating " +
                "ON rating.beer_id = beers.beer_id WHERE brewery_id = ? GROUP BY beers.beer_id, rating.beer_id, avg_rating ORDER BY name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectBeerByBrewery, breweryId, true);
        while(results.next()) {
            breweryBeerList.add(mapRowToBeers(results));
        }
        return breweryBeerList;    }

    @Override
    public Beers getBeersById(int beerId) {
        Beers beer = null;

        String sqlgetBeersById = "SELECT * FROM beers LEFT JOIN (SELECT beer_id, AVG(rating)AS avg_rating FROM reviews GROUP BY beer_id)AS rating " +
                "ON rating.beer_id = beers.beer_id WHERE beers.beer_id =? GROUP BY beers.beer_id, rating.beer_id, avg_rating ORDER BY name";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sqlgetBeersById, beerId, true);
        while(result.next()) {
            beer = mapRowToBeers(result);
        }
        return beer;    }

    @Override
    public boolean searchForBeersByName(String name) {
        String sqlSearchForBeer = "SELECT * FROM beers LEFT JOIN (SELECT beer_id, AVG(rating)AS avg_rating FROM reviews GROUP BY beer_id)AS rating " +
                "ON rating.beer_id = beers.beer_id WHERE UPPER(name) = ? GROUP BY beers.beer_id, rating.beer_id, avg_rating ORDER BY name";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForBeer, name.toUpperCase());
        if(results.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void saveBeers(Beers newBeers) {
        jdbcTemplate.update("INSERT INTO beers(name, abv, ibu, type, info, img_url, brewery_id, is_active) VALUES (?,?,?,?,?,?,?,?)",
                newBeers.getBeerName(), newBeers.getAbv(), newBeers.getBeerType(), newBeers.getBeerDescription(), newBeers.getImage(), newBeers.getBreweryId());
    }

    @Override
    public List<Beers> getAllBeersByBrewery(int breweryId) {
        List<Beers> breweryBeerList = new ArrayList<>();
        String sqlSelectBeerByBrewery = "SELECT * FROM beers LEFT JOIN (SELECT beer_id, AVG(rating)AS avg_rating FROM reviews GROUP BY beer_id)AS rating " +
                "ON rating.beer_id = beers.beer_id WHERE brewery_id = ? GROUP BY beers.beer_id, rating.beer_id, avg_rating ORDER BY name";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectBeerByBrewery, breweryId);

        while(results.next()) {
            breweryBeerList.add(mapRowToBeers(results));
        }
        return breweryBeerList;    }

    @Override
    public void removeBeers(int beerId) {
        jdbcTemplate.update("DELETE FROM beers WHERE beer_id = ?", beerId);
    }

    private Beers mapRowToBeers(SqlRowSet row) {
        Beers newBeer = new Beers();

        newBeer.setBeerId(row.getInt("beer_id"));
        newBeer.setBeerName(row.getString("beer_name").toUpperCase());
        newBeer.setAbv(row.getDouble("abv"));
        newBeer.setBeerType(row.getString("beer_type"));
        newBeer.setBeerDescription(row.getString("beer_description"));
        newBeer.setImage(row.getString("image"));
        newBeer.setBreweryId(row.getInt("brewery_id"));

        return newBeer;
    }
}
