package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, UUID> {

    @Query(value ="SELECT id FROM public.Country WHERE name = ?1", nativeQuery = true)
    Optional<CountryEntity> findCountryById(String idCountry);

}
