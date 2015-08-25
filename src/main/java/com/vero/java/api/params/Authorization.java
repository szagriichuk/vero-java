package com.vero.java.api.params;

/**
 * @author szagriichuk.
 */
public class Authorization extends StringParam {
    public Authorization(String param) {
        super(param);
    }

    @Override
    public String name() {
        return "Authorization";
    }
}
