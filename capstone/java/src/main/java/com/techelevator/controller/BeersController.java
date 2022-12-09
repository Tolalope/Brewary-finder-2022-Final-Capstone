package com.techelevator.controller;

import com.techelevator.dao.BeersDao;
import com.techelevator.model.Beers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/")
@RestController
@CrossOrigin

public class BeersController {
    @Autowired
    private BeersDao beersDao;

    @PostMapping("/beers")
    public void saveBeers(@RequestBody @Valid Beers beers) {
        beersDao.saveBeers(beers);
    }

    @GetMapping("/beers")
    public List<Beers> getAllBeers() {
        return beersDao.getAllBeers();
    }

    @GetMapping("/beers/{id}")
    public Beers getBeersById(@PathVariable int beersId) {
        return beersDao.getBeersById(beersId);
    }

    @GetMapping
    public Beers getBeersByName(@RequestParam(value="name") String name){
        return beersDao.getBeersByName(name);
    }

    @GetMapping("/breweries/beers/{id}")
    public List<Beers> getBeersByBrewery(@PathVariable int breweryId) {
        return beersDao.getBeersByBrewery(breweryId);
    }

    @DeleteMapping("/beers/{id}")
    public void removeBeers(@PathVariable int beerId) {
        beersDao.removeBeers(beerId);
    }

}

// Are we adding getAllBeersByBrewery from BeersDAO??