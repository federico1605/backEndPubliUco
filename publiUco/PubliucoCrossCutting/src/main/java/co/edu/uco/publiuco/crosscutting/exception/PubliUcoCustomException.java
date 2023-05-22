package co.edu.uco.publiuco.crosscutting.exception;

import co.edu.uco.publiuco.crosscutting.exception.enumeration.ExceptionLocation;

import java.io.Serial;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.applyTrim;
import static co.edu.uco.publiuco.crosscutting.utils.UtilText.isEmpty;

public class PubliUcoCustomException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1248346293196099172L;
    private String userMessage;
    private ExceptionLocation layer;

    protected PubliUcoCustomException(final Exception rootException, final String technicalMessage, final String userMessage, final ExceptionLocation layer) {
        super(applyTrim(technicalMessage),getDefaultIfNull(rootException, new Exception()));
        setUserMessage(userMessage);
        setLayer(layer);
    }

    public final String getUserMessage() {
        return userMessage;
    }

    private final void setUserMessage(final String userMessage) {
        this.userMessage = applyTrim(userMessage);
    }

    public final ExceptionLocation getLayer() {
        return layer;
    }

    private final void setLayer(final ExceptionLocation layer) {
        this.layer = getDefaultIfNull(layer, ExceptionLocation.SERVICE);
    }

    public final boolean isTechnicalException() {
        return isEmpty(getUserMessage());
    }

}
