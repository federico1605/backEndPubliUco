package co.edu.uco.publiuco.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getNewUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class CountryDTO {

    private UUID codigo;
    private String nombre;

    public CountryDTO(final UUID codigo, final String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public CountryDTO() {
        setCodigo(UtilUUID.getStringAsUUID());
        setNombre(EMPTY);
    }

    public static final CountryDTO create(){
        return new CountryDTO();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo == null ? getNewUUID() : getDefaultUUID(codigo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = applyTrim(nombre);
    }
}
