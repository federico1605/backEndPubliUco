package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.entity.CountryEntity;
import co.edu.uco.publiuco.repository.PaisRepository;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CountryExistSpecification extends CompositeSpecification<CountryDomain> {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        return countryExist(countryDomain);
    }

    private boolean countryExist(CountryDomain countryDomain){
        try{
            Optional<CountryEntity>response = paisRepository.findPaisById(countryDomain.getCodigo().toString());
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
