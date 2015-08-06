package com.vero.java.api;

/**
 * @author szagriichuk.
 */
public class VeroApi extends Key {

    public VeroApi(String key) {
        super(key);
    }

    public ActionsApi actions(){
        return new DefaultActionsApi(key);
    }

    public AuthenticationApi authentications(){
        return null;
    }

    public TagsApi tags(){
        return null;
    }

    public UsersApi users(){
        return null;
    }
}
