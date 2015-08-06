package com.vero.java.api;

import com.vero.java.http.HttpExecutor;
import com.vero.java.http.ResponseCallback;
import com.vero.java.http.url.Urls;
import com.vero.java.http.url.uri.BaseUrl;
import com.vero.java.http.url.uri.Track;
import com.vero.java.http.url.uri.Users;
import com.vero.java.http.url.uri.Version2;
import com.vero.java.model.BaseData;
import com.vero.java.serializer.Serializer;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

/**
 * @author szagriichuk.
 */
public class DefaultUsersApi implements UsersApi {
    @Override
    public void create(BaseData data) {
        HttpPost post = new HttpPost(Urls.nw().of(new BaseUrl()).of(new Version2()).of(new Users()).of(new Track()).build());
        try {
            post.setEntity(new StringEntity(Serializer.serialize(data)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpExecutor.execute(post, new ResponseCallback<Object>() {
            @Override
            public void onComplete(Object value) {
                //TODO
            }

            @Override
            public void onError(Throwable throwable) {
                //TODO
            }
        });
    }
}
