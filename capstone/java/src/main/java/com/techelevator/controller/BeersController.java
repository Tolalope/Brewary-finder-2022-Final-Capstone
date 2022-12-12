package com.techelevator.controller;

import com.techelevator.dao.BeersDao;
import com.techelevator.model.Beers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin

public class BeersController {

    @Autowired
    private BeersDao beersDao;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/beers")
    public void addBeers(@RequestBody @Valid Beers beers) {
        beersDao.insertBeers(beers);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path= "/beers", method = RequestMethod.GET)
    public List<Beers> getAllBeers() {
        return beersDao.getAllBeers();
    }

    /*
    @GetMapping("/beers/{beersId}")
    public Beers getBeersById(@PathVariable int beersId) {
        return beersDao.getBeersById(beersId);
    }

    @RequestMapping(path = "/beers/{beerName}", method = RequestMethod.GET)
    public Beers getBeersByName(@RequestParam(defaultValue = "", required = true) String beerName){
        return beersDao.getBeersByName(beerName);
    }

    @GetMapping("/breweries/beers/{id}")
    public List<Beers> getAllBeersByBrewery(@PathVariable int breweryId) {
        return beersDao.getAllBeersByBrewery(breweryId);
    }
   */

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/search-beers", method = RequestMethod.GET)
    public Beers filter(@RequestParam(defaultValue = "0", required = false) int id,
                              @RequestParam(defaultValue = "", required = false) String name) {
        Beers filterBeer = new Beers();
        if(id > 0) {
            filterBeer = beersDao.getBeersById(id);
            return filterBeer;
        }
        if(name.length() > 0) {
            filterBeer = beersDao.getBeersByName(name.toUpperCase());
            return filterBeer;
        }
        return filterBeer;

    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/breweries/{breweryId}/beers", method = RequestMethod.GET)
    public List<Beers> getAllBeersByBrewery(@RequestParam(defaultValue = "0", required = true) int breweryId) {
        return beersDao.getAllBeersByBrewery(breweryId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/beers/{id}")
    public void deleteBeers(@PathVariable int beerId) {
        beersDao.deleteBeers(beerId);
    }

}