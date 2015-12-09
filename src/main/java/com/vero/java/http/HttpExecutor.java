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
    private static CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.createDefault();

    public static void execute(HttpRequestBase method, final TextResponseCallBack callback) {
        startAsyncClient();
        httpAsyncClient.execute(method, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse result) {
                checkIfStatusIsSuccess(result);
                try {
                    callback.onComplete(EntityUtils.toString(result.getEntity()));
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
            }

            @Override
            public void cancelled() {
                failed(new HttpException("The operation was canceled."));
            }
        });
    }

    private static void startAsyncClient() {
        if (!httpAsyncClient.isRunning()) {
            httpAsyncClient.start();
        }
    }
}
