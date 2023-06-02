package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID> {

    @Query(value="SELECT * FROM public.ciudad WHERE departamento = ?1 AND nombre = ?2", nativeQuery = true)
    Optional<CityEntity> findCityByDepartment(UUID departmentId, String cityName);

    @Modifying
    @Query(value="INSERT INTO public.ciudad(codigo, departamento, nombre) VALUES(?1,?2,?3)", nativeQuery = true)
    void createCityByDepartment(UUID cityId, UUID departmentId, String name);
}
