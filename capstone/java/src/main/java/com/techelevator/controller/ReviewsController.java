package com.techelevator.controller;


import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Beers;
import com.techelevator.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class ReviewsController {

    private ReviewsDao reviewsDao;

    @PreAuthorize("permitAll")
    @PostMapping("/reviews")
    public void saveReview(@RequestBody Reviews review) {
         reviewsDao.insertReview(review);
    }


    @GetMapping("/beers/reviews/{beerId}")
    public List<Reviews> searchReviewsByBeerId(@PathVariable int beerId) {
        return reviewsDao.searchReviewsByBeerId(beerId);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/reviews/{id}", method = RequestMethod.GET)
    public Reviews filter(@RequestParam(defaultValue = "0", required = false) int id) {
        Reviews filterReview = new Reviews();
        if(id > 0) {
            filterReview = reviewsDao.getReview(id);
            return filterReview;
        }
        return filterReview;

    }


}
