package com.vero.java.serializer;

import com.vero.java.api.params.VeroData;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class SerializerTest {

    @Test
    public void testSerialize() throws Exception {
        VeroData<Object> veroData = new VeroData<>();
        veroData.add("auth_token", "KEY");
        veroData.add("id", "123123");
        veroData.add("email", "test@test.com");
        VeroData<String> test = new VeroData<>();
        test.add("firstname", "tets1");
        test.add("lastname", "tets2");
        veroData.add("data", test);
        Assert.assertNotNull(Serializer.serialize(veroData));
    }
}