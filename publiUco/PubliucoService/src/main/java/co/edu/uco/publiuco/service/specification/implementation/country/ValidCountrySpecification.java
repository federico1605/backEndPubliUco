package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidCountrySpecification extends CompositeSpecification<CountryDomain> {
    @Autowired
    CountryExistSpecification countryExist;

    @Autowired
    CountryIdValidSpecification countryIdValid;

    @Autowired
    CountryIsNotDefaultSpecification countryIsNotDefault;

    @Autowired
    CountryNameValidSpecification countryNameValid;

    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        try {
            return countryIsNotDefault.and(countryIdValid)
                    .and(countryExist).and(countryNameValid).isSatisfyBy(countryDomain);
        }catch (ServicePubliUcoCustomException e){
            throw e;
        }
    }
}
