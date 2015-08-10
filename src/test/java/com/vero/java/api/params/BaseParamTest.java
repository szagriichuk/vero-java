package com.vero.java.api.params;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public abstract class BaseParamTest {
    @Test
    public void testAddName() throws Exception {
        Param param = getParameter("value");
        Assert.assertEquals(getExpected(param), param.toString());
    }

    @Test
    public void testAddNullName() throws Exception {
        Param param = getParameter(null);
        Assert.assertEquals(getExpected(param), param.toString());
    }

    private String getExpected(Param param) {
        return param.paramName() + "=" + param.param;
    }

    abstract Param<?> getParameter(String name);

}
