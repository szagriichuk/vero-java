package com.vero.java.api.params;

/**
 * Represents {@code auth_token} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class AuthToken extends Param<String> {
    public AuthToken(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "auth_token";
    }
}
