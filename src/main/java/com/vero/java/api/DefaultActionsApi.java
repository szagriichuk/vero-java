package com.vero.java.api;

import com.vero.java.api.params.ActionData;
import com.vero.java.api.params.EventName;
import com.vero.java.api.params.Identity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vero.java.api.VeroHttpApiUrls.EVENTS_TRACK;

/**
 * @author szagriichuk.
 */
class DefaultActionsApi extends BaseHttpApi implements ActionsApi {

    public DefaultActionsApi(String key) {
        super(key);
    }

    @Override
    public void track(Identity identity, EventName name, ActionData data) {
        post(EVENTS_TRACK, identity, name, data);
    }
}
