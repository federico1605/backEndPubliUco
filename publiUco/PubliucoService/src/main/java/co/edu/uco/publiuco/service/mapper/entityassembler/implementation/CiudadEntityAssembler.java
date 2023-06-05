package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class CiudadEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {

    public CiudadEntityAssembler() {
        super();
        this.modelMapper = new ModelMapper();
    }

    private final ModelMapper modelMapper;

    @Override
    public CityDomain assembleDomain(CityEntity entity) {
        return modelMapper.map(entity, CityDomain.class);
    }

    @Override
    public CityEntity assembleEntity(CityDomain domain) {
        TypeMap<CityDomain, CityEntity> typeMap = modelMapper.getTypeMap(CityDomain.class, CityEntity.class);
        if (typeMap == null) {
            typeMap = this.modelMapper.createTypeMap(CityDomain.class, CityEntity.class);

        }
        typeMap.addMappings(modelMapper1 -> modelMapper1.map(CityDomain::getDepartment,CityEntity::setDepartmentEntity));
        return modelMapper.map(domain, CityEntity.class);
    }
}
