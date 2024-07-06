package com.example.ReactiveProducer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
public class ReactiveProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProducerApplication.class, args);
	}

//	@Bean
//	public Function<Flux<String>, Flux<String>> uppercase() {
//		return s -> s.map(m-> {
//			System.out.println(m);
//			return m.toUpperCase();
//		});
//	}
//
//	@Bean
//	Consumer<Flux<Flux<ConsumerRecord<?, String>>>> input() {
//		return flux -> flux
//				.publishOn(Schedulers.boundedElastic())
//				.doOnNext(inner -> inner
//						.doOnNext(val -> {
//							System.out.println(val.value());
//							log.info(val.value());
//						})
//						.subscribe())
//				.subscribe();

//	}

//	@Bean
//	public Consumer<Flux<String>> consumeString(){
//		return strFlux -> {
//			//business Logic
//			strFlux.doOnNext(log::info).subscribe();
//		};
//	}

//	@Bean
//	public Supplier<String> stringSupplier() {
//		return () -> "Hello from Supplier";
//	}

//	@Bean
//	public Supplier<Flux<String>> stringSupplier() {
//		return () -> Flux.fromStream(Stream.generate(() -> {
//			try {
//				Thread.sleep(1000);
//				return "Hello from Supplier".concat(Instant.now().toString());
//			} catch (Exception e) {
//				// ignore
//				return "Exception Occurred";
//			}
//		})).subscribeOn(Schedulers.boundedElastic()).share();
//	}

}
