package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Brewery {

    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String phone;

    @JsonProperty ("website_url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Brewery(int id, String name, String street, String city, String state, String phone, String url) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.url = url;
    }

    public Brewery() {

    }
}
