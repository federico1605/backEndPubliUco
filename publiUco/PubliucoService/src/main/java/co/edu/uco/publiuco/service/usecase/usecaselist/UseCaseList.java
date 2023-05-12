package co.edu.uco.publiuco.service.usecase.usecaselist;

import java.util.List;
import java.util.Optional;

public interface UseCaseList<D> {
    List<D> execute(Optional<D> domain);
}
