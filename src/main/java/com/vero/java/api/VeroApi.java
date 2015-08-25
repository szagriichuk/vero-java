package com.vero.java.api;

/**
 * The Vero API only has two key models: users and actions.
 * The API is designed to be easy to use and understand.
 * <p/>
 * <b>Authentication</b>
 * You authenticate to the Vero API by providing your authorization token during creating new {@link VeroApi} instance.
 * You can manage your API keys and authorization token in your Vero account.
 * Your authorization token and API keys carry privileges so be sure to keep them secret.
 *
 * @author szagriichuk.
 */
public class VeroApi extends BaseHttpApi {

    public VeroApi(String key) {
        super(key);
    }

    /**
     * Returns a new instance of the default implementation of {@link ActionsApi};
     */
    public ActionsApi actions() {
        return new BaseActionsApi(key);
    }

    /**
     * Returns a new instance of the default implementation of {@link UsersApi};
     */
    public UsersApi users() {
        return new BaseUsersApi(key);
    }

    /**
     * Returns a new instance of the default implementation of {@link HeartbeatApi};
     */
    public HeartbeatApi heartbeat() {
        return new BaseHeartbeatApi(key);
    }

    /**
     * Returns a new instance of the default implementation of {@link CustomerApi};
     */
    public CustomerApi customers() {
        return new BaseCustomerApi(key);
    }
}
