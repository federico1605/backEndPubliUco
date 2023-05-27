package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.CountryEntity;
import co.edu.uco.publiuco.service.domain.CountryDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PaisEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {

    private  ModelMapper modelMapper;

    public PaisEntityAssembler() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public CountryDomain assembleDomain(CountryEntity entity) {
        return modelMapper.map(entity, CountryDomain.class);
    }

    @Override
    public CountryEntity assembleEntity(CountryDomain domain) {
        return modelMapper.map(domain, CountryEntity.class);
    }
}
