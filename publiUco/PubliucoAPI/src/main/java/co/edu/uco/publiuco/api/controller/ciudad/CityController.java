package co.edu.uco.publiuco.api.controller.ciudad;

import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadUseCaseFacade;
import co.edu.uco.publiuco.service.facade.ciudad.implementacion.RegistrarCiudadUseCaseFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/city")
public class CityController {


    @Autowired
    private RegistrarCiudadUseCaseFacade facade;

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO city){
        ResponseEntity<CityDTO> responseEntity;


        HttpStatus httpStatus = HttpStatus.CREATED;
        try {
            facade.execute(city);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            httpStatus = HttpStatus.BAD_REQUEST;
        }



        return new ResponseEntity<>(city,httpStatus);
    }
}
