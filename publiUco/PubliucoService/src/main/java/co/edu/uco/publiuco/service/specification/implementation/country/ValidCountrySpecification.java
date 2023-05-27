package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidCountrySpecification extends CompositeSpecification<CountryDomain> {
    @Autowired
    CountryExistSpecification countryExistSpecification;

    @Autowired
    CountryIdValidSpecification countryIdValidSpecification;

    @Autowired
    CountryIsNotDefaultSpecification countryIsNotDefaultSpecification;

    @Autowired
    CountryNameValidSpecification countryNameValidSpecification;

    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        try {
            return countryIsNotDefaultSpecification.and(countryIdValidSpecification)
                    .and(countryExistSpecification).and(countryNameValidSpecification).isSatisfyBy(countryDomain);
        }catch (ServicePubliUcoCustomException e){
            throw e;
        }
    }
}
