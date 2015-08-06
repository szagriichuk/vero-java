package com.vero.java.http.params;

/**
 * @author szagriichuk.
 */
public class Id extends Param<Integer> {
    public Id(Integer param) {
        super(param);
    }

    @Override
    protected String paramName() {
        return "id";
    }
}
