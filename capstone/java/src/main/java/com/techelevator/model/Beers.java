package com.techelevator.model;

public class Beers {
    private int beerId;
    private String beerName;
    private double abv;
    private String beerType;
    private String beerDescription;
    private String image;
    private int breweryId;


    public Beers(int beerId, String beerName, double abv, String beerType, String beerDescription, String image, int breweryId) {
        this.beerId = beerId;
        this.beerName = beerName;
        this.abv = abv;
        this.beerType = beerType;
        this.beerDescription = beerDescription;
        this.image = image;
        this.breweryId = breweryId;
    }

    public Beers() {

    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getBeerDescription() {
        return beerDescription;
    }

    public void setBeerDescription(String beerDescription) {
        this.beerDescription = beerDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }
}
