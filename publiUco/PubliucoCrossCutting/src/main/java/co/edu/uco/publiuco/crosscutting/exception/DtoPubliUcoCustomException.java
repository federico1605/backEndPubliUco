package co.edu.uco.publiuco.crosscutting.exception;

import co.edu.uco.publiuco.crosscutting.exception.enumeration.ExceptionLocation;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public class DtoPubliUcoCustomException extends PubliUcoCustomException{
    private DtoPubliUcoCustomException(Exception rootException, String technicalMessage, String userMessage) {
        super(rootException, technicalMessage, userMessage, ExceptionLocation.DTO);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage) {
        return new DtoPubliUcoCustomException(new Exception(), technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage,
                                                       final Exception rootException) {
        return new DtoPubliUcoCustomException(rootException, technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage) {
        return new DtoPubliUcoCustomException(new Exception(), technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
        return new DtoPubliUcoCustomException(rootException, technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createUserException(final String userMessage, final Exception rootException) {
        return new DtoPubliUcoCustomException(rootException, userMessage, userMessage);
    }
}
