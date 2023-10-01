package com.daily.mission.member.service.domain.valueobject;

import lombok.Getter;

@Getter
public class Email {
    private final String value;

    public Email(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return true;
    }
}
