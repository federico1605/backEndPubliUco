package co.edu.uco.publiuco.dto;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import  co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class DepartmentDTO {

    private UUID id;
    private CountryDTO country;
    private String name;

    public DepartmentDTO(final UUID id, final CountryDTO countryDto, final String name) {
        setId(id);
        setCountryDto(countryDto);
        setName(name);
    }

    public DepartmentDTO() {
        setId(UtilUUID.getStringAsUUID());
        setCountryDto(CountryDTO.create());
        setName(EMPTY);
    }

    public static final DepartmentDTO create() {
        return new DepartmentDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(id);
    }

    public CountryDTO getCountryDto() {
        if (isNull(country)) {
            setCountryDto(CountryDTO.create());
        }
        return country;
    }

    public void setCountryDto(CountryDTO countryDto) {
        this.country = getDefaultIfNull(countryDto, new CountryDTO());
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
