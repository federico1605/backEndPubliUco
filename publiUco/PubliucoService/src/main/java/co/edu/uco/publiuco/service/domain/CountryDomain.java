package co.edu.uco.publiuco.service.domain;

import java.util.UUID;

public class CountryDomain {

    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID codigo) {
        this.id = id;
    }

}
