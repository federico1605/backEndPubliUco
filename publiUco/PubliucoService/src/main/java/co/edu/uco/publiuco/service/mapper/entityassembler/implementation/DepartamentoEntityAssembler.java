package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.DepartmentEntity;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoEntityAssembler implements EntityAssembler<DepartmentEntity, DepartmentDomain> {

    private ModelMapper modelMapper;

    public DepartamentoEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DepartmentDomain assembleDomain(DepartmentEntity entity) {
        return modelMapper.map(entity, DepartmentDomain.class);
    }

    @Override
    public DepartmentEntity assembleEntity(DepartmentDomain domain) {
        return modelMapper.map(domain, DepartmentEntity.class);
    }
}
