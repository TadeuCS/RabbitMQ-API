package br.com.rabbitmq.api.config;

import br.com.rabbitmq.api.dtos.NfseDto;
import br.com.rabbitmq.api.models.SuperModel;
import br.com.rabbitmq.api.services.NotaService;
import br.com.rabbitmq.api.utils.RabbitMQConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RabbitMqConsumer {

    private final NotaService notaService;

    @RabbitListener(queues = RabbitMQConstants.QUEUE_SAVE)
    public void saveNfse(String message){
        notaService.save(message);
    }
}
