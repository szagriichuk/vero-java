package com.vero.java.api;

/**
 * This API is available to be pinged on an regular basis for mission critical operations.
 * It provides you with a functionality of checking the status of the Vero API.
 *
 * @author szagriichuk.
 */
interface HeartbeatApi {
    /**
     * A successful response will log the following JSON response with a 200 status code.
     * <pre>
     * {@code
     * {"status":200,"message":"Vero api is up"} }
     * </pre>
     * in other cases will throw the {@link VeroApiException} exception with problem indication.
     */
    void heartbeat() throws VeroApiException;
}
