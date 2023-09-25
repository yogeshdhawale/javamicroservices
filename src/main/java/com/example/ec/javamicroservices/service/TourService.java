package com.example.ec.javamicroservices.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.javamicroservices.domain.Tour;
import com.example.ec.javamicroservices.domain.TourPackage;
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
     * @param title
     * @param tourPackageName
     * @param details
     * @return
     */
    public Tour createTour(String title, String tourPackageName,
            Map<String, String> details) {

        TourPackage tourPackage = tourPackageRepo.findByName(tourPackageName)
                .orElseThrow(() -> new IllegalArgumentException("create tour failed"));

        return tourRepo.save(
                new Tour(title, tourPackage, details));

    }

    public long total() {

        return tourRepo.count();
    }
}
