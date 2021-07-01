package com.diagnocons.ris.persistence;

import com.diagnocons.ris.domain.dto.User;
import com.diagnocons.ris.domain.repository.UserRepository;
import com.diagnocons.ris.persistence.crud.UsuarioCrudRepository;
import com.diagnocons.ris.persistence.entity.Usuario;
import com.diagnocons.ris.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    private UserMapper mapper;

    public Optional<List<User>> getAll(){
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return Optional.of(mapper.toUsers(usuarios));
    }

    @Override
    public Optional<User> getById(Long id) {
        return usuarioCrudRepository.findById(id).map(user -> mapper.toUser(user));
    }


    public Optional<User> getByNickname(String nick){
        Optional<Usuario> usuario = usuarioCrudRepository.findByNickOrderByNickDesc(nick);
        return usuario.map(user -> mapper.toUser(user)) ;
    }

    public Optional<User> getByEmail(String email){
        Optional<Usuario> usuario = usuarioCrudRepository.findByEmailOrderByNickDesc(email);
        return usuario.map(user -> mapper.toUser(user));
    }

    public Optional<User> getByPhoneNumber(String phoneNumber){
        Optional<Usuario> usuario = usuarioCrudRepository.findByPhoneNumberOrderByNickDesc(phoneNumber);
        return usuario.map(user -> mapper.toUser(user));
    }

    @Override
    public Optional<List<User>> getByUserType(Long idUserType) {
        return usuarioCrudRepository.findByIdTipoUsuario(idUserType).map(users -> mapper.toUsers(users));
    }

    public Optional<User> getByString(String replaceId){
        Optional<Usuario> usuario =  usuarioCrudRepository.findByReplaceId(replaceId);
        return usuario.map(user -> mapper.toUser(user));
    }

    public User save(User user){
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public boolean delete(Long id){
        if(getById(id).isPresent()){
            usuarioCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean delete(User user){
        Usuario usuario = mapper.toUsuario(user);
        if(getById(usuario.getId()).isPresent()){
            usuarioCrudRepository.delete(usuario);
            return true;
        }
        return false;
    }



}
