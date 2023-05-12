package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, UUID> {
}
