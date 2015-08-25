package com.vero.java.http;

import com.vero.java.api.params.Param;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szagriichuk.
 */
public class Headers {
    public static List<Header> create(Param<?>... params) {
        List<Header> headers = new ArrayList<>();
        if (params != null) {
            for (Param<?> param : params) {
                headers.add(new BasicHeader(param.name(), String.valueOf(param.value())));
            }
        }
        return headers;
    }
}
