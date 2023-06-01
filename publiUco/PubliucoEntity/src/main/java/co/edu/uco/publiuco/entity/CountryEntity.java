package co.edu.uco.publiuco.entity;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import jakarta.persistence.Column;
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
    @Column(name = "codigo")
    private UUID id;
    @Column(name = "nombre")
    private String name;

    public CountryEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryEntity() {
        setId(getStringAsUUID());
        setName(EMPTY);
    }

    public static CountryEntity build(UUID id, String name) {
        return new CountryEntity(id, name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = UtilUUID.getDefaultUUID(id);
    }

    public void setName(String name) {
        this.name = UtilText.getDefaultString(name);
    }}
