package com.vero.java.api;

/**
 * @author szagriichuk.
 */
public class VeroApiException extends RuntimeException {
    public VeroApiException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
