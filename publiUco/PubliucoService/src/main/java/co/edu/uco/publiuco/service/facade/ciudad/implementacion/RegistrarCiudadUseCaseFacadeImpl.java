package co.edu.uco.publiuco.service.facade.ciudad.implementacion;

import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadUseCaseFacade;
import co.edu.uco.publiuco.service.mapper.dtoassambler.DTOAssembler;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrarCiudadUseCaseFacadeImpl implements RegistrarCiudadUseCaseFacade {

    @Autowired
    private RegistrarCiudadUseCase registrarCiudadUseCase;

    @Autowired
    private DTOAssembler<CityDTO,CiudadDomain> dtoAssembler;

    @Override
    public void execute(CityDTO dto) {
        //Sirve el assembler para llevar de DTO a Domian
        registrarCiudadUseCase.execute(dtoAssembler.assembleDomain(dto));
    }
}
