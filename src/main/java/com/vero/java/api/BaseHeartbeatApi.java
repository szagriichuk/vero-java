package com.vero.java.api;

import com.vero.java.http.callback.TextResponseCallBack;
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
