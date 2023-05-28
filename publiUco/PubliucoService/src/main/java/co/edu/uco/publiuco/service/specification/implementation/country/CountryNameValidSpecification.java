package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.repository.CountryRepository;
import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class CountryNameValidSpecification extends CompositeSpecification<CountryDomain> {
    private CountryRepository countryRepository;

    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        return isValidName(countryDomain);
    }

    private boolean isValidName(CountryDomain countryDomain) {
        if (countryDomain.getId()==null || "".equals(countryDomain.getName())){
            throw ServicePubliUcoCustomException.createUserException("Name must be present");
        }
        return true;
    }
}
