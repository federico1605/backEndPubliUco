package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.PaisEntity;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaisEntityAssembler implements EntityAssembler<PaisEntity, PaisDomain> {

    private  ModelMapper modelMapper;

    public PaisEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PaisDomain assembleDomain(PaisEntity entity) {
        return modelMapper.map(entity, PaisDomain.class);
    }

    @Override
    public PaisEntity assembleEntity(PaisDomain domain) {
        return modelMapper.map(domain, PaisEntity.class);
    }
}
