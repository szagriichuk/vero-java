package com.vero.java.http.params;

/**
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
