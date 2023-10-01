package com.daily.mission.member.service.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nickName;
    private String password;

    @Builder
    private MemberEntity(Long id, String email, String nickName, String password) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.password = password;
    }
}
