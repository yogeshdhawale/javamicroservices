package com.example.ec.javamicroservices.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.repo.TourRatingsRepo;
import com.example.ec.javamicroservices.repo.TourRepo;

@Service
public class TourRatingService {
    private TourRatingsRepo ratingsRepo;
    private TourRepo tourRepo;

    @Autowired
    public TourRatingService(TourRatingsRepo tourRatingsRepo, TourRepo tourRepo) {
        this.ratingsRepo = tourRatingsRepo;
        this.tourRepo = tourRepo;
    }

    public Tour getTourObj(int tourId) throws NoSuchElementException {
        return tourRepo.findById(tourId)
                .orElseThrow(() -> new NoSuchElementException("Does not exists" + tourId));
    }

    public void save(TourRating tourRating) {
        ratingsRepo.save(tourRating);
    }

    public List<TourRating> findTourRatings(int tourId) {

        return ratingsRepo.findByPkTourId(tourId);
    }

}
