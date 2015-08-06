package com.vero.java.http.url;

import com.vero.java.http.url.uri.BaseUrl;
import com.vero.java.http.url.uri.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szagriichuk.
 */
public final class Urls {
    private static final BaseUrl baseUrl = new BaseUrl();
    private List<Uri> uris = new ArrayList<>();

    private Urls() {
    }

    public static Urls nw() {
        return new Urls();
    }

    public Urls of(Uri uri) {
        uris.add(uri);
        return this;
    }

    public String build() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < uris.size() - 1; i++) {
            Uri uri = uris.get(i);
            if (isFirstElement(i) && isBaseUrl(uri)) {
                addParameter(builder, uri);
                continue;
            } else if (isFirstElement(i) && !isBaseUrl(uri)) {
                addParameter(builder, baseUrl);
            }
            addParameter(builder, uri);
        }
        addLastParameter(builder, uris.get(uris.size() - 1));
        return builder.toString();
    }

    private boolean isFirstElement(int i) {
        return i == 0;
    }

    private boolean isBaseUrl(Uri uri) {
        return uri instanceof BaseUrl;
    }

    private void addParameter(StringBuilder builder, Uri uri) {
        builder.append(uri).append("/");
    }

    private void addLastParameter(StringBuilder builder, Uri uri) {
        builder.append(uri);
    }
}
