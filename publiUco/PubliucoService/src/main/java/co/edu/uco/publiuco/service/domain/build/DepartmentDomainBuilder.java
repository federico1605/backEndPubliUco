package co.edu.uco.publiuco.service.domain.build;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.dto.CountryDTO;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.domain.DepartmentDomain;

import java.util.UUID;

public class DepartmentDomainBuilder {

    private UUID id;
    private CountryDomain countryDomain;
    private String name;

    public DepartmentDomainBuilder() {
        setId(UtilUUID.DEFAULT_UUID);
        setCountry(CountryDomainBuilder.get().build());
        setName(UtilText.EMPTY);
    }

    public static final DepartmentDomainBuilder get(){
        return new DepartmentDomainBuilder();
    }

    public DepartmentDomain build() {
        return DepartmentDomain.build(getId(),getcountryDomain(),getName());
    }

    public UUID getId() {
        return id;
    }

    public CountryDomain getcountryDomain() {
        return countryDomain;
    }

    public String getName() {
        return name;
    }

    public final DepartmentDomainBuilder setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
        return this;
    }

    public final DepartmentDomainBuilder setCountry(CountryDomain countryDomain) {
        this.countryDomain = countryDomain == null ? CountryDomainBuilder.get().build() : countryDomain;
        return this;
    }

    public final DepartmentDomainBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
