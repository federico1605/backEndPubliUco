package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, UUID> {

    @Query(value = "SELECT * FROM public.departamento WHERE nombre = ?1 AND pais = ?2")
    Optional<DepartmentEntity> findDepartmentByIDAndCountry(String department, String country);
}
