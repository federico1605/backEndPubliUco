package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.PaisEntity;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;

public class PaisEntityAssembler implements EntityAssembler<PaisEntity, PaisDomain> {

    private final ModelMapper modelMapper;

    public PaisEntityAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
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
