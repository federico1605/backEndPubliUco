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

    private void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }
}
