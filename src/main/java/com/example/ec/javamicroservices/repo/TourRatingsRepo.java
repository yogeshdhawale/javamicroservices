package com.example.ec.javamicroservices.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ec.javamicroservices.domain.TourRating;

@RepositoryRestResource(exported = false)
// @RepositoryRestResource(collectionResourceRel = "rating", path = "rating")
public interface TourRatingsRepo
        extends CrudRepository<TourRating, String>, PagingAndSortingRepository<TourRating, String> {

    List<TourRating> findByTourId(String tourId);

    Page<TourRating> findByTourId(String tourId, Pageable pageable);

    Optional<TourRating> findByTourIdAndCustomerName(String tourId, Integer customerName);

    Iterable<TourRating> findAll();
}
