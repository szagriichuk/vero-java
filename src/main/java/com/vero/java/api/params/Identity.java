package com.vero.java.api.params;


/**
 * Represents {@code identity} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Identity extends ComplexParam<String> {
    public Identity(VeroData<String> param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "identity";
    }
}
