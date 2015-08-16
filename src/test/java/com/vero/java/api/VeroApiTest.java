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
        VeroApi veroApi = new VeroApi("faeb1ce37aeac6f563f768c7360b7c0ef16f1563");
        try {
            veroApi.heartbeat();
        } catch (Exception e) {
            fail("The hearbeat is fail");
        }
    }
}