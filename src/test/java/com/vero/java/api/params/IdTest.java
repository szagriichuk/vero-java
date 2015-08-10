package com.vero.java.api.params;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class IdTest extends IntegerBaseParamTest{

    @Override
    Param<?> getParameter(String name) {
        return new Id(getParam(name));
    }
}