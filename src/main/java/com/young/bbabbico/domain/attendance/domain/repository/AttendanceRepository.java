package com.young.bbabbico.domain.attendance.domain.repository;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

    Optional<Attendance> findByUserAndDate(User user, LocalDate date);
    Attendance findAttendanceByUserAndDate(User user, LocalDate date);
    List<Attendance> findByUserAndDateGreaterThanEqualAndDateLessThanEqual(User user, LocalDate monthStart, LocalDate monthEnd);
}
