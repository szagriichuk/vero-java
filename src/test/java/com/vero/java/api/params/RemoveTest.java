package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class RemoveTest extends BaseParamTest {

    @Override
    Param<?> getParameter(String name) {
        return new Remove(name);
    }
}