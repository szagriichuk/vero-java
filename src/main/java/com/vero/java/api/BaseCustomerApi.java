package com.vero.java.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.vero.java.api.params.Authorization;
import com.vero.java.api.params.Id;
import com.vero.java.http.Headers;
import com.vero.java.http.callback.TextResponseCallBack;
import com.vero.java.serializer.Serializer;
import com.vero.java.serializer.SerializerException;

import java.util.concurrent.CountDownLatch;

import static com.vero.java.api.VeroHttpApiUrls.GET_USER;

/**
 * @author szagriichuk.
 */
public class BaseCustomerApi extends BaseHttpApi implements CustomerApi {
    public BaseCustomerApi(String key) {
        super(key);
    }

    @Override
    public JsonNode getById(Id id) {
        JsonNode node;
        node = getUserData(id);
        return node;
    }

    private JsonNode getUserData(Id id) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final JsonNode[] node = new JsonNode[1];
        get(GET_USER, Headers.create(new Authorization(key)), new TextResponseCallBack() {
            @Override
            public void onComplete(String value) {
                deserialize(value);
                countDownLatch.countDown();
            }

            private void deserialize(String value) {
                try {
                    node[0] = Serializer.deserialize(value);
                } catch (SerializerException e) {
                    onError(e);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                countDownLatch.countDown();
                LOG.error("Cannot read customer data.", throwable);
                throw new VeroApiException("Cannot read customer data.", throwable);
            }
        }, String.valueOf(id.value()));
        awaitUserData(countDownLatch);
        return node[0];
    }

    private void awaitUserData(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            LOG.info(e.getMessage(), e);
        }
    }

    @Override
    public boolean isPresent(Id id) {
        JsonNode userData = getById(id);
        return userData != null;
    }
}
