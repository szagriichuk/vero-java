package com.vero.java.http.params;

import com.vero.java.model.VeroData;
import com.vero.java.serializer.Serializer;

/**
 * @author szagriichuk.
 */
public abstract class BaseDataParam extends Param<String> {
    public BaseDataParam(VeroData param) {
        super(Serializer.serialize(param));
    }
}
