package com.young.bbabbico.domain.home.domain;

import com.young.bbabbico.domain.home.domain.type.HomeApplyStatus;
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
@Table(name = "tbl_home_apply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HomeApply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private HomeApplyStatus homeRequestStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public HomeApply(User user) {
        this.date = LocalDate.now().plusDays(1);
        this.homeRequestStatus = HomeApplyStatus.HOME_APPLY;
        this.user = user;
    }
}
