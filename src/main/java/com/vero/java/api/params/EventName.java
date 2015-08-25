package com.vero.java.api.params;

/**
 * Represents {@code event_name} parameter of the Vero API request.
 *
 * @author szagriichuk.
 */
public class EventName extends StringParam{
    public EventName(String param) {
        super(param);
    }

    @Override
    public String name() {
        return "event_name";
    }
}
