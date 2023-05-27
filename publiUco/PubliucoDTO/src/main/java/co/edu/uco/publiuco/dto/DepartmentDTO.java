package co.edu.uco.publiuco.dto;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import  co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class DepartmentDTO {

    private UUID codigo;
    private CountryDTO pais;
    private String nombre;

    public DepartmentDTO(final UUID codigo, final CountryDTO countryDto, final String nombre) {
        setCodigo(codigo);
        setCountryDto(countryDto);
        setNombre(nombre);
    }

    public DepartmentDTO() {
        setCodigo(UtilUUID.getStringAsUUID());
        setCountryDto(CountryDTO.create());
        setNombre(EMPTY);
    }

    public static final DepartmentDTO create() {
        return new DepartmentDTO();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(codigo);
    }

    public CountryDTO getPaisDto() {
        if (isNull(pais)) {
            setCountryDto(CountryDTO.create());
        }
        return pais;
    }

    public void setCountryDto(CountryDTO countryDto) {
        this.pais = getDefaultIfNull(countryDto, new CountryDTO());
    }

    public String getNombre() {
        if (isNull(nombre)) {
            setNombre(EMPTY);
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = applyTrim(nombre);
    }
}
