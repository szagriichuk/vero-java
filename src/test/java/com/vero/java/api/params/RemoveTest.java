package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class RemoveTest extends StringBaseParameterTest {

    @Override
    Param<?> getParameter(String name) {
        return new RemoveTag(name);
    }
}