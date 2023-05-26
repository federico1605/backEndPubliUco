package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, UUID> {

    @Query(value ="SELECT codigo FROM public.pais WHERE nombre = ?1", nativeQuery = true)
    Optional<PaisEntity> findPaisById(String pais);
}
