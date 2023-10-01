package com.daily.mission.member.service.application.port.output;

import com.daily.mission.member.service.domain.entity.Member;

public interface MemberCommandRepository {
    Member save(Member member);
}
