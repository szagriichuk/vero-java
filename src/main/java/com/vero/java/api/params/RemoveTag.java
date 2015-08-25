package com.vero.java.api.params;

/**
 * Represents {@code remove} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class RemoveTag extends Tag {
    public RemoveTag(String param) {
        super(param);
    }

    @Override
    public String name() {
        return "remove";
    }
}
