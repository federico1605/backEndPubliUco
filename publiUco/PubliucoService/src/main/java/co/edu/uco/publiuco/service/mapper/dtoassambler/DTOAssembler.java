package co.edu.uco.publiuco.service.mapper.dtoassambler;

public interface DTOAssembler<T,D> {

    D assembleDomain(T dto);
    T assembleDTO(D domain);
}
