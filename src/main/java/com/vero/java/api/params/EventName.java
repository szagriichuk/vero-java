package com.vero.java.api.params;

/**
 * Represents {@code event_name} parameter of the Vero API request.
 *
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
