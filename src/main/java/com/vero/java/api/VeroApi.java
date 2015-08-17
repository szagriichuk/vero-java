package com.vero.java.api;

/**
 * @author szagriichuk.
 */
public class VeroApi extends BaseHttpApi {

    public VeroApi(String key) {
        super(key);
    }

    public ActionsApi actions() {
        return new BaseActionsApi(key);
    }

    public UsersApi users() {
        return new BaseUsersApi(key);
    }

    public HeartbeatApi heartbeat() {
        return new BaseHeartbeatApi(key);
    }
}
