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

    public static VeroDataBuilder of() {
        return new VeroDataBuilder();
    }

    public <T> void add(Param<T> param) {
        put(param.paramName(), param.value);
    }

    public final void addAll(Param<?>... params) {
        for (Param<?> param : params) {
            add(param);
        }
    }

    public static class VeroDataBuilder {
        private List<Param<?>> params = new ArrayList<>();

        public VeroDataBuilder of(Param<?> param) {
            params.add(param);
            return this;
        }

        public VeroData build() {
            VeroData veroData = new VeroData();
            veroData.addAll(params.toArray(new Param[params.size()]));
            return veroData;
        }
    }
}
