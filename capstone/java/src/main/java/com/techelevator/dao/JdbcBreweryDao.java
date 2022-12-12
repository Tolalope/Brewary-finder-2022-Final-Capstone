package com.techelevator.dao;

import com.techelevator.model.Brewery;
import com.techelevator.model.Beers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

    private BeersDao beersDao;

    @Override
    public List<Brewery> getAllBreweries() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT brewery_id, name, street, city, state, phone, url " +
                     "FROM breweries";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }
    @Override
    public void insertBrewery(Brewery brewery) {
        String insertBrewerySql = "INSERT INTO breweries (name, street, city, state, phone, url " +
                "VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING brewery_id";
        Integer newBreweryId;
        newBreweryId = jdbcTemplate.queryForObject(insertBrewerySql, Integer.class, brewery.getId(), brewery.getName(), brewery.getStreet(),
                brewery.getCity(), brewery.getState(), brewery.getPhone(), brewery.getUrl());

        List <Beers> beersList = new ArrayList<>();
        beersList = beersDao.getAllBeers();

        for(Beers beer : beersList) {
            beersDao.insertBeersToBrewery(newBreweryId, beer.getBeerId());
        }
    }

    @Override
    public void updateBrewery(Brewery brewery) {
        String updateBrewerySql = "UPDATE breweries " +
                "SET name = ?, street = ?, city = ?, state = ?, phone = ?, url = ? " +
                "WHERE brewery_id = ?";
        jdbcTemplate.update(updateBrewerySql, brewery.getName(), brewery.getStreet(), brewery.getCity(), brewery.getState(), brewery.getPhone(), brewery.getUrl());

    }

    @Override
    public boolean searchForBrewery(String name) {
        String searchForBrewerySql = "SELECT brewery_id, name, street, city, state, phone, url" +
                "FROM breweries " +
                "WHERE name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(searchForBrewerySql, name);
        if(results.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Brewery getBreweryById(int id) {
        Brewery brewery = new Brewery();
        String getBreweryByIdSql = "SELECT brewery_id, name, street, city, state, phone, url " +
                "FROM breweries " +
                "WHERE brewery_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(getBreweryByIdSql, id);
        if(results.next()) {
            brewery = mapRowToBrewery(results);
        }

        return brewery;
    }

    @Override
    public Brewery getBreweryByName(String name) {
        Brewery brewery = new Brewery();
        String getBreweryByNameSql = "SELECT brewery_id, name, street, city, state, phone, url " +
                "WHERE name = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(getBreweryByNameSql, name);
        if(results.next()) {
            brewery = mapRowToBrewery(results);
        }
        return brewery;
    }


    private Brewery mapRowToBrewery(SqlRowSet results) {
        Brewery brewery = new Brewery();
        brewery.setId(results.getString("brewery_id"));
        brewery.setName(results.getString("name"));
        brewery.setStreet(results.getString("street"));
        brewery.setCity(results.getString("city"));
        brewery.setState(results.getString("state"));
        brewery.setPhone(results.getString("phone"));
        brewery.setUrl(results.getString("url"));

        return brewery;
    }

}





