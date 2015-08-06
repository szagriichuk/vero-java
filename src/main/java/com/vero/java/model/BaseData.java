package com.vero.java.model;

import java.util.HashMap;

/**
 * @author szagriichuk.
 */
public class BaseData extends HashMap<String, String>{
    public void add(String name, String value){
        put(name, value);
    }
}
