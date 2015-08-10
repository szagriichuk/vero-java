package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class NewIdTest extends IntegerBaseParamTest {

    @Override
    Param<?> getParameter(Integer id) {
        return new NewId(id);
    }
}