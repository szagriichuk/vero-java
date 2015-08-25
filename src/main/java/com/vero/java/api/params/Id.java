package com.vero.java.api.params;

/**
 * Represents {@code id} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Id extends Param<Integer> {
    public Id(Integer param) {
        super(param);
    }

    @Override
    public String name() {
        return "id";
    }
}
