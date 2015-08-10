package com.vero.java.api.params;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class EventNameTest extends StringBaseParameterTest{

    @Override
    Param<?> getParameter(String name) {
        return new EventName(name);
    }
}