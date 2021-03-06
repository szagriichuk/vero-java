package com.vero.java.http.url;

import java.util.ArrayList;
import java.util.List;

import static com.vero.java.http.url.Uris.*;

/**
 * @author szagriichuk.
 */
public final class Url {
    private List<Uris> uris = new ArrayList<>();

    private Url() {
    }

    public static Url start() {
        return new Url();
    }

    public static Url v2() {
        return Url.start().of(API).of(V2);
    }

    public static Url openV1() {
        return Url.start().of(OPEN).of(V1);
    }

    public Url of(Uris uri) {
        uris.add(uri);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uris.size() - 1; i++) {
            addParameter(builder, uris.get(i));
        }
        addLastParameter(builder, uris.get(uris.size() - 1));

        return builder.toString();
    }

    private void addParameter(StringBuilder builder, Uris uri) {
        builder.append(uri).append("/");
    }

    private void addLastParameter(StringBuilder builder, Uris uri) {
        builder.append(uri);
    }
}
