package org.mambo.core.configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/11/12
 * Time: 10:24
 */
public class KeyNotFoundException extends RuntimeException {
    private final String key;

    public KeyNotFoundException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return "key \"" + key + "\" not found";
    }
}
