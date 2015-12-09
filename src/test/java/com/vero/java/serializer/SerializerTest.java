package com.vero.java.serializer;

import com.vero.java.api.params.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author szagriichuk.
 */
public class SerializerTest {

    @Test
    public void testSerialize() throws Exception {
        VeroData veroData = VeroData.empty();
        veroData = veroData.add(new AuthToken("TOKEN"));
        veroData = veroData.add(new Id(12345));
        veroData = veroData.add(new Email("test@test.com"));
        VeroData test = VeroData.empty();
        test = test.add(new FirstName("test1"));
        test = test.add(new LastName("test2"));
        veroData = veroData.add(new UserData(test));
        Assert.assertNotNull(Serializer.serialize(veroData));
    }
}