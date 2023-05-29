package co.edu.uco.publiuco.service.domain.build;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.service.domain.CountryDomain;

import java.util.UUID;

public class CountryDomainBuilder {

    private UUID id;
    private String name;

    public CountryDomainBuilder() {
        setId(UtilUUID.DEFAULT_UUID);
        setName(UtilText.EMPTY);
    }

    public static final CountryDomainBuilder get(){
        return new CountryDomainBuilder();
    }

    public CountryDomain build() {
        return CountryDomain.build(getId(),getName());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public final CountryDomainBuilder setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
        return this;
    }

    public final CountryDomainBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
