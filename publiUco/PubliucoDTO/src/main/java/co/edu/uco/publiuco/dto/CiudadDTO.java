package co.edu.uco.publiuco.dto;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getNewUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public class CiudadDTO {
    private UUID codigo;
    private DepartamentoDTO departamento;
    private String nombre;

    public CiudadDTO(final UUID codigo,final DepartamentoDTO departamento,final String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public CiudadDTO() {
        setCodigo(getNewUUID());
        setDepartamento(DepartamentoDTO.create());
        setNombre(EMPTY);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
