package io.github.spiderweb.destination;

import io.github.eutkin.spiderweb.domain.Destination;
import io.github.spiderweb.destination.domain.SelectContext;
import io.scalecube.services.annotations.Service;
import io.scalecube.services.annotations.ServiceMethod;
import reactor.core.publisher.Mono;

import java.util.List;

@Service("destination-selector")
public interface DestinationSelector {

    @ServiceMethod("select")
    Mono<Destination> select(SelectContext selectContext, List<Destination> source);

}
