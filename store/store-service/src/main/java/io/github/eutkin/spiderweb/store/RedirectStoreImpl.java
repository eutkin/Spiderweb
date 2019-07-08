package io.github.eutkin.spiderweb.store;

import io.github.eutkin.spiderweb.domain.Destination;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class RedirectStoreImpl implements RedirectStore {

    private final Map<String, List<Destination>> store;

    public RedirectStoreImpl(Map<String, List<Destination>> store) {
        this.store = store;
    }

    @Override
    public Mono<List<Destination>> readDestinations(String path) {
        List<Destination> data = store.get(path);
        return Objects.nonNull(data) ? Mono.just(data) : Mono.empty();
    }
}
