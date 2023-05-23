package co.edu.uco.publiuco.dto;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import  co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;

public class DepartamentoDTO {

    private UUID codigo;
    private PaisDTO pais;
    private String nombre;

    public DepartamentoDTO(final UUID codigo,final PaisDTO paisDto,final String nombre) {
        setCodigo(codigo);
        setPaisDto(paisDto);
        setNombre(nombre);
    }

    public DepartamentoDTO() {
        setCodigo(UtilUUID.getStringAsUUID());
        setPaisDto(PaisDTO.create());
        setNombre(EMPTY);
    }

    public static final DepartamentoDTO create() {
        return new DepartamentoDTO();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo == null ? UtilUUID.getNewUUID() : UtilUUID.getDefaultUUID(codigo);
    }

    public PaisDTO getPaisDto() {
        if (isNull(pais)) {
            setPaisDto(PaisDTO.create());
        }
        return pais;
    }

    public void setPaisDto(PaisDTO paisDto) {
        this.pais = getDefaultIfNull(paisDto, new PaisDTO());
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
