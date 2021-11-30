package eu.palantir.catalogue.auth;

import java.util.Objects;

public class CatalogueClient {

    private final ClientType clientType;
    private final String clientId;

    public CatalogueClient(ClientType clientType, String clientId) {
        this.clientType = clientType;
        this.clientId = clientId;
    }

    public ClientType getClientType() {
        return this.clientType;
    }

    public String getClientId() {
        return this.clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CatalogueClient)) {
            return false;
        }
        CatalogueClient catalogueClient = (CatalogueClient) o;
        return Objects.equals(clientType, catalogueClient.clientType)
                && Objects.equals(clientId, catalogueClient.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientType, clientId);
    }

}
