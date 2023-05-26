package co.edu.uco.publiuco.service.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class CiudadDomain {
    private UUID codigo;
    private DepartamentoDomain departamento;
    private String ciudad;

    public CiudadDomain(UUID codigo, DepartamentoDomain departamento, String ciudad) {
        setCodigo(codigo);
        setDepartamento(departamento);
        setCiudad(ciudad);
    }

    public CiudadDomain() {
        setCiudad(UtilText.EMPTY);
        setCodigo(UtilUUID.getStringAsUUID());
        setDepartamento(new DepartamentoDomain());
    }

    public DepartamentoDomain getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public void setDepartamento(DepartamentoDomain departamento) {
        this.departamento = departamento;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
