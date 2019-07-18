package io.github.spiderweb.destination;

import io.github.eutkin.spiderweb.domain.Destination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DestinationSelectorImpl implements DestinationSelector {

    @Override
    public Mono<Destination> select(List<Destination> source) {
        if (source == null || source.isEmpty()) {
            return Mono.empty();
        }
        if (true) {
            List<Destination> copy = new ArrayList<>(source);
            Collections.shuffle(copy, ThreadLocalRandom.current());
            return Mono.just(copy.get(0));
        }
        return Mono.just(source.get(0));
    }
}
