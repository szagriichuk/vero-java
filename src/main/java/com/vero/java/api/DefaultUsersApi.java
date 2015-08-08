package com.vero.java.api;

import com.vero.java.http.HttpException;
import com.vero.java.http.HttpMethod;
import com.vero.java.http.callback.ErrorResponseCallback;
import com.vero.java.http.url.UrlBuilder;
import com.vero.java.model.UsersData;
import com.vero.java.model.VeroData;
import com.vero.java.serializer.Serializer;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.nio.entity.NStringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

import static com.vero.java.http.HttpExecutor.execute;
import static com.vero.java.http.url.Uris.*;

/**
 * @author szagriichuk.
 */
public class DefaultUsersApi implements UsersApi {

    private static final Logger LOG = LoggerFactory.getLogger(UsersApi.class);

    @Override
    public void create(UsersData data) {
        execute(createPostTrackHttpRequest(data), new ErrorResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot create user", throwable);
            }
        });
    }

    private HttpEntityEnclosingRequestBase createPostTrackHttpRequest(VeroData data) {
        HttpEntityEnclosingRequestBase post = (HttpEntityEnclosingRequestBase) createHttpMethod(HttpMethod.POST, createTrackUrl());
        HttpEntity entity = createEntity(data);
        if (entity != null) {
            post.setEntity(entity);
        }
        return post;
    }

    private HttpEntity createEntity(VeroData data) {
        try {
            return new NStringEntity(Serializer.serialize(data));
        } catch (UnsupportedEncodingException e) {
            LOG.error("Cannot create http request entity from String data.", e);
        }

        return null;
    }

    private String createTrackUrl() {
        return UrlBuilder.start().of(BASE).of(VERSION).of(USERS).of(TRACK).build();
    }

    private HttpRequestBase createHttpMethod(HttpMethod method, String url) {
        switch (method) {
            case POST:
                return new HttpPost(url);
            default:
                throw new HttpException("Canno create http method for input data: " + method);
        }
    }
}
