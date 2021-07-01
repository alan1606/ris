package com.diagnocons.ris.domain.repository;


import com.diagnocons.ris.domain.dto.UserType;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository {
    Optional<List<UserType>> getAll();

    Optional<UserType> getById(Long id);

    Optional<UserType> getByType(String type);

    UserType save(UserType userType);

    boolean delete(Long idUserType);
}
