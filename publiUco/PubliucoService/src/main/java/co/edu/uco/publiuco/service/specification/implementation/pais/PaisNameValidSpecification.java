package co.edu.uco.publiuco.service.specification.implementation.pais;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.entity.PaisEntity;
import co.edu.uco.publiuco.repository.PaisRepository;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.Optional;

@Component
public class PaisNameValidSpecification extends CompositeSpecification<PaisDomain> {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public boolean isSatisfyBy(PaisDomain paisDomain) {
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
