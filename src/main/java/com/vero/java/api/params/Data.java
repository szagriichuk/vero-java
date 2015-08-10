package com.vero.java.api.params;

/**
 * Represents {@code data} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Data<T> extends ComplexParam {
    public Data(VeroData<T> param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "data";
    }
}
