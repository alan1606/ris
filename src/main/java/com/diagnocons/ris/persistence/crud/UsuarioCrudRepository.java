package com.diagnocons.ris.persistence.crud;

import com.diagnocons.ris.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByNickOrderByNickDesc(String nick);

    @Override
    Optional<Usuario> findById(Long aLong);


    Optional<Usuario> findByEmailOrderByNickDesc(String email);

    Optional<Usuario> findByPhoneNumberOrderByNickDesc(String phoneNumber);

    Optional<Usuario> findByReplaceId(String replaceId);

    Optional<List<Usuario>> findByIdTipoUsuario(Long idTipoUsuario);
}
