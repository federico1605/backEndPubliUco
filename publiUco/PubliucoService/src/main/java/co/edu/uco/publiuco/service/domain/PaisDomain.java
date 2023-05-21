package co.edu.uco.publiuco.service.domain;

import java.util.UUID;

public class PaisDomain {

    private UUID codigo;
    private String nombre;

    private UUID getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }
}
