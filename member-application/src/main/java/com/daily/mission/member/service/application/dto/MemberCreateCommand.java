package com.daily.mission.member.service.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import static com.daily.mission.common.type.validation.Validation.validate;

public record MemberCreateCommand(
        @NotNull String email,
        @NotNull String password) {

    @Builder
    public MemberCreateCommand(@NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
        validate(this);
    }
}
