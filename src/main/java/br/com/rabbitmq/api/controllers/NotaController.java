package br.com.rabbitmq.api.controllers;

import br.com.rabbitmq.api.entities.Nfse;
import br.com.rabbitmq.api.models.SuperModel;
import br.com.rabbitmq.api.services.NotaService;
import br.com.rabbitmq.api.services.RabbitmqService;
import br.com.rabbitmq.api.utils.RabbitMQConstants;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "nfse")
public class NotaController {

    private final NotaService notaService;
    private final RabbitmqService rabbitmqService;

    @PostMapping
    private ResponseEntity<?> send(@Valid @RequestBody SuperModel superModel) throws Exception {
        rabbitmqService.sendMessage(RabbitMQConstants.QUEUE_SEND, superModel);
        return ResponseEntity.ok("Nota enviada com sucesso!");
    }

    @GetMapping
    private ResponseEntity<?> listAll(){
        List<Nfse> notas = notaService.findAll();
        return ResponseEntity.ok(notas);
    }
}