package com.example.ReactiveProducer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Instant;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
@Slf4j
public class ProduceEvents {

    @Bean
    public Supplier<Flux<Message<Instant>>> stringSupplier() {
        return () -> Flux.fromStream(Stream.generate(() -> {
            try {
                Thread.sleep(150);
                var message = Instant.now();
                log.info(message.toString());
                return MessageBuilder.withPayload(message).setHeader("partitionKey", Instant.now().toString()).build();
            } catch (Exception e) {
                // ignore
                return null;
            }
        })).subscribeOn(Schedulers.boundedElastic()).share();
    }
}
