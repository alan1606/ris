package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.FotoUsuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FotoUsuarioCrudRepository extends CrudRepository<FotoUsuario, Long> {
    Optional<List<FotoUsuario>> findByIdUsuario(Long idUsuario);
    Optional<FotoUsuario> findByRuta(String ruta);

}
