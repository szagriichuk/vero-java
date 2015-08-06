package com.vero.java.http.params;

import com.vero.java.model.BaseData;
import com.vero.java.serializer.Serializer;

/**
 * @author szagriichuk.
 */
public class Data extends BaseDataParam {
    public Data(BaseData param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "data";
    }
}
