package com.daily.mission.member.service.domain.exception;

import com.daily.mission.common.domain.exception.DailyMissionException;
import lombok.Getter;

@Getter
public class MemberDomainException extends DailyMissionException {

    public MemberDomainException(String message) {
        super(message);
    }

    public MemberDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
