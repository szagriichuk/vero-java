package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class FirstName extends StringParam {

    public FirstName(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "firstname";
    }
}
