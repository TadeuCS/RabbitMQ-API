package br.com.rabbitmq.api.config;

import br.com.rabbitmq.api.utils.RabbitMQConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {

    private final AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue getQueue(String name){
        return new Queue(name, true, false, false);
    }

    private DirectExchange getExchange(){
        return new DirectExchange(RabbitMQConstants.EXCHANGE_NAME);
    }

    private Binding getBinding(Queue queue, Exchange exchange){
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void init(){
        Queue queueSend = this.getQueue(RabbitMQConstants.QUEUE_SEND);
        Queue queueSave = this.getQueue(RabbitMQConstants.QUEUE_SAVE);

        DirectExchange exchange = this.getExchange();

        Binding bindingSend = this.getBinding(queueSend, exchange);
        Binding bindingSave = this.getBinding(queueSave, exchange);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareQueue(queueSend);
        this.amqpAdmin.declareBinding(bindingSend);

        this.amqpAdmin.declareQueue(queueSave);
        this.amqpAdmin.declareBinding(bindingSave);
    }
}
