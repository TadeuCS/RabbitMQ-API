package br.com.rabbitmq.api.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.rabbitmq.api.services.NotaService;
import br.com.rabbitmq.api.utils.RabbitMQConstants;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RabbitMqConsumer {

    private final NotaService notaService;

    @RabbitListener(queues = RabbitMQConstants.QUEUE_SAVE, containerFactory = "rabbitListenerContainerFactory")
    public void saveNfse(String message) {
        notaService.save(message);
    }
}
