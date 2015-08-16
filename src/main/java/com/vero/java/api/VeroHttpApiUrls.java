package com.vero.java.api;

import com.vero.java.http.url.Uris;
import com.vero.java.http.url.Url;

import static com.vero.java.http.url.Uris.*;

/**
 * @author szagriichuk.
 */
interface VeroHttpApiUrls {
    String USERS_TRACK = Url.start().of(BASE).of(VERSION).of(USERS).of(Uris.TRACK).build();
    String UPDATE = Url.start().of(BASE).of(VERSION).of(USERS).of(Uris.EDIT).build();
    String REIDENTIFY = Url.start().of(BASE).of(VERSION).of(USERS).of(Uris.REIDENTIFY).build();
    String EDIT_TAGS = Url.start().of(BASE).of(VERSION).of(USERS).of(TAGS).of(EDIT).build();
    String EVENTS_TRACK = Url.start().of(BASE).of(VERSION).of(EVENTS).of(Uris.TRACK).build();
}
