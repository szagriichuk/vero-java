package com.vero.java.api.params;

/**
 * Represents {@code data} parameter of the Vero API action request.
 *
 * @author szagriichuk.
 */
public class ActionData extends Data<String> {
    public ActionData(VeroData<String> param) {
        super(param);
    }
}
