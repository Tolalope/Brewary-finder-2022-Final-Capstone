package com.techelevator.controller;

import com.techelevator.dao.BeersDao;
import com.techelevator.model.Beers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin

public class BeersController {

    @Autowired
    private BeersDao beersDao;

    @PostMapping("/beers")
    public void addBeers(@RequestBody @Valid Beers beers) {
        beersDao.insertBeers(beers);
    }

    @RequestMapping(path= "/beers", method = RequestMethod.GET)
    public List<Beers> getAllBeers() {
        return beersDao.getAllBeers();
    }

    @GetMapping("/beers/{beersId}")
    public Beers getBeersById(@PathVariable int beersId) {
        return beersDao.getBeersById(beersId);
    }

    @RequestMapping(path = "/search-beers", method = RequestMethod.GET)
    public Beers getBeersByName(@RequestParam(defaultValue = "", required = true) String beerName){
        return beersDao.getBeersByName(beerName);
    }

    @GetMapping("/breweries/beers/{id}")
    public List<Beers> getAllBeersByBrewery(@PathVariable int breweryId) {
        return beersDao.getAllBeersByBrewery(breweryId);
    }

    @DeleteMapping("/beers/{id}")
    public void deleteBeers(@PathVariable int beerId) {
        beersDao.deleteBeers(beerId);
    }

}