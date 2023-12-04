package br.com.rabbitmq.api.mappers;

import br.com.rabbitmq.api.dtos.NfseDto;
import br.com.rabbitmq.api.entities.Nfse;
import br.com.rabbitmq.api.models.SuperModel;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {

    public Nfse modelToEntity(NfseDto dto){
        Nfse nfse = new Nfse();
        nfse.setNuNota(dto.getNumNota());
        nfse.setChave(dto.getChave());
        return nfse;
    }
}
