package com.vero.java.api;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class BaseHeartbeatApiTest {

    @Test
    public void testHeartbeat() throws Exception {
        HeartbeatApi veroApi = new BaseHeartbeatApi("TOKEN");
        try {
            veroApi.heartbeat();
        } catch (Exception e) {
            fail("The hearbeat is fail");
        }
    }
}