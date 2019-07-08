package io.github.eutkin.spiderweb.redirect;

import io.github.eutkin.spiderweb.store.RedirectStore;
import io.github.spiderweb.destination.DestinationSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.scalecube.beans.EnableScalecubeClients;

@SpringBootApplication
@EnableScalecubeClients({RedirectStore.class, DestinationSelector.class})
public class RedirectApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedirectApplication.class, args);
  }

}
