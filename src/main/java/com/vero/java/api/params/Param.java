package com.vero.java.api.params;

/**
 * Base abstraction of the Vero's parameters.
 *
 * @author szagriichuk.
 */
public abstract class Param<T> {
    T value;

    public Param(T param) {
        this.value = param;
    }

    @Override
    public String toString() {
        return paramName() + "=" + value;
    }

    protected abstract String paramName();
}
