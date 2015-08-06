package com.vero.java.http.params;

import com.vero.java.model.BaseData;

/**
 * @author szagriichuk.
 */
public class Identity extends BaseDataParam {
    public Identity(BaseData param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "identity";
    }
}
