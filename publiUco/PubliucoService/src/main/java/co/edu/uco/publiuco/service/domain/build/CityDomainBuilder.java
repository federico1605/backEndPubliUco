package co.edu.uco.publiuco.service.domain.build;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;

import java.util.UUID;

public class CityDomainBuilder {

    private UUID id;
    private DepartmentDomain department;
    private String name;

    private CityDomainBuilder() {
        setId(UtilUUID.DEFAULT_UUID);
        setDepartment(DepartmentDomainBuilder.get().build());
        setName(UtilText.EMPTY);
    }

    public static final CityDomainBuilder get() {
        return new CityDomainBuilder();
    }

    public CityDomain build() {
        return CityDomain.build(getId(),getDepartament(),getName());
    }

    public UUID getId() {
        return id;
    }

    public DepartmentDomain getDepartament() {
        return department;
    }

    public String getName() {
        return name;
    }

    public final CityDomainBuilder setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
        return this;
    }

    public final CityDomainBuilder setDepartment(DepartmentDomain department) {
        this.department = department == null ? DepartmentDomainBuilder.get().build() : department;
        return this;
    }

    public final CityDomainBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
