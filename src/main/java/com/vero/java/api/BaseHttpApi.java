package com.vero.java.api;

import com.vero.java.api.params.Param;
import com.vero.java.http.HttpMethod;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.nio.entity.NStringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * @author szagriichuk.
 */
abstract class BaseHttpApi {
    private static final Logger LOG = LoggerFactory.getLogger(BaseHttpApi.class);

    String createPostDataString(Param<?>... params) {
        return createDataString(System.lineSeparator(), params);
    }

    String createDataString(String delim, Param<?>... params) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < params.length - 1; i++) {
            builder.append(params[i]).append(delim);
        }
        builder.append(params[params.length - 1]);
        return builder.toString().trim();
    }


    HttpEntityEnclosingRequestBase createPostRequest(String postData, String url) {
        HttpEntityEnclosingRequestBase post = (HttpEntityEnclosingRequestBase) HttpMethod.POST.create(url);
        HttpEntity entity = createHttpEntity(postData);
        if (entity != null) {
            post.setEntity(entity);
        }
        return post;
    }

    private HttpEntity createHttpEntity(String data) {
        try {
            return new NStringEntity(data);
        } catch (UnsupportedEncodingException e) {
            LOG.error("Cannot create http request entity from String data.", e);
        }
        return null;
    }
}
