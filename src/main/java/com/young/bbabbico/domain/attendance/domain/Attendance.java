package com.young.bbabbico.domain.attendance.domain;

import com.young.bbabbico.domain.attendance.domain.type.Status;
import com.young.bbabbico.domain.attendance.domain.type.WorkingMode;
import com.young.bbabbico.global.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_attendance")
public class Attendance extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private WorkingMode workingMode;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Status status;

    @Builder
    public Attendance() {
        this.workingMode = WorkingMode.COMPANY;
        this.status = Status.GO;
    }

    public void updateWorkingMode(WorkingMode mode) {
        this.workingMode = mode;
    }

    public void leave() {
        this.status = Status.LEAVE;
    }
}
