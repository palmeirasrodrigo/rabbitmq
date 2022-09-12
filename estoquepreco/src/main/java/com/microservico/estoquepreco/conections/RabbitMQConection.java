package com.microservico.estoquepreco.conections;

import constants.ConstantsRabbitmq;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConection {

    private static final String Exchange_Name = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directChance() {
        return new DirectExchange(Exchange_Name);
    }

    private Binding relationship(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void add() {
        Queue stockQueue = this.queue(ConstantsRabbitmq.STOCK_QUEUE);
        Queue priceQueue = this.queue(ConstantsRabbitmq.PRICE_QUEUE);

        DirectExchange exchange = this.directChance();

        Binding stockCall = this.relationship(stockQueue, exchange);
        Binding priceCall = this.relationship(priceQueue, exchange);

        //create queue
        this.amqpAdmin.declareQueue(stockQueue);
        this.amqpAdmin.declareQueue(priceQueue);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(stockCall);
        this.amqpAdmin.declareBinding(priceCall);
    }
}
