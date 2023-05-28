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
@Table(name = "Departament")
public class DepartmentEntity {

    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "Country")
    private CountryEntity countryEntity;
    private String name;

    public DepartmentEntity(UUID id, CountryEntity countryEntity, String name) {
        this.id = id;
        this.countryEntity = countryEntity;
        this.name = name;
    }

    public DepartmentEntity() {
        setId(getStringAsUUID());
        setCountryEntity(new CountryEntity());
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

    public CountryEntity getCountryEntity() {
        if (isNull(countryEntity)) {
            setCountryEntity(new CountryEntity());
        }
        return countryEntity;
    }

    public void setCountryEntity(final CountryEntity countryEntity) {
        this.countryEntity = getDefaultIfNull(countryEntity, new CountryEntity());
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
