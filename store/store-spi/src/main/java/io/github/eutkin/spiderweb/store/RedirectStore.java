package io.github.eutkin.spiderweb.store;

import io.github.eutkin.spiderweb.domain.Destination;
import io.scalecube.services.annotations.Service;
import io.scalecube.services.annotations.ServiceMethod;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("redirect-store")
public interface RedirectStore {

    @ServiceMethod("read-url")
    Mono<List<Destination>> readDestinations(String path);
}
