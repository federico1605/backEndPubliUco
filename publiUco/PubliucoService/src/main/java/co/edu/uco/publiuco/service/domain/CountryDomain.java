package co.edu.uco.publiuco.service.domain;

import java.util.UUID;

public class CountryDomain {

    private UUID codigo;
    private String nombre;

    public UUID getCodigo() {
        return codigo;
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
