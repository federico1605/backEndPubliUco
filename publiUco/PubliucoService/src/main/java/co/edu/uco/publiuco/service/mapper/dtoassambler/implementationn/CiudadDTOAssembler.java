package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;


import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CiudadDTOAssembler implements DTOAssembler<CiudadDTO,CiudadDomain> {

    private ModelMapper modelMapper;

    public CiudadDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CiudadDomain assembleDomain(CiudadDTO dto) {
        return modelMapper.map(dto, CiudadDomain.class);
    }

    @Override
    public CiudadDTO assembleDTO(CiudadDomain domain) {
        return modelMapper.map(domain, CiudadDTO.class);
    }
}
