package com.daily.mission.member.service.domain.valueobject;

import com.daily.mission.common.domain.valueobject.BaseId;
import lombok.Getter;


@Getter
public class MemberId extends BaseId<Long> {

    public MemberId(Long value) {
        super(value);
    }
}
