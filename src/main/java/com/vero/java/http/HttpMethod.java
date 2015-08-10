package com.vero.java.http;

import org.apache.http.client.methods.*;

/**
 * @author szagriichuk.
 */
public enum HttpMethod {
    POST {
        @Override
        public HttpRequestBase create(String url) {
            return new HttpPost(url);
        }
    }, GET {
        @Override
        public HttpRequestBase create(String url) {
            return new HttpGet(url);
        }
    }, PUT {
        @Override
        public HttpRequestBase create(String url) {
            return new HttpPut(url);
        }
    }, DELETE {
        @Override
        public HttpRequestBase create(String url) {
            return new HttpDelete(url);
        }
    }, HEAD {
        @Override
        public HttpRequestBase create(String url) {
            return new HttpHead(url);
        }
    };

    public abstract HttpRequestBase create(String url);
}
