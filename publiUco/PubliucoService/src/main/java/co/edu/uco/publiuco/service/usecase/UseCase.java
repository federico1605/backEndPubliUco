package co.edu.uco.publiuco.service.usecase;

public interface UseCase<D> {

    void execute(D domain);
}
