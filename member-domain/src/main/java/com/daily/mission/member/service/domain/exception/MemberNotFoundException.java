package com.daily.mission.member.service.domain.exception;

public class MemberNotFoundException extends MemberDomainException {
    public MemberNotFoundException(String message) {
        super(message);
    }

    public MemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
