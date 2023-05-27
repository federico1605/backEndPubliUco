package co.edu.uco.publiuco.service.specification.implementation.country;

import co.edu.uco.publiuco.repository.PaisRepository;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryNameValidSpecification extends CompositeSpecification<CountryDomain> {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean isSatisfyBy(CountryDomain countryDomain) {
        return false;
        //UtilUUID.getStringAsUUID()
    }
/*
    private Boolean paisAlreadyExist(PaisDomain paisDomain){
        try {
            Optional<PaisEntity> response = paisRepository.findPaisById(UtilUUID.getUUIDAsString(paisDomain.getCodigo()));

        }
        return true;
    }*/
}
