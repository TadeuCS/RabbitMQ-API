package br.com.rabbitmq.api.repositories;

import br.com.rabbitmq.api.entities.Nfse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NotaRepository extends JpaRepository<Nfse, UUID> {
}
