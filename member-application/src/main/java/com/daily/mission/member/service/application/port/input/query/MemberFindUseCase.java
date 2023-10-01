package com.daily.mission.member.service.application.port.input.query;

import com.daily.mission.member.service.application.dto.MemberQuery;

public interface MemberFindUseCase {
    MemberQuery findMember(Long memberId);
}
