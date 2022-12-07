package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcReviewsDao implements ReviewsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveReview(Reviews review) {
        String saveReviewSql = "INSERT INTO reviews(user_id, beer_id, beer_name, brewery_name, description, rating) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(saveReviewSql, review.getUserId(),review.getBeerId(), review.getBeerName(), review.getBreweryName(), review.getDescription(), review.getRating());

    }

    @Override
    public List<Reviews> searchReviewsByBeerId(int beerId) {
        List<Reviews> reviewList = new ArrayList<>();
        String searchReviewsByBeerIdSql = "SELECT review_id, user_id, beer_id, beer_name, brewery_name, description, rating " +
                "WHERE beer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(searchReviewsByBeerIdSql, beerId);
        while(results.next()) {
            reviewList.add(mapRowToReview(results));
        }
        return reviewList;
    }

    @Override
    public void getReview(int reviewId) {

        String getReviewSql = "SELECT review_id, user_id, beer_id, beer_name, brewery_name, description, rating " +
                "WHERE review_id = ?";

        jdbcTemplate.queryForRowSet(getReviewSql, reviewId);
    }

    private Reviews mapRowToReview(SqlRowSet results) {

        Reviews review = new Reviews();

        review.setReviewId(results.getInt("review_id"));
        review.setUserId(results.getInt("user_id"));
        review.setBeerId(results.getInt("beer_id"));
        review.setBeerName(results.getString("beer_name"));
        review.setBreweryName(results.getString("brewery_name"));
        review.setDescription(results.getString("description"));
        review.setRating(results.getInt("rating"));

        return review;
    }
}
