package co.edu.uco.publiuco.service.specification.implementation.department;

import co.edu.uco.publiuco.service.domain.DepartmentDomain;
import co.edu.uco.publiuco.service.specification.CompositeSpecification;

public class DepartmentNameValidSpecification extends CompositeSpecification<DepartmentDomain> {
    @Override
    public boolean isSatisfyBy(DepartmentDomain departmentDomain) {
        return isValidName(departmentDomain);
    }

    private boolean isValidName(DepartmentDomain departmentDomain) {

        return true;
    }
}
