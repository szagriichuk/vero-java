package com.vero.java.api.params;

/**
 * Represents {@code add} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Add extends StringParam {
    public Add(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "add";
    }
}
