package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;


import co.edu.uco.publiuco.dto.CountryDTO;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaisDTOAssembler implements DTOAssembler<CountryDTO, CountryDomain> {

    private  ModelMapper modelMapper;

    public PaisDTOAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CountryDomain assembleDomain(CountryDTO dto) {
        return modelMapper.map(dto, CountryDomain.class);
    }

    @Override
    public CountryDTO assembleDTO(CountryDomain domain) {
        return modelMapper.map(domain, CountryDTO.class);
    }
}
