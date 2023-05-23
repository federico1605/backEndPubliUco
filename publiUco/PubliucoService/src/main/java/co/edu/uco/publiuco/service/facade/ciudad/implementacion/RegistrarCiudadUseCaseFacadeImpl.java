package co.edu.uco.publiuco.service.facade.ciudad.implementacion;

import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadUseCaseFacade;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrarCiudadUseCaseFacadeImpl implements RegistrarCiudadUseCaseFacade {

    @Autowired
    private RegistrarCiudadUseCase registrarCiudadUseCase;
    @Override
    public void execute(CiudadDTO dto) {
        //Sirve el assembler para llevar de DTO a Domian
        registrarCiudadUseCase.execute(dto);
    }
}
