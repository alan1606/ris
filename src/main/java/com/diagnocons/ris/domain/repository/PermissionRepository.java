package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository {
    Optional<List<Permission>> getAll();

    Optional<Permission> getById(Long id);

    Optional<Permission> getByPermission(String permission);

    Permission save(Permission permission);

    boolean delete(Long id);
}
