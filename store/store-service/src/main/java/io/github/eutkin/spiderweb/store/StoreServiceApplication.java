package io.github.eutkin.spiderweb.store;

import io.github.eutkin.spiderweb.domain.Destination;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

@SpringBootApplication
public class StoreServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
            .sources(StoreServiceApplication.class)
            .build(args)
            .run()
        ;
    }

    @Bean
    @ConfigurationProperties(prefix = "store")
    public Map<String, List<Destination>> store() {
        return new HashMap<>();
    }

    @Bean
    @ConfigurationPropertiesBinding
    public Converter<String, Destination> destinationConverter() {
        return new Converter<String, Destination>() {
            @Override
            public Destination convert(String source) {
                return new Destination().setUri(URI.create(source));
            }
        };
    }
}
