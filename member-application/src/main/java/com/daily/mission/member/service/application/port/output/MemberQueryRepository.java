package com.daily.mission.member.service.application.port.output;

import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.domain.valueobject.Email;
import com.daily.mission.member.service.domain.valueobject.MemberId;

import java.util.Optional;

public interface MemberQueryRepository {
    Optional<Member> findByEmail(Email email);
    Optional<Member> findById(MemberId memberId);
}
