package com.techelevator.controller;

import com.techelevator.API.BreweryAPI;
import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class BreweryController {
    @Autowired
    private BreweryDao breweryDao;
    @Autowired
    private UserDao userDao;

    /*
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Brewery> breweries() {
        return breweryDao.getAllBreweries();
    }

     */

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/search-breweries", method = RequestMethod.GET)
    public Brewery[] searchBreweries(@RequestParam(defaultValue = "", required = false) String zip,
                                     @RequestParam(defaultValue = "", required = false) String name,
                                     @RequestParam(defaultValue = "", required = false) String city,
                                     @RequestParam(defaultValue = "", required = false) String state) {
        BreweryAPI api = new BreweryAPI();
        return api.getBreweries(zip, name, city, state);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/add-brewery", method = RequestMethod.POST)
    public void addBrewery(@RequestBody @Valid Brewery newBrewery) {
        breweryDao.insertBrewery(newBrewery);
    }
}
