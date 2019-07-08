package io.github.spiderweb.destination;

import io.github.eutkin.spiderweb.domain.Destination;
import io.github.spiderweb.destination.domain.SelectContext;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DestinationSelectorImpl implements DestinationSelector {

    @Override
    public Mono<Destination> select(SelectContext selectContext, List<Destination> source) {
        if (source == null || source.isEmpty()) {
            return Mono.empty();
        }
        if (selectContext.isRandom()) {
            List<Destination> copy = new ArrayList<>(source);
            Collections.shuffle(copy, ThreadLocalRandom.current());
            return Mono.just(copy.get(0));
        }
        return Mono.just(source.get(0));
    }
}
