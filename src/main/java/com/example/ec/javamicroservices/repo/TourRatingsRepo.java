package com.example.ec.javamicroservices.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.ec.javamicroservices.domain.TourRating;
import com.example.ec.javamicroservices.domain.TourRatingPK;

@RepositoryRestResource(exported = false)
//@RepositoryRestResource(collectionResourceRel = "rating", path = "rating")
public interface TourRatingsRepo extends CrudRepository<TourRating, TourRatingPK>, PagingAndSortingRepository<TourRating, TourRatingPK> {

    /*
     * 
     */
    List<TourRating> findByPkTourId(Integer tourId);
    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);

    Optional<TourRating> findByPkTourIdAndPkCustomerName(Integer tourId, String customerName);

    Iterable<TourRating> findAll();
}
