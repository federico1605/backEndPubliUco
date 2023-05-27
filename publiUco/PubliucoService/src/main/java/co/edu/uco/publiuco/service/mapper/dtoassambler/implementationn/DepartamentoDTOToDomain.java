package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;

import co.edu.uco.publiuco.dto.DepartmentDTO;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoDTOToDomain implements DTOAssembler<DepartmentDTO, DepartmentDomain> {

    private  ModelMapper modelMapper;

    public DepartamentoDTOToDomain() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DepartmentDomain assembleDomain(DepartmentDTO dto) {
        return modelMapper.map(dto, DepartmentDomain.class);
    }

    @Override
    public DepartmentDTO assembleDTO(DepartmentDomain domain) {
        return modelMapper.map(domain, DepartmentDTO.class);
    }
}
