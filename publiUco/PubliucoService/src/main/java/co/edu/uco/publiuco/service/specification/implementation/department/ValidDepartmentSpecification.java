package co.edu.uco.publiuco.service.specification.implementation.department;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidDepartmentSpecification extends CompositeSpecification<DepartmentDomain> {

    @Autowired
    DepartmentIdValidSpecification departmentIDValidSpecification;

    @Autowired
    DepartmentExistSpecification departmentExistSpecification;

    @Autowired
    DepartmentNameValidSpecification departmentNameValidSpecification;

    @Override
    public boolean isSatisfyBy(DepartmentDomain departmentDomain) {
        try {
            return departmentExistSpecification.and(departmentIDValidSpecification)
                    .and(departmentNameValidSpecification).isSatisfyBy(departmentDomain);
        } catch (ServicePubliUcoCustomException exception){
            throw exception;
        }
    }
}
