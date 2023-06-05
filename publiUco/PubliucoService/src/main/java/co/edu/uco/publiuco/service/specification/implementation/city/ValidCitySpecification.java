package co.edu.uco.publiuco.service.specification.implementation.city;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidCitySpecification extends CompositeSpecification<CityDomain> {

    @Autowired
    CityExistSpecification cityExist;

    @Autowired
    CityIdValidSpecification cityIdValid;

    @Autowired
    CityIsNotDefaultSpecification cityIsNotDefault;

    @Autowired
    CityNameValidSpecification cityNameValid;

    @Override
    public boolean isSatisfyBy(CityDomain cityDomain) {
        try {
            return cityIsNotDefault.and(cityIdValid)
                    .and(cityExist).and(cityNameValid).isSatisfyBy(cityDomain);
        }catch (ServicePubliUcoCustomException e){
            throw e;
        }
    }
}
