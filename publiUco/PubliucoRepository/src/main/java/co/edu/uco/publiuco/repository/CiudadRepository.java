package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, UUID> {
}
