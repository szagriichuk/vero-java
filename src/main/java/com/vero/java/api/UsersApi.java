package com.vero.java.api;

import com.vero.java.api.params.*;

/**
 * @author szagriichuk.
 */
public interface UsersApi {
    void add(Id id, Email email, UserData data);

    void update(Id id, Changes data);

    void reidentify(Id id, NewId newId);
}
