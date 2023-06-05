package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CityIdValidSpecification extends CompositeSpecification<CityDomain> {
    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        return isValidId(cityDomain);
    }

    private boolean isValidId(CityDomain cityDomain) {
        if (UtilObject.isNull(cityDomain.getId())) {
            throw ServicePubliUcoCustomException.createUserException("El codigo del departamento no puede ser nulo");
        }
        else if (UtilUUID.getUUIDAsString(cityDomain.getId()).length() != 36|| Objects.equals(cityDomain.getId().toString(), UtilUUID.DEFAULT_UUID_AS_STRING)) {
            throw ServicePubliUcoCustomException.createUserException("Invalid department Id");
        }
        return true;
    }
}
