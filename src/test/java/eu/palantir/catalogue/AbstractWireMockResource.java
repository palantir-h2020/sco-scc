package eu.palantir.catalogue;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractWireMockResource implements QuarkusTestResourceLifecycleManager {
    protected WireMockServer wireMockServer;

    @Override
    public void stop() {
        wireMockServer.stop();
    }

    /**
     * Prepares the WireMock server base URL, which is to be injected. N.B.:
     * Provides an extension point for subtypes.
     *
     * @return The WireMock server base URL.
     * @throws MalformedURLException When the generated URL from the WireMock server
     *                               is malformed
     *                               (usually never).
     */
    protected URL prepareInjectedUrl() throws MalformedURLException {
        return new URL(wireMockServer.baseUrl());
    }

    @Override
    public void inject(Object testInstance) {
        Class<?> c = testInstance.getClass();
        // Static configuration, we currently support one annotation
        Class<? extends Annotation> supportedAnnotation = WireMockBaseUrl.class;

        // Prepare injected field type and value
        Class<?> injectedClass = URL.class;
        URL wireMockInjectedUrl;
        try {
            wireMockInjectedUrl = prepareInjectedUrl();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(
                    "WireMockServer baseURL is malformed " + wireMockServer.baseUrl(), e);
        }

        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {

                boolean foundFieldWithSupportedAnnotation = f.getAnnotation(supportedAnnotation) != null;
                if (foundFieldWithSupportedAnnotation) {
                    // Ensure type of annotated field matches injected type
                    if (!injectedClass.isAssignableFrom(f.getType())) {
                        throw new RuntimeException(
                                supportedAnnotation + " can only be used on fields of type " + injectedClass);
                    }

                    f.setAccessible(true);

                    try {
                        f.set(testInstance, wireMockInjectedUrl);
                        return;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            c = c.getSuperclass();
        }
    }

}
