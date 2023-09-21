package com.example.ec.javamicroservices.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.domain.TourRatingPK;

@RepositoryRestResource(exported = false)
public interface TourRatingsRepo extends CrudRepository<TourRating, TourRatingPK> {

    /*
     * 
     */
    List<TourRating> findByPKTourId(Integer tourId);

    Optional<TourRating> findByPKTourIdAndPKCustomerName(Integer tourId, String customerName);

}
