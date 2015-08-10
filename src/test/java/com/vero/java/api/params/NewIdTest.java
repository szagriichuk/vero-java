package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class NewIdTest extends IntegerBaseParamTest {

    @Override
    Param<?> getParameter(String name) {
        return new NewId(getParam(name));
    }
}