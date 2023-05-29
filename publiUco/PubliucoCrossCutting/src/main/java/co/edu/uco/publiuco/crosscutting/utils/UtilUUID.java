package co.edu.uco.publiuco.crosscutting.utils;

import java.util.UUID;

import static co.edu.uco.publiuco.crosscutting.utils.UtilObject.getDefaultIfNull;

public class UtilUUID {

    public static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
    public static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);

    private UtilUUID() {
        super();
    }

    public static final UUID getDefaultUUID(final UUID value) {
        return (value == null) ? DEFAULT_UUID:value;
    }

    public static final UUID getNewUUID() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while(isDefaultUUID(uuid));
        return uuid;
    }

    public static final String getUUIDAsString(final UUID value) {
        return getDefaultUUID(value).toString();
    }

    public static final UUID getStringAsUUID() {
        return UUID.fromString(DEFAULT_UUID_AS_STRING);
    }
    public static final UUID getStringAsUUID(final String value) {
        return UUID.fromString(value);
    }

    public static final boolean isDefaultUUID(final UUID value) {
        return DEFAULT_UUID.equals(value);
    }
}
