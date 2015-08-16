package com.vero.java.api;

import static com.vero.java.api.VeroHttpApiUrls.HEARTBEAT;

/**
 * @author szagriichuk.
 */
public class VeroApi extends BaseHttpApi {

    public VeroApi(String key) {
        super(key);
    }

    public ActionsApi actions() {
        return new DefaultActionsApi(key);
    }

    public UsersApi users() {
        return new DefaultUsersApi(key);
    }

    public void heartbeat() {
        post(HEARTBEAT);
    }
}
