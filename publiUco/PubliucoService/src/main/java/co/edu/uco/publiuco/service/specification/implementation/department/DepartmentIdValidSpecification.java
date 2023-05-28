package co.edu.uco.publiuco.service.specification.implementation.department;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;

import java.util.Objects;

public class DepartmentIDValidSpecification extends CompositeSpecification<DepartmentDomain> {
    @Override
    public boolean isSatisfyBy(DepartmentDomain departmentDomain) {
        return isValidId(departmentDomain);
    }

    private boolean isValidId(DepartmentDomain departmentDomain) {
        if (UtilObject.isNull(departmentDomain.getId())) {
            throw ServicePubliUcoCustomException.createUserException("El codigo del departamento no puede puede ser nulo");
        }
        else if (UtilUUID.getUUIDAsString(departmentDomain.getId()).length() != 36|| Objects.equals(departmentDomain.getId().toString(), UtilUUID.DEFAULT_UUID_AS_STRING)) {
            throw ServicePubliUcoCustomException.createUserException("Invalid budget Id");
        }
        return true;
    }
}
