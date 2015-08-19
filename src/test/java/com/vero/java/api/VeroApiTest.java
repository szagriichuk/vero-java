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
            veroApi.users().add(new Id(123), new Email("test@gmail.com"), new UserData(new VeroData() {
                {
                    add(new StringParamWithName("test1", "123"));
                    add(new StringParamWithName("test1", "123"));
                    add(new StringParamWithName("test2", "321"));
                }
            }));
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