package eu.palantir.catalogue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to specify that the field should be injected with the WireMock server
 * baseURL. Can only be used on type {@link java.net.URL}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WireMockBaseUrl {
}
