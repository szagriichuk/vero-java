package com.vero.java.api.params;

/**
 * Represents {@code data} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class Data extends ComplexParam {
    public Data(VeroData param) {
        super(param);
    }

    @Override
    public String name() {
        return "data";
    }
}
