package br.com.rabbitmq.api.services;

import br.com.rabbitmq.api.dtos.NfseDto;
import br.com.rabbitmq.api.entities.Nfse;
import br.com.rabbitmq.api.mappers.NotaMapper;
import br.com.rabbitmq.api.repositories.NotaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotaService {

    private final NotaMapper notaMapper;

    private final NotaRepository notaRepository;

    public void save(String message) {
        try {
            System.out.println(message);
            ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            NfseDto nfseDto = mapper.readValue(message, NfseDto.class);
            Nfse nfse = notaMapper.modelToEntity(nfseDto);
            notaRepository.save(nfse);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Nfse> findAll() {
        return notaRepository.findAll();
    }
}
