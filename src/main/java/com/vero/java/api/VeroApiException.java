package com.vero.java.api;

/**
 * Indicates when something wrong with Vero API.
 *
 * @author szagriichuk.
 */
public class VeroApiException extends RuntimeException {
    public VeroApiException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
