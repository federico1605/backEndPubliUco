package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.build.DepartmentDomainBuilder;

import java.util.UUID;

public class CityDomain {
    private UUID id;
    private DepartmentDomain department;
    private String name;

    private CityDomain(UUID id, DepartmentDomain department, String name) {
        setId(id);
        setDepartment(department);
        setName(name);
    }

    public static CityDomain build(final UUID id, final DepartmentDomain departmentDomain, final String name) {
        return new CityDomain(id,departmentDomain,name);
    }

    public DepartmentDomain getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public void setDepartment(final DepartmentDomain department) {
        this.department = UtilObject.getDefaultIfNull(department, DepartmentDomainBuilder.get().build());
    }

    public void setName(final String name) {
        this.name = UtilText.getDefaultString(name);
    }
}
