package io.github.spiderweb.destination.domain;

import java.util.Optional;

public class SelectContext {

    private boolean random = false;

    private String ipAddress;

    public boolean isRandom() {
        return random;
    }

    public Optional<String> getIpAddress() {
        return Optional.ofNullable(ipAddress);
    }

    public SelectContext setRandom(boolean random) {
        this.random = random;
        return this;
    }

    public SelectContext setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }
}
