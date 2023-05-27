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
public class CiudadEntity {

    @Id
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "departamento")
    private DepartmentEntity departmentEntity;
    private String nombre;

    public CiudadEntity(UUID codigo, DepartmentEntity departmentEntity, String nombre) {
        setCodigo(codigo);
        setDepartamentoEntity(departmentEntity);
        setNombre(nombre);
    }

    public CiudadEntity() {
        setCodigo(getStringAsUUID());
        setDepartamentoEntity(new DepartmentEntity());
        setNombre(EMPTY);
    }

    public UUID getCodigo() {
        if (isNull(codigo)){
            setCodigo(getStringAsUUID());
        }
        return codigo;
    }

    public void setCodigo(final UUID codigo) {
        this.codigo = getDefaultUUID(codigo);
    }

    public DepartmentEntity getDepartamentoEntity() {
        if (isNull(departmentEntity)) {
            setDepartamentoEntity(new DepartmentEntity());
        }
        return departmentEntity;
    }

    public void setDepartamentoEntity(final DepartmentEntity departmentEntity) {
        this.departmentEntity = getDefaultIfNull(departmentEntity, new DepartmentEntity());
    }

    public String getNombre() {
        if (isNull(nombre)) {
            setNombre(EMPTY);
        }
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = applyTrim(nombre);
    }
}
