package co.edu.uco.publiuco.dto;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getNewUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public class PaisDTO {

    private UUID codigo;
    private String nombre;

    public PaisDTO(final UUID codigo,final String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public PaisDTO() {
        setCodigo(getNewUUID());
        setNombre(EMPTY);
    }

    public static final PaisDTO create(){
        return new PaisDTO();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
