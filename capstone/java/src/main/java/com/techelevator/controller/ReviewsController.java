package com.techelevator.controller;


import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
@CrossOrigin

public class ReviewsController {

    @Autowired
    private ReviewsDao reviewsDao;

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping("/beers/reviews")
    public void saveReview(@RequestBody Reviews Review) {
         reviewsDao.saveReview();
    }

    @GetMapping("/beer/{id}/reviews")
    public List<Reviews> searchReviewsByBeerId(@PathVariable int beerId) {
        reviewsDao.searchReviewsByBeerId(beerId);
    }


}
