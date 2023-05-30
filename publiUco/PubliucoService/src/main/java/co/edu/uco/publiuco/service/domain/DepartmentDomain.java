package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.dto.CountryDTO;
import co.edu.uco.publiuco.service.domain.build.CountryDomainBuilder;

import java.util.UUID;

public class DepartmentDomain {
    private UUID id;
    private CountryDomain countryDomain;
    private String name;

    private DepartmentDomain(UUID id, CountryDomain countryDomain, String name) {
        setId(id);
        setCountryDomain(countryDomain);
        setName(name);
    }

    public DepartmentDomain() {
        setName(null);
        setId(null);
        setCountryDomain(null);
    }

    public static DepartmentDomain build(UUID id, CountryDomain countryDomain, String name) {
        return new DepartmentDomain(id,countryDomain,name);
    }

    public UUID getId() {
        return id;
    }

    public CountryDomain getCountryDomain() {
        return countryDomain;
    }

    public void setCountryDomain(final CountryDomain countryDomain) {
        this.countryDomain = UtilObject.getDefaultIfNull(countryDomain, CountryDomainBuilder.get().build());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = UtilText.getDefaultString(name);
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }
}
