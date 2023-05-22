package co.edu.uco.publiuco.dto;

import java.util.UUID;

public class DepartamentoDTO {

    private UUID codigo;
    private PaisDTO paisDto;
    private String nombre;

    private DepartamentoDTO(final UUID codigo,final PaisDTO paisDto,final String nombre) {
        this.codigo = codigo;
        this.paisDto = paisDto;
        this.nombre = nombre;
    }

    private DepartamentoDTO() {
    }

    public static final DepartamentoDTO create() {
        return new DepartamentoDTO();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public PaisDTO getPaisDto() {
        return paisDto;
    }

    public void setPaisDto(PaisDTO paisDto) {
        this.paisDto = paisDto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
