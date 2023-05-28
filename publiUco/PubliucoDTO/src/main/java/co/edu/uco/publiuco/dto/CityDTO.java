package co.edu.uco.publiuco.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class CityDTO {
    private UUID id;
    private DepartmentDTO departament;
    private String name;

    public CityDTO(final UUID codigo, final DepartmentDTO departament, final String name) {
        setId(codigo);
        setName(name);
        setDepartament(departament);
    }

    public CityDTO() {
        setId(UtilUUID.getStringAsUUID());
        setDepartament(DepartmentDTO.create());
        setName(EMPTY);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(id);
    }

    public DepartmentDTO getDepartament() {
        if (isNull(departament)) {
            setDepartament(DepartmentDTO.create());
        }
        return departament;
    }

    public void setDepartament(DepartmentDTO departament) {
        this.departament = getDefaultIfNull(departament, new DepartmentDTO(departament.getId(),departament.getCountryDto(),departament.getName()));
    }

    public String getName() {
        if (isNull(name)) {
            setName(EMPTY);
        }
        return name;
    }

    public void setName(String name) {
        this.name = applyTrim(name);
    }
}
