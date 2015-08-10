package com.vero.java.api.params;

import java.util.HashMap;

/**
 * Base abstraction of the vero data.
 *
 * @author szagriichuk.
 */
public class VeroData<T> extends HashMap<String, T> {
    public void add(Param<T> param) {
        put(param.paramName(), param.value);
    }
}
