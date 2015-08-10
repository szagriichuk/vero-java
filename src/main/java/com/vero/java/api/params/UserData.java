package com.vero.java.api.params;

/**
 * Represents {@code data} parameter of the Vero API user request.
 *
 * @author szagriichuk.
 */
public class UserData extends Data<String> {
    public UserData(VeroData<String> param) {
        super(param);
    }
}
