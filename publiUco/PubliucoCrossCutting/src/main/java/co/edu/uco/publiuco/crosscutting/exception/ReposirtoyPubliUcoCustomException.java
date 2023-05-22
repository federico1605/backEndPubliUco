package co.edu.uco.publiuco.crosscutting.exception;

import co.edu.uco.publiuco.crosscutting.exception.enumeration.ExceptionLocation;

import static co.edu.uco.publiuco.crosscutting.utils.UtilText.EMPTY;

public class ReposirtoyPubliUcoCustomException extends PubliUcoCustomException{
    private ReposirtoyPubliUcoCustomException(Exception rootException, String technicalMessage, String userMessage) {
        super(rootException, technicalMessage, userMessage, ExceptionLocation.REPOSITORY);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage) {
        return new ReposirtoyPubliUcoCustomException(new Exception(), technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException create(final String userMessage, final String technicalMessage,
                                                       final Exception rootException) {
        return new ReposirtoyPubliUcoCustomException(rootException, technicalMessage, userMessage);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage) {
        return new ReposirtoyPubliUcoCustomException(new Exception(), technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createTechnicalException(final String technicalMessage, final Exception rootException) {
        return new ReposirtoyPubliUcoCustomException(rootException, technicalMessage,EMPTY);
    }

    public static final PubliUcoCustomException createUserException(final String userMessage, final Exception rootException) {
        return new ReposirtoyPubliUcoCustomException(rootException, userMessage, userMessage);
    }
}
