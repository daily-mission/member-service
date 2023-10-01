package com.daily.mission.member.service.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberCreate {
    @Getter
    @NoArgsConstructor
    public static class Request {
        private String email;
        private String password;

        public Request(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    @Getter
    public static class Response {
        private final Long memberId;

        public Response(Long memberId) {
            this.memberId = memberId;
        }
    }
}
