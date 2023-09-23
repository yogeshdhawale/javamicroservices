package com.example.ec.javamicroservices.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.ec.javamicroservices.domain.TourPackage;

@RepositoryRestResource(collectionResourceRel = "package", path = "package")
public interface TourPackageRepo extends CrudRepository<TourPackage, String> {

    Optional<TourPackage> findByName(String name);
    Optional<TourPackage> findByCode(String code);

    @Override
    @RestResource(exported = false)
    default void delete(TourPackage entity) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @RestResource(exported = false)

    default void deleteAll() {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteAll(Iterable<? extends TourPackage> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    @RestResource(exported = false)
    default void deleteById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    @RestResource(exported = false)
    default <S extends TourPackage> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

}
