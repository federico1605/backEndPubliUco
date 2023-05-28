package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;


import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CiudadDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {

    private ModelMapper modelMapper;

    public CiudadDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CityDomain assembleDomain(CityDTO dto) {
        return modelMapper.map(dto, CityDomain.class);
    }

    @Override
    public CityDTO assembleDTO(CityDomain domain) {
        return modelMapper.map(domain, CityDTO.class);
    }
}
