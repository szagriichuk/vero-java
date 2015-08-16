package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class DataTest extends ComplexParamTest {

    @Override
    Param<?> getParameter(VeroData value) {
        return new Data(value);
    }
}