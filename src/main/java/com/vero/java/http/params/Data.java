package com.vero.java.http.params;

import com.vero.java.model.VeroData;

/**
 * @author szagriichuk.
 */
public class Data extends BaseDataParam {
    public Data(VeroData param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "data";
    }
}
