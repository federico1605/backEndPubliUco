package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.repository.CityRepository;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.publiuco.service.specification.implementation.city.ValidCitySpecification;
import co.edu.uco.publiuco.service.usecase.ciudad.RegistrarCiudadUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarCiudadUseCaseImpl implements RegistrarCiudadUseCase {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EntityAssembler<CityEntity, CityDomain> entityAssembler;

    @Autowired
    private ValidCitySpecification validCitySpecification;
    @Override
    public void execute(CityDomain domain) {
        try {
            CityEntity entity = entityAssembler.assembleEntity(domain);
            entity.setId(UtilUUID.getNewUUID());
            validCitySpecification.isSatisfyBy(domain);
            cityRepository.createCityByDepartment(entity.getId().toString(),entity.getDepartmentEntity().getId().toString()
                    ,entity.getName());
        } catch (ServicePubliUcoCustomException exception) {
            throw exception;
        } catch (Exception e) {
            throw ServicePubliUcoCustomException.createTechnicalException("Hubo un error tratando de crear la ciudad ",e);
        }
    }
}
