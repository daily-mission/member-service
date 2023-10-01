package com.daily.mission.member.service.web.mapper;

import com.daily.mission.common.type.DataMapper;
import com.daily.mission.member.service.application.dto.MemberCreateCommand;
import com.daily.mission.member.service.web.dto.MemberCreate;

@DataMapper
public class MemberCommandDataMapper {
    public MemberCreateCommand createMemberCreateCommand(MemberCreate.Request request) {
        return MemberCreateCommand.builder()
                                  .email(request.getEmail())
                                  .password(request.getPassword())
                                  .build();
    }
}
