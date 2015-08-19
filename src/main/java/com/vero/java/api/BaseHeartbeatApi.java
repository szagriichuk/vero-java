package com.vero.java.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vero.java.api.VeroHttpApiUrls.HEARTBEAT;

/**
 * @author szagriichuk.
 */
class BaseHeartbeatApi extends BaseHttpApi implements HeartbeatApi {
    private static final Logger LOG = LoggerFactory.getLogger(BaseHeartbeatApi.class);

    public BaseHeartbeatApi(String key) {
        super(key);
    }

    @Override
    public void heartbeat() {
        get(HEARTBEAT);
    }
}
