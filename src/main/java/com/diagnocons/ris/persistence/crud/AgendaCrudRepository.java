package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Agenda;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AgendaCrudRepository extends CrudRepository<Agenda, Long> {
    Optional<Agenda> findByDia(LocalDate dia);
}
