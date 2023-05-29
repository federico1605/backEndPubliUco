package co.edu.uco.publiuco.service.specification.implementation.department;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.entity.DepartmentEntity;
import co.edu.uco.publiuco.repository.DepartmentRepository;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DepartmentExistSpecification extends CompositeSpecification<DepartmentDomain> {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public boolean isSatisfyBy(DepartmentDomain departmentDomain) {
        return departmentExist(departmentDomain);
    }

    private boolean departmentExist(DepartmentDomain departmentDomain) {
        try {
            Optional<DepartmentEntity> response = departmentRepository.findDepartmentByIDAndCountry(departmentDomain.getName()
                    ,departmentDomain.getCountryDomain().getId().toString());
            if (response.isEmpty()) {
                throw ServicePubliUcoCustomException.createUserException("El pais ya esta registrado");
            }
        } catch (ServicePubliUcoCustomException exception) {
            throw ServicePubliUcoCustomException.createUserException("Error al conseguir el departamento "+exception.getMessage());
        }
        return true;
    }
}
