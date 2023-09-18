package com.example.ec.javamicroservices.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.ec.javamicroservices.domain.TourPackage;

public interface TourPackageRepo extends CrudRepository <TourPackage, String> {
    Optional<TourPackage> findByName(String name);
}
