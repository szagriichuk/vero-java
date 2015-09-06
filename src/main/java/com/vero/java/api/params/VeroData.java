package com.vero.java.api.params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Base abstraction of the vero data.
 *
 * @author szagriichuk.
 */
public class VeroData extends HashMap<String, Object> {
    private VeroData() {
    }

    private VeroData(VeroData veroData) {
        super(veroData);
    }

    public static VeroDataBuilder of() {
        return new VeroDataBuilder();
    }

    public static VeroData empty() {
        return new VeroData();
    }

    public final <T> VeroData add(Param<T> param) {
        VeroData vero = new VeroData(this);
        vero.put(param.name(), param.value);
        return vero;
    }

    public final VeroData addAll(Param<?>... params) {
        VeroData vero = new VeroData(this);
        for (Param<?> param : params) {
            vero = vero.add(param);
        }
        return vero;
    }

    public static class VeroDataBuilder {
        private List<Param<?>> params = new ArrayList<>();

        public VeroDataBuilder of(Param<?> param) {
            params.add(param);
            return this;
        }

        public VeroData build() {
            return new VeroData().addAll(params.toArray(new Param[params.size()]));
        }
    }
}
