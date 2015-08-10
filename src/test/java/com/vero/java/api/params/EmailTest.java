package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class EmailTest extends StringBaseParameterTest {

    @Override
    Param<?> getParameter(String name) {
        return new Email(name);
    }
}