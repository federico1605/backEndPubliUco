package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.repository.CityRepository;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CityExistSpecification extends CompositeSpecification<CityDomain> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        try {
            Optional<CityEntity> response = cityRepository.findCityByDepartment(cityDomain.getDepartment().getId(),
                    cityDomain.getName());
            if (response.isPresent()) {
                log.error("Error tratando de crear la ciudad, el nombre de la ciudad ya esta registrado");
                return false;
            }
        } catch (ServicePubliUcoCustomException exception) {
            throw ServicePubliUcoCustomException.createUserException("Error al obtener la ciudad "+exception.getMessage());
        }
        return true;
    }
}
