package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.dto.DepartamentoDTO;

import java.util.UUID;

public class CiudadDomain {
    private UUID codigo;
    private DepartamentoDTO departamento;
    private String ciudad;

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public UUID getCodigo() {
        return codigo;
    }

    private void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    private void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    private void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
