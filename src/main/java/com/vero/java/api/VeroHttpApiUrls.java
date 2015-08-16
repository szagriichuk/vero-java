package com.vero.java.api;

import com.vero.java.http.url.Uris;
import com.vero.java.http.url.Url;

import static com.vero.java.http.url.Uris.*;

/**
 * @author szagriichuk.
 */
interface VeroHttpApiUrls {
    // Users
    String USERS_TRACK = Url.v2().of(USERS).of(Uris.TRACK).build();
    String UPDATE = Url.v2().of(USERS).of(Uris.EDIT).build();
    String REIDENTIFY = Url.v2().of(USERS).of(Uris.REIDENTIFY).build();
    String EDIT_TAGS = Url.v2().of(USERS).of(TAGS).of(EDIT).build();
    String UNSUBSCRIBE = Url.v2().of(USERS).of(Uris.UNSUBSCRIBE).build();
    String RESUBSCRIBE = Url.v2().of(USERS).of(Uris.RESUBSCRIBE).build();
    // Events
    String EVENTS_TRACK = Url.v2().of(EVENTS).of(Uris.TRACK).build();
    // Common
    String HEARTBEAT = Url.v2().of(HEARBEAT).build();
}
