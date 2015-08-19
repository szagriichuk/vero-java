package com.vero.java.http.url;

import java.util.ArrayList;
import java.util.List;

/**
 * @author szagriichuk.
 */
public enum Uris {
    BASE("https://api.getvero.com/api"), EDIT("edit"), EVENTS("events"), HEARBEAT("heartbeat"), REIDENTIFY("reidentify"),
    RESUBSCRIBE("resubscribe"), TAGS("tags"), TRACK("track"), UNSUBSCRIBE("unsubscribe"), USERS("users"), VERSION("v2"), DELETE("delete");

    private String value;

    Uris(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

}
