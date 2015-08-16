package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class ChangesTest extends ComplexParamTest {

    @Override
    Param<?> getParameter(VeroData value) {
        return new Changes(value);
    }
}