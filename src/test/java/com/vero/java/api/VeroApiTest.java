package com.vero.java.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.vero.java.api.params.*;
import org.junit.Assert;
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
        VeroApi veroApi = new VeroApi("ZmFlYjFjZTM3YWVhYzZmNTYzZjc2OGM3MzYwYjdjMGVmMTZmMTU2Mzo4NTcyOTU3NjkwNjRjNTAxMTU4ZjkxMTdkMTRjOWQ3NDBkZDFkMTNk");
        try {
            veroApi.actions().track(new Identity(VeroData.of(new Id(142549103)).
                    of(new Email("sergii@hitplay.com")).build()),
                    new EventName("test"), new ActionData(VeroData.
                            of(new StringParamWithName("test1","Test test")).build()) );
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testUsersDelete() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.users().delete(new Id(123456));
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testUsersUnsubscribe() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.users().unsubscribe(new Id(12345678));
            veroApi.users().update(new Id(12345678), new Changes(VeroData.of(new StringParamWithName("user_email_opt_in", "false")).build()));
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testUsersReSubscribe() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            veroApi.users().resubscribe(new Id(123456789));
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testGetById() throws Exception {
        VeroApi veroApi = new VeroApi("KEY");
        try {
            JsonNode data = veroApi.customers().getById(new Id(12345678));
            TimeUnit.SECONDS.sleep(3);
            Assert.assertNotNull(data);
        } catch (Exception e) {
            fail("The add user is fail");
        }
    }

    @Test
    public void testUpdate() throws Exception {
        VeroApi veroApi = new VeroApi("ZmFlYjFjZTM3YWVhYzZmNTYzZjc2OGM3MzYwYjdjMGVmMTZmMTU2Mzo4NTcyOTU3NjkwNjRjNTAxMTU4ZjkxMTdkMTRjOWQ3NDBkZDFkMTNk");
        try {
            veroApi.users().update(new Id(123456789), new Changes(
                    VeroData.
                            of( new Email("johnLLLLLL@smith.com")).
                            of(new FirstName("JohnLLL")).
                            of(new LastName("SmithLLL")).
                            of(new StringParamWithName("user_email_opt_in", "true")).
                            of(new StringParamWithName("opt_out", "true")).
                            build()
            ));
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