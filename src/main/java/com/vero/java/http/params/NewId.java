package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public class NewId extends Param<Integer> {
    public NewId(Integer param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "new_id";
    }
}
