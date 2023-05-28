package co.edu.uco.publiuco.service.usecase.ciudad.implementation;

import co.edu.uco.publiuco.repository.CityRepository;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.usecase.ciudad.ListarCiudadesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListarCiudadesUseCaseImpl implements ListarCiudadesUseCase {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<CityDomain> execute(Optional<CityDomain> domain) {
        return null;
    }
}
