package br.com.rabbitmq.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NfseDto {
    private BigDecimal numNota;
    private String chave;
}
