package com.diagnocons.ris.persistence;

import com.diagnocons.ris.persistence.crud.UsuarioCrudRepository;
import com.diagnocons.ris.persistence.entity.Usuario;

import java.util.List;

public class UsuarioRepository {
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<Usuario> getAll(){
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    public Usuario getUsuarioByNick(String nick){
        return usuarioCrudRepository.findByNickOrderByNickDesc(nick);
    }
}
