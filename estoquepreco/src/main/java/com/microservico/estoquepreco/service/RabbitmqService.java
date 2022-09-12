package com.microservico.estoquepreco.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void sendMessage(String nameQueue, Object message) {
        try {
            String messageJson = this.objectMapper.writeValueAsString(message);
            this.rabbitTemplate.convertAndSend(nameQueue, messageJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
