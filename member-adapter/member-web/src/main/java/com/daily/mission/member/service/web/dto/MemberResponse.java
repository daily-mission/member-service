package com.daily.mission.member.service.web.dto;

import com.daily.mission.member.service.application.dto.MemberQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberResponse {
    private Long memberId;
    private String email;
    private String nickNam;

    public MemberResponse(MemberQuery query) {
        this.memberId = query.memberId();
        this.email = query.email();
        this.nickNam = query.nickName();
    }

}
