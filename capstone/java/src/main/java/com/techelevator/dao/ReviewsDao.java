package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    public void insertReview (Reviews review);

    public List<Reviews> searchReviewsByBeerId(int beerId);

    public List<Reviews> searchReviewsByBreweryId(int breweryId);

    public void getReview(int reviewId);

}
