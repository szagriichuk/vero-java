package com.vero.java.http.url.uri;

/**
 * @author szagriichuk.
 */
public class Uri {
    protected String uri;

    public Uri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return getUri();
    }
}
