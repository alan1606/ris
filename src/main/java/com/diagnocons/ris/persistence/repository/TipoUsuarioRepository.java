package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.UserType;
import com.diagnocons.ris.domain.repository.UserTypeRepository;
import com.diagnocons.ris.persistence.crud.TipoUsuarioCrudRepository;
import com.diagnocons.ris.persistence.entity.TipoUsuario;
import com.diagnocons.ris.persistence.mapper.UserTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoUsuarioRepository implements UserTypeRepository {
    @Autowired
    private TipoUsuarioCrudRepository tipoUsuarioCrudRepository;
    @Autowired
    private UserTypeMapper mapper;


    @Override
    public Optional<List<UserType>> getAll() {
        List<TipoUsuario> tipoUsuarios = (List<TipoUsuario>) tipoUsuarioCrudRepository.findAll();
        return Optional.of(mapper.toUsersTypes(tipoUsuarios));
    }

    @Override
    public Optional<UserType> getById(Long id) {
        return tipoUsuarioCrudRepository.findById(id).map(uType -> mapper.toUserType(uType));
    }

    @Override
    public Optional<UserType> getByType(String type) {
        Optional<TipoUsuario> tipoUsuario =  tipoUsuarioCrudRepository.findByTipo(type);
        return tipoUsuario.map(uType -> mapper.toUserType(uType));

    }

    @Override
    public UserType save(UserType userType) {
        TipoUsuario tipoUsuario = mapper.toTipoUsuario(userType);
        return mapper.toUserType(tipoUsuarioCrudRepository.save(tipoUsuario));
    }

    @Override
    public boolean delete(Long idUserType) {
        if(getById(idUserType).isPresent()){
            tipoUsuarioCrudRepository.deleteById(idUserType);
            return true;
        }
        return false;
    }
}
