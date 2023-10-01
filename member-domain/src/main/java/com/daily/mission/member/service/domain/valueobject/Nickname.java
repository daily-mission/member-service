package com.daily.mission.member.service.domain.valueobject;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Nickname {
    private String value;

    public Nickname() {
    }

    public Nickname(String value) {
        this.value = value;
    }

    public void setRandomValue() {
        this.value = UUID.randomUUID().toString();
    }


}
