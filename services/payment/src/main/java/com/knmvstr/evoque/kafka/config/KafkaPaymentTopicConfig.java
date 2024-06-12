package com.knmvstr.evoque.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaPaymentTopicConfig {
    @Bean
    public NewTopic paymentTopic() {
        return new NewTopic("payment-topic", 2, (short) 1);
    }
}
