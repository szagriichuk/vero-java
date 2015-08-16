package com.vero.java.api;

import com.vero.java.http.callback.TextResponseCallBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vero.java.api.VeroHttpApiUrls.HEARTBEAT;

/**
 * @author szagriichuk.
 */
public class VeroApi extends BaseHttpApi {
    private static final Logger LOG = LoggerFactory.getLogger("Http API");

    public VeroApi(String key) {
        super(key);
    }

    public ActionsApi actions() {
        return new DefaultActionsApi(key);
    }

    public UsersApi users() {
        return new DefaultUsersApi(key);
    }

    /**
     * A successful response will log the following JSON response with a 200 status code.
     * <pre>
     * {@code
     * {"status":200,"message":"Vero api is up"} }
     * </pre>
     * in other cases will throw the {@link VeroApiException} exception with problem indication.
     */
    public void heartbeat() {
        post(HEARTBEAT, new TextResponseCallBack() {
            @Override
            public void onComplete(String value) {
                LOG.info(value);
            }

            @Override
            public void onError(Throwable throwable) {
                throw new VeroApiException("The hearbeat operation is fail.", throwable);
            }
        });
    }
}
