package com.vero.java.http.params;

import com.vero.java.model.BaseData;
import com.vero.java.serializer.Serializer;

/**
 * @author szagriichuk.
 */
public abstract class BaseDataParam extends Param<String> {
    public BaseDataParam(BaseData param) {
        super(Serializer.serialize(param));
    }
}
