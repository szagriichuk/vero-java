package com.vero.java.http.url;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szagriichuk.
 */
public final class UrlBuilder {
    private List<Uris> uris = new ArrayList<>();

    private UrlBuilder() {
    }

    public static UrlBuilder start(){
        return new UrlBuilder();
    }
    public UrlBuilder of(Uris uri) {
        uris.add(uri);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uris.size() - 1; i++) {
            addParameter(builder, uris.get(i));
        }
        addLastParameter(builder, uris.get(uris.size() - 1));
        uris.clear();
        return builder.toString();
    }

    private void addParameter(StringBuilder builder, Uris uri) {
        builder.append(uri).append("/");
    }

    private void addLastParameter(StringBuilder builder, Uris uri) {
        builder.append(uri);
    }


}
