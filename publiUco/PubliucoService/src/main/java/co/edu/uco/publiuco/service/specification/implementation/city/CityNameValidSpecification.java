package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class CityNameValidSpecification extends CompositeSpecification<CityDomain> {

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        return isValidName(cityDomain);
    }

    private boolean isValidName(CityDomain cityDomain) {
        if (cityDomain.getId()==null || "".equals(cityDomain.getName())){
            throw ServicePubliUcoCustomException.createUserException("Name must be present");
        }
        return true;
    }
}
