package com.example.ReactiveProducer.config;

import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

//@Configuration
//public class PartitionKeyExtractorStrategyConfig {
//    @Bean
//    public PartitionKeyExtractorStrategy getPartitionKeyExtractorStrategy() {
//        return new CustomPartitionKeyExtractorStrategy();
//    }
//
//}
//
//class CustomPartitionKeyExtractorStrategy implements PartitionKeyExtractorStrategy {
//
//    @Override
//    public Object extractKey(Message<?> message) {
//        return 3;
//    }
//}