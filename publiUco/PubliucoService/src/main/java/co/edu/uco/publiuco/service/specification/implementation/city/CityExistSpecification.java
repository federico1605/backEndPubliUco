package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.repository.CityRepository;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CityExistSpecification extends CompositeSpecification<CityDomain> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        return cityExist(cityDomain);
    }

    private boolean cityExist(CityDomain cityDomain){
        try{
//            Revisar el porque no usa el jpa sin el findById with wrapping
            Optional<CityEntity>response = cityRepository.findCityByDepartment(cityDomain.getId().toString());
            if(response.isEmpty()){
                throw ServicePubliUcoCustomException.createUserException("El pais no existe");
            }
            return true;
        }catch (ServicePubliUcoCustomException servicePubliUcoCustomException) {
            throw servicePubliUcoCustomException;
        }catch (Exception e){
            throw ServicePubliUcoCustomException.create("Error consiguiendo el Pais", e.getMessage());

        }
    }

}