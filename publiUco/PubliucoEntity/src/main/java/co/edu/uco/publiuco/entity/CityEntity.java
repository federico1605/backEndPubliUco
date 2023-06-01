package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getStringAsUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;

@Entity
@Table(name = "ciudad")
public class CityEntity {

    @Id
    @Column(name = "codigo")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "departamento")
    private DepartmentEntity department;
    @Column(name = "nombre")
    private String name;

    public CityEntity(UUID id, DepartmentEntity departmentEntity, String name) {
        setId(id);
        setDepartmentEntity(departmentEntity);
        setName(name);
    }

    public CityEntity() {
        setId(getStringAsUUID());
        setDepartmentEntity(department);
        setName(EMPTY);
    }

    public static CityEntity build (final UUID id, final DepartmentEntity departmentEntity, final String name) {
        return new CityEntity(id,departmentEntity,name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = getDefaultUUID(id);
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartmentEntity(final DepartmentEntity departmentEntity) {
        this.department = getDefaultIfNull(departmentEntity, new DepartmentEntity());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = applyTrim(name);
    }
}
