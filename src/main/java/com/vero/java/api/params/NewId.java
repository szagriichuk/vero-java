package com.vero.java.api.params;

/**
 * Represents {@code new_id} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class NewId extends Param<Integer> {
    public NewId(Integer param) {
        super(param);
    }

    @Override
    public String name() {
        return "new_id";
    }
}
