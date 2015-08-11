package com.vero.java.api;

import com.vero.java.api.params.*;
import com.vero.java.http.callback.ErrorResponseCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vero.java.api.VeroHttpApiUrls.*;
import static com.vero.java.http.HttpExecutor.execute;

/**
 * Default implementation of the {@link UsersApi}.
 *
 * @author szagriichuk.
 */
class DefaultUsersApi extends BaseHttpApi implements UsersApi {

    private static final Logger LOG = LoggerFactory.getLogger(UsersApi.class);

    public DefaultUsersApi(String key) {
        super(key);
    }

    @Override
    public void add(Id id, Email email, UserData data) {
        execute(createPostRequest(createPostDataString(id, email, data), TRACK), new ErrorResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot create user", throwable);
            }
        });
    }

    @Override
    public void update(Id id, Changes data) {
        execute(createPostRequest(createPostDataString(id, data), UPDATE), new ErrorResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot create user", throwable);
            }
        });
    }

    @Override
    public void reidentify(Id id, NewId newId) {
        execute(createPostRequest(createPostDataString(id, newId), REIDENTIFY), new ErrorResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot create user", throwable);
            }
        });
    }
}
