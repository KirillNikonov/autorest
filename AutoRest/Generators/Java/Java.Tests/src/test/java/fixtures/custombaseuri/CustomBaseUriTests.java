package fixtures.custombaseuri;

import com.microsoft.rest.RestClient;
import com.microsoft.rest.serializer.JacksonMapperAdapter;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import fixtures.custombaseuri.implementation.AutoRestParameterizedHostTestClientImpl;
import okhttp3.Interceptor;
import okhttp3.Response;

import static org.junit.Assert.fail;

public class CustomBaseUriTests {
    private static AutoRestParameterizedHostTestClient client;

    @BeforeClass
    public static void setup() {
        client = new AutoRestParameterizedHostTestClientImpl();
    }

    // Positive test case
    @Test
    public void getEmptyWithValidCustomUri() throws Exception {
        client.withHost("host:3000");
        Assert.assertTrue(client.paths().getEmpty("local").getResponse().isSuccessful());
    }

    @Test
    public void getEmptyWithInvalidCustomUriAccountName() throws Exception {
        try {
            client.paths().getEmpty("bad");
            Assert.assertTrue(false);
        }
        catch (UnknownHostException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void getEmptyWithInvalidCustomUriHostName() throws Exception {
        try {
            client.withHost("badhost");
            client.paths().getEmpty("local");
            Assert.assertTrue(false);
        }
        catch (UnknownHostException e) {
            Assert.assertTrue(true);
        }
        finally {
            client.withHost("host:3000");
        }
    }

    @Test
    public void getEmptyWithEmptyCustomUriAccountName() throws Exception {
        try {
            client.paths().getEmpty(null);
            Assert.assertTrue(false);
        }
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void getEmptyMultipleThreads() throws Exception {
        final CountDownLatch latch = new CountDownLatch(2);
        RestClient restClient = new RestClient.Builder("http://{accountName}{host}")
                .withInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            // do nothing
                        }
                        return chain.proceed(chain.request());
                    }
                })
                .withMapperAdapter(new JacksonMapperAdapter())
                .build();
        final AutoRestParameterizedHostTestClient client1 = new AutoRestParameterizedHostTestClientImpl(restClient);
        client1.withHost("host:3000");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client1.paths().getEmpty("badlocal");
                    fail();
                } catch (UnknownHostException e) {
                    latch.countDown();
                } catch (Exception e) {
                    fail();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Assert.assertTrue(client1.paths().getEmpty("local").getResponse().isSuccessful());
                    latch.countDown();
                } catch (Exception ex) {
                    fail();
                }
            }
        });
        t1.start();
        t2.start();
        Assert.assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
}
