package com.young.bbabbico.domain.attendance.domain;

import com.young.bbabbico.domain.attendance.domain.type.Status;
import com.young.bbabbico.domain.attendance.domain.type.WorkingMode;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_attendance")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Attendance(User user) {
        this.workingMode = WorkingMode.COMPANY;
        this.status = Status.GO;
        this.user = user;
    }

    public void updateWorkingMode(WorkingMode mode) {
        this.workingMode = mode;
    }

    public void leave() {
        this.status = Status.LEAVE;
    }
}
