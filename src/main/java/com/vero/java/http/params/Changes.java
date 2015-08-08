package com.vero.java.http.params;

import com.vero.java.model.VeroData;

/**
 * @author szagriichuk.
 */
public class Changes extends BaseDataParam {

    public Changes(VeroData param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "changes";
    }
}
