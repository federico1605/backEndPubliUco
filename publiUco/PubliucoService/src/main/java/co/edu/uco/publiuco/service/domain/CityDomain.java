package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class CityDomain {
    private UUID id;
    private DepartmentDomain departament;
    private String name;

    public CityDomain(UUID id, DepartmentDomain departament, String name) {
        setId(id);
        setDepartament(departament);
        setName(name);
    }

    public CityDomain() {
        setId(UtilUUID.getStringAsUUID());
        setDepartament(new DepartmentDomain());
        setName(UtilText.EMPTY);
    }

    public DepartmentDomain getDepartament() {
        return departament;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDepartament(DepartmentDomain departament) {
        this.departament = departament;
    }

    public void setName(String name) {
        this.name = name;
    }
}
