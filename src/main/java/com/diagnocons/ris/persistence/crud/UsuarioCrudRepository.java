package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    Usuario findByNickOrderByNickDesc(String nick);
}
