package com.diagnocons.ris.domain.repository;

import com.diagnocons.ris.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<List<User>> getAll();

    Optional<User> getById(Long id);

    Optional<User> getByNickname(String nickname);

    Optional<User> getByEmail(String email);

    Optional<User> getByPhoneNumber(String phoneNumber);

    Optional<User> getByString(String string);

    Optional<List<User>> getByUserType(Long idUserType);

    User save(User user);

    boolean delete(User user);

    boolean delete(Long userId);
}
