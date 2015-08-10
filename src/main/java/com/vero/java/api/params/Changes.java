package com.vero.java.api.params;

/**
 * Represents {@code changes} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Changes extends ComplexParam<String> {

    public Changes(VeroData<String> param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "changes";
    }
}
