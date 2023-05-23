package co.edu.uco.publiuco.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

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
        setCodigo(UtilUUID.getStringAsUUID());
        setDepartamento(DepartamentoDTO.create());
        setNombre(EMPTY);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(codigo);
    }

    public DepartamentoDTO getDepartamento() {
        if (isNull(departamento)) {
            setDepartamento(DepartamentoDTO.create());
        }
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = getDefaultIfNull(departamento, new DepartamentoDTO());
    }

    public String getNombre() {
        if (isNull(nombre)) {
            setNombre(EMPTY);
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = applyTrim(nombre);
    }
}
