package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.TipoUsuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioCrudRepository extends CrudRepository<TipoUsuario, Long> {
    Optional<TipoUsuario> findByTipo(String tipo);
}
