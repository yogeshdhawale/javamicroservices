package com.example.ec.javamicroservices.web;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.service.TourRatingService;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

    TourRatingService tourRatingService;

    @Autowired
    public TourRatingController(TourRatingService service) {
        tourRatingService = service;
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
            @PathVariable(value = "tourId") String tourId,
            @RequestBody @Validated RatingDTO obj) {

        tourRatingService.getTourObj(tourId);
        TourRating tRating = new TourRating(tourId, obj.getCustomerName(), obj.getScore(), obj.getComment());

        tourRatingService.save(tRating);
    }

    @GetMapping
    public Page<TourRating> getRatings(@PathVariable(value = "tourId") String tourId,
            Pageable pageable) {
        return tourRatingService.getTourRatings(tourId, pageable);
    }

    @GetMapping(path = "/average")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Double> getAvgRating(@PathVariable(value = "tourId") String tourId) {

        tourRatingService.getTourObj(tourId);

        return Map.of("average",
                tourRatingService.getTourRatings(tourId).stream()
                        .mapToInt(TourRating::getScore).average()
                        .orElseThrow(() -> new NoSuchElementException("No ratings found")));
    }

}
