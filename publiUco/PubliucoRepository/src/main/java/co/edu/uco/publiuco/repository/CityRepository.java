package co.edu.uco.publiuco.repository;

import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID> {

    @Query(value="SELECT * FROM public.City b WHERE b.idDepartment = ?1 ", nativeQuery = true)
    Optional<CityEntity> findCityByDepartment(String departmsentId);

    @Modifying
    @Query(value="INSERT INTO public.City(id, idDepartment, name) VALUES(?1,?2,?3)", nativeQuery = true)
    void createCityByDepartment(String cityId, String departmentId, String name);

}
