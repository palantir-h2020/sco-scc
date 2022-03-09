package eu.palantir.catalogue.repository;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

import java.net.URI;

public class URICodecProvider implements CodecProvider {

    @Override
    public <T> Codec<T> get(Class<T> aClass, CodecRegistry codecRegistry) {
        if (aClass.equals(URI.class)) {
            return (Codec<T>) new URICodec();
        }
        return null;
    }
}
