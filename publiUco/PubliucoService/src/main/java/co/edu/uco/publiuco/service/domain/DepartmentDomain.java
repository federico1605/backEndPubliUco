package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import co.edu.uco.publiuco.dto.CountryDTO;

import java.util.UUID;

public class DepartmentDomain {
    private UUID codigo;
    private CountryDTO countryDto;
    private String nombre;

    public DepartmentDomain(UUID codigo, CountryDTO countryDto, String nombre) {
        setCodigo(codigo);
        setPaisDto(countryDto);
        setNombre(nombre);
    }

    public DepartmentDomain() {
        setCodigo(UtilUUID.getStringAsUUID());
        setPaisDto(new CountryDTO());
        setNombre(UtilText.EMPTY);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public CountryDTO getPaisDto() {
        return countryDto;
    }

    public void setPaisDto(CountryDTO countryDto) {
        this.countryDto = countryDto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }
}
