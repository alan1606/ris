package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.UserPermission;

import java.util.List;
import java.util.Optional;

public interface UserPermissionRepository {

    Optional<List<UserPermission>> getByIdPermission(Long idPermission);

    Optional<List<UserPermission>> getByIdUser(Long idUser);

    Optional<UserPermission> getById(Long id);

    Optional<List<UserPermission>> getAll();

    UserPermission save(UserPermission userPermission);

    boolean delete(Long id);

}
