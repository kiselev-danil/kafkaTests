package com.example.ReactiveProducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Service
public class ConsumeEvents {
    private final Logger log = LoggerFactory.getLogger(ConsumeEvents.class);

    @Bean
    public Consumer<Flux<String>> consumeString(){
        return strFlux -> {
            //business Logic
            strFlux.doOnNext(str -> {
                log.info(str);
            }).subscribe();
        };
    }
}
