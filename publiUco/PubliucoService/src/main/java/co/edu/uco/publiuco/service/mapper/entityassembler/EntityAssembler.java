package co.edu.uco.publiuco.service.mapper.entityassembler;

public interface EntityAssembler<E,D> {

    D assembleDomain(E entity);
    E assembleEntity(D domain);
}
