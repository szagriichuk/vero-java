package com.vero.java.model;

import java.util.HashMap;

/**
 * @author szagriichuk.
 */
public class VeroData<T> extends HashMap<String, T>{
    public void add(String name, T value){
        put(name, value);
    }
}
