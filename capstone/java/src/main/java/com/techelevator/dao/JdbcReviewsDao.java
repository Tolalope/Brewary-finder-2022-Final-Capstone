package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewsDao implements ReviewsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertReview(Reviews review) {
        String sqlInsertReview = "INSERT INTO reviews(user_id, beer_id, brewery_id, description, rating) " +
                "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sqlInsertReview, review.getUserId(),review.getBeerId(), review.getBreweryId(), review.getDescription(), review.getRating());

    }

    @Override
    public List<Reviews> searchReviewsByBeerId(int beerId) {
        List<Reviews> reviewList = new ArrayList<>();
        String sqlSearchReviewsByBeerId = "SELECT review_id, user_id, beer_id, brewery_id, description, rating " +
                "FROM reviews " +
                "WHERE beer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchReviewsByBeerId, beerId);
        while(results.next()) {
            reviewList.add(mapRowToReview(results));
        }
        return reviewList;
    }

    public List<Reviews> searchReviewsByBreweryId(int breweryId) {
        List<Reviews> reviewList = new ArrayList<>();
        String sqlSearchReviewsByBreweryId = "SELECT review_id, user_id, beer_id, brewery_id, description, rating " +
                "FROM reviews " +
                "WHERE brewery_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchReviewsByBreweryId, breweryId);
        while(results.next()) {
            reviewList.add(mapRowToReview(results));
        }
        return reviewList;
    }

    @Override
    public void getReview(int reviewId) {

        String getReviewSql = "SELECT review_id, user_id, beer_id, brewery_id, description, rating " +
                "FROM reviews " +
                "WHERE review_id = ?";

        jdbcTemplate.queryForRowSet(getReviewSql, reviewId);
    }

    private Reviews mapRowToReview(SqlRowSet results) {

        Reviews review = new Reviews();

        review.setReviewId(results.getInt("review_id"));
        review.setUserId(results.getInt("user_id"));
        review.setBeerId(results.getInt("beer_id"));
        review.setBreweryId(results.getInt("brewery_id"));
        review.setDescription(results.getString("description"));
        review.setRating(results.getInt("rating"));

        return review;
    }
}
