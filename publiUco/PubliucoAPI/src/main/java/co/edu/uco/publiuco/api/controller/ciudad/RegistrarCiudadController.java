package co.edu.uco.publiuco.api.controller.ciudad;

import co.edu.uco.publiuco.dto.CiudadDTO;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadUseCaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publiuco/api/v1/ciudad")
public class RegistrarCiudadController {
    @Autowired
    private RegistrarCiudadUseCaseFacade facade;

    @PostMapping()
    public ResponseEntity<CiudadDTO> createCiudad(@RequestBody CiudadDTO ciudad){
        ResponseEntity<CiudadDTO> responseEntity;

        HttpStatus httpStatus = HttpStatus.CREATED;


        return new ResponseEntity<CiudadDTO>(httpStatus);
    }
}
