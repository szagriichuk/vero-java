package com.vero.java.api.params;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
public class AuthTokenTest extends BaseParamTest{

    @Override
    Param<?> getParameter(String name) {
        return new AuthToken(name);
    }
}