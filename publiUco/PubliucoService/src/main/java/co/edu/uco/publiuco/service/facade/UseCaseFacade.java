package co.edu.uco.publiuco.service.facade;

public interface UseCaseFacade<D> {

    void execute(D dto);
}
