package com.vero.java.api;

import com.vero.java.api.params.ActionData;
import com.vero.java.api.params.EventName;
import com.vero.java.api.params.Identity;

/**
 * @author szagriichuk.
 */
public interface ActionsApi {
    void track(Identity identity, EventName name, ActionData data);
}
