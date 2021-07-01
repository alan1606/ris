package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.Permission;

import java.util.List;

public interface PermissionRepository {
    List<Permission> getAll();
}
