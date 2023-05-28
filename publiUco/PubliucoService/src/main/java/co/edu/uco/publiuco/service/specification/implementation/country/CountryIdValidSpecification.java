package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CountryIdValidSpecification extends CompositeSpecification<CountryDomain> {
    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        return isValidId(countryDomain);
    }

    private boolean isValidId(CountryDomain countryDomain) {
        if (UtilObject.isNull(countryDomain.getId())) {
            throw ServicePubliUcoCustomException.createUserException("El codigo no puede ser nulo");
        }
        if (UtilUUID.getUUIDAsString(countryDomain.getId()).length() != 36|| Objects.equals(countryDomain.getId().toString(), UtilUUID.DEFAULT_UUID_AS_STRING)) {
            throw ServicePubliUcoCustomException.createUserException("Invalid budget Id");
        }
        return true;
    }
}
