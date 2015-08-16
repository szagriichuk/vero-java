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
        VeroData veroData = new VeroData();
        veroData.add(new AuthToken("KEY"));
        veroData.add(new Id(12345));
        veroData.add(new Email("test@test.com"));
        VeroData test = new VeroData();
        test.add(new FirstName("test1"));
        test.add(new LastName("test2"));
        veroData.add(new UserData(test));
        Assert.assertNotNull(Serializer.serialize(veroData));
    }
}