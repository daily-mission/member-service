package com.daily.mission.member.service.application.mapper;

import com.daily.mission.common.type.DataMapper;
import com.daily.mission.member.service.application.dto.MemberCreateCommand;
import com.daily.mission.member.service.application.dto.MemberQuery;
import com.daily.mission.member.service.application.encode.PasswordEncoder;
import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.domain.valueobject.Email;
import com.daily.mission.member.service.domain.valueobject.MemberId;
import com.daily.mission.member.service.domain.valueobject.Password;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@DataMapper
public class MemberDataMapper {
    private final PasswordEncoder passwordEncoder;

    public Member createMemberCommandToMemberDomain(MemberCreateCommand command) {
        return Member.builder()
                     .memberId(new MemberId(null))
                     .email(new Email(command.email()))
                     .nickName(null)
                     .passWord(new Password(passwordEncoder.encode(command.password())))
                     .build();
    }

    public MemberQuery memberDomainToMemberQuery(Member member) {
        return MemberQuery.builder()
                          .memberId(member.getMemberId().getValue())
                          .email(member.getEmail().getValue())
                          .nickName(member.getNickName().getValue())
                          .build();
    }
}
