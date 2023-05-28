package co.edu.uco.publiuco.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getNewUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class CountryDTO {

    private UUID id;
    private String name;

    public CountryDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    public CountryDTO() {
        setId(UtilUUID.getStringAsUUID());
        setName(EMPTY);
    }

    public static final CountryDTO create(){
        return new CountryDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? getNewUUID() : getDefaultUUID(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = applyTrim(name);
    }
}
