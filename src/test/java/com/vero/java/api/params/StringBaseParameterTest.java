package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public abstract class StringBaseParameterTest extends BaseParamTest<String>{
    @Override
    String getParamValue() {
        return "Test";
    }
}
