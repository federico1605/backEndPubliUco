package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CountryIsNotDefaultSpecification extends CompositeSpecification<CountryDomain> {

    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        return isNotDefault(countryDomain);
    }
    private boolean isNotDefault(CountryDomain countryDomain){
        if (Objects.equals(countryDomain.getId().toString(), UtilUUID.DEFAULT_UUID_AS_STRING) && "" .equals(countryDomain.getName())) {
            throw ServicePubliUcoCustomException.createUserException("No se encontro info en el pais dado");
        }else {
            return true;
        }
    }
}
