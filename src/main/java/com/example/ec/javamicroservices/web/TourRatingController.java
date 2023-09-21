package com.example.ec.javamicroservices.web;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.domain.TourRatingPK;
import com.example.ec.javamicroservices.repo.TourRatingsRepo;
import com.example.ec.javamicroservices.repo.TourRepo;
import com.example.ec.javamicroservices.service.TourRatingService;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

    TourRatingService ratingService;

    @Autowired
    public TourRatingController(TourRatingsRepo tourRatingsRepo, TourRepo tourRepo) {
        ratingService = new TourRatingService(tourRatingsRepo, tourRepo);
    }

    protected TourRatingController() {

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(
            @PathVariable(value = "tourId") int tourId,
            @RequestBody @Validated RatingDTO obj) {

        Tour tour = ratingService.getTourObj(tourId);
        TourRatingPK pk = new TourRatingPK(tour, obj.getCustomerName());
        TourRating tRating = new TourRating(pk, obj.getScore(), obj.getComment());

        ratingService.save(tRating);
    }
}
