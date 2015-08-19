package com.vero.java.http.url;

import org.junit.Assert;
import org.junit.Test;
import static com.vero.java.http.url.Uris.*;
/**
 * @author szagriichuk.
 */
public class UrlsTest {

    @Test
    public void testBuildHearbeatUrl() throws Exception {
        String url = Url.v2().of(HEARBEAT).build();
        Assert.assertEquals("https://api.getvero.com/api/v2/heartbeat", url);
    }
}