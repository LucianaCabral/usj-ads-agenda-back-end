package br.edu.usj.ads.lgii.agendabackend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato, Long> {
   List<Contato>findAll();
   List<Contato>findByNomeContainingIgnoreCase(String nome);
}
