package com.vero.java.http.url;

import com.vero.java.http.url.uri.BaseUrl;
import com.vero.java.http.url.uri.Heartbeat;
import com.vero.java.http.url.uri.Version2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class UrlsTest {

    @Test
    public void testBuildHearbeatUrl() throws Exception {
        String url = Urls.nw().of(new BaseUrl()).of(new Version2()).of(new Heartbeat()).build();
        Assert.assertEquals("https://api.getvero.com/api/v2/heartbeat", url);

    }
}