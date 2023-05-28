package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.dto.CountryDTO;

import java.util.UUID;

public class DepartmentDomain {
    private UUID id;
    private CountryDTO countryDto;
    private String name;

    public DepartmentDomain(UUID id, CountryDTO countryDto, String name) {
        setId(id);
        setCountryDto(countryDto);
        setName(name);
    }

    public DepartmentDomain() {
        setId(UtilUUID.getStringAsUUID());
        setCountryDto(new CountryDTO());
        setName(UtilText.EMPTY);
    }

    public UUID getCodigo() {
        return id;
    }

    public CountryDTO getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDTO countryDto) {
        this.countryDto = countryDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
