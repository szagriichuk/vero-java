package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class StringParamWithName extends StringParam {
    private String name;

    public StringParamWithName(String name, String value) {
        super(value);
        this.name = name;
    }

    @Override
    protected String paramName() {
        return name;
    }
}
