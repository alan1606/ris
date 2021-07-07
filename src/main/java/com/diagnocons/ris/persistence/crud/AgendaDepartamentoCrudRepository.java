package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.AgendaEnDepartamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AgendaDepartamentoCrudRepository extends CrudRepository<AgendaEnDepartamento, Long> {
    @Query("Select a from AgendaEnDepartamento a where a.agenda.id = ?1")
    Optional<List<AgendaEnDepartamento>> findByIdAgenda(Long idAgenda);

    @Query("Select a from AgendaEnDepartamento a where a.departamento.id = ?1")
    Optional<List<AgendaEnDepartamento>> findByIdDepartamento(Long idDepartamento);

    @Query("Select a from AgendaEnDepartamento a where a.agenda.id = ?1 and a.departamento.id = ?2")
    Optional<AgendaEnDepartamento> findByIdAgendaIdDepartamento(Long idAgenda, Long idDepartamento);



}
