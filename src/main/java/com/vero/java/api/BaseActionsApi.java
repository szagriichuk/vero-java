package com.vero.java.api;

import com.vero.java.api.params.ActionData;
import com.vero.java.api.params.EventName;
import com.vero.java.api.params.Identity;

import static com.vero.java.api.VeroHttpApiUrls.EVENTS_TRACK;

/**
 * @author szagriichuk.
 */
class BaseActionsApi extends BaseHttpApi implements ActionsApi {

    public BaseActionsApi(String key) {
        super(key);
    }

    @Override
    public void track(Identity identity, EventName name, ActionData data) {
        post(EVENTS_TRACK, identity, name, data);
    }
}
