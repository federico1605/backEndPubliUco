package co.edu.uco.publiuco.crosscutting.utils;

public class UtilObject {

    private static final UtilObject INSTANCE = new UtilObject();

    private UtilObject() {

    }
    public static final <T> boolean isNull(T value) {
        return value == null;
    }

    public static final <T> T getDefaultIfNull(T value, T defaultValue) {
        return (isNull(value))? defaultValue : value;
    }
}
