package co.edu.uco.publiuco.service.mapper.entityassembler.implementation;

import co.edu.uco.publiuco.entity.CityEntity;
import co.edu.uco.publiuco.entity.CountryEntity;
import co.edu.uco.publiuco.entity.DepartmentEntity;
import co.edu.uco.publiuco.service.domain.CityDomain;
import co.edu.uco.publiuco.service.mapper.entityassembler.EntityAssembler;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CiudadEntityAssembler implements EntityAssembler<CityEntity, CityDomain> {

    public CiudadEntityAssembler() {
        super();
        this.modelMapper = new ModelMapper();
    }

    private ModelMapper modelMapper;

    @Override
    public CityDomain assembleDomain(CityEntity entity) {
        return modelMapper.map(entity, CityDomain.class);
    }

    @Override
    public CityEntity assembleEntity(CityDomain domain) {
        CityEntity city =modelMapper.map(domain, CityEntity.class);
//        CountryEntity country = new CountryEntity(domain.getDepartment().getCountryDomain().getId(), domain.getDepartment().getCountryDomain().getName());
//        DepartmentEntity department = new DepartmentEntity(domain.getDepartment().getId(),country,domain.getDepartment().getName());
//        city.setDepartamentEntity(department);
        return city;
    }
}
