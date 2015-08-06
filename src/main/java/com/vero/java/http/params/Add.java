package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public class Add extends Param<String> {
    public Add(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "add";
    }
}
