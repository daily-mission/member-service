package com.daily.mission.member.service.application.service;

import com.daily.mission.common.type.UseCase;
import com.daily.mission.member.service.application.dto.MemberQuery;
import com.daily.mission.member.service.application.mapper.MemberDataMapper;
import com.daily.mission.member.service.application.port.input.query.MemberFindUseCase;
import com.daily.mission.member.service.application.port.output.MemberQueryRepository;
import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.domain.exception.MemberNotFoundException;
import com.daily.mission.member.service.domain.valueobject.MemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional(readOnly = true)
public class MemberFindService implements MemberFindUseCase {
    private final MemberQueryRepository memberQueryRepository;
    private final MemberDataMapper memberDataMapper;
    @Override
    public MemberQuery findMember(Long memberId) {
        Member member = memberQueryRepository.findById(new MemberId(memberId))
                                             .orElseThrow(() -> new MemberNotFoundException(memberId + " 회원이 존재하지 않습니다."));
        return memberDataMapper.memberDomainToMemberQuery(member);
    }

}
