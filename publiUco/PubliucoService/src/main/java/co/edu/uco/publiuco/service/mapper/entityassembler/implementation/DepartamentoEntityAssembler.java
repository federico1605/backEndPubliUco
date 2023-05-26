package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.entity.DepartamentoEntity;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.domain.DepartamentoDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoEntityAssembler implements EntityAssembler<DepartamentoEntity, DepartamentoDomain> {

    private ModelMapper modelMapper;

    public DepartamentoEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DepartamentoDomain assembleDomain(DepartamentoEntity entity) {
        return modelMapper.map(entity,DepartamentoDomain.class);
    }

    @Override
    public DepartamentoEntity assembleEntity(DepartamentoDomain domain) {
        return modelMapper.map(domain, DepartamentoEntity.class);
    }
}
