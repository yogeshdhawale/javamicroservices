package com.example.ec.javamicroservices.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.ec.javamicroservices.domain.Tour;
/*
import com.example.ec.javamicroservices.domain.TourDifficultyEnum;
import com.example.ec.javamicroservices.domain.TourRegionEnum;

import java.util.List;
import java.util.Optional;
 */

@RepositoryRestResource(collectionResourceRel = "tour", path = "tour")
public interface TourRepo extends CrudRepository<Tour, Integer>, PagingAndSortingRepository<Tour, Integer> {

    // http://localhost:8080/tours/search/findByTourPackageCode?code=Backpack%20Cal&size=2&page=1

    Optional<Tour> findById(String tourId);

    Page<Tour> findByTourPackageCode(String code, Pageable pagable);

    Page<Tour> findByTourPackageName(String name, Pageable pagable);

    @Query(value = "{'tourPackageCode' : ?0}", fields = "{ 'id': 1, 'title': 1, 'tourPackageCode':1, 'tourPackageName' : 1}")
    Page<Tour> findSummaryByTourPackageCode(@Param("code") String code, Pageable pagable);

    @Override
    @RestResource(exported = false)

    default Iterable<Tour> findAll(Sort sort) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    @RestResource(exported = false)

    default Page<Tour> findAll(Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    boolean existsById(String tourId);

    /*
     * Page<Tour> findByDifficulty(TourDifficultyEnum difficulty, Pageable pagable);
     * 
     * Optional<Tour> findByTitle(String title);
     * 
     * List<Tour> findByRegion(TourRegionEnum region);
     * 
     * List<Tour> findByPriceLessThan(Double price);
     * 
     * List<Tour> findByDifficultyAndPriceLessThan(TourDifficultyEnum difficulty,
     * Double price);
     * 
     * List<Tour> findByTourPackageCodeAndDifficulty(String tourPackageCode,
     * TourDifficultyEnum difficulty);
     */

}
