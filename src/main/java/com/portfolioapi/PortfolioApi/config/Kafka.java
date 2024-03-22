package com.portfolioapi.PortfolioApi.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class Kafka {

    private final KafkaProperties kafkaProperties;

    @Value("${topics.notify.request.topic}")
    private String notifyRequestTopic;

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> properties = kafkaProperties.buildProducerProperties(null);
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic notifyRequestTopicBuilder() {
        return TopicBuilder
                .name(notifyRequestTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
