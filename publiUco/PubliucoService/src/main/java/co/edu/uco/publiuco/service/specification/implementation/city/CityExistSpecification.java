package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.repository.CityRepository;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CityExistSpecification extends CompositeSpecification<CityDomain> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        try {
            Optional<CityEntity> response = cityRepository.findCityByDepartment(cityDomain.getDepartament().getId().toString());
            if (response.isEmpty()) {
                throw ServicePubliUcoCustomException.createUserException("El pais ya esta registrado");
            }
        } catch (ServicePubliUcoCustomException exception) {
            throw ServicePubliUcoCustomException.createUserException("Error al obtener la ciudad "+exception.getMessage());
        }
        return true;
    }
}
