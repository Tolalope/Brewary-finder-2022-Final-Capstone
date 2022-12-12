package com.techelevator.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Reviews {
    private int reviewId;
    private int userId;
    private int beerId;
    private int breweryId;
    private String description;
    @Min(value = 1, message = "Rating must be between 1 and 5.")
    @Max(value = 5, message = "Rating must be between 1 and 5.")
    private int rating;


    public Reviews() {
    }

    public Reviews(int reviewId, int userId, int beerId, int breweryId, String description, int rating) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.beerId = beerId;
        this.breweryId = breweryId;
        this.description = description;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


