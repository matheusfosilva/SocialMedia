package com.portfolioapi.PortfolioApi.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolioapi.PortfolioApi.dto.users.UserFollowDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyRequestProducer {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topics.notify.request.topic}")
    private String topicsNotifyRequest;

    public String sendMessage(UserFollowDTO userFollowDTO) throws JsonProcessingException {
        String messageContent = objectMapper.writeValueAsString(userFollowDTO);
        kafkaTemplate.send(topicsNotifyRequest, messageContent);
        return "notification have been sent to process";
    }
}
