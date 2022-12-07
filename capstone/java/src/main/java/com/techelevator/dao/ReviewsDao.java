package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    public void saveReview (Reviews review);

    public List<Reviews> searchReviewsByBeerId(int beerId);

    public void getReview(int reviewId);
}
