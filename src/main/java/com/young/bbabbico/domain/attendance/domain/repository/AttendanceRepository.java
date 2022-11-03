package com.young.bbabbico.domain.attendance.domain.repository;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
}
