package co.edu.uco.publiuco.service.specification.implementation.department;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class DepartmentNameValidSpecification extends CompositeSpecification<DepartmentDomain> {

    private static final Integer COUNTCHARACTER = 3;

    @Override
    public boolean isSatisfyBy(DepartmentDomain departmentDomain) {
        return isValidName(departmentDomain);
    }

    private boolean isValidName(DepartmentDomain departmentDomain) {
        if (departmentDomain.getName().length() < COUNTCHARACTER) {
            throw ServicePubliUcoCustomException.createUserException("Se necesita mayor logico para el nombre del departamento");
        } else if (!departmentDomain.getName().matches("^[a-zA-Z\\s]+$")) {
            throw ServicePubliUcoCustomException.createUserException("No se permite usar caracteres especiales o numeros en el nombre del departamennto");
        }
        return true;
    }
}
