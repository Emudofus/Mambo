package org.mambo.core.login.service.login.crypto;

/**
 * Created with IntelliJ IDEA.
 * User: Blackrush
 * Date: 25/12/12
 * Time: 00:36
 */
public class BadCredentialsException extends RuntimeException {
    public BadCredentialsException() {
    }

    public BadCredentialsException(String message) {
        super(message);
    }

    public BadCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCredentialsException(Throwable cause) {
        super(cause);
    }

    public BadCredentialsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
