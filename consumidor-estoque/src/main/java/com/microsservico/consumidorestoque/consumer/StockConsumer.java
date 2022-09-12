package com.microsservico.consumidorestoque.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.ConstantsRabbitmq;
import dto.StockDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockConsumer {

    @RabbitListener(queues = ConstantsRabbitmq.STOCK_QUEUE, containerFactory = "rabbitListenerContainerFactory")
    private void consumer(String message) throws JsonProcessingException, InterruptedException {
        StockDto stockDto = new ObjectMapper().readValue(message, StockDto.class);
        System.out.println(stockDto.getProductCode());
        System.out.println(stockDto.getAmount());
        System.out.println("---------------------------------------------");

        throw new IllegalArgumentException("Argumento inválido");
    }
}
