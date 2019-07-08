package io.github.eutkin.spiderweb.redirect;

import io.scalecube.services.annotations.Service;
import io.scalecube.services.annotations.ServiceMethod;
import java.net.URI;
import reactor.core.publisher.Mono;

@Service
public interface DestinationProvider {

  @ServiceMethod
  Mono<URI> provide(String path);

}
