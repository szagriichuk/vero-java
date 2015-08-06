package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public class EventName extends Param<String>{
    public EventName(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "event_name";
    }
}
