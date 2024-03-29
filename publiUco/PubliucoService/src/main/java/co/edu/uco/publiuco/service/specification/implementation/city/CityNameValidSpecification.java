package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class CityNameValidSpecification extends CompositeSpecification<CityDomain> {

    private static final Integer COUNTCHARACTER = 3;

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        try {
            return isValidName(cityDomain);
        } catch (PubliUcoCustomException exception) {
            throw exception;
        }
    }

    private boolean isValidName(CityDomain cityDomain) {
        if (cityDomain.getName().length() < COUNTCHARACTER) {
            throw ServicePubliUcoCustomException.createUserException("Se necesita mayor logico para el nombre del departamento");
        } else if (!cityDomain.getName().matches("^[a-zA-ZñÑ\\s]+$")) {
            throw ServicePubliUcoCustomException.createUserException("No se permite usar caracteres especiales o numeros en el nombre del departamennto");
        }
        return true;
    }
}
