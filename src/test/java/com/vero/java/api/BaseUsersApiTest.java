package com.vero.java.api;

import com.vero.java.api.params.*;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class BaseUsersApiTest {

    @Test
    public void testAdd() throws Exception {
        UsersApi usersApi = new BaseUsersApi("TOKEN");
        usersApi.add(new Id(1234), new Email("john@smith.com"), new UserData(new VeroData(){{
            add(new FirstName("John"));
            add(new LastName("Smith"));
        }}));
    }

    @Test
    public void testUpdate() throws Exception {
        UsersApi usersApi = new BaseUsersApi("TOKEN");
        usersApi.update(new Id(1234),  new Changes(new VeroData(){{
            add(new FirstName("Mark"));
            add(new LastName("Twain"));
        }}));
    }

    @Test
    public void testReidentify() throws Exception {
        UsersApi usersApi = new BaseUsersApi("TOKEN");
        usersApi.reidentify(new Id(1234), new NewId(4321));
    }
}