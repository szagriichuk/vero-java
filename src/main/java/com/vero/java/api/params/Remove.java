package com.vero.java.api.params;

/**
 * Represents {@code remove} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Remove extends Param<String> {
    public Remove(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "remove";
    }
}
