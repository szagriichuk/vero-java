package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public abstract class ComplexParamTest extends BaseParamTest<VeroData> {
    @Override
    VeroData getParamValue() {
        VeroData data = new VeroData();
        data.add(new FirstName("Test1"));
        return data;
    }
}
