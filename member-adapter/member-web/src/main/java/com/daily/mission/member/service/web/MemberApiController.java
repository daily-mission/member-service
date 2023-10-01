package com.daily.mission.member.service.web;

import com.daily.mission.common.web.BaseResponse;
import com.daily.mission.member.service.application.dto.MemberCreateCommand;
import com.daily.mission.member.service.application.dto.MemberQuery;
import com.daily.mission.member.service.application.port.input.command.MemberCreateUseCase;
import com.daily.mission.member.service.application.port.input.query.MemberFindUseCase;
import com.daily.mission.member.service.web.dto.MemberCreate;
import com.daily.mission.member.service.web.dto.MemberResponse;
import com.daily.mission.member.service.web.mapper.MemberCommandDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberApiController {

    private final MemberCreateUseCase memberCreateUseCase;
    private final MemberFindUseCase memberFindUseCase;
    private final MemberCommandDataMapper memberCommandDataMapper;

    @PostMapping
    public BaseResponse<MemberCreate.Response> createMember(@RequestBody MemberCreate.Request request) {
        MemberCreateCommand command = memberCommandDataMapper.createMemberCreateCommand(request);
        Long memberId = memberCreateUseCase.createMember(command);
        return BaseResponse.success(new MemberCreate.Response(memberId));
    }

    @GetMapping("/{memberId}")
    public BaseResponse<MemberResponse> getMember(@PathVariable Long memberId) {
        MemberQuery query = memberFindUseCase.findMember(memberId);
        return BaseResponse.success(new MemberResponse(query));
    }
}
