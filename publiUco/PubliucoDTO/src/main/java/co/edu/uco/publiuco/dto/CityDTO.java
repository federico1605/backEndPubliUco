package co.edu.uco.publiuco.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class CityDTO {
    private UUID id;
    private DepartmentDTO department;
    private String name;

    public CityDTO(final UUID id, final DepartmentDTO department, final String name) {
        setId(id);
        setName(name);
        setDepartment(department);
    }

    public CityDTO() {
        setId(UtilUUID.getStringAsUUID());
        setDepartment(DepartmentDTO.create());
        setName(EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(id);
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = getDefaultIfNull(department, new DepartmentDTO());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = applyTrim(name);
    }
}
