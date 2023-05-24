package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;

public class CiudadEntityAssembler implements EntityAssembler<CiudadEntity, CiudadDomain> {

    private final ModelMapper modelMapper;

    public CiudadEntityAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CiudadDomain assembleDomain(CiudadEntity entity) {
        return modelMapper.map(entity, CiudadDomain.class);
    }

    @Override
    public CiudadEntity assembleEntity(CiudadDomain domain) {
        return modelMapper.map(domain, CiudadEntity.class);
    }
}
