package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;

public class CityNameValidSpecification extends CompositeSpecification<CityDomain> {

    private static final Integer COUNTCHARACTER = 3;

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        return isValidName(cityDomain);
    }

    private boolean isValidName(CityDomain cityDomain) {
        if (cityDomain.getName().length() < COUNTCHARACTER) {
            throw ServicePubliUcoCustomException.createUserException("Se necesita mayor logico para el nombre del departamento");
        } else if (!cityDomain.getName().matches("^[a-zA-Z\\s]+$")) {
            throw ServicePubliUcoCustomException.createUserException("No se permite usar caracteres especiales o numeros en el nombre del departamennto");
        }
        return true;
    }
}
