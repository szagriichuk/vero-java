package com.vero.java.http;

import com.vero.java.http.callback.TextResponseCallBack;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Http method executor.
 *
 * @author szagriichuk.
 */
public final class HttpExecutor {

    public static void execute(HttpRequestBase method, final TextResponseCallBack callback) {
        final CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.createDefault();
        httpAsyncClient.start();
        httpAsyncClient.execute(method, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                checkIfStatusIsSuccess(result);
                try {
                    callback.onComplete(EntityUtils.toString(result.getEntity()));
                    close(httpAsyncClient, callback);
                } catch (IOException e) {
                    failed(e);
                }
            }

            private void checkIfStatusIsSuccess(HttpResponse result) {
                if (result.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
                    failed(new HttpException(result.getStatusLine().getReasonPhrase()));
            }

            @Override
            public void failed(Exception ex) {
                callback.onError(ex);
                close(httpAsyncClient, callback);
            }

            @Override
            public void cancelled() {
                failed(new HttpException("The operation was canceled."));
            }
        });
    }

    private static void close(CloseableHttpAsyncClient httpAsyncClient, TextResponseCallBack callback) {
        try {
            httpAsyncClient.close();
        } catch (IOException e) {
            callback.onError(e);
        }
    }
}
