package com.diagnocons.ris.persistence.repository;

import com.diagnocons.ris.domain.dto.UserPhoto;
import com.diagnocons.ris.domain.repository.UserPhotoRepository;
import com.diagnocons.ris.persistence.crud.FotoUsuarioCrudRepository;
import com.diagnocons.ris.persistence.entity.FotoUsuario;
import com.diagnocons.ris.persistence.mapper.UserPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FotoUsuarioRepository implements UserPhotoRepository {
    @Autowired
    private FotoUsuarioCrudRepository fotoUsuarioCrudRepository;

    @Autowired
    private UserPhotoMapper mapper;


    @Override
    public Optional<List<UserPhoto>> getAll() {
        List<FotoUsuario> fotos = (List<FotoUsuario>) fotoUsuarioCrudRepository.findAll();
        return Optional.of(mapper.toUsersPhotos(fotos));
    }

    @Override
    public Optional<UserPhoto> getById(Long id) {
        return fotoUsuarioCrudRepository.findById(id).map(foto -> mapper.toUserPhoto(foto));
    }

    @Override
    public Optional<List<UserPhoto>> getByIdUser(Long idUser) {
        Optional<List<FotoUsuario>> fotos = fotoUsuarioCrudRepository.findByIdUsuario(idUser);
        return Optional.of(mapper.toUsersPhotos(fotos.orElse(null)));
    }

    @Override
    public Optional<UserPhoto> getByPath(String path) {
        return fotoUsuarioCrudRepository.findByRuta(path).map(foto -> mapper.toUserPhoto(foto));
    }

    @Override
    public UserPhoto save(UserPhoto userPhoto) {
        FotoUsuario foto = mapper.toFotoUsuario(userPhoto);
        return mapper.toUserPhoto(fotoUsuarioCrudRepository.save(foto));
    }

    @Override
    public boolean delete(Long id) {
        if(getById(id).isPresent()){
            fotoUsuarioCrudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
