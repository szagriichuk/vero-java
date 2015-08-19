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
        usersApi.add(new Id(123), new Email("test@gmail.com"), new UserData(new VeroData() {
            {
                add(new StringParamWithName("test1", "123"));
                add(new StringParamWithName("test1", "123"));
                add(new StringParamWithName("test2", "321"));
            }
        }));
    }


    @Test
    public void testUpdate() throws Exception {
        usersApi.update(new Id(1234), new Changes(new VeroData() {{
            add(new FirstName("Mark"));
            add(new LastName("Twain"));
        }}));
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