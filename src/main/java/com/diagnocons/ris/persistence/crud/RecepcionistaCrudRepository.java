package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Recepcionista;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecepcionistaCrudRepository extends CrudRepository<Recepcionista, Long> {
    Optional<Recepcionista> findByIdUsuario(Long idUsuario);

}
