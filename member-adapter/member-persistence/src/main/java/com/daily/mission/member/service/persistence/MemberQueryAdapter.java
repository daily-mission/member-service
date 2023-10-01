package com.daily.mission.member.service.persistence;

import com.daily.mission.common.type.PersistenceAdapter;
import com.daily.mission.member.service.application.port.output.MemberQueryRepository;
import com.daily.mission.member.service.domain.entity.Member;
import com.daily.mission.member.service.domain.valueobject.Email;
import com.daily.mission.member.service.domain.valueobject.MemberId;
import com.daily.mission.member.service.persistence.mapper.MemberJpaDataMapper;
import com.daily.mission.member.service.persistence.repository.MemberCommandJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class MemberQueryAdapter implements MemberQueryRepository {

    private final MemberJpaDataMapper memberJpaDataMapper;
    private final MemberCommandJpaRepository memberCommandJpaRepository;

    @Override
    public Optional<Member> findByEmail(Email email) {
        return memberCommandJpaRepository.findByEmail(email.getValue())
                .map(memberJpaDataMapper::memberEntityToMemberDomain);
    }

    @Override
    public Optional<Member> findById(MemberId memberId) {
        return memberCommandJpaRepository.findById(memberId.getValue())
                                         .map(memberJpaDataMapper::memberEntityToMemberDomain);
    }
}
