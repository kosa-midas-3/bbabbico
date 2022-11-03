package com.young.bbabbico.domain.user.domain.repository;

import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
