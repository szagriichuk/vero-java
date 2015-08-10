package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public abstract class IntegerBaseParamTest extends BaseParamTest<Integer> {
    @Override
    Integer getParamValue() {
        return 12345;
    }
}
