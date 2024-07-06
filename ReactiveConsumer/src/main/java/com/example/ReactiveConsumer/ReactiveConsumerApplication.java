package com.example.ReactiveConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
public class ReactiveConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveConsumerApplication.class, args);
    }

    @Bean
    public Consumer<Flux<Message<Instant>>> consumeStringMessage() {
        return strFlux -> {
            //business Logic

            strFlux.doOnNext(m -> {
                Instant recieved = m.getPayload();
                var diff = Instant.now().toEpochMilli()- recieved.toEpochMilli();
                log.info("{} {}", Thread.currentThread(), m.getPayload());
                log.info("{}", diff);
            }).subscribe();
        };
    }
}
