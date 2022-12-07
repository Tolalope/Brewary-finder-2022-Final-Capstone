package com.techelevator.controller;

import com.techelevator.dao.BreweryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Brewery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class BreweryController {
    private BreweryDao breweryDao;
    private UserDao userDao;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/breweries", method = RequestMethod.GET)
    public List<Brewery> breweries() {
        return breweryDao.listAll();
    }
}
