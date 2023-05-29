package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class CountryDomain {

    private UUID id;
    private String name;

    private CountryDomain(UUID id, String name) {
        setId(id);
        setName(name);
    }

    public static CountryDomain build(UUID id, String name) {
        return new CountryDomain(id,name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = UtilText.getDefaultString(name);
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

}
