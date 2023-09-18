package com.example.ec.javamicroservices.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourDifficultyEnum;
import com.example.ec.javamicroservices.domain.TourRegionEnum;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TourRepo extends CrudRepository<Tour, Integer> {

    List<Tour> findByTourPackageCode(String code);

    Optional<Tour> findByTitle(String title);

    Collection<Tour> findByDifficulty(TourDifficultyEnum difficulty);

    List<Tour> findByRegion(TourRegionEnum region);

    List<Tour> findByPriceLessThan(Double price);

    List<Tour> findByDifficultyAndPriceLessThan(TourDifficultyEnum difficulty, Double price);

    List<Tour> findByTourPackageCodeAndDifficulty(String tourPackageCode, TourDifficultyEnum difficulty);
}
