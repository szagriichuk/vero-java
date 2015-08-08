package com.vero.java.http.params;

import com.vero.java.model.VeroData;

/**
 * @author szagriichuk.
 */
public class Identity extends BaseDataParam {
    public Identity(VeroData param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "identity";
    }
}
