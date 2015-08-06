package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public class Remove extends Param<String> {
    public Remove(String param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "remove";
    }
}
