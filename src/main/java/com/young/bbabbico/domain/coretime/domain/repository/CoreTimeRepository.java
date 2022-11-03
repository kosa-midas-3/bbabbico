package com.young.bbabbico.domain.coretime.domain.repository;

import com.young.bbabbico.domain.coretime.domain.CoreTime;
import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface CoreTimeRepository extends CrudRepository<CoreTime, Long> {
    CoreTime findCoreTimeByUserAndDate(User user, LocalDate date);
}
