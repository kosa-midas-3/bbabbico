package com.young.bbabbico.domain.coretime.domain;

import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "tbl_core_time")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CoreTime extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(length = 10, nullable = false)
    private String startTime;

    @Column(length = 10, nullable = false)
    private String endTime;

    @Column(length = 100, nullable = false)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public CoreTime(String startTime, String endTime, String reason, User user) {
        this.date = LocalDate.now().plusDays(1);
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.user = user;
    }
}
