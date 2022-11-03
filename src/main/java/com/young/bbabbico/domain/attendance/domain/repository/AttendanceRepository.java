package com.young.bbabbico.domain.attendance.domain.repository;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    Optional<Attendance> findByUserAndCreatedAtGreaterThan(User user, LocalDateTime createdAt);
}
