package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public abstract class Param<T> {
    private T param;

    public Param(T param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return paramName() + "=" + param;
    }

    protected abstract String paramName();

}
