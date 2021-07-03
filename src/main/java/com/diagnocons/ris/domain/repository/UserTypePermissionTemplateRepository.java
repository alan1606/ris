package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.UserTypePermissionTemplate;

import java.util.List;
import java.util.Optional;

public interface UserTypePermissionTemplateRepository {
    Optional<List<UserTypePermissionTemplate>> getByIdPermission(Long idPermission);

    Optional<List<UserTypePermissionTemplate>> getByIdUserType(Long idUserType);

    Optional<UserTypePermissionTemplate> getById(Long id);

    Optional<List<UserTypePermissionTemplate>> getAll();

    UserTypePermissionTemplate save(UserTypePermissionTemplate userTypePermissionTemplate);

    boolean delete(Long id);
}
