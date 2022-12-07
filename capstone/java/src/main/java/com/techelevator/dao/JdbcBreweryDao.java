package com.techelevator.dao;

import com.techelevator.model.Brewery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBreweryDao implements BreweryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcBreweryDao(JdbcTemplate jdbcTemplate){ this.jdbcTemplate = jdbcTemplate; }

    @Override
    public List<Brewery> listAll() {
        List<Brewery> breweries = new ArrayList<>();
        String sql = "SELECT  brewery_id, name, street, city, state, phone, url" +
                     "FROM breweries";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Brewery brewery = mapRowToBrewery(results);
            breweries.add(brewery);
        }
        return breweries;
    }
    @Override
    public void createBrewery(Brewery brewery) {
        String insertBrewerySql = "INSERT INTO breweries (brewery_id, name, street, city, state, phone, url " +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertBrewerySql,brewery.getId(), brewery.getName(), brewery.getStreet(),
                brewery.getCity(), brewery.getState(), brewery.getPhone(), brewery.getUrl());
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





