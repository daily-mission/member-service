package com.daily.mission.member.service.domain.exception;

public class MemberDuplicateException extends MemberDomainException {
    public MemberDuplicateException(String message) {
        super(message);
    }

    public MemberDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }
}
