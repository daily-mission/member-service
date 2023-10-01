package com.daily.mission.member.service.domain.entity;

import com.daily.mission.common.domain.entity.AggregateRoot;
import com.daily.mission.member.service.domain.exception.MemberDomainException;
import com.daily.mission.member.service.domain.valueobject.Email;
import com.daily.mission.member.service.domain.valueobject.MemberId;
import com.daily.mission.member.service.domain.valueobject.Nickname;
import com.daily.mission.member.service.domain.valueobject.Password;
import lombok.Builder;
import lombok.Getter;

import static java.util.Objects.isNull;

@Getter
public class Member extends AggregateRoot<MemberId> {
    private final MemberId memberId;
    private final Email email;
    private Nickname nickName;
    private Password passWord;

    @Builder
    private Member(MemberId memberId, Email email, Nickname nickName, Password passWord) {
        this.memberId = memberId;
        this.email = email;
        this.nickName = nickName;
        this.passWord = passWord;
    }

    public void validateAndInitialize() {
        validateMember();
        initializeMember();
    }

    private void validateMember() {
        if (!email.isValid()) {
            throw new MemberDomainException("이메일 형식이 올바르지 않습니다.");
        }

        if (!passWord.isValid()) {
            throw new MemberDomainException("비밀번호 형식이 올바르지 않습니다.");
        }

        if (!isNull(nickName)) {
            throw new MemberDomainException("닉네임은 랜덤값 입니다.");
        }
    }

    private void initializeMember() {
        nickName = new Nickname();
        nickName.setRandomValue();
    }
}
