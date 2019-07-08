package io.github.eutkin.spiderweb.domain;

import java.net.URI;

public class Destination {

    private URI uri;

    public URI getUri() {
        return uri;
    }

    public Destination setUri(URI uri) {
        this.uri = uri;
        return this;
    }
}
