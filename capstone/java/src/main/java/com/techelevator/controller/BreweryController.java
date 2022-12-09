package com.techelevator.controller;

import com.techelevator.API.BreweryAPI;
import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Brewery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class BreweryController {
    @Autowired
    private BreweryDao breweryDao;
    @Autowired
    private UserDao userDao;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Brewery> breweries() {
        return breweryDao.listAll();
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/searchBreweries", method = RequestMethod.GET)
    public Brewery[] searchBreweries(@RequestParam(defaultValue = "", required = false) String zip) {
        BreweryAPI api = new BreweryAPI();
        return api.getBreweries(zip);
    }
}
