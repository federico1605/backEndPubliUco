package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;


import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CiudadDTOAssembler implements DTOAssembler<CityDTO,CiudadDomain> {

    private ModelMapper modelMapper;

    public CiudadDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CiudadDomain assembleDomain(CityDTO dto) {
        return modelMapper.map(dto, CiudadDomain.class);
    }

    @Override
    public CityDTO assembleDTO(CiudadDomain domain) {
        return modelMapper.map(domain, CityDTO.class);
    }
}
