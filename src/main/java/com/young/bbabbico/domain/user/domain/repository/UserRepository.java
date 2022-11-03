package com.young.bbabbico.domain.user.domain.repository;

import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.type.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);

    void deleteByName(String name);

    @Query("SELECT u FROM User u JOIN FETCH u.department WHERE u.authority = :authority")
    List<User> findUsersByAuthority(Authority authority);
}
