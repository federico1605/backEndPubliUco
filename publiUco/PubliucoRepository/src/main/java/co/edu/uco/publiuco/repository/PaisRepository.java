package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<CountryEntity, UUID> {

    @Query(value ="SELECT codigo FROM public.pais WHERE nombre = ?1", nativeQuery = true)
    Optional<CountryEntity> findPaisById(String pais);
}
