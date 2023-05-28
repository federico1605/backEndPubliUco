package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CityIsNotDefaultSpecification extends CompositeSpecification<CityDomain> {

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        return isNotDefault(cityDomain);
    }
    private boolean isNotDefault(CityDomain cityDomain){
        if (Objects.equals(cityDomain.getId().toString(), UtilUUID.DEFAULT_UUID_AS_STRING) && "" .equals(cityDomain.getName())) {
            throw ServicePubliUcoCustomException.createUserException("No se encontro info en el pais dado");
        }else {
            return true;
        }
    }
}
