package com.vero.java.api;

import com.vero.java.api.params.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.vero.java.api.VeroHttpApiUrls.*;

/**
 * Default implementation of the {@link UsersApi}.
 *
 * @author szagriichuk.
 */
class BaseUsersApi extends BaseHttpApi implements UsersApi {

    public BaseUsersApi(String key) {
        super(key);
    }

    @Override
    public void add(Id id, Email email, UserData data) {
        post(USERS_TRACK, createVeroData(id, email, data));
    }

    @Override
    public void update(Id id, Changes data) {
        put(UPDATE, createVeroData(id, data));
    }

    @Override
    public void reidentify(Id id, NewId newId) {
        put(REIDENTIFY, createVeroData(id, newId));
    }

    @Override
    public void editTags(Id id, Tag... tags) {
        put(EDIT_TAGS, createVeroData(toParams(id, tags)));
    }

    private Param<?>[] toParams(Id id, Tag[] tags) {
        List<Param<?>> paramList = new ArrayList<>();
        Collections.addAll(paramList, id);
        Collections.addAll(paramList, tags);
        return paramList.toArray(new Param<?>[paramList.size()]);
    }

    @Override
    public void unsubscribe(Id id) {
        post(UNSUBSCRIBE, createVeroData(id));
    }

    @Override
    public void resubscribe(Id id) {
        post(RESUBSCRIBE, createVeroData(id));
    }

    @Override
    public void delete(Id id) {
        post(DELETE, createVeroData(id));
    }
}
