package co.edu.uco.publiuco.dto;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class CityDTO {
    private UUID codigo;
    private DepartmentDTO departamento;
    private String nombre;

    public CityDTO(final UUID codigo, final DepartmentDTO departamento, final String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public CityDTO() {
        setCodigo(UtilUUID.getStringAsUUID());
        setDepartamento(DepartmentDTO.create());
        setNombre(EMPTY);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(codigo);
    }

    public DepartmentDTO getDepartamento() {
        if (isNull(departamento)) {
            setDepartamento(DepartmentDTO.create());
        }
        return departamento;
    }

    public void setDepartamento(DepartmentDTO departamento) {
        this.departamento = getDefaultIfNull(departamento, new DepartmentDTO(departamento.getCodigo(),departamento.getPaisDto(),departamento.getNombre()));
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
