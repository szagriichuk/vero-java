package com.vero.java.http.callback;

/**
 * @author szagriichuk.
 */
public interface ResponseCallback<T> {
    void onComplete(T value);
    void onError(Throwable throwable);

}
