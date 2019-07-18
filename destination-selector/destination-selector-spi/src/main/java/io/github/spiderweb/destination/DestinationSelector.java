package io.github.spiderweb.destination;

import io.github.eutkin.spiderweb.domain.Destination;
import io.scalecube.services.annotations.Service;
import io.scalecube.services.annotations.ServiceMethod;
import java.util.List;
import reactor.core.publisher.Mono;

@Service("destination-selector")
public interface DestinationSelector {

    @ServiceMethod("select")
    Mono<Destination> select(List<Destination> source);

}
