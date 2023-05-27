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
@Table(name = "departamento")
public class DepartmentEntity {

    @Id
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "pais")
    private CountryEntity countryEntity;
    private String nombre;

    public DepartmentEntity(UUID codigo, CountryEntity countryEntity, String nombre) {
        this.codigo = codigo;
        this.countryEntity = countryEntity;
        this.nombre = nombre;
    }

    public DepartmentEntity() {
        setCodigo(getStringAsUUID());
        setPaisEntity(new CountryEntity());
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

    public CountryEntity getPaisEntity() {
        if (isNull(countryEntity)) {
            setPaisEntity(new CountryEntity());
        }
        return countryEntity;
    }

    public void setPaisEntity(final CountryEntity countryEntity) {
        this.countryEntity = getDefaultIfNull(countryEntity, new CountryEntity());
    }

    public String getNombre() {
        if (isNull(nombre)) {
            setNombre(EMPTY);
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = applyTrim(nombre);
    }
}
