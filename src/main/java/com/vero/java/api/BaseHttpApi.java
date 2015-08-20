package com.vero.java.api;

import com.vero.java.api.params.AuthToken;
import com.vero.java.api.params.Param;
import com.vero.java.api.params.VeroData;
import com.vero.java.http.HttpMethod;
import com.vero.java.http.callback.TextResponseCallBack;
import com.vero.java.http.callback.VoidResponseCallback;
import com.vero.java.serializer.Serializer;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.nio.entity.NStringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

import static com.vero.java.http.HttpExecutor.execute;

/**
 * Provides common methods for
 *
 * @author szagriichuk.
 */
abstract class BaseHttpApi extends Key {
    private static final Logger LOG = LoggerFactory.getLogger("Http API");

    public BaseHttpApi(String key) {
        super(key);
    }

    String createHttpEntityData(VeroData params) {
        params.add(new AuthToken(key));
        return Serializer.serialize(params);
    }

    String createHttpRequestString(String delim, AuthToken authToken, Param<?>... params) {
        if (params == null || params.length == 0)
            return "";

        StringBuilder builder = new StringBuilder();
        builder.append(authToken).append(delim);
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

    HttpRequestBase createDeleteRequest(String url) {
        return HttpMethod.DELETE.create(url);
    }

    HttpEntityEnclosingRequestBase createPutRequest(String postData, String url) {
        HttpEntityEnclosingRequestBase post = (HttpEntityEnclosingRequestBase) HttpMethod.PUT.create(url);
        HttpEntity entity = createHttpEntity(postData);
        if (entity != null) {
            post.setEntity(entity);
        }
        return post;
    }

    HttpRequestBase createGetRequest(String url) {
        return HttpMethod.GET.create(url);
    }

    private HttpEntity createHttpEntity(String data) {
        try {
            return new NStringEntity(data);
        } catch (UnsupportedEncodingException e) {
            LOG.error("Cannot create http request entity from String data.", e);
        }
        return null;
    }

    void post(String url, VeroData params) {
        post(url, new VoidResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot execute POST method.", throwable);
                throw new VeroApiException("Cannot execute POST method.", throwable);
            }
        }, params);
    }

    void post(String url, TextResponseCallBack callBack, VeroData params) {
        execute(createPostRequest(createHttpEntityData(params), url), callBack);
    }

    void put(String url, TextResponseCallBack callBack, VeroData params) {
        execute(createPutRequest(createHttpEntityData(params), url), callBack);
    }

    void put(String url, VeroData params) {
        put(url, new VoidResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot execute POST method.", throwable);
                throw new VeroApiException("Cannot execute POST method.", throwable);
            }
        }, params);
    }

    void get(String url, Param<?>... params) {
        get(url, new VoidResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot execute GET method.", throwable);
                throw new VeroApiException("Cannot execute GET method.", throwable);
            }
        }, params);
    }

    void get(String url, TextResponseCallBack callBack, Param<?>... params) {
        execute(createGetRequest(createUrlWithParams(url + "?", params)), callBack);
    }

    void delete(String url, Param<?>... params) {
        delete(url, new VoidResponseCallback() {
            @Override
            public void onError(Throwable throwable) {
                LOG.error("Cannot execute POST method.", throwable);
                throw new VeroApiException("Cannot execute POST method.", throwable);
            }
        }, params);
    }

    void delete(String url, TextResponseCallBack callBack, Param<?>... params) {
        execute(createDeleteRequest(createUrlWithParams(url + "?", params)), callBack);
    }


    VeroData createVeroData(Param<?>... params) {
        VeroData veroData = VeroData.of().build();
        veroData.addAll(params);
        return veroData;
    }

    String createUrlWithParams(String url, Param<?>... params) {
        return url + createHttpRequestString("&", new AuthToken(key), params);
    }
}
