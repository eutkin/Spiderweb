package io.github.eutkin.spiderweb.redirect;

import io.github.eutkin.spiderweb.domain.Destination;
import io.github.eutkin.spiderweb.store.RedirectStore;
import io.github.spiderweb.destination.DestinationSelector;
import io.github.spiderweb.destination.domain.SelectContext;
import io.scalecube.services.routing.RandomServiceRouter;
import java.net.URI;
import org.springframework.boot.scalecube.beans.SelectionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingRestController {

    // external client
    private final RedirectStore redirectStore;

    // external client with custom router
    @SelectionStrategy(RandomServiceRouter.class)
    private final DestinationSelector destinationSelector;

    // internal service
    private final DestinationProvider destinationProvider;

    public GreetingRestController(RedirectStore redirectStore,
        DestinationSelector destinationSelector,
        DestinationProvider destinationProvider) {
        this.redirectStore = redirectStore;
        this.destinationSelector = destinationSelector;
        this.destinationProvider = destinationProvider;
    }

    @GetMapping("external/{path}")
    public Mono<String> print1(String path) {
        SelectContext selectContext = new SelectContext().setRandom(true);
        return redirectStore
                .readDestinations(path)
                .flatMap(destinations -> destinationSelector.select(selectContext, destinations))
                .map(Destination::getUri)
                .map(URI::toString);
    }

    @GetMapping("inner/{path}")
    public Mono<String> print2(String path) {
        return destinationProvider.provide(path).map(URI::toString);
    }
}
