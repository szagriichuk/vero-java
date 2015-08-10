package com.vero.java.api.params;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class IdTest extends IntegerBaseParamTest{

    @Override
    Param<?> getParameter(Integer id) {
        return new Id(id);
    }
}