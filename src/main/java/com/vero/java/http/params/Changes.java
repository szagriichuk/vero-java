package com.vero.java.http.params;

import com.vero.java.model.BaseData;

/**
 * @author szagriichuk.
 */
public class Changes extends BaseDataParam {

    public Changes(BaseData param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "changes";
    }
}
