package br.com.rabbitmq.api.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RabbitmqService {

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String queueName, Object message) throws Exception {
        try {
            this.rabbitTemplate.convertAndSend(queueName, message);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao formatar o JSON da mensagem!", e);
        }
    }

}
