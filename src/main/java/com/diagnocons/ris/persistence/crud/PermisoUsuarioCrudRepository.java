package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.PermisoUsuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PermisoUsuarioCrudRepository extends CrudRepository<PermisoUsuario, Long> {

    Optional<List<PermisoUsuario>> findByIdUsuario(Long idUsuario);

    Optional<List<PermisoUsuario>> findByIdPermiso(Long idPermiso);

    Optional<PermisoUsuario> findById(Long id);
}
