package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CiudadEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {

    public CiudadEntityAssembler() {
        super();
        this.modelMapper = new ModelMapper();
    }

    private ModelMapper modelMapper;

    @Override
    public CityDomain assembleDomain(CityEntity entity) {
        return modelMapper.map(entity, CityDomain.class);
    }

    @Override
    public CityEntity assembleEntity(CityDomain domain) {
        return modelMapper.map(domain, CityEntity.class);
    }
}
