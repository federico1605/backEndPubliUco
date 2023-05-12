package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.dto.DepartamentoDTO;

import java.util.UUID;

public class CiudadDomain {
    private UUID codigo;
    private DepartamentoDTO departamento;
    private String ciudad;

    private UUID getCodigo() {
        return codigo;
    }

    private void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }
}
