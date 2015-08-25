package com.vero.java.api.params;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public abstract class BaseParamTest<T> {
    @Test
    public void testRealName() throws Exception {
        Param param = getParameter(getParamValue());
        Assert.assertEquals(getExpected(param), param.toString());
    }

    @Test
    public void testNullName() throws Exception {
        Param param = getParameter(null);
        Assert.assertEquals(getExpected(param), param.toString());
    }

    private String getExpected(Param param) {
        return param.name() + "=" + param.value;
    }

    abstract Param<?> getParameter(T value);

    abstract T getParamValue();

}
