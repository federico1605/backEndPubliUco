package co.edu.uco.publiuco.crosscutting.utils;

import java.util.Objects;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;

public class UtilText {

    public static final String EMPTY = "";

    private UtilText() {
        super();
    }

    public static final String getDefaultString(String value, String defaultValue) {
        return getDefaultIfNull(value, defaultValue);
    }

    public static final String getDefaultString(String value) {
        return getDefaultString(value, EMPTY);
    }

    public static final String applyTrim(String value) {
        return getDefaultString(value).trim();
    }

    public static final boolean isEmpty(String value) {
        return Objects.equals(value, EMPTY);
    }
}
