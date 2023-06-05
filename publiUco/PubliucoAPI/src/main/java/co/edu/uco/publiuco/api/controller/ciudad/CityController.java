package co.edu.uco.publiuco.api.controller.ciudad;

import co.edu.uco.publiuco.api.response.Response;
import co.edu.uco.publiuco.api.response.dto.Message;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoCustomException;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.dto.CityDTO;
import co.edu.uco.publiuco.service.facade.ciudad.RegistrarCiudadUseCaseFacade;
import co.edu.uco.publiuco.service.port.MailPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1/city")
public class CityController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailPort mailPort;

    @Autowired
    private RegistrarCiudadUseCaseFacade facade;

    @PostMapping
    public ResponseEntity<Response<CityDTO>>  createCity(@RequestBody CityDTO city){
        Response<CityDTO> response = new Response<>();
        ResponseEntity<Response<CityDTO>> responseEntity;
        HttpStatus httpStatus = HttpStatus.CREATED;
        response.setData(new ArrayList<>());
        try {
            facade.execute(city);
            response.addData(city);
            response.addMessage(Message.createSuccessMessage("City register succesfully", "The City has register succesfully :)"));
            mailPort.sendMail("City register succesfully" , "federico.zapata4970@soyuco.edu.co", "The City  a register succesfully");
        } catch (PubliUcoCustomException exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createErrorMessage(exception.getUserMessage(), "Create city Error"));
            if (!UtilObject.isNull(exception.getCause())
                    && exception.isTechnicalException()) {
                response.addMessage(Message.createErrorMessage(exception.getMessage(),"Technical Message"));
            }
        } catch (Exception exception) {
            httpStatus = HttpStatus.BAD_REQUEST;
            response.addMessage(Message.createFatalMessage(exception.getMessage(), "Unexpected Error"));
            log.error(exception.getMessage());
        }
        responseEntity = new ResponseEntity<Response<CityDTO>>(response,httpStatus);
        return responseEntity;
    }
}
