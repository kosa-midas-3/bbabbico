package com.young.bbabbico.domain.home.domain.repository;

import com.young.bbabbico.domain.home.domain.HomeApply;
import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface HomeApplyRepository extends CrudRepository<HomeApply, Long> {
    HomeApply findByUserAndDate(User user, LocalDate date);
    void deleteAllByUser(User user);
}
