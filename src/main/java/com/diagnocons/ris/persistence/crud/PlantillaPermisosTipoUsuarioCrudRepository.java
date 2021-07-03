package com.diagnocons.ris.persistence.crud;


import com.diagnocons.ris.persistence.entity.PlantillaPermisosTipoUsuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlantillaPermisosTipoUsuarioCrudRepository extends CrudRepository<PlantillaPermisosTipoUsuario, Long> {

    Optional<List<PlantillaPermisosTipoUsuario>> findByIdTipoUsuario(Long idTipoUsuario);
    Optional<List<PlantillaPermisosTipoUsuario>> findByIdPermiso(Long idPermiso);
    Optional<PlantillaPermisosTipoUsuario> findById(Long id);
}
