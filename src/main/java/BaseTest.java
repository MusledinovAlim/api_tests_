import java.io.IOException;
import java.util.Locale;

import api.TypicodeControllerApi;
import other.CustomCompositeInterceptor;
import io.qameta.allure.Step;

import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BaseTest {

    protected static final TypicodeControllerApi TYPICODE = createJacksonClient(TypicodeControllerApi.class);

    static {
        Locale.setDefault(Locale.ENGLISH);
    }

    private static <CLIENT> CLIENT createJacksonClient(final Class<CLIENT> clientClass) {
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .followRedirects(true)
                        .followSslRedirects(true)
                        .addNetworkInterceptor(new CustomCompositeInterceptor())
                        .build())
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(clientClass);
    }

    @Step("Выполнение запроса")
    public static Response getResponse(retrofit2.Call call) throws IOException {
        return call.execute();
    }

    @Step("Проверка, что статус код {expectedStatusCode}")
    public static void assertStatusCode(Response response, int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.code());
    }

    @Step("Проверка наличия Headers( в response)")
    public static void assertNotNullHeaders(Response response) {
        assertNotNull(response.headers().toString());
    }
}
