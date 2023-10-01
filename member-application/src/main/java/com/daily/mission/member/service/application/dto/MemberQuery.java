package com.daily.mission.member.service.application.dto;

import lombok.Builder;

public record MemberQuery(
        Long memberId,
        String email,
        String nickName
) {

    @Builder
    public MemberQuery(Long memberId, String email, String nickName) {
        this.memberId = memberId;
        this.email = email;
        this.nickName = nickName;
    }
}
