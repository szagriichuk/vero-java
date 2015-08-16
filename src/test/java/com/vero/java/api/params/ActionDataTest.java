package com.vero.java.api.params;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class ActionDataTest extends ComplexParamTest{

    @Override
    Param<?> getParameter(VeroData value) {
        return new ActionData(value);
    }
}