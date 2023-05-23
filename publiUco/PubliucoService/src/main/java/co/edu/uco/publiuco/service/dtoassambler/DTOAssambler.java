package co.edu.uco.publiuco.service.dtoassambler;

public interface DTOAssambler<T, D> {

    T assembleDTO(D domain);
    D assemblerDomain(T dto);
}
