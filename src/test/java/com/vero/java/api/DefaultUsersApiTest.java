package com.vero.java.api;

import com.vero.java.api.params.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class DefaultUsersApiTest {

    @Test
    public void testAdd() throws Exception {
        UsersApi usersApi = new DefaultUsersApi("faeb1ce37aeac6f563f768c7360b7c0ef16f1563");
        usersApi.add(new Id(1234), new Email("john@smith.com"), new UserData(new VeroData(){{
            add(new FirstName("John"));
            add(new LastName("Smith"));
        }}));
    }

    @Test
    public void testUpdate() throws Exception {
        UsersApi usersApi = new DefaultUsersApi("faeb1ce37aeac6f563f768c7360b7c0ef16f1563");
        usersApi.update(new Id(1234),  new Changes(new VeroData(){{
            add(new FirstName("Mark"));
            add(new LastName("Twain"));
        }}));
    }
    @Test
    public void testReidentify() throws Exception {
        UsersApi usersApi = new DefaultUsersApi("faeb1ce37aeac6f563f768c7360b7c0ef16f1563");
        usersApi.reidentify(new Id(1234), new NewId(4321));
    }
}