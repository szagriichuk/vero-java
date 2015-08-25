package com.vero.java.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.vero.java.api.params.Id;

/**
 * The customer endpoind allows you to get customer info by id or check ,
 * if customer is present in <a href="https://app.getvero.com/customers/">customer list </a> in Vero view page.
 *
 * @author szagriichuk.
 */
public interface CustomerApi {
    /**
     * The {@code getById} endpoint returns the customer data by the input {@link Id}.
     * Customer data is {@link JsonNode} which ready to changed without re-developed api.
     * The {@link JsonNode} is using because customer api is in Alpha stage.
     */
    JsonNode getById(Id id);

    /**
     * The {@code getById} endpoint returns true if customer is present in Vero DB and false in other cases.
     */
    boolean isPresent(Id id);

}
