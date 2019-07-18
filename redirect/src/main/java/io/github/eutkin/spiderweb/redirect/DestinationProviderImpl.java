package io.github.eutkin.spiderweb.redirect;

import io.github.eutkin.spiderweb.domain.Destination;
import io.github.eutkin.spiderweb.store.RedirectStore;
import io.github.spiderweb.destination.DestinationSelector;
import io.github.spiderweb.destination.domain.SelectContext;
import io.scalecube.services.routing.RandomServiceRouter;
import java.net.URI;
import org.springframework.boot.scalecube.beans.SelectionStrategy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DestinationProviderImpl implements DestinationProvider  {

  private final RedirectStore redirectStore;

  @SelectionStrategy(routerType = RandomServiceRouter.class)
  private final DestinationSelector destinationSelector;

  public DestinationProviderImpl(RedirectStore redirectStore,
      DestinationSelector destinationSelector) {
    this.redirectStore = redirectStore;
    this.destinationSelector = destinationSelector;
  }

  @Override
  public Mono<URI> provide(String path) {
    SelectContext selectContext = new SelectContext().setRandom(true);
    return redirectStore
        .readDestinations(path)
        .flatMap(destinationSelector::select)
        .map(Destination::getUri);
  }
}
