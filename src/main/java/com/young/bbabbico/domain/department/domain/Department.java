package com.young.bbabbico.domain.department.domain;

import com.young.bbabbico.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_department")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    String name;

    @Builder
    public Department(String name) {
        this.name = name;
    }
}
