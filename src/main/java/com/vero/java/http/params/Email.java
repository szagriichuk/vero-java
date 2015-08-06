package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public class Email extends Param<String> {
    public Email(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "email";
    }
}
