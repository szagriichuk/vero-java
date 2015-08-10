package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class EmailTest extends BaseParamTest {

    @Override
    Param<?> getParameter(String name) {
        return new Email(name);
    }
}