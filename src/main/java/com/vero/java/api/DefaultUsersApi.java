package com.vero.java.api;

import com.vero.java.api.params.*;

import static com.vero.java.api.VeroHttpApiUrls.*;

/**
 * Default implementation of the {@link UsersApi}.
 *
 * @author szagriichuk.
 */
class DefaultUsersApi extends BaseHttpApi implements UsersApi {

    public DefaultUsersApi(String key) {
        super(key);
    }

    @Override
    public void add(Id id, Email email, UserData data) {
        post(USERS_TRACK, id, email, data);
    }

    @Override
    public void update(Id id, Changes data) {
        post(UPDATE, id, data);
    }

    @Override
    public void reidentify(Id id, NewId newId) {
        post(REIDENTIFY, id, newId);
    }

    @Override
    public void editTags(Id id, Add add, Remove remove) {
        post(EDIT_TAGS, id, add, remove);
    }
}
