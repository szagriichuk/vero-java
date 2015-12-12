package com.vero.java.http;

import com.google.code.tempusfugit.concurrency.IntermittentTestRunner;
import com.google.code.tempusfugit.concurrency.annotations.Intermittent;
import com.vero.java.http.callback.TextResponseCallBack;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author szagriichuk.
 */
@RunWith(IntermittentTestRunner.class)
public class HttpExecutorTest {

    @Test
    public void testSimpleCorrectExecute() throws Exception {
        Assert.assertTrue(executeHttpRequest("http://www.google.com"));
    }

    @Test
    public void testSimpleIncorrectExecute() throws Exception {
        Assert.assertFalse(executeHttpRequest("http://www.google.com/test"));
    }

    @Test
    @Intermittent(repetition = 20)
    public void test20IncorrectExecute() throws Exception {
        testSimpleIncorrectExecute();
    }

    @Test
    @Intermittent(repetition = 20)
    public void test20CorrectExecute() throws Exception {
        testSimpleCorrectExecute();
    }

    private boolean executeHttpRequest(String url) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        final boolean[] isComplete = {false};
        HttpExecutor.execute(new HttpGet(url), new TextResponseCallBack() {
            @Override
            public void onComplete(String value) {
                latch.countDown();
                isComplete[0] = true;
                System.out.println(value);
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
                isComplete[0] = false;
            }
        });
        latch.await();
        return isComplete[0];
    }

}