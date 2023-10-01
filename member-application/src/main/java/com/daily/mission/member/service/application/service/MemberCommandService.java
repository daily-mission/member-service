package com.daily.mission.member.service.application.service;

import com.daily.mission.common.type.UseCase;
import com.daily.mission.member.service.application.dto.MemberCreateCommand;
import com.daily.mission.member.service.application.port.input.command.MemberCreateUseCase;
import com.daily.mission.member.service.application.port.output.MemberQueryRepository;
import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.domain.exception.MemberDuplicateException;
import com.daily.mission.member.service.domain.valueobject.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@UseCase
class MemberCommandService implements MemberCreateUseCase {

    private final MemberCreateHelper memberCreateHelper;
    private final MemberQueryRepository memberQueryRepository;

    @Override
    @Transactional
    public Long createMember(MemberCreateCommand command) {
        duplicateEmailCheck(command);
        Member createMember = memberCreateHelper.persistMember(command);
        return createMember.getMemberId().getValue();
    }

    private void duplicateEmailCheck(MemberCreateCommand command) {
        memberQueryRepository.findByEmail(new Email(command.email()))
                .ifPresent(m -> {
                    throw new MemberDuplicateException(command.email() + " 회원이 존재합니다.");
                });
    }
}
