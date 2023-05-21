package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.dto.PaisDTO;

import java.util.UUID;

public class DepartamentoDomain {
    private UUID codigo;
    private PaisDTO paisDto;
    private String nombre;

    private UUID getCodigo() {
        return codigo;
    }

    public PaisDTO getPaisDto() {
        return paisDto;
    }

    private void setPaisDto(PaisDTO paisDto) {
        this.paisDto = paisDto;
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
