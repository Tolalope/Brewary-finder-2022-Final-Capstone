package com.techelevator.controller;

import com.techelevator.dao.BeersDao;
import com.techelevator.model.Beers;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/")
@RestController
@CrossOrigin

public class BeersController {
    private BeersDao beersDao;

    @PostMapping("/beers")
    public void addBeers(@RequestBody @Valid Beers beers) {
        beersDao.insertBeers(beers);
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
    public List<Beers> getAllBeersByBrewery(@PathVariable int breweryId) {
        return beersDao.getAllBeersByBrewery(breweryId);
    }

    @DeleteMapping("/beers/{id}")
    public void deleteBeers(@PathVariable int beerId) {
        beersDao.deleteBeers(beerId);
    }

}