package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class IdentityTest extends ComplexParamTest {

    @Override
    Param<?> getParameter(VeroData value) {
        return new Identity(value);
    }
}