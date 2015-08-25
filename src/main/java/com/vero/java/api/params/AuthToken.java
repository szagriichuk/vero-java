package com.vero.java.api.params;

/**
 * Represents {@code auth_token} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class AuthToken extends StringParam {
    public AuthToken(String param) {
        super(param);
    }

    @Override
    public String name() {
        return "auth_token";
    }
}
