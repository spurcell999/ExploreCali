package com.example.ec.repo;


import com.example.ec.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

// rename to packages not TourPackagesRepository
@RepositoryRestResource(collectionResourceRel="packages", path="packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);

    @Override
    @RestResource(exported=false)
    <S extends TourPackage> S save(S s);

    @Override
    @RestResource(exported=false) // forbit to outside world
    <S extends TourPackage> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @RestResource(exported=false)
    void deleteById(String s);

    @Override
    @RestResource(exported=false)
    void delete(TourPackage tourPackage);

    @Override
    @RestResource(exported=false)
    void deleteAll(Iterable<? extends TourPackage> iterable);

    @Override
    @RestResource(exported=false)
    void deleteAll();
}
