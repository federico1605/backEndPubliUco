package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getStringAsUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;

@Entity
@Table(name = "ciudad")
public class CityEntity {

    @Id
    @Column(name = "codigo")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "departamento")
    private DepartmentEntity departmentEntity;
    @Column(name = "nombre")
    private String name;

    public CityEntity(UUID id, DepartmentEntity departmentEntity, String name) {
        setId(id);
        setDepartamentEntity(departmentEntity);
        setName(name);
    }

    public CityEntity() {
        setId(getStringAsUUID());
        setDepartamentEntity(new DepartmentEntity());
        setName(EMPTY);
    }

    public UUID getId() {
        if (isNull(id)){
            setId(getStringAsUUID());
        }
        return id;
    }

    public void setId(final UUID id) {
        this.id = getDefaultUUID(id);
    }

    public DepartmentEntity getDepartmentEntity() {
        if (isNull(departmentEntity)) {
            setDepartamentEntity(new DepartmentEntity());
        }
        return departmentEntity;
    }

    public void setDepartamentEntity(final DepartmentEntity departmentEntity) {
        this.departmentEntity = getDefaultIfNull(departmentEntity, new DepartmentEntity());
    }

    public String getName() {
        if (isNull(name)) {
            setName(EMPTY);
        }
        return name;
    }

    public void setName(final String name) {
        this.name = applyTrim(name);
    }
}
