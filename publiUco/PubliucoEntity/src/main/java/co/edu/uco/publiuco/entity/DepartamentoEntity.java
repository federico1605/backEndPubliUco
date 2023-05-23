package co.edu.uco.publiuco.entity;

import jakarta.persistence.*;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getStringAsUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;

@Entity
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    private UUID codigo;
    @ManyToOne
    @JoinColumn(name = "pais")
    private PaisEntity paisEntity;
    private String nombre;

    public DepartamentoEntity(UUID codigo, PaisEntity paisEntity, String nombre) {
        this.codigo = codigo;
        this.paisEntity = paisEntity;
        this.nombre = nombre;
    }

    public DepartamentoEntity() {
        setCodigo(getStringAsUUID());
        setPaisEntity(new PaisEntity());
        setNombre(EMPTY);
    }

    public UUID getCodigo() {
        if (isNull(codigo)){
            setCodigo(getStringAsUUID());
        }
        return codigo;
    }

    public void setCodigo(final UUID codigo) {
        this.codigo = getDefaultUUID(codigo);
    }

    public PaisEntity getPaisEntity() {
        if (isNull(paisEntity)) {
            setPaisEntity(new PaisEntity());
        }
        return paisEntity;
    }

    public void setPaisEntity(final PaisEntity paisEntity) {
        this.paisEntity = getDefaultIfNull(paisEntity, new PaisEntity());
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
