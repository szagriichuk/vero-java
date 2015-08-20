package com.vero.java.api;

import com.vero.java.api.params.*;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class BaseActionsApiTest {

    @Test
    public void testTrack() throws Exception {
        ActionsApi actionsApi = new BaseActionsApi("TOKEN");
        actionsApi.track(new Identity(VeroData.of().
                of(new Id(1234)).
                of(new Email("john@smith.com")).build()
        ), new EventName("Viewed product"), new ActionData(VeroData.of().
                of(new StringParamWithName("product_name", "Red T-shirt")).
                of(new StringParamWithName("product_url", "http://www.yourdomain.com/products/red-t-shirt")).
                build()
        ));
    }
}