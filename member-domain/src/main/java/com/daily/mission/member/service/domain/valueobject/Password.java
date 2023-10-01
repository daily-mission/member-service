package com.daily.mission.member.service.domain.valueobject;

import lombok.Getter;

@Getter
public class Password {
    private final String value;

    public Password(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return true;
    }
}
