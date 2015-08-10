package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public abstract class IntegerBaseParamTest extends BaseParamTest {
    Integer getParam(String name) {
        if (name != null) {
            return 12345;
        }
        return null;
    }
}
