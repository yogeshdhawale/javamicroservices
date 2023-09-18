package com.example.ec.javamicroservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.javamicroservices.domain.TourPackage;
import com.example.ec.javamicroservices.repo.TourPackageRepo;

@Service
public class TourPackageService {

    private TourPackageRepo tourPackageRepo;

    @Autowired
    public TourPackageService(TourPackageRepo tourPackageRepo) {
        this.tourPackageRepo = tourPackageRepo;
    }

    /**
     * 
     * @param name
     * @param code
     * @return TourPackage
     */
    public TourPackage createTourPackage(String name, String code) {

        return tourPackageRepo.findByName(name)
                .orElse(tourPackageRepo.save(new TourPackage(name, code)));
    }

    public Iterable<TourPackage> lookup() {
        return tourPackageRepo.findAll();
    }

    /**
     * 
     * @return total number of tour packages
     */
    public long total() {
        return tourPackageRepo.count();
    }
}
