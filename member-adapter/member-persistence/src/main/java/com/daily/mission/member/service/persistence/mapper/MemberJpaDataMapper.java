package com.daily.mission.member.service.persistence.mapper;

import com.daily.mission.common.type.DataMapper;
import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.domain.valueobject.Email;
import com.daily.mission.member.service.domain.valueobject.MemberId;
import com.daily.mission.member.service.domain.valueobject.Nickname;
import com.daily.mission.member.service.domain.valueobject.Password;
import com.daily.mission.member.service.persistence.entity.MemberEntity;

@DataMapper
public class MemberJpaDataMapper {
    public Member memberEntityToMemberDomain(MemberEntity memberEntity) {
        return Member.builder()
                     .memberId(new MemberId(memberEntity.getId()))
                     .email(new Email(memberEntity.getEmail()))
                     .nickName(new Nickname(memberEntity.getNickName()))
                     .passWord(new Password(memberEntity.getPassword()))
                     .build();
    }

    public MemberEntity memberDomainToMemberEntity(Member member) {
        return MemberEntity.builder()
                           .id(member.getMemberId().getValue())
                           .email(member.getEmail().getValue())
                           .nickName(member.getNickName().getValue())
                           .password(member.getPassWord().getValue())
                           .build();
    }
}
