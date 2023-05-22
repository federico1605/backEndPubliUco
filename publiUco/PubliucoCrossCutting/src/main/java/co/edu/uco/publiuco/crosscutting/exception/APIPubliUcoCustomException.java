package co.edu.uco.publiuco.crosscutting.exception;

import co.edu.uco.publiuco.crosscutting.exception.enumeration.ExceptionLocation;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public class APIPubliUcoCustomException extends PubliUcoCustomException{
    private APIPubliUcoCustomException(Exception rootException, String technicalMessage, String userMessage) {
        super(rootException, technicalMessage, userMessage, ExceptionLocation.API);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage) {
        return new APIPubliUcoCustomException(new Exception(), technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage,
                                                         final Exception rootException) {
        return new APIPubliUcoCustomException(rootException, technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage) {
        return new APIPubliUcoCustomException(new Exception(), technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
        return new APIPubliUcoCustomException(rootException, technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createUserException(final String userMessage, final Exception rootException) {
        return new APIPubliUcoCustomException(rootException, userMessage, userMessage);
    }
}
