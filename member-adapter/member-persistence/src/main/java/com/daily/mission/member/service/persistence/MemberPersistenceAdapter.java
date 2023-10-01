package com.daily.mission.member.service.persistence;

import com.daily.mission.common.type.PersistenceAdapter;
import com.daily.mission.member.service.application.port.output.MemberCommandRepository;
import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.persistence.mapper.MemberJpaDataMapper;
import com.daily.mission.member.service.persistence.repository.MemberCommandJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MemberPersistenceAdapter implements MemberCommandRepository {

    private final MemberJpaDataMapper memberJpaDataMapper;
    private final MemberCommandJpaRepository memberCommandJpaRepository;

    @Override
    public Member save(Member member) {
        return memberJpaDataMapper.memberEntityToMemberDomain(
                memberCommandJpaRepository.save(memberJpaDataMapper.memberDomainToMemberEntity(member)));
    }
}
