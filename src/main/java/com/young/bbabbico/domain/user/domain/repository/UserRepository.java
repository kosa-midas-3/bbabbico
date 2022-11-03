package com.young.bbabbico.domain.user.domain.repository;

import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
    void deleteByName(String name);
}
