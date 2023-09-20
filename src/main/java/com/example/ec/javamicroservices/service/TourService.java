package com.example.ec.javamicroservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourDifficultyEnum;
import com.example.ec.javamicroservices.domain.TourPackage;
import com.example.ec.javamicroservices.domain.TourRegionEnum;
import com.example.ec.javamicroservices.repo.TourPackageRepo;
import com.example.ec.javamicroservices.repo.TourRepo;

@Service
public class TourService {
    private TourRepo tourRepo;
    private TourPackageRepo tourPackageRepo;

    @Autowired
    public TourService(TourRepo tourRepo, TourPackageRepo tourPackageRepo) {
        this.tourRepo = tourRepo;
        this.tourPackageRepo = tourPackageRepo;
    }

    /**
     * 
     * @param title
     * @param description
     * @param price
     * @param duration
     * @param region
     * @param difficulty
     * @param tourPackageCode
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, Double price, String duration,
            TourRegionEnum region,
            TourDifficultyEnum difficulty, String tourPackageName) {

        
        TourPackage tourPackage = tourPackageRepo.findByName(tourPackageName)
                .orElseThrow(IllegalArgumentException::new);

        return tourRepo.save(
                new Tour(title, description, price, duration, region, difficulty, tourPackage));

    }

    public long total() {

        return tourRepo.count();
    }
}
