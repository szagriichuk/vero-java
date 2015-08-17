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
        actionsApi.track(new Identity(new VeroData() {{
            add(new Id(1234));
            add(new Email("john@smith.com"));
        }}), new EventName("Viewed product"), new ActionData(new VeroData() {
            {
                add(new StringParamWithName("product_name", "Red T-shirt"));
                add(new StringParamWithName("product_url", "http://www.yourdomain.com/products/red-t-shirt"));
            }
        }));
    }
}