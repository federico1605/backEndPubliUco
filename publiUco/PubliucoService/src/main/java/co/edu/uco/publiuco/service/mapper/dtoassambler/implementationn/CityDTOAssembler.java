package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;


import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {

    private final ModelMapper modelMapper;

    public CityDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CityDomain assembleDomain(CityDTO dto) {
        System.out.println();
        return modelMapper.map(dto, CityDomain.class);
    }

    @Override
    public CityDTO assembleDTO(CityDomain domain) {
        return modelMapper.map(domain, CityDTO.class);
    }
}
