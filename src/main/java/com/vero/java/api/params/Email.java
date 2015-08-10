package com.vero.java.api.params;

/**
 * Represents {@code email} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Email extends StringParam {
    public Email(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "email";
    }
}
