package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.CiudadRepository;
import co.edu.uco.publiuco.service.domain.CiudadDomain;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class RegistrarCiudadUseCaseImpl implements RegistrarCiudadUseCase {

    @Autowired
    private CiudadRepository ciudadRepository;
    @Override
    public void execute(CiudadDomain domain) {
        //Crear las reglas de negocio
        //Spefication Pattern o un validator pattern
        //Que no exista con el mismo UUID
        //Que no exita mismo nombre para mismo departamento
        //Que el dominioo de las reglas de integridad como son la logitud
        //Solo debe tener letras y espacios
        //Son obligaotrio

        //Crear el ensalblador
        CiudadEntity entity = null;
        ciudadRepository.save(entity);
    }
}
