package com.vero.java.api;

import com.vero.java.api.params.ActionData;
import com.vero.java.api.params.EventName;
import com.vero.java.api.params.Identity;

/**
 * The Actions end-point has a single function: {@code track} when an individual user takes
 * a specific action on your website.
 * <p/>
 * For example, you may want to record when a customer clicks a certain button or uses
 * a certain feature. To use this end-point, you are required to record the identifier (ID)
 * of the user taking the action, the name of the action you want to record and (optionally)
 * attributes associated with that action. In the example provided, you are tracking when
 * a customer views a product and are also capturing the attributes name, price and a link
 * to the product image.
 * <p/>
 * You can use these attributes to create more targeted segments and more granular emails
 * in Vero. Note that there are two reserved action names: <b>Identified</b> and <b>Visited</b> site.
 * You should not use these action names as they are tracked automatically by Vero when
 * a customer is first added to the database and when they are again seen on your website.
 *
 * @author szagriichuk.
 */
public interface ActionsApi {
    /**
     * The {@code track} method tracks an action called {@link EventName} for the user with identifier {@link Identity}.
     * It can also include optional attributes including to the ActionData.
     * For example:
     * <pre>
     *     {@code actionsApi.track(new Identity(new VeroData() {{
     *                      add(new Id(1234));
     *                      add(new Email("john@smith.com"));
     *              }}), new EventName("Viewed product"), new ActionData(new VeroData() {
     *                   {
     *                      add(new StringParamWithName("product_name", "Red T-shirt"));
     *                      add(new StringParamWithName("product_url", "http://www.yourdomain.com/products/red-t-shirt"));
     *                    }
     *              }));
     *
     *      }
     * </pre>
     */
    void track(Identity identity, EventName name, ActionData data);
}
