package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.UserPhoto;

import java.util.List;
import java.util.Optional;

public interface UserPhotoRepository {
    Optional<List<UserPhoto>> getAll();

    Optional<UserPhoto> getById(Long id);

    Optional<List<UserPhoto>> getByIdUser(Long idUser);

    Optional<UserPhoto> getByPath(String path);

    UserPhoto save(UserPhoto userPhoto);

    boolean delete(Long id);
}
