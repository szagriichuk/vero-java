package com.vero.java.api;

import com.vero.java.api.params.*;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * @author szagriichuk.
 */
public class VeroApiTest {

    @Test
    public void testActions() throws Exception {
        // TODO
    }

    @Test
    public void testUsersAdd() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.users().add(new Id(12345), new Email("john@smith.com"), new UserData(
                    VeroData.of().
                            of(new FirstName("John")).
                            of(new LastName("Smith")).
                            build()
            ));
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testUsersDelete() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.users().delete(new Id(12345));
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testUsersUnsubscribe() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.users().unsubscribe(new Id(12345));
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testHeartbeat() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.heartbeat().heartbeat();
        } catch (Exception e) {
            fail("The hearbeat is fail");
        }
    }
}