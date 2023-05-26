package co.edu.uco.publiuco.crosscutting.exception;

import co.edu.uco.publiuco.crosscutting.exception.enumeration.ExceptionLocation;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public class ServicePubliUcoCustomException extends PubliUcoCustomException{
    private ServicePubliUcoCustomException(Exception rootException, String technicalMessage, String userMessage) {
        super(rootException, technicalMessage, userMessage, ExceptionLocation.SERVICE);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage) {
        return new ServicePubliUcoCustomException(new Exception(), technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage,
                                                       final Exception rootException) {
        return new ServicePubliUcoCustomException(rootException, technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage) {
        return new ServicePubliUcoCustomException(new Exception(), technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
        return new ServicePubliUcoCustomException(rootException, technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createUserException(final String userMessage) {
        return new ServicePubliUcoCustomException(null, userMessage,userMessage);
    }
}
