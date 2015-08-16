package com.vero.java.http;

import com.vero.java.http.callback.TextResponseCallBack;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static com.vero.java.serializer.Serializer.deserialize;

/**
 * Http method executor.
 *
 * @author szagriichuk.
 */
public final class HttpExecutor {
    private static CloseableHttpAsyncClient httpAsyncClients = HttpAsyncClients.createDefault();

    public static void execute(HttpRequestBase method, final TextResponseCallBack callback) {
        startAsyncClient();
        httpAsyncClients.execute(method, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                try {
                    callback.onComplete(deserialize(EntityUtils.toString(result.getEntity()), String.class));
                } catch (IOException e) {
                    failed(e);
                }
            }

            @Override
            public void failed(Exception ex) {
                callback.onError(ex);
            }

            @Override
            public void cancelled() {
                throw new HttpException("The operation was canceled.");
            }
        });
    }

    private static void startAsyncClient() {
        if (!httpAsyncClients.isRunning()) {
            httpAsyncClients.start();
        }
    }
}
