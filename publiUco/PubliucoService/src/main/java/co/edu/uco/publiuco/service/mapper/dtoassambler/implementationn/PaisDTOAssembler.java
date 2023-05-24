package co.edu.uco.publiuco.service.mapper.dtoassambler.implementationn;


import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.service.domain.PaisDomain;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaisDTOAssembler implements DTOAssembler<PaisDTO,PaisDomain> {

    private final ModelMapper modelMapper;

    public PaisDTOAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PaisDomain assembleDomain(PaisDTO dto) {
        return modelMapper.map(dto, PaisDomain.class);
    }

    @Override
    public PaisDTO assembleDTO(PaisDomain domain) {
        return modelMapper.map(domain, PaisDTO.class);
    }
}
