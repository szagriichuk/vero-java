package com.vero.java.api;

import com.vero.java.api.params.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class BaseUsersApiTest {
    private UsersApi usersApi;

    @Before
    public void setUp() throws Exception {
        usersApi = new BaseUsersApi("TOKEN");
    }

    @Test
    public void testAdd() throws Exception {
        usersApi.add(new Id(123), new Email("test@gmail.com"), new UserData(VeroData.
                of().
                of(new StringParamWithName("test1", "123")).
                of(new StringParamWithName("test1", "123")).build()
        ));
    }


    @Test
    public void testUpdate() throws Exception {
        usersApi.update(new Id(1234), new Changes(VeroData.of().of(
                new FirstName("Mark")).of(
                new LastName("Twain")).build()
        ));
    }

    @Test
    public void testReidentify() throws Exception {
        usersApi.reidentify(new Id(1234), new NewId(4321));
    }

    @Test
    public void testEditTags() throws Exception {
        usersApi.editTags(new Id(1234), new AddTag("warm-lead"), new RemoveTag("prospect"));
    }

    @Test
    public void testUnsubscribes() throws Exception {
        usersApi.unsubscribe(new Id(1234));
    }

    @Test
    public void testResubscribes() throws Exception {
        usersApi.resubscribe(new Id(1234));
    }
}