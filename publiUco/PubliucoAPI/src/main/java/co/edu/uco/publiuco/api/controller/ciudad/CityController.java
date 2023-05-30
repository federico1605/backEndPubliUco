package co.edu.uco.publiuco.api.controller.ciudad;

import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadUseCaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
    @Autowired
    private RegistrarCiudadUseCaseFacade facade;

    @PostMapping
    public ResponseEntity<CityDTO> createCiudad(@RequestBody CityDTO ciudad){
        ResponseEntity<CityDTO> responseEntity;

        HttpStatus httpStatus = HttpStatus.CREATED;
        try {
            facade.execute(ciudad);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
        }



        return new ResponseEntity<>(ciudad,httpStatus);
    }
}
