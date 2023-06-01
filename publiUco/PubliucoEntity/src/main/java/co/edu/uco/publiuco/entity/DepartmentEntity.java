package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getStringAsUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;

@Entity
@Table(name = "departamento")
public class DepartmentEntity {

    @Id
    @Column(name = "codigo")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "pais")
    private CountryEntity countryEntity;
    @Column(name = "nombre")
    private String name;

    public DepartmentEntity(UUID id, CountryEntity countryEntity, String name) {
        setId(id);
        setCountryEntity(countryEntity);
        setName(name);
    }

    public DepartmentEntity() {
        setId(getStringAsUUID());
        setCountryEntity(countryEntity);
        setName(EMPTY);
    }

    public static DepartmentEntity build (UUID id,CountryEntity countryEntity, String name) {
        return new DepartmentEntity(id,countryEntity,name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = getDefaultUUID(id);
    }

    public CountryEntity getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(final CountryEntity countryEntity) {
        this.countryEntity = getDefaultIfNull(countryEntity, new CountryEntity());
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = applyTrim(nombre);
    }
}
