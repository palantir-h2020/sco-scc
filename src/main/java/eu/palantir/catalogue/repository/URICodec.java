package eu.palantir.catalogue.repository;

import com.mongodb.MongoClientSettings;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.jboss.logging.Logger;

import java.net.URI;
import java.net.URISyntaxException;

public class URICodec implements Codec<URI> {

    private static final Logger LOGGER = Logger.getLogger(URICodec.class);
    private static final String URI_KEY = "uri";

    private final Codec<Document> documentCodec;

    public URICodec() {
        documentCodec = MongoClientSettings.getDefaultCodecRegistry().get(Document.class);
    }

    @Override
    public URI decode(BsonReader bsonReader, DecoderContext decoderContext) {
        final var document = documentCodec.decode(bsonReader, decoderContext);

        var uriAsString = document.getString(URI_KEY);
        if (uriAsString == null) {
            return null;
        }

        try {
            return new URI(uriAsString);
        } catch (URISyntaxException e) {
            LOGGER.errorf(e, "Failed to decode URI: ");
            return null;
        }
    }

    @Override
    public void encode(BsonWriter bsonWriter, URI uri, EncoderContext encoderContext) {
        final var document = new Document();
        document.put(URI_KEY, uri.toString());
        documentCodec.encode(bsonWriter, document, encoderContext);
    }

    @Override
    public Class<URI> getEncoderClass() {
        return URI.class;
    }
}
