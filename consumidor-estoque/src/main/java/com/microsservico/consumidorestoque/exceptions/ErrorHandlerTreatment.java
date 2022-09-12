package com.microsservico.consumidorestoque.exceptions;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.support.ListenerExecutionFailedException;
import org.springframework.util.ErrorHandler;

public class ErrorHandlerTreatment implements ErrorHandler {
    @Override
    public void handleError(Throwable t) {
        String consumerQueue = ((ListenerExecutionFailedException) t).getFailedMessage().getMessageProperties().getConsumerQueue();
        System.out.println(consumerQueue);

        String message = new String(((ListenerExecutionFailedException) t).getFailedMessage().getBody());
        System.out.println(message);

        System.out.println(t.getCause().getMessage());

        //Logar no ElasticSearch

        throw new AmqpRejectAndDontRequeueException("Não deve retornar a fila");
    }
}
