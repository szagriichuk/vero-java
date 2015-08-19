package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class AddTest extends StringBaseParameterTest {

    @Override
    Param<?> getParameter(String name) {
        return new AddTag(name);
    }
}