package com.daily.mission.member.service.web.exception.handler;

import com.daily.mission.common.web.BaseResponse;
import com.daily.mission.common.web.ErrorResponse;
import com.daily.mission.common.web.GlobalExceptionHandler;
import com.daily.mission.member.service.domain.exception.MemberDomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class MemberExceptionHandler extends GlobalExceptionHandler {
    @ExceptionHandler(value = {MemberDomainException.class})
    @ResponseStatus(BAD_REQUEST)
    public BaseResponse<ErrorResponse> handleException(MemberDomainException e) {
        log.error(e.getMessage(), e);
        return BaseResponse.error(BAD_REQUEST.getReasonPhrase(), e.getMessage());
    }
}
