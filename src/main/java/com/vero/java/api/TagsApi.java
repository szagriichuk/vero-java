package com.vero.java.api;

import com.vero.java.api.params.Add;
import com.vero.java.api.params.Id;
import com.vero.java.api.params.Remove;

/**
 * @author szagriichuk.
 */
public interface TagsApi {
    void edit(Id id, Add add, Remove remove);
}
