package com.vero.java.http.callback;

/**
 * @author szagriichuk.
 */
public abstract class VoidResponseCallback implements TextResponseCallBack {
    @Override
    public void onComplete(String value) {
    }
}
