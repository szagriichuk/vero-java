package com.vero.java.api.params;

/**
 * Represents {@code add} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class AddTag extends Tag {
    public AddTag(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "add";
    }
}
