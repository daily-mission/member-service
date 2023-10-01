package com.daily.mission.member.service.application.port.input.command;

import com.daily.mission.member.service.application.dto.MemberCreateCommand;

public interface MemberCreateUseCase {
    Long createMember(MemberCreateCommand command);
}
