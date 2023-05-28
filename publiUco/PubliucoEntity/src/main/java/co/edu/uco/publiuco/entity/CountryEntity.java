package co.edu.uco.publiuco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getStringAsUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;

@Entity
@Table(name = "Country")
public class CountryEntity {

    @Id
    private UUID id;
    private String name;

    public CountryEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryEntity() {
        setId(getStringAsUUID());
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
