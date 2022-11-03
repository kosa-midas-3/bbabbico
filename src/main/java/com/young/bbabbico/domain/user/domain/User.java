package com.young.bbabbico.domain.user.domain;

import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.user.domain.type.Authority;
import com.young.bbabbico.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Authority authority;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    @Builder
    public User(String name, String nickname, Authority authority, Department department) {
        this.name = name;
        this.nickname = nickname;
        this.authority = authority;
        this.department = department;
    }
}
