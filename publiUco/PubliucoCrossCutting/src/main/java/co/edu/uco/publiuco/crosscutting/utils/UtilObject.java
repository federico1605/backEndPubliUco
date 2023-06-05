package co.edu.uco.publiuco.crosscutting.utils;

public class UtilObject {

    private static final UtilObject INSTANCE = new UtilObject();

    private UtilObject() {

    }
    public static <T> boolean isNull(T value) {
        return value == null;
    }

    public static <T> T getDefaultIfNull(T value, T defaultValue) {
        return (isNull(value))? defaultValue : value;
    }
    public static UtilObject getUtilObject() {
        return INSTANCE;
    }
}
