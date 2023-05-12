package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, UUID> {
}
