package com.daily.mission.member.service.application.service;


import com.daily.mission.member.service.application.dto.MemberCreateCommand;
import com.daily.mission.member.service.application.mapper.MemberDataMapper;
import com.daily.mission.member.service.application.port.output.MemberCommandRepository;
import com.daily.mission.member.service.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class MemberCreateHelper {

    private final MemberDataMapper memberDataMapper;
    private final MemberCommandRepository memberCommandRepository;

    public Member persistMember(MemberCreateCommand command) {
        Member member = memberDataMapper.createMemberCommandToMemberDomain(command);
        member.validateAndInitialize();

        return memberCommandRepository.save(member);
    }
}
