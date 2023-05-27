package co.edu.uco.publiuco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getStringAsUUID;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;
import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.isNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilUUID.getDefaultUUID;

@Entity
@Table(name = "pais")
public class CountryEntity {

    @Id
    private UUID codigo;
    private String nombre;

    public CountryEntity(UUID codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public CountryEntity() {
        setCodigo(getStringAsUUID());
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

    public String getNombre() {
        if (isNull(nombre)) {
            setNombre(EMPTY);
        }
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = applyTrim(nombre);
    }
}
