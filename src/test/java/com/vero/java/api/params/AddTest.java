package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class AddTest extends BaseParamTest {

    @Override
    Param<?> getParameter(String name) {
        return new Add(name);
    }
}