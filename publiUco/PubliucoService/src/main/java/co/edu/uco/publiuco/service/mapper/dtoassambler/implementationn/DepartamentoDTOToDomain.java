package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;

import co.edu.uco.publiuco.dto.DepartamentoDTO;
import co.edu.uco.publiuco.service.domain.DepartamentoDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoDTOToDomain implements DTOAssembler<DepartamentoDTO, DepartamentoDomain> {

    private  ModelMapper modelMapper;

    public DepartamentoDTOToDomain() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public DepartamentoDomain assembleDomain(DepartamentoDTO dto) {
        return modelMapper.map(dto, DepartamentoDomain.class);
    }

    @Override
    public DepartamentoDTO assembleDTO(DepartamentoDomain domain) {
        return modelMapper.map(domain, DepartamentoDTO.class);
    }
}
