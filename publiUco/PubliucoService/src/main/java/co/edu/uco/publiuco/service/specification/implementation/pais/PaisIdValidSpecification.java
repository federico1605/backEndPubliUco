package co.edu.uco.publiuco.service.specification.implementation.pais;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PaisIdValidSpecification extends CompositeSpecification<PaisDomain> {
    @Override
    public boolean isSatisfyBy(PaisDomain paisDomain) {
        return isValidId(paisDomain);
    }

    private boolean isValidId(PaisDomain paisDomain) {
        if (UtilObject.isNull(paisDomain.getCodigo())) {
            throw ServicePubliUcoCustomException.createUserException("El codigo no puede ser nulo");
        }
        if (UtilUUID.getUUIDAsString(paisDomain.getCodigo()).length() != 36|| Objects.equals(paisDomain.getCodigo().toString(), UtilUUID.DEFAULT_UUID_AS_STRING)) {
            throw ServicePubliUcoCustomException.createUserException("Invalid budget Id");
        }
        return true;
    }
}
