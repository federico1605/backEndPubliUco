package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.repository.CityRepository;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarCiudadUseCaseImpl implements RegistrarCiudadUseCase {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EntityAssembler<CityEntity, CityDomain> entityAssembler;
    @Override
    public void execute(CityDomain domain) {
        //Crear las reglas de negocio
        //Spefication Pattern o un validator pattern
        //Que no exista con el mismo UUID
        //Que no exita mismo nombre para mismo departamento
        //Que el dominioo de las reglas de integridad como son la logitud
        //Solo debe tener letras y espacios
        //Son obligaotrio

        //Crear el ensalblador
        CityEntity entity = entityAssembler.assembleEntity(domain);
        cityRepository.save(entity);
    }
}
