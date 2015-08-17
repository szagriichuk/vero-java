package com.vero.java.api;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class VeroApiTest {

    @Test
    public void testActions() throws Exception {
        // TODO
    }

    @Test
    public void testUsers() throws Exception {
        //TODO
    }

    @Test
    public void testHeartbeat() throws Exception {
        VeroApi veroApi = new VeroApi("TOKEN");
        try {
            veroApi.heartbeat();
        } catch (Exception e) {
            fail("The hearbeat is fail");
        }
    }
}